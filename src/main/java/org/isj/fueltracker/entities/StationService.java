package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StationService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStation;

    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;

    public enum TypeCarburant{
        Gazoil, Essence
    }

    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;

    @ManyToMany
    private List<Utilisateur> listeUtilisateurs = new ArrayList<>();

    @ManyToMany
    private List<Fournisseur> listeFournisseurs = new ArrayList<>();

    @OneToOne
    private Paiement paiement;

    public StationService() {
    }

    public StationService(String nom, String adresse, TypeCarburant typeCarburant, Paiement paiement) {
        this.nom = nom;
        this.adresse = adresse;
        this.typeCarburant = typeCarburant;
        this.paiement = paiement;
    }

    public Long getIdStation() {
        return idStation;
    }

    public void setIdStation(Long idStation) {
        this.idStation = idStation;
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

    public TypeCarburant getTypeCarburant() {
        return typeCarburant;
    }

    public void setTypeCarburant(TypeCarburant typeCarburant) {
        this.typeCarburant = typeCarburant;
    }

    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }

    public List<Fournisseur> getListeFournisseurs() {
        return listeFournisseurs;
    }

    public void setListeFournisseurs(List<Fournisseur> listeFournisseurs) {
        this.listeFournisseurs = listeFournisseurs;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }
}
