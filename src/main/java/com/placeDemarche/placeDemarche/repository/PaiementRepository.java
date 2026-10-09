package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Paiement.
 */
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}