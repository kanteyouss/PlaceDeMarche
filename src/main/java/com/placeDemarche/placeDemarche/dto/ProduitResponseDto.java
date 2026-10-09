package com.placeDemarche.placeDemarche.dto;

import java.util.List;

/**
 * DTO de réponse pour Produit.
 */
public class ProduitResponseDto {
    private Long id;
    private String nom;
    private String description;
    private VendeurResponseDto vendeur;
    private CategorieResponseDto categorie;
    private List<ProduitVariantResponseDto> variants;
    private Integer stockTotal;

    public ProduitResponseDto() {
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

    public VendeurResponseDto getVendeur() {
        return vendeur;
    }

    public void setVendeur(VendeurResponseDto vendeur) {
        this.vendeur = vendeur;
    }

    public CategorieResponseDto getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieResponseDto categorie) {
        this.categorie = categorie;
    }

    public List<ProduitVariantResponseDto> getVariants() {
        return variants;
    }

    public void setVariants(List<ProduitVariantResponseDto> variants) {
        this.variants = variants;
    }

    public Integer getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(Integer stockTotal) {
        this.stockTotal = stockTotal;
    }
}