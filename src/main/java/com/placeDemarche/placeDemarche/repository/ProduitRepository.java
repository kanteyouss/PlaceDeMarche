package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Produit.
 */
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}