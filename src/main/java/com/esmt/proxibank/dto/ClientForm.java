/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.dto;

import com.esmt.proxibank.domaine.Compte;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public class ClientForm {
    
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    private long number;
    private List<Compte> liste;
    private String type;
    private long Solde;

    public ClientForm() {
    }

    public ClientForm(String nom, String prenom, String adresse, long number, String type, Long Solde) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.number = number;
        this.type = type;
        this.Solde = Solde;
    }

    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSolde(Long Solde) {
        this.Solde = Solde;
    }

    public void setListe(List<Compte> liste) {
        this.liste = liste;
    }

    public List<Compte> getListe() {
        return liste;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public long getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Long getSolde() {
        return Solde;
    }
    
    public boolean isNew() {
        return true;
    }
}
