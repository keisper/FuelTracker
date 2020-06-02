package org.isj.fueltracker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPaiement;


    public enum Statut{
        NonPayé, EnCours, Payé
    }

    @Enumerated(EnumType.STRING)
    private Statut statutPaiement;

    @OneToOne
    private StationService stationService;

    @ManyToOne
    private Commande commande;

    public Paiement() {
    }

    public Paiement(Statut statutPaiement, StationService stationService, Commande commande) {
        this.statutPaiement = statutPaiement;
        this.stationService = stationService;
        this.commande = commande;
    }

    public Long getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(Long idPaiement) {
        this.idPaiement = idPaiement;
    }

    public Statut getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(Statut statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    public StationService getStationService() {
        return stationService;
    }

    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
