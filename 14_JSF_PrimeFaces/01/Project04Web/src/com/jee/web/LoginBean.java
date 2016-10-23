package com.jee.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.jee.web.beans.UsersBean;
import com.jee.web.constants.UrlConstants;
import com.jee.web.dto.UserDto;
import com.jee.web.utils.MessageUtils;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private HttpServletRequest request;
    
    private String username;
    private String password;
    
    @ManagedProperty("#{usersBean}")
    private UsersBean usersBean;
    
    @PostConstruct
    public void init() {}
    
    public String login() {
        UserDto user = usersBean.validateUser(username, password);
        
        if (user == null) {
            MessageUtils.addErrorMessage("login.error.invalid.credentials");
            
            return "";
        } else {
            /*HttpServletRequest request = (HttpServletRequest) FacesContext.
             * getCurrentInstance().getExternalContext().getRequest();*/
            request.getSession().setAttribute("LOGGED_USER", user);
            
            return UrlConstants.SUCCESS_LOGIN_REDIRECT;
        }
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
    
    public UsersBean getUsersBean() {
        return this.usersBean;
    }
    
    public void setUsersBean(UsersBean usersBean) {
        this.usersBean = usersBean;
    }
}
