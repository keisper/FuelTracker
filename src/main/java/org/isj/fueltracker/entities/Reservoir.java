package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservoir implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReservoir;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "volumeReservoir")
    private int volumeReservoir;

    @OneToMany(mappedBy = "reservoir")
    private List<Index> listindex = new ArrayList<>();

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
     * @return List<Index>
     */
    public List<Index> getListindex() {
        return listindex;
    }

    /**
     *
     * @param listindex
     */
    public void setListindex(List<Index> listindex) {
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
}