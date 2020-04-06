package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaiement;

    public enum Statut{
        NonPaye, EnCours, Paye
    }

    @Enumerated(EnumType.STRING)
    private Statut statutPaiement;

    @OneToOne
    private StationService stationService;

    @ManyToOne
    private Commande commande;

    public Paiement() {
    }

    /**
     *
     * @param statutPaiement
     * @param stationService
     * @param commande
     */
    public Paiement(Statut statutPaiement, StationService stationService, Commande commande) {
        this.statutPaiement = statutPaiement;
        this.stationService = stationService;
        this.commande = commande;
    }

    /**
     *
     * @return Long
     */
    public Long getIdPaiement() {
        return idPaiement;
    }

    /**
     *
     * @param idPaiement
     */
    public void setIdPaiement(Long idPaiement) {
        this.idPaiement = idPaiement;
    }

    /**
     *
     * @return Statut
     */
    public Statut getStatutPaiement() {
        return statutPaiement;
    }

    /**
     *
     * @param statutPaiement
     */
    public void setStatutPaiement(Statut statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    /**
     *
     * @return List<Produit>
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
     * @return Commande
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     *
     * @param commande
     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
