package com.jee.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jee.entity.UserModel;
import com.jee.service.UserServiceLocal;
import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "listUsersBean")
@ViewScoped
public class ListUsersBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    UserServiceLocal userService;
    
    @PostConstruct
    public void init() {}
    
    public String listAction() {
        return UrlConstants.UPDATE_URL;
    }
    
    public String editAction() {
        return UrlConstants.EDIT_URL;
    }
    
    public String createAction() {
        return UrlConstants.CREATE_URL;
    }
    
    public List<UserModel> getAllUsers() {
        //return userService.findAllUsers();
        return userService.findAllUsersForDisplay();
    }
}
