/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.dao;

import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Compte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TOSHIBA
 */
@Repository
public interface ICompteDao extends JpaRepository<Compte, Long>{
    public List<Compte> findByType(String type);
    public List<Compte> findByCompteClient(Client c);
   // public int NombredeCompteByType(Compte c);
   // public int soldeTotalByTypeCompte(Compte c);
    //public Compte crediter(Compte e, long somme);
   // public void debiter(Compte e, Long somme);
}
