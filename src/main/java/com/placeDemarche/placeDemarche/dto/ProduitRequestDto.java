package com.placeDemarche.placeDemarche.dto;

/**
 * DTO de requête pour Produit.
 */
public class ProduitRequestDto {
    private Long id;
    private String nom;
    private String description;
    private Long vendeurId;
    private Long categorieId;

    public ProduitRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getVendeurId() {
        return vendeurId;
    }

    public void setVendeurId(Long vendeurId) {
        this.vendeurId = vendeurId;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}