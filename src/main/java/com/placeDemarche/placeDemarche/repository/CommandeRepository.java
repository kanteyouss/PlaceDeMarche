package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Commande.
 */
@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}