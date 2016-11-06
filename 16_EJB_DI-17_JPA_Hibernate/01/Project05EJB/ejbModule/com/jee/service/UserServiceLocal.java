package com.jee.service;

import java.util.List;

import javax.ejb.Local;

import com.jee.entity.UserModel;

@Local
public interface UserServiceLocal {
    List<UserModel> findAllUsers();
    
    List<UserModel> findAllUsersForDisplay();
    
    UserModel save(UserModel entity);
    
    UserModel update(UserModel entity);
    
    void delete(UserModel entity);
    
    UserModel findById(Long id);
    
    UserModel loginUser(String username, String password);
    
    UserModel checkUserExists(String username, Long id);
}
