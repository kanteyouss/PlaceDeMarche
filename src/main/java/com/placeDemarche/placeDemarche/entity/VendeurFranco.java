package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Représente l'entité VendeurFranco (`vendeur_franco`).
 */
@Entity
@Table(name = "vendeur_franco")
public class VendeurFranco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seuil_montant", nullable = false, precision = 10, scale = 2)
    private BigDecimal seuilMontant;

    @Column(name = "date_application", nullable = false)
    private LocalDateTime dateApplication;

    @Column(nullable = false)
    private Boolean actif;

    @ManyToOne
    @JoinColumn(name = "vendeur_id", nullable = false)
    private Vendeur vendeur;

    public VendeurFranco() {
    }

    public VendeurFranco(Long id, BigDecimal seuilMontant, LocalDateTime dateApplication, Boolean actif, Vendeur vendeur) {
        this.id = id;
        this.seuilMontant = seuilMontant;
        this.dateApplication = dateApplication;
        this.actif = actif;
        this.vendeur = vendeur;
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

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }
}