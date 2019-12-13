
package com.esmt.proxibank.service;

import com.esmt.proxibank.domaine.Client;
import java.util.List;

/**
 *
 * @author TOSHIBA
 */
public interface IClientService {
    public List<Client> findByNom(String nom);
    public List<Client> findByPrenomOrNom(String prenom, String nom);
   // public List<Client> findByTypeCompte(Compte c);	

    //CRUD
    public Client enregistrer(Client e);
    public Client miseAJour(Client e);
    public Client trouver(Long id);
    public void suprimer(Long id);
    public List<Client> lister();
}
