package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.IndexCarburant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndexRepository extends JpaRepository<IndexCarburant, Long> {
    Optional<IndexCarburant> findByIdIndex(Long idIndex);
}
