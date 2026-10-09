package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Représente l'entité Commission (`commission`).
 */
@Entity
@Table(name = "commission")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal montant;

    public Commission() {
    }

    public Commission(Long id, BigDecimal montant) {
        this.id = id;
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }
}