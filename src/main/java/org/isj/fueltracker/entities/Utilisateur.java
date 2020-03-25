package org.isj.fueltracker.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUtilisateur;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "nationalite")
    private String nationalite;
    @Column(name = "pays")
    private String pays;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "login")
    private String login;
    @Column(name = "mdp")
    private String mdp;
    @Column(name = "roles")
    private String roles;
    @Column(name = "droits")
    private String droits;
    @Column(name = "active")
    private boolean active;



    private float partAction;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setDroits(String droits) {
        this.droits = droits;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public enum Statut{
        Personne_Morale, Personne_Physique
    }

    @Enumerated(EnumType.STRING)
    private Statut statutUtilisateur;

    @ManyToMany
    private List<StationService> listeStations = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String nationalite, String pays, String adresse, float partAction, Statut statutUtilisateur) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.pays = pays;
        this.adresse = adresse;
        this.partAction = partAction;
        this.statutUtilisateur = statutUtilisateur;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getPartAction() {
        return partAction;
    }

    public void setPartAction(float partAction) {
        this.partAction = partAction;
    }

    public Statut getStatutUtilisateur() {
        return statutUtilisateur;
    }

    public void setStatutUtilisateur(Statut statutUtilisateur) {
        this.statutUtilisateur = statutUtilisateur;
    }

    public List<StationService> getListeStations() {
        return listeStations;
    }

    public void setListeStations(List<StationService> listeStations) {
        this.listeStations = listeStations;
    }

    public List<String> getRoles(){
        if (this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getDroits(){
        if (this.roles.length()>0){
            return Arrays.asList(this.droits.split(","));
        }
        return new ArrayList<>();
    }
}
