package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
