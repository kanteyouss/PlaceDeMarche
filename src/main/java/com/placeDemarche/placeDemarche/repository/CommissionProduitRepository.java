package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.CommissionProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository JPA de l'entité CommissionProduit.
 */
@Repository
public interface CommissionProduitRepository extends JpaRepository<CommissionProduit, Long> {

    /**
     * Recherche les entités dont categorieidanddatefinisnull correspond.
     *
     * @param categorieId L'identifiant de categorie
     * @return La liste des CommissionProduit
     */
    List<CommissionProduit> findByCategorieIdAndDateFinIsNull(Long categorieId);
}
