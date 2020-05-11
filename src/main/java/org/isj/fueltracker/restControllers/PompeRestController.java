package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Pompe;
import org.isj.fueltracker.repositories.PompeRepository;
import org.isj.fueltracker.repositories.StationServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pompe")
@CrossOrigin("*")
public class PompeRestController {

    private final PompeRepository pompeRepository;
    private StationServiceRepository stationServiceRepository;

    public PompeRestController(PompeRepository pompeRepository, StationServiceRepository stationServiceRepository) {
        this.pompeRepository = pompeRepository;
        this.stationServiceRepository = stationServiceRepository;
    }

    @GetMapping("listerPompe")
    public List<Pompe> getAllPompe(){
        return pompeRepository.findAll();
    }

    @PostMapping("creerPompe")
    public Pompe createPompe(@RequestBody Pompe pompe){
        return pompeRepository.save(pompe);
    }

    @DeleteMapping("supprimerPompe/{idPompe}")
    public void deletePompe(@PathVariable Long idPompe){
        pompeRepository.deleteById(idPompe);
    }

    @GetMapping("retrouverPompeById/{idPompe}")
    public Pompe getIdPompe(@PathVariable Long idPompe){
        return pompeRepository.findByIdPompe(idPompe);
    }

    @PutMapping("modifierPompe")
    public Pompe updatePompe(@RequestBody Pompe pompe) throws Exception {
        if(pompe.getIdPompe() == null){
            throw new Exception("Pompe non existante");
        }

        return pompeRepository.save(pompe);
    }

    @GetMapping("byStation/{idStation}")
    public List<Pompe> pompesByStation(@PathVariable Long idStation){
        return pompeRepository.findAllByStationService(stationServiceRepository.findByIdStation(idStation));
    }
}
