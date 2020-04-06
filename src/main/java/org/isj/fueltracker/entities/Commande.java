package org.isj.fueltracker.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateCommande;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dateLivraison;

    private float volumeCommande;
    private float volumeLivre;
    public enum TypeCarburantLivre{
        Gazoil, Essence
    }

    @Enumerated(EnumType.STRING)
    private TypeCarburantLivre typeCarburantLivre;

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commande")
    private List<Paiement> listePaiementsEffectues = new ArrayList<>();

    public Commande() {
    }

    /**
     *
     * @param dateCommande
     * @param dateLivraison
     * @param volumeCommande
     * @param volumeLivre
     * @param typeCarburantLivre
     * @param fournisseur
     */
    public Commande(Date dateCommande, Date dateLivraison, float volumeCommande, float volumeLivre, TypeCarburantLivre typeCarburantLivre, Fournisseur fournisseur) {
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.volumeCommande = volumeCommande;
        this.volumeLivre = volumeLivre;
        this.typeCarburantLivre = typeCarburantLivre;
        this.fournisseur = fournisseur;
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
     * @return
     */
    public TypeCarburantLivre getTypeCarburantLivre() {
        return typeCarburantLivre;
    }

    /**
     *
     * @param typeCarburantLivre
     */
    public void setTypeCarburantLivre(TypeCarburantLivre typeCarburantLivre) {
        this.typeCarburantLivre = typeCarburantLivre;
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
     * @return List<Paiement>
     */
    public List<Paiement> getListePaiementsEffectues() {
        return listePaiementsEffectues;
    }

    /**
     *
     * @param listePaiementsEffectues
     */
    public void setListePaiementsEffectues(List<Paiement> listePaiementsEffectues) {
        this.listePaiementsEffectues = listePaiementsEffectues;
    }
}
