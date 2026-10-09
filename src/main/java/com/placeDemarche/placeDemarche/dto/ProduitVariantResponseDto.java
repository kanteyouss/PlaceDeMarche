package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;

/**
 * DTO de réponse pour ProduitVariant.
 */
public class ProduitVariantResponseDto {
    private Long id;
    private String libelle;
    private String taille;
    private String couleur;
    private String capacite;
    private BigDecimal prix;

    public ProduitVariantResponseDto() {
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


}