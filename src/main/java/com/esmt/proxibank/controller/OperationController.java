/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.controller;

import com.esmt.proxibank.service.IOperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author TOSHIBA
 */
@Controller
public class OperationController {
    
    
    private final Logger logger = LoggerFactory.getLogger(OperationController.class);
    
    @Autowired
    private IOperationService ies;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
       // binder.setValidator(simpleFormValidator);
        //binder.setValidator(clientFormValidator);
    }
    @GetMapping(value = "/operations")
    public String afficherTousLesOperations(Model model) {
        
        logger.debug("afficherTousLesOperations()");
        model.addAttribute("operations", ies.lister());
        return "operations/liste";
    }
    
}
