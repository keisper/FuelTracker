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

    @Column (name = "nom")
    private String nom;
    @Column (name = "prenom")
    private String prenom;
    @Column (name = "nationalite")
    private String nationalite;
    @Column (name = "pays")
    private String pays;
    @Column (name = "adresse")
    private String adresse;
    @Column (name = "partAction")
    private float partAction;
    @Column (name = "roles")
    private String roles;
    @Column (name = "username")
    private String username;
    @Column (name = "password")
    private String password;
    @Column (name = "email")
    private String email;
    @Column (name = "active",nullable = false)
    private Boolean active;


    public enum Statut{
        Personne_Morale, Personne_Physique
    }

    @Enumerated(EnumType.STRING)
    private Statut statutUtilisateur;

    @ManyToMany
    private List<StationService> listeStations = new ArrayList<>();

    public Utilisateur() {
    }

    /**
     *  @param nom
     * @param prenom
     * @param nationalite
     * @param pays
     * @param adresse
     * @param partAction
     * @param statutUtilisateur
     * @param roles
     * @param username
     * @param password
     * @param email
     * @param active
     */
    public Utilisateur(String nom, String prenom, String nationalite, String pays, String adresse,
                       float partAction, Statut statutUtilisateur, String roles, String username,
                       String password, String email, Boolean active) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.pays = pays;
        this.adresse = adresse;
        this.partAction = partAction;
        this.statutUtilisateur = statutUtilisateur;
        this.roles = roles;
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
    }

    /**
     *
     * @return Long
     */
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     *
     * @param idUtilisateur
     */
    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
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
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return String
     */
    public String getNationalite() {
        return nationalite;
    }

    /**
     *
     * @param nationalite
     */
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    /**
     *
     * @return String
     */
    public String getPays() {
        return pays;
    }

    /**
     *
     * @param pays
     */
    public void setPays(String pays) {
        this.pays = pays;
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
     * @return float
     */
    public float getPartAction() {
        return partAction;
    }

    /**
     *
     * @param partAction
     */
    public void setPartAction(float partAction) {
        this.partAction = partAction;
    }

    /**
     *
     * @return Statut
     */
    public Statut getStatutUtilisateur() {
        return statutUtilisateur;
    }

    /**
     *
     * @param statutUtilisateur
     */
    public void setStatutUtilisateur(Statut statutUtilisateur) {
        this.statutUtilisateur = statutUtilisateur;
    }

    /**
     *
     * @return List<StationService>
     */
    public List<StationService> getListeStations() {
        return listeStations;
    }

    /**
     *
     * @param listeStations
     */
    public void setListeStations(List<StationService> listeStations) {
        this.listeStations = listeStations;
    }

    /**
     *
     * @return String
     */
    public String getRoles() { return roles; }

    /**
     *
     * @param roles
     */
    public void setRoles(String roles) { this.roles = roles; }

    /**
     *
     * @return String
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public Boolean getActive() {
        return active;
    }

    /**
     *
     * @param active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     *
     * @return List<String>
     */
    public List<String> getRoleList(){
        if (this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
}
