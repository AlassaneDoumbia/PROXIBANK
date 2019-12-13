/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.controller;

import com.esmt.proxibank.domaine.Compte;
import com.esmt.proxibank.domaine.Operation;
import com.esmt.proxibank.dto.CompteForm;
import com.esmt.proxibank.service.IClientService;
import com.esmt.proxibank.service.ICompteService;
import com.esmt.proxibank.service.IOperationService;
import com.esmt.proxibank.utils.TypeCompte;
import com.esmt.proxibank.utils.TypeOperation;
import com.esmt.proxibank.utils.Utils;
import java.util.ArrayList;
import java.util.List;
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
public class CompteController {
    
    private final Logger logger = LoggerFactory.getLogger(CompteController.class);

    @Autowired
    private ICompteService ies;
    

    @Autowired
    private IClientService ied;
    
    @Autowired
    private IOperationService ios;
    //@Autowired
    //CompteFormValidator compteFormValidator;

    //DÃ©finir le form validator
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //binder.setValidator(compteFormValidator);
    }
    
    @GetMapping(value = "/comptes")
    public String afficherTousLescomptes(Model model) {
        
        logger.debug("afficherTousLescomptes()");
        model.addAttribute("comptes", ies.lister());
        return "comptes/liste";
    }
    
    @GetMapping(value = "/comptes/{id}")
    public String afficherTousLescomptesClients(@PathVariable("id") Long id,Model model) {
        
        model.addAttribute("client", ied.trouver(id));
        logger.debug("afficherTousLescomptes()");
        model.addAttribute("comptes", ies.findByCompteClient(ied.trouver(id)));
        return "comptes/informationCompteForm";
    }
    
    @PostMapping(value = "/comptes/{id}")
    public String enregistrerOuMettreAJourcompte(@ModelAttribute("compteForm") @Validated Compte e,
        BindingResult result, @PathVariable("id") Long id, Model model, final RedirectAttributes redirectAttributes) {

        logger.debug("enregistrerOuMettreAJourcompte() : {}", e);

        if (result.hasErrors()) {
            //peuplerModelParDefaut(model);
            return "comptes/compteform";
        } else {

            // Ajouter des messages au flash scope
            redirectAttributes.addFlashAttribute("css", "success");
            if (e.isNew()) {
                e.setCompteClient(ied.trouver(id));
                Compte cl = ies.enregistrer(e);
                model.addAttribute("compteForm", cl);
                Operation op = new Operation(TypeOperation.AJOUT_COMPTE.toString(), 
                        e.getSolde(), Utils.getDate(), ied.trouver(id));
                ios.enregistrer(op);
                //peuplerModelParDefaut(model);
                redirectAttributes.addFlashAttribute("msg", "Client ajouté avec success!");

            } else {
                e.setCompteClient(ied.trouver(id));
                ies.miseAJour(e);
                Operation op = new Operation(TypeOperation.MODIF_COMPTE.toString(), 
                        e.getSolde(), Utils.getDate(), ied.trouver(id));
                ios.enregistrer(op);
                redirectAttributes.addFlashAttribute("msg", "Client mis jour avec success!");
            }

            return "redirect:/comptes/"+id;
        }
    }

    // Affiche le formulaire d'ajout d'un client
    @GetMapping(value = "/comptes/{id}/add")
    public String afficherFormAjoutClient(@PathVariable("id") Long id,Model model) {

        logger.debug("afficherFormAjoutClient()");

        Compte e = new Compte();

        // Valeur par dÃ©faut
        //e.setNom("Musk");
        //e.setPrenom("Elon");
        model.addAttribute("id", id);
        model.addAttribute("compteForm", e);

        peuplerModelParDefaut(model);

        return "comptes/compteform";
    }
    
    @PostMapping(value = "/comptes/{id}/debiter/{idc}")
    public String effectuerDebit(@ModelAttribute("compteForm") @Validated CompteForm ec,
        BindingResult result, @PathVariable("id") Long id,@PathVariable("idc") Long idc, Model model, final RedirectAttributes redirectAttributes) {

        Compte e = ies.trouver(idc);
        ies.debiter(e, ec.getSolde());
        CompteForm c = new CompteForm(idc,e.getType());
        //model.addAttribute("compteForm", c);
        peuplerModelParDefaut(model);
        return "redirect:/comptes/"+id;
    }
    
    // Affiche le formulaire demise Ã  jour
    @GetMapping(value = "/comptes/{id}/debiter/{idc}")
    public String afficherFormDebit(@PathVariable("id") Long id ,@PathVariable("idc") Long idc, Model model) {

        logger.debug("afficherFormMiseAJour() : {}", id);

        Compte e = ies.trouver(idc);
        CompteForm c = new CompteForm(idc,e.getType());
        model.addAttribute("compteForm", c);
        model.addAttribute("clientId", id);

        peuplerModelParDefaut(model);

        return "comptes/debiterForm";
    }
    
    @PostMapping(value = "/comptes/{id}/crediter/{idc}")
    public String effectuerCredit(@ModelAttribute("compteForm") @Validated CompteForm ec,
        BindingResult result, @PathVariable("id") Long id,@PathVariable("idc") Long idc, Model model, final RedirectAttributes redirectAttributes) {

        Compte e = ies.trouver(idc);
        ies.crediter(e, ec.getSolde());
        ies.miseAJour(e);
        //model.addAttribute("compteForm", c);
        peuplerModelParDefaut(model);
        return "redirect:/comptes/"+id;
    }
    
    // Affiche le formulaire demise Ã  jour
    @GetMapping(value = "/comptes/{id}/crediter/{idc}")
    public String afficherFormCredit(@PathVariable("id") Long id ,@PathVariable("idc") Long idc, Model model) {

        logger.debug("afficherFormMiseAJour() : {}", id);
        
        Compte e = ies.trouver(idc);
        CompteForm c = new CompteForm(idc,e.getType());
        model.addAttribute("compteForm", c);
        model.addAttribute("clientId", id);

        peuplerModelParDefaut(model);

        return "comptes/crediterForm";
    }
    
    // Affiche le formulaire demise Ã  jour
    @GetMapping(value = "/comptes/{id}/update/{idc}")
    public String afficherFormMiseAJour(@PathVariable("id") Long id ,@PathVariable("idc") Long idc, Model model) {

        logger.debug("afficherFormMiseAJour() : {}", id);

        Compte e = ies.trouver(idc);
        model.addAttribute("compteForm", e);

        peuplerModelParDefaut(model);

        return "comptes/compteform";
    }
    // Supprimer un compte
    @GetMapping(value = "/comptes/{id}/delete/{idc}")
    public String supprimercompte(@PathVariable("id") Long id,@PathVariable("idc") Long idc, 
        final RedirectAttributes redirectAttributes) {

        logger.debug("supprimercompte() : {}", idc);

        ies.suprimer(idc);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "compte supprimÃ©!");

        return "redirect:/comptes/"+id;

    }
    
    private void peuplerModelParDefaut(Model model) {
        List<String> types = new ArrayList<>();
        types.add(TypeCompte.COURANT.toString());
        types.add(TypeCompte.EPARGNE.toString());
        model.addAttribute("types",types);
    }
   
}
