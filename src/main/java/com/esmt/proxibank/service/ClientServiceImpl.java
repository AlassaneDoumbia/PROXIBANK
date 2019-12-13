/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.service;

import com.esmt.proxibank.dao.IClientDao;
import com.esmt.proxibank.domaine.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author TOSHIBA
 */
@Component(value = "clientServiceImpl")
public class ClientServiceImpl implements IClientService{
    
    @Autowired
    private IClientDao icd;

    @Override
    public List<Client> findByNom(String nom) {
        return icd.findByNom(nom);
    }

    @Override
    public List<Client> findByPrenomOrNom(String prenom, String nom) {
        return icd.findByPrenomOrNom(prenom, nom);
    }

   // @Override
    //public List<Client> findByTypeCompte(Compte c) {
    //    return icd.findByTypeCompte(c);
    //}

    @Override
    public Client enregistrer(Client e) {
        return icd.save(e);
    }

    @Override
    public Client miseAJour(Client e) {
        return icd.saveAndFlush(e);
    }

    @Override
    public Client trouver(Long id) {
        return icd.findOne(id);
    }

    @Override
    public void suprimer(Long id) {
        icd.delete(id);
    }

    @Override
    public List<Client> lister() {
        return icd.findAll();
    }
    
}
