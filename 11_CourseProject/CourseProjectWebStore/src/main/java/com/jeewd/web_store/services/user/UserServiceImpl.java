package com.jeewd.web_store.services.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.user.UserDao;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
import com.jeewd.web_store.entities.customer.Customer;
import com.jeewd.web_store.entities.user.Role;
import com.jeewd.web_store.entities.user.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<UserSearch> getUsersBySearch(UserSearch userSearch) {
        List<UserSearch> usersSearchResult = new ArrayList<>();
        boolean isAdmin = false;
        boolean isUser = false;
        
        for (User user : userDao.getUsersBySearch(userSearch)) {
            UserSearch userSearchResult = new UserSearch();
            userSearch.setId(user.getId());
            userSearchResult.setUsername(user.getUsername());
            
            if (user.getCustomers() != null) {
                String customerName = "";
                
                for (Customer customer : user.getCustomers()) {
                    if ("Active".equals(customer.getStatus())) {
                        customerName = customer.getName();
                    }
                }
                
                userSearchResult.setCustomerName(customerName);
            } else {
                userSearchResult.setCustomerName("");
            }
            
            isAdmin = false;
            isUser = false;
            
            for (Role userRole : user.getRoles()) {
                userSearchResult.setType(userRole.getRole());
                
                if ("ROLE_ADMIN".equals(userRole.getRole())) {
                    isAdmin = true;
                }
                
                if ("ROLE_USER".equals(userRole.getRole())) {
                    isUser = true;
                }
            }
            
            if (isAdmin) {
                userSearchResult.setType("admin");
            } else if (isUser) {
                userSearchResult.setType("user");
            } else {
                userSearchResult.setType("none");
            }
            
            userSearchResult.setStatus(user.getStatus());
            
            usersSearchResult.add(userSearchResult);
        }
        
        return usersSearchResult != null ? usersSearchResult : null;
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
