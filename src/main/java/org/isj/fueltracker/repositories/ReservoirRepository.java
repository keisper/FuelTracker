package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.IndexCarburant;
import org.isj.fueltracker.entities.Reservoir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservoirRepository extends JpaRepository<Reservoir, Long> {
    Optional<Reservoir> findByIdReservoir(Long id);
    //List<Reservoir> findAllByListindex(List<IndexCarburant> list);
}
