package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.ProduitRequestDto;
import com.placeDemarche.placeDemarche.dto.ProduitResponseDto;
import com.placeDemarche.placeDemarche.dto.VendeurResponseDto;
import com.placeDemarche.placeDemarche.dto.CategorieResponseDto;
import com.placeDemarche.placeDemarche.entity.Produit;
import com.placeDemarche.placeDemarche.entity.Vendeur;
import com.placeDemarche.placeDemarche.entity.Categorie;
import com.placeDemarche.placeDemarche.repository.ProduitRepository;
import com.placeDemarche.placeDemarche.repository.VendeurRepository;
import com.placeDemarche.placeDemarche.repository.CategorieRepository;
import com.placeDemarche.placeDemarche.service.VendeurService;
import com.placeDemarche.placeDemarche.service.CategorieService;
import com.placeDemarche.placeDemarche.dto.ProduitVariantResponseDto;
import com.placeDemarche.placeDemarche.entity.ProduitVariant;
import com.placeDemarche.placeDemarche.repository.ProduitVariantRepository;
import com.placeDemarche.placeDemarche.repository.StockRepository;
import com.placeDemarche.placeDemarche.service.ProduitVariantService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.math.BigDecimal;

/**
 * Service métier gérant les Produits.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class ProduitService {
    private final ProduitRepository produitRepository;
    private final VendeurRepository vendeurRepository;
    private final VendeurService vendeurService;
    private final CategorieRepository categorieRepository;
    private final CategorieService categorieService;
    private final ProduitVariantRepository produitVariantRepository;
    private final ProduitVariantService produitVariantService;
    private final StockRepository stockRepository;

    public ProduitService(ProduitRepository produitRepository, VendeurRepository vendeurRepository, VendeurService vendeurService, CategorieRepository categorieRepository, CategorieService categorieService, ProduitVariantRepository produitVariantRepository, ProduitVariantService produitVariantService, StockRepository stockRepository) {
        this.produitRepository = produitRepository;
        this.vendeurRepository = vendeurRepository;
        this.vendeurService = vendeurService;
        this.categorieRepository = categorieRepository;
        this.categorieService = categorieService;
        this.produitVariantRepository = produitVariantRepository;
        this.produitVariantService = produitVariantService;
        this.stockRepository = stockRepository;
    }

    /**
     * Construit une entité Produit à partir des données de la requête.
     *
     * @param produitRequest Les données de la requête (ProduitRequestDto)
     * @param vendeur L'entité Vendeur associée
     * @param categorie L'entité Categorie associée
     * @return L'entité Produit construite
     */
    public Produit toEntity(ProduitRequestDto produitRequest, Vendeur vendeur, Categorie categorie) {
        Produit produit = new Produit();
        produit.setNom(produitRequest.getNom());
        produit.setDescription(produitRequest.getDescription());
        produit.setVendeur(vendeur);
        produit.setCategorie(categorie);
        return produit;
    }

    /**
     * Convertit une entité Produit en DTO de réponse.
     *
     * @param produit L'entité Produit à convertir
     * @return L'objet ProduitResponseDto correspondant
     */
    public ProduitResponseDto toDto(Produit produit) {
        ProduitResponseDto dto = new ProduitResponseDto();
        dto.setId(produit.getId());
        dto.setNom(produit.getNom());
        dto.setDescription(produit.getDescription());
        if (produit.getVendeur() != null) {
            dto.setVendeur(vendeurService.toDto(produit.getVendeur()));
        }
        if (produit.getCategorie() != null) {
            dto.setCategorie(categorieService.toDto(produit.getCategorie()));
        }
        dto.setVariants(produitVariantRepository.findByProduitId(produit.getId()).stream()
                .map(produitVariantService::toDto).toList());
        Long stockTotal = stockRepository.sumQuantiteByProduitId(produit.getId());
        dto.setStockTotal(stockTotal == null ? 0 : stockTotal.intValue());
        return dto;
    }

    /**
     * Retourne la liste complète des entités Produit.
     *
     * @return La liste des ProduitResponseDto
     */
    public List<ProduitResponseDto> getAllProduits() {
        return produitRepository.findAll().stream().map(this::toDto).toList();
    }

    /**
     * Recherche l'entité Produit par son identifiant unique.
     *
     * @param id L'identifiant de l'entité Produit recherchée
     * @return L'objet ProduitResponseDto correspondant
     * @throws RuntimeException Si l'entité Produit n'existe pas
     */
    public ProduitResponseDto getProduitById(Long id) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        return toDto(produit);
    }

    /**
     * Crée une entité Produit à partir des données fournies.
     *
     * @param produitRequest Les données de la requête (ProduitRequestDto)
     * @return L'objet ProduitResponseDto correspondant
     */
    public ProduitResponseDto createProduit(ProduitRequestDto produitRequest) {
        Vendeur vendeur = vendeurRepository.findById(produitRequest.getVendeurId()).orElseThrow(() -> new RuntimeException("Vendeur non trouvé"));
        Categorie categorie = categorieRepository.findById(produitRequest.getCategorieId()).orElseThrow(() -> new RuntimeException("Categorie non trouvé"));
        Produit produit = toEntity(produitRequest, vendeur, categorie);
        return toDto(produitRepository.save(produit));
    }

    /**
     * Met à jour l'entité Produit existante à partir des données fournies.
     *
     * @param id L'identifiant de l'entité Produit à modifier
     * @param produitRequest Les données de la requête (ProduitRequestDto)
     * @return L'objet ProduitResponseDto correspondant
     * @throws RuntimeException Si l'entité Produit n'existe pas
     */
    public ProduitResponseDto updateProduitById(Long id, ProduitRequestDto produitRequest) {
        Vendeur vendeur = vendeurRepository.findById(produitRequest.getVendeurId()).orElseThrow(() -> new RuntimeException("Vendeur non trouvé"));
        Categorie categorie = categorieRepository.findById(produitRequest.getCategorieId()).orElseThrow(() -> new RuntimeException("Categorie non trouvé"));
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        produit.setNom(produitRequest.getNom());
        produit.setDescription(produitRequest.getDescription());
        produit.setVendeur(vendeur);
        produit.setCategorie(categorie);
        return toDto(produitRepository.save(produit));
    }

    /**
     * Supprime l'entité Produit par son identifiant.
     *
     * @param id L'identifiant de l'entité Produit recherchée
     * @return L'objet ProduitResponseDto correspondant
     * @throws RuntimeException Si l'entité Produit n'existe pas
     */
    public ProduitResponseDto deleteProduitById(Long id) {
        Produit produit = produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        produitRepository.deleteById(id);
        return toDto(produit);
    }
}