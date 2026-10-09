package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository JPA de l'entité Stock.
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    /**
     * Param.
     *
     * @param arg L'entité "id" associée
     * @return Le résultat (sumQuantiteByProduitId(@)
     */
    @Query("SELECT COALESCE(SUM(s.quantite),0) FROM Stock s WHERE s.produitVariant.produit.id = :id")
    Long sumQuantiteByProduitId(@Param("id") Long id);
}