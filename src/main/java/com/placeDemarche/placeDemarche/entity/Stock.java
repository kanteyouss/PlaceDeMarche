package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;

/**
 * Représente l'entité Stock (`stock`).
 */
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "produit_variant_id", nullable = false)
    private ProduitVariant produitVariant;

    @ManyToOne
    @JoinColumn(name = "entrepot_id", nullable = false)
    private Entrepot entrepot;

    public Stock() {
    }

    public Stock(Long id, Integer quantite, ProduitVariant produitVariant, Entrepot entrepot) {
        this.id = id;
        this.quantite = quantite;
        this.produitVariant = produitVariant;
        this.entrepot = entrepot;
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

    public ProduitVariant getProduitVariant() {
        return produitVariant;
    }

    public void setProduitVariant(ProduitVariant produitVariant) {
        this.produitVariant = produitVariant;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }
}