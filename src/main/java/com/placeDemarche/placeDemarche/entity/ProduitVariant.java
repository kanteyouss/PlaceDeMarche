package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Représente l'entité ProduitVariant (`produit_variant`).
 */
@Entity
@Table(name = "produit_variant")
public class ProduitVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String libelle;

    @Column(length = 50)
    private String taille;

    @Column(length = 50)
    private String couleur;

    @Column(length = 50)
    private String capacite;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;

    public ProduitVariant() {
    }

    public ProduitVariant(Long id, String libelle, String taille, String couleur, String capacite, BigDecimal prix, Produit produit) {
        this.id = id;
        this.libelle = libelle;
        this.taille = taille;
        this.couleur = couleur;
        this.capacite = capacite;
        this.prix = prix;
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}