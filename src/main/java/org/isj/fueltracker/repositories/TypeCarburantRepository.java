package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Fournisseur;
import org.isj.fueltracker.entities.TypeCarburant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TypeCarburantRepository extends JpaRepository<TypeCarburant, Long> {
    Optional<TypeCarburant> findByIdTypeCarburant(Long id);
    List<TypeCarburant> findAllByFournisseur(Fournisseur fournisseur);
}
