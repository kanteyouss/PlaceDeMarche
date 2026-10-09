package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO de réponse pour Paiement.
 */
public class PaiementResponseDto {
    private Long id;
    private BigDecimal montant;
    private LocalDateTime datePaiement;
    private VendeurResponseDto vendeur;

    public PaiementResponseDto() {
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

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public VendeurResponseDto getVendeur() {
        return vendeur;
    }

    public void setVendeur(VendeurResponseDto vendeur) {
        this.vendeur = vendeur;
    }
}