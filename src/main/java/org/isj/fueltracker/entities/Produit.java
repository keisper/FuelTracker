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

    @ManyToMany
    private List<Fournisseur> listeFournisseurs = new ArrayList<>();

    public Produit() {
    }

    public Produit(String code, float quantite, String nom) {
        this.code = code;
        this.quantite = quantite;
        this.nom = nom;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Fournisseur> getListeFournisseurs() {
        return listeFournisseurs;
    }

    public void setListeFournisseurs(List<Fournisseur> listeFournisseurs) {
        this.listeFournisseurs = listeFournisseurs;
    }
}
