package com.jee.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.web.utils.MessageUtils;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    private String username;
    private String password;
    
    private static final String SUCCESS_LOGIN_REDIRECT = "/page/success?faces-redirect=true";
    private static final String LOGIN_PAGE_REDIRECT = "/page/login?faces-redirect=true";
    
    @PostConstruct
    public void init() {}
    
    public String login() {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            MessageUtils.addErrorMessage("login.error.invalid.credentials");
            
            return "";
        } else if ("admin".equals(username) && "123".equals(password)) {
            /*HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                    getExternalContext().getRequest();*/
            request.getSession().setAttribute("LOGGED_USER", username);
            
            return SUCCESS_LOGIN_REDIRECT;
        }
        
        MessageUtils.addErrorMessage("login.error.invalid.credentials");
        
        return "";
    }
    
    public String logout() {
        request.getSession().invalidate();
        
        return LOGIN_PAGE_REDIRECT;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
