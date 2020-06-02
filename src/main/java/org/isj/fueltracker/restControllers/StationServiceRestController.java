package org.isj.fueltracker.restControllers;


import org.isj.fueltracker.entities.Pompe;
import org.isj.fueltracker.entities.Reservoir;
import org.isj.fueltracker.entities.StationService;
import org.isj.fueltracker.entities.Utilisateur;
import org.isj.fueltracker.repositories.PompeRepository;
import org.isj.fueltracker.repositories.ReservoirRepository;
import org.isj.fueltracker.repositories.StationServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/api/stationService")
@CrossOrigin("*")
public class StationServiceRestController {

    private final StationServiceRepository stationServiceRepository;
    private ReservoirRepository reservoirRepository;
    private PompeRepository pompeRepository;

    /**
     *
     * @param stationServiceRepository
     * @param reservoirRepository
     * @param pompeRepository
     */
    //constructeur
    public StationServiceRestController(StationServiceRepository stationServiceRepository, ReservoirRepository reservoirRepository, PompeRepository pompeRepository) {
        this.stationServiceRepository = stationServiceRepository;
        this.reservoirRepository = reservoirRepository;
        this.pompeRepository = pompeRepository;
    }

    /**
     * méthode permettant d'afficher la liste des Station services
     * @return
     */
    @GetMapping("listerStationService")
    public List<StationService> getAllStationService(){
        List<StationService> stations = stationServiceRepository.findAll();

        for (StationService s : stations){
            s.getFournisseur();
        }
        return stations;
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
    public StationService getIdStation(@PathVariable Long idStation){
        return stationServiceRepository.findByIdStation(idStation);
    }

    @PostMapping("enregistrement")
    public void save(@RequestBody StationService stationService, @RequestBody List<Pompe> pompes, @RequestBody List<Reservoir> reservoirs){

    }

    @PostMapping("actionnairesStation/{idStation}")
    public String saveAct(@PathVariable Long idStation, @RequestBody List<Utilisateur> users){

        StationService stationService = stationServiceRepository.findByIdStation(idStation);
        try{
            if(stationService.getListeActionnaires() == null){
                stationService.setListeActionnaires(users);
                stationServiceRepository.save(stationService);
            }else{
                for(Utilisateur user : users){
                    stationService.getListeActionnaires().add(user);
                }
                stationServiceRepository.save(stationService);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "Done";
    }
}