package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.StatusResponseDto;
import com.placeDemarche.placeDemarche.entity.Status;
import com.placeDemarche.placeDemarche.repository.StatusRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Statuss.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    /**
     * Convertit une entité Status en DTO de réponse.
     *
     * @param status L'entité Status à convertir
     * @return L'objet StatusResponseDto correspondant
     */
    public StatusResponseDto toDto(Status status) {
        StatusResponseDto dto = new StatusResponseDto();
        dto.setId(status.getId());
        dto.setLibelle(status.getLibelle());
        return dto;
    }
}