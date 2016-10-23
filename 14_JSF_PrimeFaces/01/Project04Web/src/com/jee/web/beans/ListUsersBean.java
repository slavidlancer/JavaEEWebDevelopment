package com.jee.web.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.jee.web.constants.UrlConstants;

@ManagedBean(name = "listUsersBean")
@ViewScoped
public class ListUsersBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @ManagedProperty("#{usersBean}")
    private UsersBean usersBean;
    
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
    
    public UsersBean getUsersBean() {
        return this.usersBean;
    }
    
    public void setUsersBean(UsersBean usersBean) {
        this.usersBean = usersBean;
    }
}
