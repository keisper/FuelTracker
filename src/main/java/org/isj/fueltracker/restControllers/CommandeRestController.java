package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Commande;
import org.isj.fueltracker.repositories.CommamdeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommandeRestController {

    private final CommamdeRepository commamdeRepository;

    //generation du contructeur
    public CommandeRestController(CommamdeRepository commamdeRepository) {
        this.commamdeRepository = commamdeRepository;
    }

    @GetMapping("listerCommande")
    public List<Commande> getAllCommande(){
        return commamdeRepository.findAll();
    }

    @PostMapping("creerCommande")
    public Commande createCommande(@RequestBody Commande commande){
        return commamdeRepository.save(commande);
    }
    @PutMapping("modifierCommande")
    public Commande updateCommande(@RequestBody Commande commande) throws Exception {
        if(commande.getIdCommande() == null){
            throw new Exception("commande non existant");
        }

        return commamdeRepository.save(commande);
    }

    @DeleteMapping("supprimerCommande/{idCommande}")
    public void deleteCommande(@PathVariable Long idCommande){
        commamdeRepository.deleteById(idCommande);
    }
}
