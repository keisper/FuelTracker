package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class UtilisateurRestController {
    
    private final UtilisateurRepository utilisateurRepository;

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

    @GetMapping("retrouverUtilisateurByLoginAndPassword/{login}/{password}")
    public Utilisateur getUtilisateurByUsernameAndPassword(@PathVariable String login, @PathVariable String password){
        return utilisateurRepository.findByUsernameAndPassword(login, password);
    }

    /**
     * méthode permettant d'enregistrer un utilisateur à partir du paramètre utilisateur
     * @param utilisateur
     * @return
     */
    @PostMapping("creerUtilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
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
        if(utilisateur.getIdUtilisateur() == null){
            throw new Exception("Utilisateur non existant");
        }

        return utilisateurRepository.save(utilisateur);
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
