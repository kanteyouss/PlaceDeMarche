package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Représente l'entité Colis (`colis`).
 */
@Entity
@Table(name = "colis")
public class Colis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "frais_de_port", nullable = false, precision = 10, scale = 2)
    private BigDecimal fraisDePort;

    @Column(name = "montant_franco", precision = 10, scale = 2)
    private BigDecimal montantFranco;

    @Column(name = "taux_commission_applique", nullable = false, precision = 5, scale = 2)
    private BigDecimal tauxCommissionApplique;

    @Column(nullable = false)
    private Integer quantite;

    @Column(name = "quantite_retournee", nullable = false)
    private Integer quantiteRetournee;

    @Column(name = "montant_rembourse", precision = 10, scale = 2)
    private BigDecimal montantRembourse;

    @Column(name = "note_produit")
    private Integer noteProduit;

    @Column(name = "commentaire_produit", columnDefinition = "TEXT")
    private String commentaireProduit;

    @Column(name = "note_vendeur")
    private Integer noteVendeur;

    @Column(name = "commentaire_vendeur", columnDefinition = "TEXT")
    private String commentaireVendeur;

    @ManyToOne
    @JoinColumn(name = "commande_id", nullable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_variant_id", nullable = false)
    private ProduitVariant produitVariant;

    public Colis() {
    }

    public Colis(Long id, BigDecimal fraisDePort, BigDecimal montantFranco, BigDecimal tauxCommissionApplique, Integer quantite, Integer quantiteRetournee, BigDecimal montantRembourse, Integer noteProduit, String commentaireProduit, Integer noteVendeur, String commentaireVendeur, Commande commande, ProduitVariant produitVariant) {
        this.id = id;
        this.fraisDePort = fraisDePort;
        this.montantFranco = montantFranco;
        this.tauxCommissionApplique = tauxCommissionApplique;
        this.quantite = quantite;
        this.quantiteRetournee = quantiteRetournee;
        this.montantRembourse = montantRembourse;
        this.noteProduit = noteProduit;
        this.commentaireProduit = commentaireProduit;
        this.noteVendeur = noteVendeur;
        this.commentaireVendeur = commentaireVendeur;
        this.commande = commande;
        this.produitVariant = produitVariant;
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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public ProduitVariant getProduitVariant() {
        return produitVariant;
    }

    public void setProduitVariant(ProduitVariant produitVariant) {
        this.produitVariant = produitVariant;
    }
}