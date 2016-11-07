package com.jee.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
/*import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;*/
import javax.faces.bean.ViewScoped;

import com.jee.entity.UserModel;
import com.jee.service.UserServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.ValidateUser;

@ManagedBean(name = "createUserBean")
@ViewScoped
public class CreateUserBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /*@Inject
    private HttpServletRequest request;*/
    
    @EJB
    UserServiceLocal userService;
    
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
        
        userService.save(this.user);
        
        return UrlConstants.UPDATE_URL;
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
