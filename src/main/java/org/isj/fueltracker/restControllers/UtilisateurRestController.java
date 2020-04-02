package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.UtilisateurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class UtilisateurRestController {
    
    private final UtilisateurRepository utilisateurRepository;
    
    //contructeur
    public UtilisateurRestController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @GetMapping("listerUtilisateur")
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    @PostMapping("creerUtilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }
    @PutMapping("modifierUtilisateur")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) throws Exception {
        if(utilisateur.getIdUtilisateur() == null){
            throw new Exception("Utilisateur non existant");
        }

        return utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("supprimerUtilisateur/{idUtilisateur}")
    public void deleteUtilisateur(@PathVariable Long idUtilisateur){
        utilisateurRepository.deleteById(idUtilisateur);
    }
}
