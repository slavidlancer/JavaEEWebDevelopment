package com.jee.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "adminBean")
@ViewScoped
public class AdminBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public String adminPanelSimpleAction() {
        return UrlConstants.ADMIN_PAGE_URL;
    }
    
    public String adminPanelAction() {
        return UrlConstants.ADMIN_PAGE_REDIRECT;
    }
}
