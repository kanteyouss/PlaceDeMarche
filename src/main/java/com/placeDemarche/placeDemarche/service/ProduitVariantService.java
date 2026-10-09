package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.ProduitVariantResponseDto;
import com.placeDemarche.placeDemarche.entity.ProduitVariant;
import com.placeDemarche.placeDemarche.repository.ProduitVariantRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les ProduitVariants.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class ProduitVariantService {
    private final ProduitVariantRepository produitVariantRepository;

    public ProduitVariantService(ProduitVariantRepository produitVariantRepository) {
        this.produitVariantRepository = produitVariantRepository;
    }

    /**
     * Convertit une entité ProduitVariant en DTO de réponse.
     *
     * @param produitVariant L'entité ProduitVariant à convertir
     * @return L'objet ProduitVariantResponseDto correspondant
     */
    public ProduitVariantResponseDto toDto(ProduitVariant produitVariant) {
        ProduitVariantResponseDto dto = new ProduitVariantResponseDto();
        dto.setId(produitVariant.getId());
        dto.setLibelle(produitVariant.getLibelle());
        dto.setTaille(produitVariant.getTaille());
        dto.setCouleur(produitVariant.getCouleur());
        dto.setCapacite(produitVariant.getCapacite());
        dto.setPrix(produitVariant.getPrix());
        return dto;
    }
}