/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.service;

import com.esmt.proxibank.dao.IOperationDao;
import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author TOSHIBA
 */
@Component(value = "operationServiceImpl")
public class OperationServiceImpl implements IOperationService{
    
    @Autowired
    private IOperationDao icd;

    @Override
    public List<Operation> findByType(String type) {
        return icd.findByType(type);
    }

    @Override
    public List<Operation> findByMontant(long montant) {
        return icd.findByMontant(montant);
    }

    @Override
    public List<Operation> findByDates(String dates) {
        return icd.findByDates(dates);
    }

    @Override
    public List<Operation> findByClient(Client client) {
        return icd.findByClient(client);
    }

    @Override
    public Operation enregistrer(Operation e) {
        return icd.save(e);
    }

    @Override
    public Operation miseAJour(Operation e) {
        return icd.saveAndFlush(e);
    }

    @Override
    public Operation trouver(Long id) {
        return icd.findOne(id);
    }

    @Override
    public void suprimer(Long id) {
        icd.delete(id);
    }

    @Override
    public List<Operation> lister() {
        return icd.findAll();
    }

}
