package com.placeDemarche.placeDemarche.dto;

/**
 * DTO de réponse pour Entrepot.
 */
public class EntrepotResponseDto {
    private Long id;
    private String nom;
    private String adresse;

    public EntrepotResponseDto() {
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}