package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Paiement;
import org.isj.fueltracker.repositories.PaiementRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class PaiementRestController {
    private final PaiementRepository paiementRepository;

    /**
     *
     * @param paiementRepository
     */
    //constructeur
    public PaiementRestController(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    /**
     * méthode permettant d'afficher la liste des paiements
     * @return
     */
    @GetMapping("listerPaiement")
    public List<Paiement> getAllPaiement(){
        return paiementRepository.findAll();
    }

    /**
     * méthode permettant d'enregistrer un paiement à partir du paramètre paiement
     * @param paiement
     * @return
     */
    @PostMapping("creerPaiement")
    public Paiement createPaiement(@RequestBody Paiement paiement){
        return paiementRepository.save(paiement);
    }

    /**
     * méthode permettant de modifier un paiement enregistré en prenant en entrée l'id du paiement
     * @param paiement
     * @return
     * @throws Exception
     */
    @PutMapping("modifierPaiement")
    public Paiement updatePaiement(@RequestBody Paiement paiement) throws Exception {
        if(paiement.getIdPaiement() == null){
            throw new Exception("Paiement non existant");
        }

        return paiementRepository.save(paiement);
    }

    /**
     * méthode permettant de supprimer un paiement enregistré en prenant en entrée l'id du paiement
     * @param idPaiement
     */
    @DeleteMapping("supprimerPaiement/{idPaiement}")
    public void deletePaiement(@PathVariable Long idPaiement){
        paiementRepository.deleteById(idPaiement);
    }
}
