package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.IndexCarburant;
import org.isj.fueltracker.entities.Pompe;
import org.isj.fueltracker.entities.Reservoir;
import org.isj.fueltracker.repositories.IndexRepository;
import org.isj.fueltracker.repositories.PompeRepository;
import org.isj.fueltracker.repositories.ReservoirRepository;
import org.isj.fueltracker.repositories.StationServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservoir")
@CrossOrigin("*")
public class ReservoirRestController {

    private final ReservoirRepository reservoirRepository;
    private PompeRepository pompeRepository;
    private IndexRepository indexRepository;
    private StationServiceRepository stationServiceRepository;

    public ReservoirRestController(ReservoirRepository reservoirRepository, PompeRepository pompeRepository, IndexRepository indexRepository, StationServiceRepository stationServiceRepository) {
        this.reservoirRepository = reservoirRepository;
        this.pompeRepository = pompeRepository;
        this.indexRepository = indexRepository;
        this.stationServiceRepository = stationServiceRepository;
    }

    @GetMapping("listerReservoir")
    public List<Reservoir> getAllPompeReservoir(){
        return reservoirRepository.findAll();
    }

    @PostMapping("creerReservoir")
    public Reservoir createReservoir(@RequestBody Reservoir reservoir){
        return reservoirRepository.save(reservoir);
    }

    @DeleteMapping("supprimerReservoir/{idReservoir}")
    public void deleteReservoir(@PathVariable Long idReservoir){
        reservoirRepository.deleteById(idReservoir);
    }

    @GetMapping("retrouverReservoirById/{idReservoir}")
    public Optional<Reservoir> getIdReservoir(@PathVariable Long idReservoir){
        return reservoirRepository.findByIdReservoir(idReservoir);
    }

    @PutMapping("modifierReservoir")
    public Reservoir updateReservoir(@RequestBody Reservoir reservoir) throws Exception {
        if(reservoir.getIdReservoir() == null){
            throw new Exception("Reservoir non existant");
        }

        return reservoirRepository.save(reservoir);
    }

    /*@GetMapping("reservoirByStation/{idStation}")
    public List<Reservoir> reservoirByStation(@PathVariable Long idStation){
        List<Pompe> pompes = pompeRepository.findAllByStationService(stationServiceRepository.findByIdStation(idStation));
        List<IndexCarburant> indexCarburants = new ArrayList<>();
        for(Pompe p : pompes){
            indexCarburants = indexRepository.findAllByPompe(pompeRepository.findByIdPompe(p.getIdPompe()));
        }
        return reservoirRepository.findAllByListindex(indexCarburants);
    }*/
}
