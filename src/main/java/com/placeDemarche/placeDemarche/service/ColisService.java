package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.ColisResponseDto;
import com.placeDemarche.placeDemarche.dto.ProduitVariantResponseDto;
import com.placeDemarche.placeDemarche.entity.Colis;
import com.placeDemarche.placeDemarche.entity.ProduitVariant;
import com.placeDemarche.placeDemarche.repository.ColisRepository;
import com.placeDemarche.placeDemarche.service.ProduitVariantService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Coliss.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class ColisService {
    private final ColisRepository colisRepository;
    private final ProduitVariantService produitVariantService;

    public ColisService(ColisRepository colisRepository, ProduitVariantService produitVariantService) {
        this.colisRepository = colisRepository;
        this.produitVariantService = produitVariantService;
    }

    /**
     * Convertit une entité Colis en DTO de réponse.
     *
     * @param colis L'entité Colis à convertir
     * @return L'objet ColisResponseDto correspondant
     */
    public ColisResponseDto toDto(Colis colis) {
        ColisResponseDto dto = new ColisResponseDto();
        dto.setId(colis.getId());
        dto.setFraisDePort(colis.getFraisDePort());
        dto.setMontantFranco(colis.getMontantFranco());
        dto.setTauxCommissionApplique(colis.getTauxCommissionApplique());
        dto.setQuantite(colis.getQuantite());
        dto.setQuantiteRetournee(colis.getQuantiteRetournee());
        dto.setMontantRembourse(colis.getMontantRembourse());
        dto.setNoteProduit(colis.getNoteProduit());
        dto.setCommentaireProduit(colis.getCommentaireProduit());
        dto.setNoteVendeur(colis.getNoteVendeur());
        dto.setCommentaireVendeur(colis.getCommentaireVendeur());
        if (colis.getProduitVariant() != null) {
            dto.setProduitVariant(produitVariantService.toDto(colis.getProduitVariant()));
        }
        return dto;
    }
}