package org.isj.fueltracker.restControllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.isj.fueltracker.security.LoginViewModel;
import org.isj.fueltracker.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {
    
    private final UtilisateurRepository utilisateurRepository;
    private AuthenticationManager authenticationManager;


    /**
     *
     * @param utilisateurRepository
     */
    //contructeur
    public UtilisateurRestController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * méthode permettant d'afficher la liste des utilisateurs
     * @return
     */
    @GetMapping("listerUtilisateur")
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    @GetMapping("loginUtilisateur/{username}/{password}")
    public Utilisateur loginUser(@PathVariable String username, @PathVariable String password){
        return utilisateurRepository.findByUsernameAndPassword(username, password);
    }

    /**
     * méthode permettant d'enregistrer un utilisateur à partir du paramètre utilisateur
     * @param utilisateur
     * @return
     */
    @PostMapping("creerUtilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateur.setActive(true);
        return utilisateurRepository.save(utilisateur);
    }

    /**
     * méthode permettant de modifier un utilisateur enregistré en prenant en entrée l'id de l'utilisateur
     * @param utilisateur
     * @return
     * @throws Exception
     */
    @PutMapping("modifierUtilisateur")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception {
        if (utilisateurRepository.findById(utilisateur.getIdUtilisateur()).isPresent()){
            //Utilisateur utilisateur1 = utilisateurRepository.findById(utilisateur.getIdUtilisateur()).get();
            return utilisateurRepository.save(utilisateur);
        }else {
            return null;
        }
    }

    /**
     * méthode permettant de supprimer un utilisateur enregistré en prenant en entrée l'id de l'utilisateur
     * @param idUtilisateur
     */
    @DeleteMapping("supprimerUtilisateur/{idUtilisateur}")
    public void deleteUtilisateur(@PathVariable Long idUtilisateur){
        utilisateurRepository.deleteById(idUtilisateur);
    }

    @GetMapping("retrouverUtilisateurById/{idUtilisateur}")
    public Optional<Utilisateur> getIdUtilisateur(@PathVariable Long idUtilisateur){
        return utilisateurRepository.findByIdUtilisateur(idUtilisateur);
    }
}
