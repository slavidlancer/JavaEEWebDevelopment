package com.jee.web.beans.users;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jee.entity.UserModel;
import com.jee.service.UserDaoServiceLocal;
import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "listUsersBean")
@ViewScoped
public class ListUsersBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    UserDaoServiceLocal userDaoService;
    
    @PostConstruct
    public void init() {}
    
    public String loginAction() {
        return UrlConstants.LOGIN_PAGE_REDIRECT;
    }
    
    public String listAction() {
        return UrlConstants.UPDATE_USER_URL;
    }
    
    public String listAllAction() {
        return UrlConstants.LIST_USERS_REDIRECT;
    }
    
    public String editAction() {
        return UrlConstants.EDIT_USER_URL;
    }
    
    public String editAdminAction() {
        return UrlConstants.EDIT_USER_ADMIN_URL;
    }
    
    public String createAction() {
        return UrlConstants.CREATE_USER_URL;
    }
    
    public String createAdminAction() {
        return UrlConstants.CREATE_USER_ADMIN_URL;
    }
    
    public List<UserModel> getAllUsers() {
        //return userDaoService.findAllUsers();
        return userDaoService.findAllUsersIssuesCount();
    }
}
