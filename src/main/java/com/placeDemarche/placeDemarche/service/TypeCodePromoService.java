package com.placeDemarche.placeDemarche.service;

import com.placeDemarche.placeDemarche.dto.TypeCodePromoResponseDto;
import com.placeDemarche.placeDemarche.entity.TypeCodePromo;
import com.placeDemarche.placeDemarche.repository.TypeCodePromoRepository;
import org.springframework.stereotype.Service;

/**
 * Service métier gérant les TypeCodePromos.
 * Fournit les opérations CRUD et les conversions entité/DTO.
 */
@Service
public class TypeCodePromoService {
    private final TypeCodePromoRepository typeCodePromoRepository;

    public TypeCodePromoService(TypeCodePromoRepository typeCodePromoRepository) {
        this.typeCodePromoRepository = typeCodePromoRepository;
    }

    /**
     * Convertit une entité TypeCodePromo en DTO de réponse.
     *
     * @param typeCodePromo L'entité TypeCodePromo à convertir
     * @return L'objet TypeCodePromoResponseDto correspondant
     */
    public TypeCodePromoResponseDto toDto(TypeCodePromo typeCodePromo) {
        TypeCodePromoResponseDto dto = new TypeCodePromoResponseDto();
        dto.setId(typeCodePromo.getId());
        dto.setLibelle(typeCodePromo.getLibelle());
        return dto;
    }
}