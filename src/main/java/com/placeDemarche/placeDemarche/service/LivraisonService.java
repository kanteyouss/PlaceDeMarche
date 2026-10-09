package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.LivraisonResponseDto;
import com.placeDemarche.placeDemarche.dto.ColisResponseDto;
import com.placeDemarche.placeDemarche.dto.StatusResponseDto;
import com.placeDemarche.placeDemarche.entity.Livraison;
import com.placeDemarche.placeDemarche.entity.Colis;
import com.placeDemarche.placeDemarche.entity.Status;
import com.placeDemarche.placeDemarche.repository.LivraisonRepository;
import com.placeDemarche.placeDemarche.service.ColisService;
import com.placeDemarche.placeDemarche.service.StatusService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Livraisons.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class LivraisonService {
    private final LivraisonRepository livraisonRepository;
    private final ColisService colisService;
    private final StatusService statusService;

    public LivraisonService(LivraisonRepository livraisonRepository, ColisService colisService, StatusService statusService) {
        this.livraisonRepository = livraisonRepository;
        this.colisService = colisService;
        this.statusService = statusService;
    }

    /**
     * Convertit une entité Livraison en DTO de réponse.
     *
     * @param livraison L'entité Livraison à convertir
     * @return L'objet LivraisonResponseDto correspondant
     */
    public LivraisonResponseDto toDto(Livraison livraison) {
        LivraisonResponseDto dto = new LivraisonResponseDto();
        dto.setId(livraison.getId());
        dto.setNumeroSuivi(livraison.getNumeroSuivi());
        dto.setDateExpedition(livraison.getDateExpedition());
        if (livraison.getColis() != null) {
            dto.setColis(colisService.toDto(livraison.getColis()));
        }
        if (livraison.getStatus() != null) {
            dto.setStatus(statusService.toDto(livraison.getStatus()));
        }
        return dto;
    }
}