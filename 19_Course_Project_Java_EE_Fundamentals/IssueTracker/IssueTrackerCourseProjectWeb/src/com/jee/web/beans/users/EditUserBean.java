package com.jee.web.beans.users;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.jee.entity.UserModel;
import com.jee.service.UserDaoServiceLocal;
import com.jee.web.constants.UrlConstants;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.GeneralUtils;
import com.jee.web.utils.validation.ValidateUser;

@ManagedBean(name = "editUserBean")
@ViewScoped
public class EditUserBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @EJB
    UserDaoServiceLocal userDaoService;
    
    private UserModel user;
    
    @PostConstruct
    public void init() {
        String idParameter = request.getParameter("userid");
        
        if (StringUtils.isNotBlank(idParameter) && StringUtils.isNumeric(idParameter)) {
            Long id = Long.valueOf(idParameter);
            
            this.user = userDaoService.findById(id);
        }
    }
    
    public String updateAction() {
        if (!validate()) {
            return null;
        }
        
        //String encryptedPassword = GeneralUtils.encodePlainTextToMd5(this.user.getPassword());
        String encryptedPassword = GeneralUtils.encodePlainTextToSha256(this.user.getPassword());
        this.user.setPassword(encryptedPassword);
        
        userDaoService.update(this.user);
        
        return UrlConstants.UPDATE_USER_URL;
    }
    
    public String updateAdminAction() {
        if (!validate()) {
            return null;
        }
        
        //String encryptedPassword = GeneralUtils.encodePlainTextToMd5(this.user.getPassword());
        String encryptedPassword = GeneralUtils.encodePlainTextToSha256(this.user.getPassword());
        this.user.setPassword(encryptedPassword);
        
        userDaoService.update(this.user);
        
        return UrlConstants.UPDATE_USER_ADMIN_URL;
    }
    
    public UserModel getUser() {
        return this.user;
    }
    
    public void setUser(UserModel user) {
        this.user = user;
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
