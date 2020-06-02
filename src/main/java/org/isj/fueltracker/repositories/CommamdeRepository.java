package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Commande;
import org.isj.fueltracker.entities.StationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommamdeRepository extends JpaRepository<Commande, Long> {

    Commande findByIdCommande(Long id);
    List<Commande> findAllByStationService(StationService stationService);
}
