package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.CommandeRequestDto;
import com.placeDemarche.placeDemarche.dto.LigneCommandeRequestDto;
import com.placeDemarche.placeDemarche.dto.CommandeResponseDto;
import com.placeDemarche.placeDemarche.entity.Commande;
import com.placeDemarche.placeDemarche.entity.Client;
import com.placeDemarche.placeDemarche.entity.Colis;
import com.placeDemarche.placeDemarche.entity.CommissionProduit;
import com.placeDemarche.placeDemarche.entity.ProduitVariant;
import com.placeDemarche.placeDemarche.repository.CommandeRepository;
import com.placeDemarche.placeDemarche.repository.ClientRepository;
import com.placeDemarche.placeDemarche.repository.ColisRepository;
import com.placeDemarche.placeDemarche.repository.CommissionProduitRepository;
import com.placeDemarche.placeDemarche.repository.LivraisonRepository;
import com.placeDemarche.placeDemarche.repository.ProduitVariantRepository;
import com.placeDemarche.placeDemarche.service.ClientService;
import com.placeDemarche.placeDemarche.service.ColisService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service métier gérant les Commandes.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final ClientService clientService;
    private final ColisRepository colisRepository;
    private final ColisService colisService;
    private final LivraisonRepository livraisonRepository;
    private final ProduitVariantRepository produitVariantRepository;
    private final CommissionProduitRepository commissionProduitRepository;

    public CommandeService(CommandeRepository commandeRepository, ClientRepository clientRepository,
                           ClientService clientService, ColisRepository colisRepository, ColisService colisService,
                           LivraisonRepository livraisonRepository, ProduitVariantRepository produitVariantRepository,
                           CommissionProduitRepository commissionProduitRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.clientService = clientService;
        this.colisRepository = colisRepository;
        this.colisService = colisService;
        this.livraisonRepository = livraisonRepository;
        this.produitVariantRepository = produitVariantRepository;
        this.commissionProduitRepository = commissionProduitRepository;
    }

    /**
     * Construit une entité Commande à partir des données de la requête.
     *
     * @param commandeRequest Les données de la requête (CommandeRequestDto)
     * @param client L'entité Client associée
     * @return L'entité Commande construite
     */
    public Commande toEntity(CommandeRequestDto commandeRequest, Client client) {
        Commande commande = new Commande();
        commande.setDateCommande(commandeRequest.getDateCommande());
        commande.setMontantTotal(BigDecimal.ZERO);
        commande.setClient(client);
        return commande;
    }

    /**
     * Convertit une entité Commande en DTO de réponse.
     *
     * @param commande L'entité Commande à convertir
     * @return L'objet CommandeResponseDto correspondant
     */
    public CommandeResponseDto toDto(Commande commande) {
        CommandeResponseDto dto = new CommandeResponseDto();
        dto.setId(commande.getId());
        dto.setDateCommande(commande.getDateCommande());
        dto.setMontantTotal(colisRepository.calculerMontantTotal(commande.getId()));
        if (commande.getClient() != null) {
            dto.setClient(clientService.toDto(commande.getClient()));
        }
        dto.setColis(colisRepository.findByCommandeId(commande.getId()).stream()
                .map(colisService::toDto).toList());
        dto.setStatut(computeStatut(commande.getId()));
        return dto;
    }

    /**
     * Calcule compute statut.
     *
     * @param commandeId L'identifiant de commande
     * @return La chaîne calculée
     */
    private String computeStatut(Long commandeId) {
        List<String> statuts = livraisonRepository.findStatutsByCommandeId(commandeId);
        if (statuts == null || statuts.isEmpty()) { return "EN_ATTENTE"; }
        boolean tousLivre = statuts.stream().allMatch(s -> "Livré".equalsIgnoreCase(s) || "LIVRE".equalsIgnoreCase(s));
        if (tousLivre) { return "LIVREE"; }
        boolean retour = statuts.stream().anyMatch(s -> "Retourné".equalsIgnoreCase(s) || "RETOURNE".equalsIgnoreCase(s));
        if (retour) { return "RETOURNEE"; }
        return "EN_COURS";
    }

    /**
     * Détermine determiner taux commission.
     *
     * @param variant L'entité ProduitVariant associée
     * @return Le résultat (BigDecimal)
     */
    private BigDecimal determinerTauxCommission(ProduitVariant variant) {
        if (variant.getProduit() != null && variant.getProduit().getCategorie() != null) {
            List<CommissionProduit> taux =
                    commissionProduitRepository.findByCategorieIdAndDateFinIsNull(variant.getProduit().getCategorie().getId());
            if (!taux.isEmpty() && taux.get(0).getTaux() != null) {
                return taux.get(0).getTaux();
            }
        }
        return BigDecimal.ZERO;
    }

    /**
     * Ajoute ajouter colis.
     *
     * @param commande L'entité Commande à convertir
     * @param ligne L'entité LigneCommandeRequestDto associée
     */
    private void ajouterColis(Commande commande, LigneCommandeRequestDto ligne) {
        ProduitVariant variant = produitVariantRepository.findById(ligne.getProduitVariantId())
                .orElseThrow(() -> new RuntimeException("Variante produit non trouvée : " + ligne.getProduitVariantId()));
        Colis colis = new Colis();
        colis.setCommande(commande);
        colis.setProduitVariant(variant);
        colis.setQuantite(ligne.getQuantite() == null ? 1 : ligne.getQuantite());
        colis.setFraisDePort(ligne.getFraisDePort() == null ? BigDecimal.ZERO : ligne.getFraisDePort());
        colis.setTauxCommissionApplique(determinerTauxCommission(variant));
        colis.setQuantiteRetournee(0);
        colis.setMontantRembourse(BigDecimal.ZERO);
        colisRepository.save(colis);
    }

    /**
     * Retourne la liste complète des entités Commande.
     *
     * @return La liste des CommandeResponseDto
     */
    public List<CommandeResponseDto> getAllCommandes() {
        return commandeRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Commande par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Commande recherchée
     * @return L'objet CommandeResponseDto correspondant
     * @throws RuntimeException Si l'entité Commande n'existe pas
     */
    public CommandeResponseDto getCommandeById(Long id) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvé"));
        return toDto(commande);
    }

    /**
     * Crée une entité Commande à partir des données fournies.
     *
     * @param commandeRequest Les données de la requête (CommandeRequestDto)
     * @return L'objet CommandeResponseDto correspondant
     */
    public CommandeResponseDto createCommande(CommandeRequestDto commandeRequest) {
        Client client = clientRepository.findById(commandeRequest.getClientId()).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Commande commande = commandeRepository.save(toEntity(commandeRequest, client));
        if (commandeRequest.getLignes() != null) {
            for (LigneCommandeRequestDto ligne : commandeRequest.getLignes()) {
                ajouterColis(commande, ligne);
            }
        }
        return toDto(commande);
    }

    /**
     * Met à jour l'entité Commande existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Commande à modifier
     * @param commandeRequest Les données de la requête (CommandeRequestDto)
     * @return L'objet CommandeResponseDto correspondant
     * @throws RuntimeException Si l'entité Commande n'existe pas
     */
    public CommandeResponseDto updateCommandeById(Long id, CommandeRequestDto commandeRequest) {
        Client client = clientRepository.findById(commandeRequest.getClientId()).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvé"));
        commande.setDateCommande(commandeRequest.getDateCommande());
        commande.setMontantTotal(BigDecimal.ZERO);
        commande.setClient(client);
        commandeRepository.save(commande);
        if (commandeRequest.getLignes() != null) {
            for (Colis ancien : colisRepository.findByCommandeId(id)) {
                colisRepository.deleteById(ancien.getId());
            }
            for (LigneCommandeRequestDto ligne : commandeRequest.getLignes()) {
                ajouterColis(commande, ligne);
            }
        }
        return toDto(commande);
    }

    /**
     * Supprime l'entité Commande par son identifiant.
     *
     * @param id L'identifiant de l'entité Commande recherchée
     * @return L'objet CommandeResponseDto correspondant
     * @throws RuntimeException Si l'entité Commande n'existe pas
     */
    public CommandeResponseDto deleteCommandeById(Long id) {
        Commande commande = commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvé"));
        CommandeResponseDto dto = toDto(commande);
        for (Colis colis : colisRepository.findByCommandeId(id)) {
            colisRepository.deleteById(colis.getId());
        }
        commandeRepository.deleteById(id);
        return dto;
    }
}
