package com.jeewd.web_store.services.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.user.UserDao;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
import com.jeewd.web_store.entities.user.Role;
import com.jeewd.web_store.entities.user.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        List<User> usersActive = new ArrayList<>();
        
        for (User userObject : userDao.getAllUsers()) {
            if ("Active".equals(userObject.getStatus())) {
                usersActive.add(userObject);
            }
        }
        
        return usersActive;
    }

    @Override
    public List<UserSearch> getUsersBySearch(UserSearch userSearch) {
        List<UserSearch> usersSearchResult = new ArrayList<>();
        
        for (User user : userDao.getUsersBySearch(userSearch)) {
            UserSearch userSearchResult = new UserSearch();
            userSearch.setId(user.getId());
            userSearchResult.setUsername(user.getUsername());
            userSearchResult.setCustomerName("");
            
            for (Role userRole : user.getRoles()) {
                if ("ROLE_ADMIN".equals(userRole.getRole())) {
                    userSearchResult.setType("admin");
                } else {
                    userSearchResult.setType("user");
                }
            }
            
            userSearchResult.setStatus(user.getStatus());
            
            usersSearchResult.add(userSearchResult);
        }
        
        return usersSearchResult;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public boolean addUser(UserTransfer userTransfer) {
        return userDao.addUser(userTransfer);
    }

    @Override
    public boolean updateUser(UserTransfer userTransfer) {
        return userDao.updateUser(userTransfer);
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }
}
