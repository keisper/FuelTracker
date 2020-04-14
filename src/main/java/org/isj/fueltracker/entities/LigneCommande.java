package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LigneCommande implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLigneCommande;
    @Column (name = "libelle")
    private String libelle;
    @Column (name = "volume")
    private int volume;
    @Column (name = "prixlitre")
    private int prixlitre;

    @ManyToOne
    private TypeCarburant typeCarburant;

    @ManyToOne
    private Commande commande;

    public LigneCommande(){

    }

    /**
     *
     * @param libelle
     * @param volume
     * @param prixlitre
     */
    public LigneCommande(String libelle, int volume, int prixlitre){
        this.libelle = libelle;
        this.volume = volume;
        this.prixlitre = prixlitre;
    }

    /**
     *
     * @return long
     */
    public Long getIdLigneCommande() {
        return idLigneCommande;
    }

    /**
     *
     * @param idLigneCommande
     */
    public void setIdLigneCommande(Long idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
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
    public int getVolume() {
        return volume;
    }

    /**
     *
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     *
     * @return int
     */
    public int getPrixlitre() {
        return prixlitre;
    }

    /**
     *
     * @param prixlitre
     */
    public void setPrixlitre(int prixlitre) {
        this.prixlitre = prixlitre;
    }

    /**
     *
     * @return Commande
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     *
     * @param commande
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
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