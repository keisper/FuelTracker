package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IndexRepository extends JpaRepository<Index, Long> {
    Optional<Index> findByIdIndex(Long idIndex);
}
