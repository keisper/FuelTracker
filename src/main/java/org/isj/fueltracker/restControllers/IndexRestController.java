package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Index;
import org.isj.fueltracker.repositories.IndexRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class IndexRestController {

    private final IndexRepository indexRepository;

    public IndexRestController(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    @GetMapping("listerIndex")
    public List<Index> getAllIndex(){
        return indexRepository.findAll();
    }

    @PostMapping("creerIndex")
    public Index createIndex(@RequestBody Index index){
        return indexRepository.save(index);
    }

    @DeleteMapping("supprimerIndex/{idIndex}")
    public void deleteIndex(@PathVariable Long idIndex){
        indexRepository.deleteById(idIndex);
    }

    @GetMapping("retrouverIndexById/{idIndex}")
    public Optional<Index> getIdIndex(@PathVariable Long idIndex){
        return indexRepository.findByIdIndex(idIndex);
    }

    @PutMapping("modifierIndex")
    public Index updateIndex(@RequestBody Index index) throws Exception {
        if(index.getIdIndex() == null){
            throw new Exception("Index non existant");
        }

        return indexRepository.save(index);
    }
}
