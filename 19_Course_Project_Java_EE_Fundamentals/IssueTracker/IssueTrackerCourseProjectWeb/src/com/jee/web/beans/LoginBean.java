package com.jee.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jee.entity.UserModel;
import com.jee.service.UserDaoServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.MessageUtils;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    UserDaoServiceLocal userDaoService;
    
    private String username;
    private String password;
    
    @PostConstruct
    public void init() {}
    
    public String login() {
        //String encryptedPassword = GeneralUtils.encodePlainTextToMd5(this.password);
        String encryptedPassword = GeneralUtils.encodePlainTextToSha256(this.password);
        UserModel user = userDaoService.findUserLogin(this.username, encryptedPassword);
        
        if (user == null) {
            MessageUtils.addErrorMessage("login.error.invalid.credentials");
            
            return "";
        } else {
            /*HttpServletRequest request = (HttpServletRequest) FacesContext.
             * getCurrentInstance().getExternalContext().getRequest();*/
            request.getSession().setAttribute("LOGGED_USER", user);
            
            if (user.getUsername().contains("admin")) {
                return UrlConstants.SUCCESS_ADMIN_LOGIN_REDIRECT;
            }
            
            return UrlConstants.SUCCESS_LOGIN_REDIRECT;
        }
    }
    
    public String adminPanelAction() {
        return UrlConstants.ADMIN_PAGE_URL;
    }
    
    public String logout() {
        request.getSession().invalidate();
        
        return UrlConstants.LOGIN_PAGE_REDIRECT;
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
