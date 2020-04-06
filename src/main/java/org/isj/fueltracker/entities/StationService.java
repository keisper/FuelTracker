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
    private List<Utilisateur> listeUtilisateurs = new ArrayList<>();

    @ManyToMany
    private List<Fournisseur> listeFournisseurs = new ArrayList<>();

    @ManyToOne
    private Produit produit;

    @OneToOne
    private Paiement paiement;

    public StationService() {
    }

    /**
     *
     * @param nom
     * @param adresse
     * @param typeCarburant
     * @param paiement
     */
    public StationService(String nom, String adresse, TypeCarburant typeCarburant, Paiement paiement) {
        this.nom = nom;
        this.adresse = adresse;
        this.typeCarburant = typeCarburant;
        this.paiement = paiement;
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
     * @return List<Utilisateur>
     */
    public List<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    /**
     *
     * @param listeUtilisateurs
     */
    public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
        this.listeUtilisateurs = listeUtilisateurs;
    }

    /**
     *
     * @return List<Fournisseur>
     */
    public List<Fournisseur> getListeFournisseurs() {
        return listeFournisseurs;
    }

    /**
     *
     * @param listeFournisseurs
     */
    public void setListeFournisseurs(List<Fournisseur> listeFournisseurs) {
        this.listeFournisseurs = listeFournisseurs;
    }

    /**
     *
     * @return Paiement
     */
    public Paiement getPaiement() {
        return paiement;
    }

    /**
     *
     * @param paiement
     */
    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }


}
