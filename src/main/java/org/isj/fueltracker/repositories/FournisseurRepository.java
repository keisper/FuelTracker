package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    Fournisseur findByIdFournisseur(Long id);
}
