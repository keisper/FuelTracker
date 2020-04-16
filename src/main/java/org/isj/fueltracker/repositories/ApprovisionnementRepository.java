package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement,Long> {

    Optional<Approvisionnement> findByIdApprovisionnemnt(Long id);
}
