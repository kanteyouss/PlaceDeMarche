package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.EntrepotResponseDto;
import com.placeDemarche.placeDemarche.entity.Entrepot;
import com.placeDemarche.placeDemarche.repository.EntrepotRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Entrepots.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class EntrepotService {
    private final EntrepotRepository entrepotRepository;

    public EntrepotService(EntrepotRepository entrepotRepository) {
        this.entrepotRepository = entrepotRepository;
    }

    /**
     * Convertit une entité Entrepot en DTO de réponse.
     *
     * @param entrepot L'entité Entrepot à convertir
     * @return L'objet EntrepotResponseDto correspondant
     */
    public EntrepotResponseDto toDto(Entrepot entrepot) {
        EntrepotResponseDto dto = new EntrepotResponseDto();
        dto.setId(entrepot.getId());
        dto.setNom(entrepot.getNom());
        dto.setAdresse(entrepot.getAdresse());
        return dto;
    }
}