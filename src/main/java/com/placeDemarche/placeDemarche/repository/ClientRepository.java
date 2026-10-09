package com.placeDemarche.placeDemarche.repository;

import com.placeDemarche.placeDemarche.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository JPA de l'entité Client.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}