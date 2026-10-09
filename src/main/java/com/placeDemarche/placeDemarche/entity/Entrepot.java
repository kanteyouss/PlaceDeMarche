package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;

/**
 * Représente l'entité Entrepot (`entrepot`).
 */
@Entity
@Table(name = "entrepot")
public class Entrepot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nom;

    @Column(length = 255, nullable = false)
    private String adresse;

    public Entrepot() {
    }

    public Entrepot(Long id, String nom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
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