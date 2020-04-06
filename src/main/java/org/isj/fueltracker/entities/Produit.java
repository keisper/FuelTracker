package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduit;

    private String code;
    private float quantite;
    private String nom;
    private float prixStation;
    private float prixFournisseur;

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit")
    private List<StationService> listeStationsServices = new ArrayList<>();

    public Produit() {
    }

    /**
     *
     * @param code
     * @param quantite
     * @param nom
     * @param prixStation
     * @param prixFournisseur
     */
    public Produit(String code, float quantite, String nom, float prixStation, float prixFournisseur) {
        this.code = code;
        this.quantite = quantite;
        this.nom = nom;
        this.prixStation = prixStation;
        this.prixFournisseur = prixFournisseur;
    }

    /**
     *
     * @return Long
     */
    public Long getIdProduit() {
        return idProduit;
    }

    /**
     *
     * @param idProduit
     */
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    /**
     *
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return float
     */
    public float getQuantite() {
        return quantite;
    }

    /**
     *
     * @param quantite
     */
    public void setQuantite(float quantite) {
        this.quantite = quantite;
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
     * @return float
     */
    public float getPrixStation() {
        return prixStation;
    }

    /**
     *
     * @param prixStation
     */
    public void setPrixStation(float prixStation) {
        this.prixStation = prixStation;
    }

    /**
     *
     * @return float
     */
    public float getPrixFournisseur() {
        return prixFournisseur;
    }

    /**
     *
     * @param prixFournisseur
     */
    public void setPrixFournisseur(float prixFournisseur) {
        this.prixFournisseur = prixFournisseur;
    }

    /**
     *
     * @return Fournisseur
     */
    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    /**
     *
     * @param fournisseur
     */
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    /**
     *
     * @return List<StationService>
     */
    public List<StationService> getListeStationsServices() {
        return listeStationsServices;
    }

    /**
     *
     * @param listeStationsServices
     */
    public void setListeStationsServices(List<StationService> listeStationsServices) {
        this.listeStationsServices = listeStationsServices;
    }
}
