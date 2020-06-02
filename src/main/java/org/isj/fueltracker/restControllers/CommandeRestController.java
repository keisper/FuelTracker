package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Commande;
import org.isj.fueltracker.entities.LigneCommande;
import org.isj.fueltracker.repositories.CommamdeRepository;
import org.isj.fueltracker.repositories.LigneCommandeReposiroty;
import org.isj.fueltracker.repositories.StationServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commande")
@CrossOrigin("*")
public class CommandeRestController {

    private final CommamdeRepository commamdeRepository;
    private LigneCommandeReposiroty ligneCommandeReposiroty;
    private StationServiceRepository stationServiceRepository;

    /**
     * @param commamdeRepository
     * @param ligneCommandeReposiroty
     * @param stationServiceRepository
     */
    public CommandeRestController(CommamdeRepository commamdeRepository, LigneCommandeReposiroty ligneCommandeReposiroty, StationServiceRepository stationServiceRepository) {
        this.commamdeRepository = commamdeRepository;
        this.ligneCommandeReposiroty = ligneCommandeReposiroty;
        this.stationServiceRepository = stationServiceRepository;
    }

    /**
     * localhost:8085/fueltracker/api/listerCommande
     * méthode permettant d'afficher la liste des commandes déjà enregistrées
     * @return
     */
    @GetMapping("listerCommande")
    public List<Commande> getAllCommande(){
        return commamdeRepository.findAll();
    }

    /**
     * localhost:8085/fueltracker/api/creerCommande
     * méthode permettant d'enregistrer une commande à partir du paramètre commande
     * @param commande
     * @return
     */
    @PostMapping("creerCommande")
    public Commande createCommande(@RequestBody Commande commande){
        return commamdeRepository.save(commande);
    }

    /**
     * fueltracker/api/modifierCommande
     * méthode permettant de modifier une commande enregistrée en prenant en entrée l'id de la commande
     * @param commande
     * @return
     * @throws Exception
     */
    @PutMapping("modifierCommande")
    public Commande updateCommande(@RequestBody Commande commande) throws Exception {
        if(commande.getIdCommande() == null){
            throw new Exception("commande non existant");
        }

        return commamdeRepository.save(commande);
    }

    /**
     * localhost:8085/fueltracker/api/supprimerCommande
     * méthode permettant de supprimer une commande enregistrée en prenant en entrée l'id de la commande
     * @param idCommande
     */
    @DeleteMapping("supprimerCommande/{idCommande}")
    public void deleteCommande(@PathVariable Long idCommande){
        commamdeRepository.deleteById(idCommande);
    }

    @GetMapping("retrouverCommandeById/{idCommande}")
    public Commande getIdCommande(@PathVariable Long idCommande){
        return commamdeRepository.findByIdCommande(idCommande);
    }

    @PostMapping("saveLignes/{idCommande}")
    public String createAll(@PathVariable Long idCommande, @RequestBody List<LigneCommande> ligneCommandes){

        Commande commande = commamdeRepository.findByIdCommande(idCommande);
        //commamdeRepository.save(commande);
        for(LigneCommande ligneCommande : ligneCommandes){
            ligneCommande.setCommande(commande);
            ligneCommandeReposiroty.save(ligneCommande);
        }

        return "Fait";
    }

    @GetMapping("byStation/{idStation}")
    public List<Commande> getAllByStation(@PathVariable Long idStation){
        return commamdeRepository.findAllByStationService(stationServiceRepository.findByIdStation(idStation));
    }
}
