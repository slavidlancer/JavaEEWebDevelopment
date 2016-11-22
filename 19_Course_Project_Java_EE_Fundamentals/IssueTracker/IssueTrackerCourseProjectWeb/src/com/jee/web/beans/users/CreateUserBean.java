package com.jee.web.beans.users;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jee.entity.UserModel;
import com.jee.service.UserDaoServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.validation.ValidateUser;

@ManagedBean(name = "createUserBean")
@ViewScoped
public class CreateUserBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    UserDaoServiceLocal userDaoService;
    
    private UserModel user;
    private String operationType;
    
    @PostConstruct
    public void init() {
        this.user = new UserModel();
    }
    
    public String createAction() {
        if (!validate()) {
            return null;
        }
        
        //String encryptedPassword = GeneralUtils.encodePlainTextToMd5(this.user.getPassword());
        String encryptedPassword = GeneralUtils.encodePlainTextToSha256(this.user.getPassword());
        this.user.setPassword(encryptedPassword);
        
        userDaoService.save(this.user);
        request.getSession().setAttribute("LOGGED_USER", this.user);
        
        return UrlConstants.LIST_ISSUES_AUTH_REDIRECT;
    }
    
    public String createAdminAction() {
        if (!validate()) {
            return null;
        }
        
        //String encryptedPassword = GeneralUtils.encodePlainTextToMd5(this.user.getPassword());
        String encryptedPassword = GeneralUtils.encodePlainTextToSha256(this.user.getPassword());
        this.user.setPassword(encryptedPassword);
        
        userDaoService.save(this.user);
        
        return UrlConstants.LIST_USERS_REDIRECT;
    }
    
    public UserModel getUser() {
        return this.user;
    }
    
    public void setUser(UserModel user) {
        this.user = user;
    }
    
    public String getOperationType() {
        return this.operationType;
    }
    
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    
    public boolean validate() {
        boolean isValid = ValidateUser.validate(this.user);
        
        return isValid;
    }
    
    public boolean hasErrors() {
        boolean hasErrors = ContextCheck.hasErrors();
        
        return hasErrors;
    }
}
