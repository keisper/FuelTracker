package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.TypeCarburant;
import org.isj.fueltracker.repositories.TypeCarburantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class TypeCarburantRestController {

    private final TypeCarburantRepository typeCarburantRepository;

    public TypeCarburantRestController(TypeCarburantRepository typeCarburantRepository) {
        this.typeCarburantRepository = typeCarburantRepository;
    }

    @GetMapping("listerTypeCarburant")
    public List<TypeCarburant> getAllPompeTypeCarburant(){
        return typeCarburantRepository.findAll();
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
}
