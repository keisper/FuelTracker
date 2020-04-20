package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StationService implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStation;

    private String nom;
    private String adresse;

    public enum TypeCarburant{
        Gazoil, Essence
    }

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    @ManyToMany
    private List<Utilisateur> listeActionnaires = new ArrayList<>();

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "stationService")
    private List<Pompe> pompe = new ArrayList<>();

    @OneToMany(mappedBy = "stationService")
    private List<Commande> commande = new ArrayList<>();

    public StationService() {
    }

    /**
     *
     * @param nom
     * @param adresse
     * @param typeCarburant
     */
    public StationService(String nom, String adresse, TypeCarburant typeCarburant) {
        this.nom = nom;
        this.adresse = adresse;
        this.typeCarburant = typeCarburant;
    }

    /**
     *
     * @return Long
     */
    public Long getIdStation() {
        return idStation;
    }

    /**
     *
     * @param idStation
     */
    public void setIdStation(Long idStation) {
        this.idStation = idStation;
    }

    /**
     *
     * @return String
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return String
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    /**
     *
     * @return
     */
    public List<Commande> getCommande() {
        return commande;
    }

    /**
     *
     * @param commande
     */
    public void setCommande(List<Commande> commande) {
        this.commande = commande;
    }

    /**
     *
     * @return
     */
    public List<Pompe> getPompe() {
        return pompe;
    }

    /**
     *
     * @param pompe
     */
    public void setPompe(List<Pompe> pompe) {
        this.pompe = pompe;
    }

    /**
     *
     * @return List<Utilisateur>
     */

    public List<Utilisateur> getListeUtilisateurs() {
        return listeActionnaires;
    }

    /**
     *
     * @param listeUtilisateurs
     */
    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeActionnaires = listeUtilisateurs;
    }

}
