package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Pompe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PompeRepository extends JpaRepository<Pompe, Long> {
    Optional<Pompe> findByIdPompe(Long id);
}
