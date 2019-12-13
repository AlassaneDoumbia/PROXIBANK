
package com.esmt.proxibank.utils;

import com.esmt.proxibank.domaine.Client;
import com.esmt.proxibank.dto.ClientForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return ClientForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientForm e = (ClientForm) target;
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "NotEmpty.client.nom");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "NotEmpty.client.prenom");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adresse", "NotEmpty.client.adresse");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "NotEmpty.client.number");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ecoleFrequentee", "notEmpty.etudiant.ecole");
    }
    
}
