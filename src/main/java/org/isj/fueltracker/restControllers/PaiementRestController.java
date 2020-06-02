package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Paiement;
import org.isj.fueltracker.repositories.PaiementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
@CrossOrigin
public class PaiementRestController {
    private final PaiementRepository paiementRepository;
    
    //constructeur
    public PaiementRestController(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    @GetMapping("listerPaiement")
    public List<Paiement> getAllPaiement(){
        return paiementRepository.findAll();
    }

    @PostMapping("creerPaiement")
    public Paiement createPaiement(@RequestBody Paiement paiement){
        return paiementRepository.save(paiement);
    }
    @PutMapping("modifierPaiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) throws Exception {
        if(paiement.getIdPaiement() == null){
            throw new Exception("Paiement non existant");
        }

        return paiementRepository.save(paiement);
    }

    @DeleteMapping("supprimerPaiement/{idPaiement}")
    public void deletePaiement(@PathVariable Long idPaiement){
        paiementRepository.deleteById(idPaiement);
    }
}
