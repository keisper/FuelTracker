package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestBody;

import javax.rmi.CORBA.Util;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurRestControllerTest {

    @Test
    public void createUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception{
        UtilisateurRepository utilisateurRepository = null;
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setNom("TIYOUH");
        utilisateur1.setPrenom("keisper");
        utilisateurRepository.save(utilisateur1);
    }

}