package org.isj.fueltracker.security;

import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class DbInit implements CommandLineRunner {
    private UtilisateurRepository utilisateurRepository;
    private PasswordEncoder passwordEncoder;

    /**
     * @author  groupe_service
     * Constructeur
     * @param utilisateurRepository
     * @param passwordEncoder
     */
    public DbInit(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @author groupe_service
     * Tester les méthodes des différets services
     * @param args
     */
    @Override
    public void run(String... args)  {
        utilisateurRepository.deleteAll();

        Utilisateur utilisateur = new Utilisateur("Tiyouh","keisper","Cameroun","Cameroun","Manguier",
                12, Utilisateur.Statut.Personne_Morale,"ADMIN",
                "keisper",passwordEncoder.encode("keisper"),"");

        utilisateurRepository.save(utilisateur);
    }
}
