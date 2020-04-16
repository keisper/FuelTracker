package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Approvisionnement;
import org.isj.fueltracker.repositories.ApprovisionnementRepository;
import org.isj.fueltracker.repositories.CommamdeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class ApprovisionnementRestController {
    private final ApprovisionnementRepository approvisionnementRepository;

    /**
     * localhost:8085/fueltracker/api/listerApprovisionnement
     * @param approvisionnementRepository
     */
    public ApprovisionnementRestController(ApprovisionnementRepository approvisionnementRepository) {
        this.approvisionnementRepository = approvisionnementRepository;
    }

    /**
     * localhost:8085/fueltracker/api/listerApprovisionnement
     * méthode permettant d'afficher la liste des approvisionnements déjà enregistrées
     * @return
     */
    @GetMapping("listerApprovisionnement")
    public List<Approvisionnement> getAllApprovisionnement(){
        return approvisionnementRepository.findAll();
    }

    /**
     * localhost:8085/fueltracker/api/creerApprovisionnement
     * méthode permettant d'enregistrer une approvisionnement à partir du paramètre approvisionnement
     * @param approvisionnement
     * @return
     */
    @PostMapping("creerApprovisionnement")
    public Approvisionnement createApprovisionnement(@RequestBody Approvisionnement approvisionnement){
        return approvisionnementRepository.save(approvisionnement);
    }

    /**
     * fueltracker/api/modifierApprovisionnement
     * méthode permettant de modifier une approvisionnement enregistrée en prenant en entrée l'id de la approvisionnement
     * @param approvisionnement
     * @return
     * @throws Exception
     */
    @PutMapping("modifierApprovisionnement")
    public Approvisionnement updateApprovisionnement(@RequestBody Approvisionnement approvisionnement) throws Exception {
        if(approvisionnement.getIdApprovisionnemnt() == null){
            throw new Exception("approvisionnement non existant");
        }

        return approvisionnementRepository.save(approvisionnement);
    }

    /**
     * localhost:8085/fueltracker/api/supprimerApprovisionnement
     * méthode permettant de supprimer une approvisionnement enregistrée en prenant en entrée l'id de la approvisionnement
     * @param idApprovisionnement
     */
    @DeleteMapping("supprimerApprovisionnement/{idApprovisionnement}")
    public void deleteApprovisionnement(@PathVariable Long idApprovisionnement){
        approvisionnementRepository.deleteById(idApprovisionnement);
    }

    @GetMapping("retrouverApprovisionnementById/{idApprovisionnement}")
    public Optional<Approvisionnement> getIdApprovisionnement(@PathVariable Long idApprovisionnement){
        return approvisionnementRepository.findByIdApprovisionnemnt(idApprovisionnement);
    }
}
