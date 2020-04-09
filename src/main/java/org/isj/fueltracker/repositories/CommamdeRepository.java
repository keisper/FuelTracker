package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommamdeRepository extends JpaRepository<Commande, Long> {

    Optional<Commande> findById(Long id);
}
