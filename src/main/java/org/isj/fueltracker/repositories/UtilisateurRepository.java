package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername (String username);
    Utilisateur findByUsernameAndPassword (String username, String password);
    Optional<Utilisateur> findByIdUtilisateur(Long id);
}
