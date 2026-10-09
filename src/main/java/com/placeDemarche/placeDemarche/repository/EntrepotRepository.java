package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Entrepot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Entrepot.
 */
@Repository
public interface EntrepotRepository extends JpaRepository<Entrepot, Long> {
}