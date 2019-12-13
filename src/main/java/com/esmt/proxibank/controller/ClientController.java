
package com.esmt.proxibank.controller;

import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.domaine.Compte;
import com.esmt.proxibank.domaine.Operation;
import com.esmt.proxibank.dto.ClientForm;
import com.esmt.proxibank.service.IClientService;
import com.esmt.proxibank.service.ICompteService;
import com.esmt.proxibank.service.IOperationService;
import com.esmt.proxibank.utils.ClientFormValidator;
import com.esmt.proxibank.utils.TypeCompte;
import com.esmt.proxibank.utils.TypeOperation;
import com.esmt.proxibank.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class ClientController {
    
    private final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService ies;
    
    @Autowired
    private ICompteService ics;
    
    @Autowired
    private IOperationService ios;

    @Autowired
    ClientFormValidator clientFormValidator;
    
    //@Autowired
    //ClientSimpleValidator simpleFormValidator;

    //DÃ©finir le form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
       // binder.setValidator(simpleFormValidator);
        binder.setValidator(clientFormValidator);
    }
    @GetMapping(value = "/clients")
    public String afficherTousLesClients(Model model) {
        
        logger.debug("afficherTousLesClients()");
        model.addAttribute("clients", ies.lister());
        return "clients/liste";
    }
    
    @PostMapping(value = "/clients")
    public String enregistrerOuMettreAJourClient(@ModelAttribute("clientForm") @Validated ClientForm e,
        BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("enregistrerOuMettreAJourClient() : {}", e);
       // client = new Client(e.getNom(), e.getPrenom(), e.getAdresse(), e.getNumber());
        Compte cp = new Compte(e.getType(), new Client(), e.getSolde());
        if (result.hasErrors()) {
            peuplerModelParDefaut(model);
            return "clients/clientform";
        } else {
             Client client = new Client(e.getNom(), e.getPrenom(), e.getAdresse(), e.getNumber());
            // Ajouter des messages au flash scope
            if (Objects.isNull(e.getId())) {
                System.out.println("okay");
                Client cl= ies.enregistrer(client);
                cp.setCompteClient(client);
                //System.out.println("okay compte");
                ics.enregistrer(cp);
                Operation op = new Operation(TypeOperation.AJOUT_CLIENT.toString(), 
                        e.getSolde(), Utils.getDate(), cl);
                ios.enregistrer(op);
                redirectAttributes.addFlashAttribute("msg", "Client ajouté avec success!");
            }else{
                Client ct = new Client(e.getId(),e.getNom(), e.getPrenom(), e.getAdresse(), e.getNumber());
                ies.miseAJour(ct);
                
                Operation op = new Operation(TypeOperation.MODIF_CLIENT.toString(), 
                        e.getSolde(), Utils.getDate(), ct);
                ios.enregistrer(op);
                redirectAttributes.addFlashAttribute("msg", "Client modifié avec success!");
            }
            return "redirect:/clients/";
        }
    }
    
    @PostMapping(value = "/client/update")
    public String mettreAJourClient(@ModelAttribute("clientForm") @Validated Client e,
        BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("MettreAJourClient() : {}", e);
        if (result.hasErrors()) {
            peuplerModelParDefaut(model);
            return "clients/modifierform";
        } else {
            ies.miseAJour(e);
            redirectAttributes.addFlashAttribute("msg", "Client modifié avec success!");
            
            return "redirect:/clients/";
        }
    }

    // Affiche le formulaire d'ajout d'un client
    @GetMapping(value = "/clients/add")
    public String afficherFormAjoutClient(Model model) {

        logger.debug("afficherFormAjoutClient()");

        ClientForm e = new ClientForm();
        model.addAttribute("clientForm", e);

        peuplerModelParDefaut(model);

        return "clients/clientform";
    }
    // Affiche le formulaire demise Ã  jour
    @GetMapping(value = "/clients/{id}/update")
    public String afficherFormMiseAJour(@PathVariable("id") Long id, Model model) {

        logger.debug("afficherFormMiseAJour() : {}", id);

        Client e = ies.trouver(id);
        ClientForm cf = setClientForm(e);
        
        model.addAttribute("clientForm", cf);

        //peuplerModelParDefaut(model);

        return "clients/modifierClient";
    }
    // Supprimer un client
    @GetMapping(value = "/clients/{id}/delete")
    public String supprimerClient(@PathVariable("id") Long id, 
        final RedirectAttributes redirectAttributes) {

        logger.debug("supprimerClient() : {}", id);

        ies.suprimer(id);
        Operation op = new Operation(TypeOperation.SUPP_CLIENT.toString(), 
                        0, Utils.getDate(), ies.trouver(id));
        ios.enregistrer(op);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Client supprimÃ©!");

        return "redirect:/clients";

    }
    private void peuplerModelParDefaut(Model model) {
        List<String> types = new ArrayList<>();
        types.add(TypeCompte.COURANT.toString());
        types.add(TypeCompte.EPARGNE.toString());
        model.addAttribute("types",types);
    }
    
    private ClientForm setClientForm(Client e){
        ClientForm cF= new ClientForm();
        cF.setId(e.getId());
        cF.setNom(e.getNom());
        cF.setPrenom(e.getPrenom());
        cF.setAdresse(e.getAdresse());
        cF.setNumber(e.getNumber());
        cF.setListe(ics.findByCompteClient(e));
        return cF;
    }
}
