/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.dto;

/**
 *
 * @author TOSHIBA
 */
public class CompteForm {
    
    private long id;
    private String type;
    private long solde ;

    public CompteForm() {
    }

    public CompteForm(long id, String type) {
        this.id = id;
        this.type = type;
        this.solde = 0;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public long getSolde() {
        return solde;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSolde(long solde) {
        this.solde = solde;
    }
    
    
    
    
}
