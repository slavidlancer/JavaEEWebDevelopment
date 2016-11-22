package com.jee.service;

import java.util.List;

import javax.ejb.Local;

import com.jee.entity.UserModel;

@Local
public interface UserDaoServiceLocal {
    
    List<UserModel> findAllUsers();
    
    List<UserModel> findAllUsersIssuesCount();
    
    UserModel findById(Long id);
    
    UserModel save(UserModel entity);
    
    UserModel update(UserModel entity);
    
    void delete(UserModel entity);
    
    void deleteById(Long id);
    
    UserModel findUserLogin(String username, String password);
    
    UserModel checkUserExists(String username, Long id);
}
