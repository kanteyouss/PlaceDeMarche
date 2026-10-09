package com.placeDemarche.placeDemarche.dto;

/**
 * DTO de réponse pour Status.
 */
public class StatusResponseDto {
    private Long id;
    private String libelle;

    public StatusResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}