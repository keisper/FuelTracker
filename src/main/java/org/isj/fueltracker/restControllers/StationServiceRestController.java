package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.StationService;
import org.isj.fueltracker.repositories.StationServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class StationServiceRestController {
    
    private final StationServiceRepository stationServiceRepository;
    
    //constructeur
    public StationServiceRestController(StationServiceRepository stationServiceRepository) {
        this.stationServiceRepository = stationServiceRepository;
    }

    @GetMapping("listerStationService")
    public List<StationService> getAllStationService(){
        return stationServiceRepository.findAll();
    }

    @PostMapping("creerStationService")
    public StationService createStationService(@RequestBody StationService stationService){
        return stationServiceRepository.save(stationService);
    }
    @PutMapping("modifierStationService")
    public StationService updateStationService(@RequestBody StationService stationService) throws Exception {
        if(stationService.getIdStation() == null){
            throw new Exception("StationService non existante");
        }

        return stationServiceRepository.save(stationService);
    }

    @DeleteMapping("supprimerStationService/{idStation}")
    public void deleteStationService(@PathVariable Long idStation){
        stationServiceRepository.deleteById(idStation);
    }
}
