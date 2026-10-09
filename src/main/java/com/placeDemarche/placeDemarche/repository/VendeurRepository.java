package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Vendeur.
 */
@Repository
public interface VendeurRepository extends JpaRepository<Vendeur, Long> {
}