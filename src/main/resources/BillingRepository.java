package org.ups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ups.model.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {
}
