package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LigneCommandeReposiroty extends JpaRepository<LigneCommande, Long> {

    Optional<LigneCommande> findByIdLigneCommande(Long id);
}
