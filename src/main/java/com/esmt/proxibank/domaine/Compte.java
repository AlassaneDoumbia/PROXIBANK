/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.domaine;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Compte implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private long Solde;
    
    @ManyToOne()
    private Client compteClient;

    public Compte() {
    }

    public Compte(long id, String type, Client client, long solde) {
        this.id = id;
        this.type = type;
        this.compteClient = client;
        this.Solde = solde;
    }

    public Compte(String type, Client client, long solde) {
        this.type = type;
        this.compteClient = client;
        this.Solde = solde;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompteClient(Client compteClient) {
        this.compteClient = compteClient;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSolde(long Solde) {
        this.Solde = Solde;
    }

    public long getSolde() {
        return Solde;
    }   
    
    public String getType() {
        return type;
    }

    public Client getCompteClient() {
        return compteClient;
    }

    public long getId() {
        return id;
    }

    public boolean isNew() {
        //return this.id == null;
        return false;
    }
}
