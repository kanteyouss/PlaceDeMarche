package com.placeDemarche.placeDemarche.dto;

import java.math.BigDecimal;

/**
 * DTO de requête pour LigneCommande.
 */
public class LigneCommandeRequestDto {
    private Long produitVariantId;
    private Integer quantite;
    private BigDecimal fraisDePort;

    public LigneCommandeRequestDto() {
    }

    public Long getProduitVariantId() {
        return produitVariantId;
    }

    public void setProduitVariantId(Long produitVariantId) {
        this.produitVariantId = produitVariantId;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(BigDecimal fraisDePort) {
        this.fraisDePort = fraisDePort;
    }
}
