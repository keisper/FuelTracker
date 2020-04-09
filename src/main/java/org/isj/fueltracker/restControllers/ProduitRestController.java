package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Produit;
import org.isj.fueltracker.repositories.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class ProduitRestController {
    
    private final ProduitRepository produitRepository;

    /**
     *
     * @param produitRepository
     */
    //constructeur
    public ProduitRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * méthode permettant d'afficher la liste des produits
     * @return
     */
    @GetMapping("listerProduit")
    public List<Produit> getAllProduit(){
        return produitRepository.findAll();
    }

    /**
     * méthode permettant d'enregistrer un produit à partir du paramètre produit
     * @param produit
     * @return
     */
    @PostMapping("creerProduit")
    public Produit createProduit(@RequestBody Produit produit){
        return produitRepository.save(produit);
    }

    /**
     * méthode permettant de modifier un produit enregistré en prenant en entrée l'id du produit
     * @param produit
     * @return
     * @throws Exception
     */
    @PutMapping("modifierProduit")
    public Produit updateProduit(@RequestBody Produit produit) throws Exception {
        if(produit.getIdProduit() == null){
            throw new Exception("Produit non existant");
        }

        return produitRepository.save(produit);
    }

    /**
     * méthode permettant de supprimer un produit enregistré en prenant en entrée l'id du produit
     * @param idProduit
     */
    @DeleteMapping("supprimerProduit/{idProduit}")
    public void deleteProduit(@PathVariable Long idProduit){
        produitRepository.deleteById(idProduit);
    }

    @GetMapping("retrouverProduitById/{idProduit}")
    public Optional<Produit> getIdProduit(@PathVariable Long idProduit){
        return produitRepository.findById(idProduit);
    }
}
