package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository JPA de l'entité Colis.
 */
@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {

    /**
     * Recherche les entités dont commandeid correspond.
     *
     * @param commandeId L'identifiant de commande
     * @return La liste des Colis
     */
    List<Colis> findByCommandeId(Long commandeId);

    /**
     * Param.
     *
     * @param arg L'entité "id" associée
     * @return Le résultat (calculerMontantTotal(@)
     */
    @Query("SELECT COALESCE(SUM(c.quantite * c.produitVariant.prix + c.fraisDePort), 0) FROM Colis c WHERE c.commande.id = :id")
    BigDecimal calculerMontantTotal(@Param("id") Long commandeId);
}