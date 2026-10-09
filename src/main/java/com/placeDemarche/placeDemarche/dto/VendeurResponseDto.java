package com.placeDemarche.placeDemarche.dto;

import java.time.LocalDateTime;

/**
 * DTO de réponse pour Vendeur.
 */
public class VendeurResponseDto {
    private Long id;
    private String nomBoutique;
    private String email;
    private String telephone;
    private String adresse;
    private String ville;
    private String ribIban;
    private LocalDateTime dateInscription;

    public VendeurResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRibIban() {
        return ribIban;
    }

    public void setRibIban(String ribIban) {
        this.ribIban = ribIban;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }
}