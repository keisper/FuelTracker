package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
