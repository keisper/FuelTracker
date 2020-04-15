package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.LigneCommande;
import org.isj.fueltracker.repositories.LigneCommandeReposiroty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class LigneCommandeRestController {

    private final LigneCommandeReposiroty ligneCommandeReposiroty;

    public LigneCommandeRestController(LigneCommandeReposiroty ligneCommandeReposiroty) {
        this.ligneCommandeReposiroty = ligneCommandeReposiroty;
    }

    @GetMapping("listerLigneCommande")
    public List<LigneCommande> getAllLigneCommande(){
        return ligneCommandeReposiroty.findAll();
    }

    @PostMapping("creerLigneCommande")
    public LigneCommande createLigneCommande(@RequestBody LigneCommande ligneCommande){
        return ligneCommandeReposiroty.save(ligneCommande);
    }

    @DeleteMapping("supprimerLigneCommande/{idLigneCommande}")
    public void deleteFournisseurLigneCommande(@PathVariable Long idLigneCommande){
        ligneCommandeReposiroty.deleteById(idLigneCommande);
    }

    @GetMapping("retrouverLigneCommandeById/{idLigneCommande}")
    public Optional<LigneCommande> getIdLigneCommande(@PathVariable Long idLigneCommande){
        return ligneCommandeReposiroty.findByIdLigneCommande(idLigneCommande);
    }

    @PutMapping("modifierLigneCommande")
    public LigneCommande updateLigneCommande(@RequestBody LigneCommande ligneCommande) throws Exception {
        if(ligneCommande.getIdLigneCommande() == null){
            throw new Exception("Ligne Commande non existante");
        }

        return ligneCommandeReposiroty.save(ligneCommande);
    }
}
