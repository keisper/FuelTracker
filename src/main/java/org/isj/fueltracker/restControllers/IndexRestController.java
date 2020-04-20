package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.IndexCarburant;
import org.isj.fueltracker.repositories.IndexRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/index")
@CrossOrigin("*")
public class IndexRestController {

    private final IndexRepository indexRepository;

    public IndexRestController(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    @GetMapping("listerIndex")
    public List<IndexCarburant> getAllIndex(){
        return indexRepository.findAll();
    }

    @PostMapping("creerIndex")
    public IndexCarburant createIndex(@RequestBody IndexCarburant index){
        return indexRepository.save(index);
    }

    @DeleteMapping("supprimerIndex/{idIndex}")
    public void deleteIndex(@PathVariable Long idIndex){
        indexRepository.deleteById(idIndex);
    }

    @GetMapping("retrouverIndexById/{idIndex}")
    public Optional<IndexCarburant> getIdIndex(@PathVariable Long idIndex){
        return indexRepository.findByIdIndex(idIndex);
    }

    @PutMapping("modifierIndex")
    public IndexCarburant updateIndex(@RequestBody IndexCarburant index) throws Exception {
        if(index.getIdIndex() == null){
            throw new Exception("IndexCarburant non existant");
        }

        return indexRepository.save(index);
    }
}
