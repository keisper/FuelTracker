package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.IndexCarburant;
import org.isj.fueltracker.entities.Pompe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndexRepository extends JpaRepository<IndexCarburant, Long> {
    Optional<IndexCarburant> findByIdIndex(Long idIndex);
    List<IndexCarburant> findAllByPompe(Pompe pompe);
}
