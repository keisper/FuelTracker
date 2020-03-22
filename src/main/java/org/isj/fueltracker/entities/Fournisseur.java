package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<Produit> listeProduitsProposes = new ArrayList<>();

    public Fournisseur() {
    }

    public Fournisseur(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<StationService> getListeStationsFournies() {
        return listeStationsFournies;
    }

    public void setListeStationsFournies(List<StationService> listeStationsFournies) {
        this.listeStationsFournies = listeStationsFournies;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public List<Produit> getListeProduitsProposes() {
        return listeProduitsProposes;
    }

    public void setListeProduitsProposes(List<Produit> listeProduitsProposes) {
        this.listeProduitsProposes = listeProduitsProposes;
    }
}
