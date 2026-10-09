package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.VendeurFranco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité VendeurFranco.
 */
@Repository
public interface VendeurFrancoRepository extends JpaRepository<VendeurFranco, Long> {
}