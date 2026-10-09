package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Commission.
 */
@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {
}