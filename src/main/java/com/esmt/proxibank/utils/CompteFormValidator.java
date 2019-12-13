/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esmt.proxibank.utils;

import com.esmt.proxibank.domaine.Compte;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author TOSHIBA
 */
@Component
public class CompteFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Compte.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Compte e = (Compte) target;
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "solde", "NotEmpty.solde");
    }
    
}
