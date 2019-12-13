/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.service;

import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Operation;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IOperationService {
    
    public List<Operation> findByType(String type);
    public List<Operation> findByMontant(long prenom);
    public List<Operation> findByDates(String dates);
    public List<Operation> findByClient(Client client);
    
    
    //CRUD
    public Operation enregistrer(Operation e);
    public Operation miseAJour(Operation e);
    public Operation trouver(Long id);
    public void suprimer(Long id);
    public List<Operation> lister();
}
