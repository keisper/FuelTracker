package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.StationService;
import org.isj.fueltracker.repositories.StationServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class StationServiceRestController {

    private final StationServiceRepository stationServiceRepository;

    /**
     *
     * @param stationServiceRepository
     */
    //constructeur
    public StationServiceRestController(StationServiceRepository stationServiceRepository) {
        this.stationServiceRepository = stationServiceRepository;
    }

    /**
     * méthode permettant d'afficher la liste des Station services
     * @return
     */
    @GetMapping("listerStationService")
    public List<StationService> getAllStationService(){
        return stationServiceRepository.findAll();
    }

    /**
     * méthode permettant d'enregistrer une station service à partir du paramètre station service
     * @param stationService
     * @return
     */
    @PostMapping("creerStationService")
    public StationService createStationService(@RequestBody StationService stationService){
        return stationServiceRepository.save(stationService);
    }

    /**
     * méthode permettant de modifier une station service enregistrée en prenant en entrée l'id de la station service
     * @param stationService
     * @return
     * @throws Exception
     */
    @PutMapping("modifierStationService")
    public StationService updateStationService(@RequestBody StationService stationService) throws Exception {
        if(stationService.getIdStation() == null){
            throw new Exception("StationService non existante");
        }

        return stationServiceRepository.save(stationService);
    }

    /**
     * méthode permettant de supprimer une station service enregistrée en prenant en entrée l'id de la station service
     * @param idStation
     */
    @DeleteMapping("supprimerStationService/{idStation}")
    public void deleteStationService(@PathVariable Long idStation){
        stationServiceRepository.deleteById(idStation);
    }

    @GetMapping("retrouverStationServiceById/{idStation}")
    public Optional<StationService> getIdStation(@PathVariable Long idStation){
        return stationServiceRepository.findById(idStation);
    }

}
