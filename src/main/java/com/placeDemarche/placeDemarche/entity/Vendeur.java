package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Représente l'entité Vendeur (`vendeur`).
 */
@Entity
@Table(name = "vendeur")
public class Vendeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_boutique", length = 150, nullable = false)
    private String nomBoutique;

    @Column(length = 150, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String telephone;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String adresse;

    @Column(length = 100)
    private String ville;

    @Column(name = "rib_iban", length = 100, nullable = false)
    private String ribIban;

    @Column(name = "date_inscription")
    private LocalDateTime dateInscription;

    public Vendeur() {
    }

    public Vendeur(Long id, String nomBoutique, String email, String telephone, String adresse, String ville, String ribIban, LocalDateTime dateInscription) {
        this.id = id;
        this.nomBoutique = nomBoutique;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.ville = ville;
        this.ribIban = ribIban;
        this.dateInscription = dateInscription;
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