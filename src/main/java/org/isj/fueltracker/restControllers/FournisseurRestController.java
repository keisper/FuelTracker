package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Fournisseur;
import org.isj.fueltracker.repositories.FournisseurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class FournisseurRestController {
    private final FournisseurRepository fournisseurRepository;

    //contructeur
    public FournisseurRestController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @GetMapping("listerFournisseur")
    public List<Fournisseur> getAllFournisseur(){
        return fournisseurRepository.findAll();
    }

    @PostMapping("creerFournisseur")
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur){
        return fournisseurRepository.save(fournisseur);
    }
    @PutMapping("modifierFournisseur")
    public Fournisseur updateFournisseur(@RequestBody Fournisseur fournisseur) throws Exception {
        if(fournisseur.getIdFournisseur() == null){
            throw new Exception("Fournisseur non existant");
        }

        return fournisseurRepository.save(fournisseur);
    }

    @DeleteMapping("supprimerFournisseur/{idFournisseur}")
    public void deleteFournisseur(@PathVariable Long idFournisseur){
        fournisseurRepository.deleteById(idFournisseur);
    }
}
