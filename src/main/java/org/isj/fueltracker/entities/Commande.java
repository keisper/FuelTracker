package org.isj.fueltracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateCommande;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateLivraison;

    @Column (name = "volumeCommande", nullable = false)
    private float volumeCommande;

    @Column (name = "volumeLivre", nullable = false)
    private float volumeLivre;

    @Column (name = "prixTotal", nullable = false)
    private int prixTotal;

    @Column (name = "ristourne")
    private int ristourne;

    public enum Statut{
        enregistrer, commander, livrer
    }

    @Enumerated(EnumType.STRING)
    private Statut statut;

    public enum Paiement{
        EnCours, Effectué, NonEffectué
    }

    //@Column(nullable = false)
    private Date dateCreation;

    private Date dateModification;

    @Enumerated(EnumType.STRING)
    private Paiement paiement;

    @ManyToOne
    @JoinColumn(name="idFournisseur")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name="idStation")
    private StationService stationService;

    @OneToMany(mappedBy = "commande")
    @JsonIgnore
    private List<LigneCommande> listeLigneCommandes = new ArrayList<>();

    public Commande() {
    }

    /**
     *
     * @param dateCommande
     * @param dateLivraison
     * @param volumeCommande
     * @param volumeLivre
     * @param prixTotal
     * @param ristourne
     * @param statut
     * @param paiement
     */
    public Commande(Date dateCommande, Date dateLivraison, float volumeCommande, float volumeLivre, int prixTotal, int ristourne, Statut statut, Paiement paiement) {
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.volumeCommande = volumeCommande;
        this.volumeLivre = volumeLivre;
        this.prixTotal = prixTotal;
        this.ristourne = ristourne;
        this.statut = statut;
        this.paiement = paiement;
    }

    /**
     *
     * @return Long
     */
    public Long getIdCommande() {
        return idCommande;
    }

    /**
     *
     * @param idCommande
     */
    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    /**
     *
     * @return Date
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     *
     * @param dateCommande
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     *
     * @return Date
     */
    public Date getDateLivraison() {
        return dateLivraison;
    }

    /**
     *
     * @param dateLivraison
     */
    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    /**
     *
     * @return Float
     */
    public float getVolumeCommande() {
        return volumeCommande;
    }

    /**
     *
     * @param volumeCommande
     */
    public void setVolumeCommande(float volumeCommande) {
        this.volumeCommande = volumeCommande;
    }

    /**
     *
     * @return Float
     */
    public float getVolumeLivre() {
        return volumeLivre;
    }

    /**
     *
     * @param volumeLivre
     */
    public void setVolumeLivre(float volumeLivre) {
        this.volumeLivre = volumeLivre;
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
     * @return int
     */
    public int getPrixTotal() {
        return prixTotal;
    }

    /**
     *
     * @param prixTotal
     */
    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    /**
     *
     * @return int
     */
    public int getRistourne() {
        return ristourne;
    }

    /**
     *
     * @param ristourne
     */
    public void setRistourne(int ristourne) {
        this.ristourne = ristourne;
    }

    /**
     *
     * @return Statut
     */
    public Statut getStatut() {
        return statut;
    }

    /**
     *
     * @param statut
     */
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    /**
     *
     * @return StationService
     */
    public StationService getStationService() {
        return stationService;
    }

    /**
     *
     * @param stationService
     */
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    /**
     *
     * @return List<LigneCommande>
     */
    public List<LigneCommande> getListeLigneCommandes() {
        return listeLigneCommandes;
    }

    /**
     *
     * @param listeLigneCommandes
     */
    public void setListeLigneCommandes(List<LigneCommande> listeLigneCommandes) {
        this.listeLigneCommandes = listeLigneCommandes;
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
