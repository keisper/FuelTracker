package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.StationService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationServiceRepository extends JpaRepository<StationService, Long> {
}
