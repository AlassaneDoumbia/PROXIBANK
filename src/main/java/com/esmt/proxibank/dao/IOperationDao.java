/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.dao;

import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Operation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TOSHIBA
 */
@Repository
public interface IOperationDao extends JpaRepository<Operation, Long>{
    
    public List<Operation> findByType(String type);
    public List<Operation> findByMontant(long prenom);
    public List<Operation> findByDates(String dates);
    public List<Operation> findByClient(Client client);
}
