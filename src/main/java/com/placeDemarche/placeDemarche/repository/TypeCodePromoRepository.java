package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.TypeCodePromo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité TypeCodePromo.
 */
@Repository
public interface TypeCodePromoRepository extends JpaRepository<TypeCodePromo, Long> {
}