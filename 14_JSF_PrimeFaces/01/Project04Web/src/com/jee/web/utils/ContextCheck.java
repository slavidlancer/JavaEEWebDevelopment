package com.jee.web.utils;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ContextCheck {
    
    public static boolean hasErrors() {
        Iterator<FacesMessage> messages = FacesContext.getCurrentInstance().getMessages();
        
        for (; messages.hasNext(); ) {
            FacesMessage message = messages.next();
            
            if (message.getSeverity().compareTo(FacesMessage.SEVERITY_ERROR) == 0) {
                return true;
            }
        }
        
        return false;
    }
}
