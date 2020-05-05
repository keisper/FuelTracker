package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.StationService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationServiceRepository extends JpaRepository<StationService, Long> {
    StationService findByIdStation(Long id);
}
