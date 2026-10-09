package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Représente l'entité Livraison (`livraison`).
 */
@Entity
@Table(name = "livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_suivi", length = 100, nullable = false)
    private String numeroSuivi;

    @Column(name = "date_expedition")
    private LocalDateTime dateExpedition;

    @ManyToOne
    @JoinColumn(name = "colis_id", nullable = false)
    private Colis colis;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    public Livraison() {
    }

    public Livraison(Long id, String numeroSuivi, LocalDateTime dateExpedition, Colis colis, Status status) {
        this.id = id;
        this.numeroSuivi = numeroSuivi;
        this.dateExpedition = dateExpedition;
        this.colis = colis;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSuivi() {
        return numeroSuivi;
    }

    public void setNumeroSuivi(String numeroSuivi) {
        this.numeroSuivi = numeroSuivi;
    }

    public LocalDateTime getDateExpedition() {
        return dateExpedition;
    }

    public void setDateExpedition(LocalDateTime dateExpedition) {
        this.dateExpedition = dateExpedition;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}