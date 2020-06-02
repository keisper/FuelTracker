package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.TypeCarburant;
import org.isj.fueltracker.repositories.FournisseurRepository;
import org.isj.fueltracker.repositories.TypeCarburantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/typeCarburant")
@CrossOrigin("*")
public class TypeCarburantRestController {

    private final TypeCarburantRepository typeCarburantRepository;
    private final FournisseurRepository fournisseurRepository;

    public TypeCarburantRestController(TypeCarburantRepository typeCarburantRepository, FournisseurRepository fournisseurRepository) {
        this.typeCarburantRepository = typeCarburantRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @GetMapping("listerTypeCarburant")
    public List<TypeCarburant> getAllPompeTypeCarburant(){
        List<TypeCarburant> typeCarburants = typeCarburantRepository.findAll();
        for(TypeCarburant tc : typeCarburants){
            tc.getFournisseur();
        }

        return typeCarburants;
    }

    @PostMapping("creerTypeCarburant")
    public TypeCarburant createTypeCarburant(@RequestBody TypeCarburant typeCarburant){
        return typeCarburantRepository.save(typeCarburant);
    }

    @DeleteMapping("supprimerTypeCarburant/{idTypeCarburant}")
    public void deleteTypeCarburant(@PathVariable Long idTypeCarburant){
        typeCarburantRepository.deleteById(idTypeCarburant);
    }

    @GetMapping("retrouverTypeCarburantById/{idTypeCarburant}")
    public Optional<TypeCarburant> getIdTypeCarburant(@PathVariable Long idTypeCarburant){
        return typeCarburantRepository.findByIdTypeCarburant(idTypeCarburant);
    }

    @PutMapping("modifierTypeCarburant")
    public TypeCarburant updateTypeCarburant(@RequestBody TypeCarburant typeCarburant) throws Exception {
        if(typeCarburant.getIdTypeCarburant() == null){
            throw new Exception("Type Carburant non existant");
        }

        return typeCarburantRepository.save(typeCarburant);
    }

    @GetMapping("byFournisseur/{idFournisseur}")
    public List<TypeCarburant> getAllByFournisseur(@PathVariable Long idFournisseur){
        return typeCarburantRepository.findAllByFournisseur(fournisseurRepository.findByIdFournisseur(idFournisseur));
    }
}