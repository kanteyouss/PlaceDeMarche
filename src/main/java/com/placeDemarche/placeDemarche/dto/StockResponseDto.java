package com.placeDemarche.placeDemarche.dto;

/**
 * DTO de réponse pour Stock.
 */
public class StockResponseDto {
    private Long id;
    private Integer quantite;
    private ProduitVariantResponseDto produitVariant;
    private EntrepotResponseDto entrepot;

    public StockResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public ProduitVariantResponseDto getProduitVariant() {
        return produitVariant;
    }

    public void setProduitVariant(ProduitVariantResponseDto produitVariant) {
        this.produitVariant = produitVariant;
    }

    public EntrepotResponseDto getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(EntrepotResponseDto entrepot) {
        this.entrepot = entrepot;
    }
}