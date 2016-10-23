package com.jee.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
/*import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;*/
import javax.faces.bean.ViewScoped;

import com.jee.web.constants.UrlConstants;
import com.jee.web.dto.UserDto;
import com.jee.web.utils.ContextCheck;
import com.jee.web.utils.ValidateUser;

@ManagedBean(name = "createUserBean")
@ViewScoped
public class CreateUserBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /*@Inject
    private HttpServletRequest request;*/
    
    @ManagedProperty("#{usersBean}")
    private UsersBean usersBean;
    
    private UserDto user;
    private String operationType;
    
    @PostConstruct
    public void init() {
        user = new UserDto();
    }
    
    public String createAction() {
        if (!validate()) {
            return null;
        }
        
        usersBean.getUsers().add(this.user);
        
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
