package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;

/**
 * DTO de réponse pour Colis.
 */
public class ColisResponseDto {
    private Long id;
    private BigDecimal fraisDePort;
    private BigDecimal montantFranco;
    private BigDecimal tauxCommissionApplique;
    private Integer quantite;
    private Integer quantiteRetournee;
    private BigDecimal montantRembourse;
    private Integer noteProduit;
    private String commentaireProduit;
    private Integer noteVendeur;
    private String commentaireVendeur;
    private ProduitVariantResponseDto produitVariant;

    public ColisResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(BigDecimal fraisDePort) {
        this.fraisDePort = fraisDePort;
    }

    public BigDecimal getMontantFranco() {
        return montantFranco;
    }

    public void setMontantFranco(BigDecimal montantFranco) {
        this.montantFranco = montantFranco;
    }

    public BigDecimal getTauxCommissionApplique() {
        return tauxCommissionApplique;
    }

    public void setTauxCommissionApplique(BigDecimal tauxCommissionApplique) {
        this.tauxCommissionApplique = tauxCommissionApplique;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Integer getQuantiteRetournee() {
        return quantiteRetournee;
    }

    public void setQuantiteRetournee(Integer quantiteRetournee) {
        this.quantiteRetournee = quantiteRetournee;
    }

    public BigDecimal getMontantRembourse() {
        return montantRembourse;
    }

    public void setMontantRembourse(BigDecimal montantRembourse) {
        this.montantRembourse = montantRembourse;
    }

    public Integer getNoteProduit() {
        return noteProduit;
    }

    public void setNoteProduit(Integer noteProduit) {
        this.noteProduit = noteProduit;
    }

    public String getCommentaireProduit() {
        return commentaireProduit;
    }

    public void setCommentaireProduit(String commentaireProduit) {
        this.commentaireProduit = commentaireProduit;
    }

    public Integer getNoteVendeur() {
        return noteVendeur;
    }

    public void setNoteVendeur(Integer noteVendeur) {
        this.noteVendeur = noteVendeur;
    }

    public String getCommentaireVendeur() {
        return commentaireVendeur;
    }

    public void setCommentaireVendeur(String commentaireVendeur) {
        this.commentaireVendeur = commentaireVendeur;
    }



    public ProduitVariantResponseDto getProduitVariant() {
        return produitVariant;
    }

    public void setProduitVariant(ProduitVariantResponseDto produitVariant) {
        this.produitVariant = produitVariant;
    }
}