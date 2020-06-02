package org.isj.fueltracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
public class StationService implements Serializable {
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStation;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    //@Column(nullable = false)
    private Date dateCreation;

    private Date dateModification;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Utilisateur> listeActionnaires = new ArrayList<>();

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "stationService", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pompe> pompe = new ArrayList<>();

    @OneToMany(mappedBy = "stationService", cascade = CascadeType.ALL)
    @JsonIgnore
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

    public List<Utilisateur> getListeActionnaires() {
        return listeActionnaires;
    }

    public void setListeActionnaires(List<Utilisateur> listeActionnaires) {
        this.listeActionnaires = listeActionnaires;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
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
