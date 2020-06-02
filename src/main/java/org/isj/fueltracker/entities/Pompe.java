package org.isj.fueltracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
public class Pompe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPompe;

    @Column (name = "code", nullable = false)
    private String code;

    @Column (name = "libelle")
    private String libelle;

    //@Column(nullable = false)
    private Date dateCreation;

    private Date dateModification;

    @OneToMany(mappedBy = "pompe", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<IndexCarburant> listindex = new ArrayList<>();

    @ManyToOne
    private StationService stationService;

    public Pompe(){

    }

    /**
     *
     * @param code
     * @param libelle
     */
    public Pompe(String code, String libelle){
        this.code = code;
        this.libelle = libelle;
    }

    /**
     *
     * @return long
     */
    public Long getIdPompe() {
        return idPompe;
    }

    /**
     *
     * @param id
     */
    public void setIdPompe(Long id) {
        this.idPompe = idPompe;

    }

    /**
     *
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return String
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     *
     * @return List<IndexCarburant>
     */
    public List<IndexCarburant> getListindex() {
        return listindex;
    }

    /**
     *
     * @param listindex
     */
    public void setListindex(List<IndexCarburant> listindex) {
        this.listindex = listindex;
    }

    /**
     *
     * @return StationService
     */
    public StationService getStationservice() {
        return stationService;
    }

    /**
     *
     * @param stationservice
     */
    public void setStationservice(StationService stationservice) {
        this.stationService = stationservice;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

}

