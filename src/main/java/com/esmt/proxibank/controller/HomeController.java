package com.esmt.proxibank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.esmt.proxibank.service.IClientService;
import com.esmt.proxibank.service.IOperationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @SuppressWarnings("unused")
    @Autowired
    private IClientService ies;
    
    @Autowired
    private IOperationService ied;

    @RequestMapping(value="/")
//	public ModelAndView test(HttpServletResponse response) throws IOException{
    public String test(HttpServletResponse response) throws IOException{
        //Etudiant e = new Etudiant("", "");
        //ies.enregistrer(e);
        //return new ModelAndView("home");
        return "redirect:/home";
    }
    @GetMapping(value = "/home")
    public String affichehome(Model model) {
        
        model.addAttribute("operations", ied.lister().size());
        model.addAttribute("clients", ies.lister().size());
        
        return "home";
    }
}
