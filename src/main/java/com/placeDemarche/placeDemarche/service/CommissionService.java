package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.CommissionResponseDto;
import com.placeDemarche.placeDemarche.entity.Commission;
import com.placeDemarche.placeDemarche.repository.CommissionRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les Commissions.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class CommissionService {
    private final CommissionRepository commissionRepository;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    /**
     * Convertit une entité Commission en DTO de réponse.
     *
     * @param commission L'entité Commission à convertir
     * @return L'objet CommissionResponseDto correspondant
     */
    public CommissionResponseDto toDto(Commission commission) {
        CommissionResponseDto dto = new CommissionResponseDto();
        dto.setId(commission.getId());
        dto.setMontant(commission.getMontant());
        return dto;
    }
}