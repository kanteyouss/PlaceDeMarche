package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.PaiementResponseDto;
import com.placeDemarche.placeDemarche.dto.VendeurResponseDto;
import com.placeDemarche.placeDemarche.entity.Paiement;
import com.placeDemarche.placeDemarche.entity.Vendeur;
import com.placeDemarche.placeDemarche.repository.PaiementRepository;
import com.placeDemarche.placeDemarche.service.VendeurService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Paiements.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class PaiementService {
    private final PaiementRepository paiementRepository;
    private final VendeurService vendeurService;

    public PaiementService(PaiementRepository paiementRepository, VendeurService vendeurService) {
        this.paiementRepository = paiementRepository;
        this.vendeurService = vendeurService;
    }

    /**
     * Convertit une entité Paiement en DTO de réponse.
     *
     * @param paiement L'entité Paiement à convertir
     * @return L'objet PaiementResponseDto correspondant
     */
    public PaiementResponseDto toDto(Paiement paiement) {
        PaiementResponseDto dto = new PaiementResponseDto();
        dto.setId(paiement.getId());
        dto.setMontant(paiement.getMontant());
        dto.setDatePaiement(paiement.getDatePaiement());
        if (paiement.getVendeur() != null) {
            dto.setVendeur(vendeurService.toDto(paiement.getVendeur()));
        }
        return dto;
    }
}