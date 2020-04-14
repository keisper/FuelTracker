package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TypeCarburant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTypeCarburant;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "prixVente")
    private int prixVente;
    @Column(name = "prixAchat")
    private int prixAchat;

    public TypeCarburant(){

    }

    /**
     *
     * @param libelle
     * @param prixVente
     * @param prixAchat
     */
    public TypeCarburant(String libelle,int prixVente, int prixAchat){
        this.libelle = libelle;
        this.prixVente = prixVente;
        this.prixAchat = prixAchat;
    }

    /**
     *
     * @return long
     */
    public Long getIdTypeCarburant() {
        return idTypeCarburant;
    }

    /**
     *
     * @param idTypeCarburant
     */
    public void setIdTypeCarburant(Long idTypeCarburant) {
        this.idTypeCarburant = idTypeCarburant;
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
    public int getPrixAchat() {
        return prixAchat;
    }

    /**
     *
     * @param prixAchat
     */
    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     *
     * @return int
     */
    public int getPrixVente() {
        return prixVente;
    }

    /**
     *
     * @param prixVente
     */
    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }
}