package com.placeDemarche.placeDemarche.dto;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour Livraison.
 */
public class LivraisonResponseDto {
    private Long id;
    private String numeroSuivi;
    private LocalDateTime dateExpedition;
    private ColisResponseDto colis;
    private StatusResponseDto status;

    public LivraisonResponseDto() {
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

    public ColisResponseDto getColis() {
        return colis;
    }

    public void setColis(ColisResponseDto colis) {
        this.colis = colis;
    }

    public StatusResponseDto getStatus() {
        return status;
    }

    public void setStatus(StatusResponseDto status) {
        this.status = status;
    }
}