package com.placeDemarche.placeDemarche.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de requête pour Commande.
 */
public class CommandeRequestDto {
    private Long id;
    private LocalDateTime dateCommande;
    private Long clientId;
    private List<LigneCommandeRequestDto> lignes;

    public CommandeRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<LigneCommandeRequestDto> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeRequestDto> lignes) {
        this.lignes = lignes;
    }
}
