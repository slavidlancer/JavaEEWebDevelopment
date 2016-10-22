package com.jee.web.utils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtils {
    private static final String RESOURCE_BUNDLE_FILE = "resources.application";
    private static final ResourceBundle RESOURCE_BUNDLE = getBundle();
    
    public static String getMessage(String aKey) {
        return RESOURCE_BUNDLE.getString(aKey);
    }
    
    public static String getMessage(String aKey, Object... parameters) {
        return MessageFormat.format(RESOURCE_BUNDLE.getString(aKey), parameters);
    }
    
    public static void addMessage(String clientId, FacesMessage facesMessage) {
        FacesContext.getCurrentInstance().addMessage(clientId, facesMessage);
    }
    
    public static void addMessage(String aMessageId) {
        addMessage(null, new FacesMessage(getMessage(aMessageId)));
    }
    
    public static void addMessage(String aMessageId, Object... parameters) {
        addMessage(null, new FacesMessage(getMessage(aMessageId, parameters)));
    }
    
    public static void addErrorMessage(String aMessageId) {
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                getMessage(aMessageId), null));
    }
    
    public static void addErrorMessage(String aMessageId, Object... parameters) {
        addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                getMessage(aMessageId, parameters), null));
    }
    
    public static void addErrorMessage(String clientId, String aMessageId,
            Object... parameters) {
        addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                getMessage(aMessageId, parameters), null));
    }
    
    private static ResourceBundle getBundle() {
        if (FacesContext.getCurrentInstance() != null) {
            return ResourceBundle.getBundle(FacesContext.getCurrentInstance().getApplication().
                    getMessageBundle());
        }
        
        return ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE);
    }
}
