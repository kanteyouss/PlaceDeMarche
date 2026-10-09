package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Status.
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}