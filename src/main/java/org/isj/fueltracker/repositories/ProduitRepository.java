package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findById(Long id);
}
