package org.isj.fueltracker.restControllers;

import org.isj.fueltracker.entities.Reservoir;
import org.isj.fueltracker.repositories.ReservoirRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class ReservoirRestController {

    private final ReservoirRepository reservoirRepository;

    public ReservoirRestController(ReservoirRepository reservoirRepository) {
        this.reservoirRepository = reservoirRepository;
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
}
