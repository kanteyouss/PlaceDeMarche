package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO de réponse pour VendeurFranco.
 */
public class VendeurFrancoResponseDto {
    private Long id;
    private BigDecimal seuilMontant;
    private LocalDateTime dateApplication;
    private Boolean actif;
    private VendeurResponseDto vendeur;

    public VendeurFrancoResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSeuilMontant() {
        return seuilMontant;
    }

    public void setSeuilMontant(BigDecimal seuilMontant) {
        this.seuilMontant = seuilMontant;
    }

    public LocalDateTime getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(LocalDateTime dateApplication) {
        this.dateApplication = dateApplication;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public VendeurResponseDto getVendeur() {
        return vendeur;
    }

    public void setVendeur(VendeurResponseDto vendeur) {
        this.vendeur = vendeur;
    }
}