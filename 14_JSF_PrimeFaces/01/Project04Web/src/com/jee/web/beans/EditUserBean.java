package com.jee.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jee.web.constants.UrlConstants;
import com.jee.web.dto.UserDto;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.ValidateUser;

@ManagedBean(name = "editUserBean")
@ViewScoped
public class EditUserBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    @ManagedProperty("#{usersBean}")
    private UsersBean usersBean;
    
    private UserDto user;
    
    @PostConstruct
    public void init() {
        String username = request.getParameter("username");
        
        for (UserDto currentUser : usersBean.getUsers()) {
            if (currentUser.getUsername().equals(username)) {
                this.user = currentUser;
                
                break;
            }
        }
    }
    
    public String updateAction() {
        if (!validate()) {
            return null;
        }
        
        return UrlConstants.UPDATE_URL;
    }
    
    public UsersBean getUsersBean() {
        return this.usersBean;
    }
    
    public void setUsersBean(UsersBean usersBean) {
        this.usersBean = usersBean;
    }
    
    public UserDto getUser() {
        return this.user;
    }
    
    public void setUser(UserDto user) {
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
