package org.ups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ups.model.FraudDetection;

@Repository
public interface FraudRepository extends JpaRepository<FraudDetection, Integer> {
    // Spring Boot automatically implements save(), findAll(), findById(), deleteById()
}