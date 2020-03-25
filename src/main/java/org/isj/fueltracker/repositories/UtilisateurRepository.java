package org.isj.fueltracker.repositories;

import org.isj.fueltracker.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByLoginAndMdp(String login, String mdp);
    Utilisateur findByLogin(String mdp);
}
