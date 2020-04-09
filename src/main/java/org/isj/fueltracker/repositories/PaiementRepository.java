package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    Optional<Paiement> findById(Long id);
}
