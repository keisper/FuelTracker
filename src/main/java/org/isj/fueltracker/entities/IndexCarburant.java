package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class IndexCarburant implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idIndex;
    @Column (name = "description")
    private String description;
    @Column (name = "numero")
    private int numero;
    @Column (name = "volumeVendu")
    private int volumeVendu;

    @ManyToOne
    private Pompe pompe;

    @ManyToOne
    private Reservoir reservoir;

    public IndexCarburant(){

    }

    /**
     *
     * @param description
     * @param numero
     * @param volumeVendu
     */
    public IndexCarburant(String description, int numero, int volumeVendu) {
        this.description = description;
        this.numero = numero;
        this.volumeVendu = volumeVendu;
    }

    /**
     *
     * @return long
     */
    public Long getIdIndex() {
        return idIndex;
    }

    /**
     *
     * @param idIndex
     */
    public void setIdIndex(Long idIndex) {
        this.idIndex = idIndex;
    }

    /**
     *
     * @return int
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return int
     */
    public int getVolumeVendu() {
        return volumeVendu;
    }

    /**
     *
     * @param volumeVendu
     */
    public void setVolumeVendu(int volumeVendu) {
        this.volumeVendu = volumeVendu;
    }

    /**
     *
     * @return Pompe
     */
    public Pompe getPompe() {
        return pompe;
    }

    /**
     *
     * @param pompe
     */
    public void setPompe(Pompe pompe) {
        this.pompe = pompe;
    }

    /**
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return Reservoir
     */
    public Reservoir getReservoir() {
        return reservoir;
    }

    /**
     *
     * @param reservoir
     */
    public void setReservoir(Reservoir reservoir) {
        this.reservoir = reservoir;
    }
}