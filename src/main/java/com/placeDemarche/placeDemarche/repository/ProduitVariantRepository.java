package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.ProduitVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository JPA de l'entité ProduitVariant.
 */
@Repository
public interface ProduitVariantRepository extends JpaRepository<ProduitVariant, Long> {

    /**
     * Recherche les entités dont produitid correspond.
     *
     * @param produitId L'identifiant de produit
     * @return La liste des ProduitVariant
     */
    List<ProduitVariant> findByProduitId(Long produitId);
}