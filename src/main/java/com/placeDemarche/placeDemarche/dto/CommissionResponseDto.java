package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;

/**
 * DTO de réponse pour Commission.
 */
public class CommissionResponseDto {
    private Long id;
    private BigDecimal montant;

    public CommissionResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}