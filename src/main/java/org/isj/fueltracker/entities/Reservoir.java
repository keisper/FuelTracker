package org.isj.fueltracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
public class Reservoir implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservoir;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "volumeReservoir", nullable = false)
    private int volumeReservoir;

    //@Column(nullable = false)
    private Date dateCreation;

    private Date dateModification;

    @OneToMany(mappedBy = "reservoir",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<IndexCarburant> listindex = new ArrayList<>();

    @ManyToOne
    private TypeCarburant typeCarburant;

    public Reservoir(){

    }

    /**
     *
     * @param libelle
     * @param volumeReservoir
     */
    public Reservoir(String libelle, int volumeReservoir){
        this.libelle = libelle;
        this.volumeReservoir = volumeReservoir;
    }

    /**
     *
     * @return long
     */
    public Long getIdReservoir() {
        return idReservoir;
    }

    /**
     *
     * @param idReservoir
     */
    public void setIdReservoir(Long idReservoir) {
        this.idReservoir = idReservoir;
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
     * @return int
     */
    public int getVolumeReservoir() {
        return volumeReservoir;
    }

    /**
     *
     * @param volumeReservoir
     */
    public void setVolumeReservoir(int volumeReservoir) {
        this.volumeReservoir = volumeReservoir;
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
     * @return TypeCarburant
     */
    public TypeCarburant getTypeCarburant() {
        return typeCarburant;
    }

    /**
     *
     * @param typeCarburant
     */
    public void setTypeCarburant(TypeCarburant typeCarburant) {
        this.typeCarburant = typeCarburant;
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