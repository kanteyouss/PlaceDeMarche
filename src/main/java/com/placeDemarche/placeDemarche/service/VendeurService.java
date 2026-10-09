package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.VendeurRequestDto;
import com.placeDemarche.placeDemarche.dto.VendeurResponseDto;
import com.placeDemarche.placeDemarche.entity.Vendeur;
import com.placeDemarche.placeDemarche.repository.VendeurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service métier gérant les Vendeurs.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class VendeurService {
    private final VendeurRepository vendeurRepository;

    public VendeurService(VendeurRepository vendeurRepository) {
        this.vendeurRepository = vendeurRepository;
    }

    /**
     * Construit une entité Vendeur à partir des données de la requête.
     *
     * @param vendeurRequest Les données de la requête (VendeurRequestDto)
     * @return L'entité Vendeur construite
     */
    public Vendeur toEntity(VendeurRequestDto vendeurRequest) {
        Vendeur vendeur = new Vendeur();
        vendeur.setNomBoutique(vendeurRequest.getNomBoutique());
        vendeur.setEmail(vendeurRequest.getEmail());
        vendeur.setTelephone(vendeurRequest.getTelephone());
        vendeur.setAdresse(vendeurRequest.getAdresse());
        vendeur.setVille(vendeurRequest.getVille());
        vendeur.setRibIban(vendeurRequest.getRibIban());
        vendeur.setDateInscription(vendeurRequest.getDateInscription());
        return vendeur;
    }

    /**
     * Convertit une entité Vendeur en DTO de réponse.
     *
     * @param vendeur L'entité Vendeur à convertir
     * @return L'objet VendeurResponseDto correspondant
     */
    public VendeurResponseDto toDto(Vendeur vendeur) {
        VendeurResponseDto dto = new VendeurResponseDto();
        dto.setId(vendeur.getId());
        dto.setNomBoutique(vendeur.getNomBoutique());
        dto.setEmail(vendeur.getEmail());
        dto.setTelephone(vendeur.getTelephone());
        dto.setAdresse(vendeur.getAdresse());
        dto.setVille(vendeur.getVille());
        dto.setRibIban(vendeur.getRibIban());
        dto.setDateInscription(vendeur.getDateInscription());
        return dto;
    }

    /**
     * Retourne la liste complète des entités Vendeur.
     *
     * @return La liste des VendeurResponseDto
     */
    public List<VendeurResponseDto> getAllVendeurs() {
        return vendeurRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Vendeur par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Vendeur recherchée
     * @return L'objet VendeurResponseDto correspondant
     * @throws RuntimeException Si l'entité Vendeur n'existe pas
     */
    public VendeurResponseDto getVendeurById(Long id) {
        Vendeur vendeur = vendeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendeur non trouvé"));
        return toDto(vendeur);
    }

    /**
     * Crée une entité Vendeur à partir des données fournies.
     *
     * @param vendeurRequest Les données de la requête (VendeurRequestDto)
     * @return L'objet VendeurResponseDto correspondant
     */
    public VendeurResponseDto createVendeur(VendeurRequestDto vendeurRequest) {
        Vendeur vendeur = toEntity(vendeurRequest);
        return toDto(vendeurRepository.save(vendeur));
    }

    /**
     * Met à jour l'entité Vendeur existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Vendeur à modifier
     * @param vendeurRequest Les données de la requête (VendeurRequestDto)
     * @return L'objet VendeurResponseDto correspondant
     * @throws RuntimeException Si l'entité Vendeur n'existe pas
     */
    public VendeurResponseDto updateVendeurById(Long id, VendeurRequestDto vendeurRequest) {
        Vendeur vendeur = vendeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendeur non trouvé"));
        vendeur.setNomBoutique(vendeurRequest.getNomBoutique());
        vendeur.setEmail(vendeurRequest.getEmail());
        vendeur.setTelephone(vendeurRequest.getTelephone());
        vendeur.setAdresse(vendeurRequest.getAdresse());
        vendeur.setVille(vendeurRequest.getVille());
        vendeur.setRibIban(vendeurRequest.getRibIban());
        vendeur.setDateInscription(vendeurRequest.getDateInscription());
        return toDto(vendeurRepository.save(vendeur));
    }

    /**
     * Supprime l'entité Vendeur par son identifiant.
     *
     * @param id L'identifiant de l'entité Vendeur recherchée
     * @return L'objet VendeurResponseDto correspondant
     * @throws RuntimeException Si l'entité Vendeur n'existe pas
     */
    public VendeurResponseDto deleteVendeurById(Long id) {
        Vendeur vendeur = vendeurRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendeur non trouvé"));
        vendeurRepository.deleteById(id);
        return toDto(vendeur);
    }
}