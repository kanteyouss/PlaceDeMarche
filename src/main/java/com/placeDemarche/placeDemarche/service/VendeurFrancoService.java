package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.VendeurFrancoResponseDto;
import com.placeDemarche.placeDemarche.dto.VendeurResponseDto;
import com.placeDemarche.placeDemarche.entity.VendeurFranco;
import com.placeDemarche.placeDemarche.entity.Vendeur;
import com.placeDemarche.placeDemarche.repository.VendeurFrancoRepository;
import com.placeDemarche.placeDemarche.service.VendeurService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les VendeurFrancos.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class VendeurFrancoService {
    private final VendeurFrancoRepository vendeurFrancoRepository;
    private final VendeurService vendeurService;

    public VendeurFrancoService(VendeurFrancoRepository vendeurFrancoRepository, VendeurService vendeurService) {
        this.vendeurFrancoRepository = vendeurFrancoRepository;
        this.vendeurService = vendeurService;
    }

    /**
     * Convertit une entité VendeurFranco en DTO de réponse.
     *
     * @param vendeurFranco L'entité VendeurFranco à convertir
     * @return L'objet VendeurFrancoResponseDto correspondant
     */
    public VendeurFrancoResponseDto toDto(VendeurFranco vendeurFranco) {
        VendeurFrancoResponseDto dto = new VendeurFrancoResponseDto();
        dto.setId(vendeurFranco.getId());
        dto.setSeuilMontant(vendeurFranco.getSeuilMontant());
        dto.setDateApplication(vendeurFranco.getDateApplication());
        dto.setActif(vendeurFranco.getActif());
        if (vendeurFranco.getVendeur() != null) {
            dto.setVendeur(vendeurService.toDto(vendeurFranco.getVendeur()));
        }
        return dto;
    }
}