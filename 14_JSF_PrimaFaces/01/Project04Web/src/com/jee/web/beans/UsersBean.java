package com.jee.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import com.jee.web.dto.UserDto;

@ManagedBean(name = "usersBean")
@SessionScoped
public class UsersBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<UserDto> users;
    
    @PostConstruct
    public void init() {
        users = new ArrayList<UserDto>();
        UserDto initUser = new UserDto("admin", "123", "Ad", "Min", "admin@company.com");
        users.add(initUser);
        UserDto newUser = new UserDto("user", "a", "Mister", "User", "user@company.com");
        users.add(newUser);
    }
    
    public UserDto validateUser(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return null;
        }
        
        for (UserDto currentUser : users) {
            if (username.equals(currentUser.getUsername()) &&
                    password.equals(currentUser.getPassword())) {
                return currentUser;
            }
        }
        
        return null;
    }
    
    public List<UserDto> getUsers() {
        return this.users;
    }
    
    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
