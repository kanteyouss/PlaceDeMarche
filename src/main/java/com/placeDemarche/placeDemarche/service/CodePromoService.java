package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.CodePromoResponseDto;
import com.placeDemarche.placeDemarche.dto.TypeCodePromoResponseDto;
import com.placeDemarche.placeDemarche.entity.CodePromo;
import com.placeDemarche.placeDemarche.entity.TypeCodePromo;
import com.placeDemarche.placeDemarche.repository.CodePromoRepository;
import com.placeDemarche.placeDemarche.service.TypeCodePromoService;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les CodePromos.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class CodePromoService {
    private final CodePromoRepository codePromoRepository;
    private final TypeCodePromoService typeCodePromoService;

    public CodePromoService(CodePromoRepository codePromoRepository, TypeCodePromoService typeCodePromoService) {
        this.codePromoRepository = codePromoRepository;
        this.typeCodePromoService = typeCodePromoService;
    }

    /**
     * Convertit une entité CodePromo en DTO de réponse.
     *
     * @param codePromo L'entité CodePromo à convertir
     * @return L'objet CodePromoResponseDto correspondant
     */
    public CodePromoResponseDto toDto(CodePromo codePromo) {
        CodePromoResponseDto dto = new CodePromoResponseDto();
        dto.setId(codePromo.getId());
        dto.setCode(codePromo.getCode());
        dto.setDateValidite(codePromo.getDateValidite());
        dto.setNombreUtilisationMax(codePromo.getNombreUtilisationMax());
        if (codePromo.getTypeCodePromo() != null) {
            dto.setTypeCodePromo(typeCodePromoService.toDto(codePromo.getTypeCodePromo()));
        }
        return dto;
    }
}