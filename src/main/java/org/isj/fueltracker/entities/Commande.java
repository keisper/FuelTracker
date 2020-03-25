package org.isj.fueltracker.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommande;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "dateCommande")
    private Date dateCommande;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "dateLivraison")
    private Date dateLivraison;

    @Column(name = "volumeCommande")
    private float volumeCommandé;

    @Column(name = "volumeLivre")
    private float volumeLivré;

    public enum TypeCarburantLivré{
        Gazoil, Essence
    }

    @Enumerated(EnumType.STRING)
    private TypeCarburantLivré typeCarburantLivré;

    @ManyToOne
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commande")
    private List<Paiement> listePaiementsEffectués = new ArrayList<>();

    public Commande() {
    }

    public Commande(Date dateCommande, Date dateLivraison, float volumeCommandé, float volumeLivré, TypeCarburantLivré typeCarburantLivré, Fournisseur fournisseur) {
        this.dateCommande = dateCommande;
        this.dateLivraison = dateLivraison;
        this.volumeCommandé = volumeCommandé;
        this.volumeLivré = volumeLivré;
        this.typeCarburantLivré = typeCarburantLivré;
        this.fournisseur = fournisseur;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public float getVolumeCommandé() {
        return volumeCommandé;
    }

    public void setVolumeCommandé(float volumeCommandé) {
        this.volumeCommandé = volumeCommandé;
    }

    public float getVolumeLivré() {
        return volumeLivré;
    }

    public void setVolumeLivré(float volumeLivré) {
        this.volumeLivré = volumeLivré;
    }

    public TypeCarburantLivré getTypeCarburantLivré() {
        return typeCarburantLivré;
    }

    public void setTypeCarburantLivré(TypeCarburantLivré typeCarburantLivré) {
        this.typeCarburantLivré = typeCarburantLivré;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<Paiement> getListePaiementsEffectués() {
        return listePaiementsEffectués;
    }

    public void setListePaiementsEffectués(List<Paiement> listePaiementsEffectués) {
        this.listePaiementsEffectués = listePaiementsEffectués;
    }
}
