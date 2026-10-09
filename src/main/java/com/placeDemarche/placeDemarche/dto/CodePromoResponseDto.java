package com.placeDemarche.placeDemarche.dto;

import java.time.LocalDate;

/**
 * DTO de réponse pour CodePromo.
 */
public class CodePromoResponseDto {
    private Long id;
    private String code;
    private LocalDate dateValidite;
    private Integer nombreUtilisationMax;
    private TypeCodePromoResponseDto typeCodePromo;

    public CodePromoResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(LocalDate dateValidite) {
        this.dateValidite = dateValidite;
    }

    public Integer getNombreUtilisationMax() {
        return nombreUtilisationMax;
    }

    public void setNombreUtilisationMax(Integer nombreUtilisationMax) {
        this.nombreUtilisationMax = nombreUtilisationMax;
    }

    public TypeCodePromoResponseDto getTypeCodePromo() {
        return typeCodePromo;
    }

    public void setTypeCodePromo(TypeCodePromoResponseDto typeCodePromo) {
        this.typeCodePromo = typeCodePromo;
    }
}