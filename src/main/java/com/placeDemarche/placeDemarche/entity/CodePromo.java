package com.placeDemarche.placeDemarche.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Représente l'entité CodePromo (`code_promo`).
 */
@Entity
@Table(name = "code_promo")
public class CodePromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String code;

    @Column(name = "date_validite", nullable = false)
    private LocalDate dateValidite;

    @Column(name = "nombre_utilisation_max")
    private Integer nombreUtilisationMax;

    @ManyToOne
    @JoinColumn(name = "type_code_promo_id", nullable = false)
    private TypeCodePromo typeCodePromo;

    public CodePromo() {
    }

    public CodePromo(Long id, String code, LocalDate dateValidite, Integer nombreUtilisationMax, TypeCodePromo typeCodePromo) {
        this.id = id;
        this.code = code;
        this.dateValidite = dateValidite;
        this.nombreUtilisationMax = nombreUtilisationMax;
        this.typeCodePromo = typeCodePromo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(LocalDate dateValidite) {
        this.dateValidite = dateValidite;
    }

    public Integer getNombreUtilisationMax() {
        return nombreUtilisationMax;
    }

    public void setNombreUtilisationMax(Integer nombreUtilisationMax) {
        this.nombreUtilisationMax = nombreUtilisationMax;
    }

    public TypeCodePromo getTypeCodePromo() {
        return typeCodePromo;
    }

    public void setTypeCodePromo(TypeCodePromo typeCodePromo) {
        this.typeCodePromo = typeCodePromo;
    }
}