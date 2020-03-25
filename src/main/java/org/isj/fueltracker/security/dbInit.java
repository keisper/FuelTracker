package org.isj.fueltracker.security;

import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Date;

/**
 * classe utilisée pour insérer quelques utilisateurs tests en BD
 */

@Service
public class dbInit implements CommandLineRunner {
    private UtilisateurRepository utilisateurRepository;
    private DataSource dataSource;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public dbInit(UtilisateurRepository utilisateurRepository, DataSource dataSource) {
        this.utilisateurRepository = utilisateurRepository;
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
    /*
            if(utilisateurRepository.findAll().size() == 0) {
                Utilisateur admin = new Utilisateur("", "", "root@mail.com", new Date(), "", "root", bCryptPasswordEncoder.encode("1234"), Utilisateur.Sexe.masculin);
                admin.setRole(Utilisateur.Role.administrateur);
                admin.setActive(true);
                Utilisateur vie = new Utilisateur("", "", "user@mail.com", new Date(), "", "user", bCryptPasswordEncoder.encode("1234"), Utilisateur.Sexe.masculin);
                vie.setRole(Utilisateur.Role.utilisateur);
                vie.setActive(true);
                utilisateurRepository.save(admin);
                utilisateurRepository.save(vie);
            }*/
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("keisper");
        utilisateurRepository.save(utilisateur);

    }
}
