package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Fournisseur;
import org.isj.fueltracker.repositories.FournisseurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("/api/fournisseur")
@CrossOrigin("*")
public class FournisseurRestController {
    private final FournisseurRepository fournisseurRepository;

    /**
     * Constructeur
     * @param fournisseurRepository
     */
    //contructeur
    public FournisseurRestController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    /**
     * méthode permettant d'afficher la liste des fournisseurs
     * @return
     */
    @GetMapping("listerFournisseur")
    public List<Fournisseur> getAllFournisseur(){
        return fournisseurRepository.findAll();
    }

    /**
     * méthode permettant d'enregistrer un fournisseur à partir du paramètre fournisseur
     * @param fournisseur
     * @return
     */
    @PostMapping("creerFournisseur")
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }

    /**
     * méthode permettant de modifier un fournisseur enregistré en prenant en entrée l'id du fournisseur
     * @param fournisseur
     * @return
     * @throws Exception
     */
    @PutMapping("modifierFournisseur")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur) throws Exception {
        if(fournisseur.getIdFournisseur() == null){
            throw new Exception("Fournisseur non existant");
        }

        return fournisseurRepository.save(fournisseur);
    }

    /**
     * méthode permettant de supprimer un fournisseur enregistré en prenant en entrée l'id du fournisseur
     * @param idFournisseur
     */
    @DeleteMapping("supprimerFournisseur/{idFournisseur}")
    public void deleteFournisseur(@PathVariable Long idFournisseur){
        fournisseurRepository.deleteById(idFournisseur);
    }

    @GetMapping("retrouverFournisseurById/{idFournisseur}")
    public Optional<Fournisseur> getIdFournisseur(@PathVariable Long idFournisseur){
        return fournisseurRepository.findByIdFournisseur(idFournisseur);
    }
}
