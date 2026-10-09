package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO de réponse pour CommissionProduit.
 */
public class CommissionProduitResponseDto {
    private Long id;
    private BigDecimal taux;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private CategorieResponseDto categorie;
    private CommissionResponseDto commission;

    public CommissionProduitResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public CategorieResponseDto getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieResponseDto categorie) {
        this.categorie = categorie;
    }

    public CommissionResponseDto getCommission() {
        return commission;
    }

    public void setCommission(CommissionResponseDto commission) {
        this.commission = commission;
    }
}