package org.isj.fueltracker.security;

import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class DbInit implements CommandLineRunner {
    private UtilisateurRepository utilisateurRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * @author  groupe_service
     * Constructeur
     * @param utilisateurRepository
     * @param passwordEncoder
     */
    public DbInit(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;

    }

    /**
     * @author groupe_service
     * Tester les méthodes des différets services
     * @param args
     */
    @Override
    public void run(String... args)  {

        utilisateurRepository.deleteAll();

        Utilisateur utilisateur = new Utilisateur("TIYOUH","Keisper","Camerounais","Cameroun","Yaoundé",12,
                Utilisateur.Statut.Personne_Morale,"ADMIN","keisper",bCryptPasswordEncoder.encode("keisper1234"),
                "keisper99@gmail.com",true);

        utilisateurRepository.save(utilisateur);

    }
}
