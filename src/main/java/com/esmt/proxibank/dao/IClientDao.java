/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.dao;

import com.esmt.proxibank.domaine.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TOSHIBA
 */
@Repository
public interface IClientDao extends JpaRepository<Client, Long>{
    
    public List<Client> findByNom(String nom);
    public List<Client> findByPrenomOrNom(String prenom, String nom);
    //public List<Client> findByTypeCompte(Compte c);
}
