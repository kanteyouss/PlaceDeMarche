package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.CodePromo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité CodePromo.
 */
@Repository
public interface CodePromoRepository extends JpaRepository<CodePromo, Long> {
}