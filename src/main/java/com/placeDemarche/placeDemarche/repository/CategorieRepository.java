package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Categorie.
 */
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}