package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO de réponse pour Commande.
 */
public class CommandeResponseDto {
    private Long id;
    private LocalDateTime dateCommande;
    private BigDecimal montantTotal;
    private ClientResponseDto client;
    private List<ColisResponseDto> colis;
    private String statut;

    public CommandeResponseDto() {
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

    public BigDecimal getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }

    public ClientResponseDto getClient() {
        return client;
    }

    public void setClient(ClientResponseDto client) {
        this.client = client;
    }

    public List<ColisResponseDto> getColis() {
        return colis;
    }

    public void setColis(List<ColisResponseDto> colis) {
        this.colis = colis;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}