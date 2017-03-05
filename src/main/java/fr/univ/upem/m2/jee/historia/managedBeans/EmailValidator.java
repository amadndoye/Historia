/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ.upem.m2.jee.historia.managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Lamine
 */
public class EmailValidator implements Validator{
        @Override
    public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
		
        String email = (String) value;

        if(!email.contains("@")) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("Email is not valid.");
                message.setDetail("Email is not valid.");
                fc.addMessage("userForm:Email", message);
                throw new ValidatorException(message);
        }
    }

  
}
