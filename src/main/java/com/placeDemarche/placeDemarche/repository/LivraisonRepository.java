package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository JPA de l'entité Livraison.
 */
@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

    /**
     * Param.
     *
     * @param arg L'entité "id" associée
     * @return Le résultat (findStatutsByCommandeId(@)
     */
    @Query("SELECT l.status.libelle FROM Livraison l WHERE l.colis.commande.id = :id")
    List<String> findStatutsByCommandeId(@Param("id") Long id);
}