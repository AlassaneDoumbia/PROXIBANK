/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.service;

import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Compte;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface ICompteService {
    
    public List<Compte> findByTypeCompte(String type);
    //public int nombredeCompteByType(Compte c);
    public long soldeTotalByTypeCompte(Compte c);
    public Compte crediter(Compte e, long somme);
    public Compte debiter(Compte e, long somme);
    public List<Compte> findByCompteClient(Client c);
    //CRUD
    public Compte enregistrer(Compte e);
    public Compte miseAJour(Compte e);
    public Compte trouver(Long id);
    public void suprimer(Long id);
    public List<Compte> lister();
}
