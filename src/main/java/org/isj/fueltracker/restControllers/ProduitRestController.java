package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Produit;
import org.isj.fueltracker.repositories.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class ProduitRestController {
    
    private final ProduitRepository produitRepository;
    
    //constructeur
    public ProduitRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping("listerProduit")
    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }

    @PostMapping("creerProduit")
    public Produit createProduit(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }
    @PutMapping("modifierProduit")
    public Produit updateProduit(@RequestBody Produit produit) throws Exception {
        if(produit.getIdProduit() == null){
            throw new Exception("Produit non existant");
        }

        return produitRepository.save(produit);
    }

    @DeleteMapping("supprimerProduit/{idProduit}")
    public void deleteProduit(@PathVariable Long idProduit){
        produitRepository.deleteById(idProduit);
    }
}
