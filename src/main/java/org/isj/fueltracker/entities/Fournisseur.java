package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFournisseur;

    private String nom;
    private String adresse;

    @ManyToMany
    private List<StationService> listeStationsFournies = new ArrayList<>();

    @OneToMany(mappedBy = "fournisseur")
    private List<Commande> listeCommandes = new ArrayList<>();

    @ManyToMany
    private List<Produit> listeProduits = new ArrayList<>();

    public Fournisseur() {
    }

    /**
     *
     * @param nom
     * @param adresse
     */
    public Fournisseur(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    /**
     *
     * @return Long
     */
    public Long getIdFournisseur() {
        return idFournisseur;
    }

    /**
     *
     * @param idFournisseur
     */
    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
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
     * @return List<StationService>
     */
    public List<StationService> getListeStationsFournies() {
        return listeStationsFournies;
    }

    /**
     *
     * @param listeStationsFournies
     */
    public void setListeStationsFournies(List<StationService> listeStationsFournies) {
        this.listeStationsFournies = listeStationsFournies;
    }

    /**
     *
     * @return List<Commande>
     */
    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    /**
     *
     * @param listeCommandes
     */
    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    /**
     *
     * @return List<Produit>
     */
    public List<Produit> getListeProduits() {
        return listeProduits;
    }

    /**
     *
     * @param listeProduits
     */
    public void setListeProduits(List<Produit> listeProduits) {
        this.listeProduits = listeProduits;
    }
}
