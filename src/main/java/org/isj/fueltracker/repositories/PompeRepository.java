package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Pompe;
import org.isj.fueltracker.entities.StationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PompeRepository extends JpaRepository<Pompe, Long> {
    Pompe findByIdPompe(Long id);
    List<Pompe> findAllByStationService(StationService stationService);
}
