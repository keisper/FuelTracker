package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Commande;
import org.isj.fueltracker.repositories.CommamdeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class CommandeRestController {

    private final CommamdeRepository commamdeRepository;

    /**
     * localhost:8085/fueltracker/api/listerCommande
     * @param commamdeRepository
     */
    public CommandeRestController(CommamdeRepository commamdeRepository) {
        this.commamdeRepository = commamdeRepository;
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
    public Optional<Commande> getIdCommande(@PathVariable Long idCommande){
        return commamdeRepository.findByIdCommande(idCommande);
    }
}
