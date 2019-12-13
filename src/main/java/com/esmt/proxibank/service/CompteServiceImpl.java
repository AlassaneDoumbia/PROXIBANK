
package com.esmt.proxibank.service;

import com.esmt.proxibank.dao.ICompteDao;
import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Compte;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author TOSHIBA
 */
@Component(value = "compteServiceImpl")
public class CompteServiceImpl implements ICompteService{

    @Autowired
    private ICompteDao icd;
    
    
    //@Override
   // public int nombredeCompteByType(Compte c) {
        
        //return icd.findByType(c.getType()).size();
    //}

    @Override
    public long soldeTotalByTypeCompte(Compte c) {
        List<Compte> liste =  icd.findByType(c.getType());
        long soldeTotal = 0;
        for (Iterator<Compte> iterator = liste.iterator(); iterator.hasNext();) {
            Compte next = iterator.next();
            soldeTotal += next.getSolde();
        }
        return soldeTotal;
    }

    @Override
    public Compte crediter(Compte e, long somme) {
        long s = e.getSolde() - somme ;
        e.setSolde(s);
        return icd.saveAndFlush(e);
    }

    @Override
    public Compte debiter(Compte e, long somme) {
        long s = e.getSolde() + somme; 
        e.setSolde(s);
        return icd.saveAndFlush(e);}

    @Override
    public Compte enregistrer(Compte e) {
        return icd.save(e);
    }

    @Override
    public Compte miseAJour(Compte e) {
        return icd.saveAndFlush(e);
    }

    @Override
    public Compte trouver(Long id) {
        return icd.findOne(id);
    }

    @Override
    public void suprimer(Long id) {
        icd.delete(id);
    }

    @Override
    public List<Compte> lister() {
        return icd.findAll();
    }

    @Override
    public List<Compte> findByTypeCompte(String type) {
        return icd.findByType(type);
    }

    @Override
    public List<Compte> findByCompteClient(Client c) {
        return icd.findByCompteClient(c);
    }
    
}
