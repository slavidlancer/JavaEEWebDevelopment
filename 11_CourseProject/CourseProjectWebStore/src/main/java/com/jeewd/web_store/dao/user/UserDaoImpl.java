package com.jeewd.web_store.dao.user;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
import com.jeewd.web_store.entities.user.Role;
import com.jeewd.web_store.entities.user.User;

@Repository
public class UserDaoImpl implements UserDao {
    private static List<User> users;
    
    static {
        users = new ArrayList<>();
        
        Role adminRole = new Role();
        adminRole.setId(1L);
        adminRole.setRole("ROLE_ADMIN");
        Role userRole = new Role();
        userRole.setId(2L);
        userRole.setRole("ROLE_USER");
        
        List<Role> adminRoles = new ArrayList<>();
        adminRoles.add(userRole);
        adminRoles.add(adminRole);
        
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        
        User adminUser = new User();
        adminUser.setId(1L);
        adminUser.setUsername("admin");
        adminUser.setPassword("c4ca4238a0b923820dcc509a6f75849b");
        adminUser.setRoles(adminRoles);
        adminUser.setStatus("Active");
        
        User user01User = new User();
        user01User.setId(2L);
        user01User.setUsername("user01");
        user01User.setPassword("c20ad4d76fe97759aa27a0c99bff6710");
        user01User.setRoles(userRoles);
        user01User.setStatus("Active");
        
        User user02User = new User();
        user02User.setId(3L);
        user02User.setUsername("user02");
        user02User.setPassword("c20ad4d76fe97759aa27a0c99bff6710");
        user02User.setRoles(userRoles);
        user02User.setStatus("Inactive");
        
        users.add(adminUser);
        users.add(user01User);
        users.add(user02User);
    }
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> getUsersBySearch(UserSearch userSearch) {
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> users = UserDaoImpl.users;
        List<User> usersActive = new ArrayList<>();
        
        for (User userObject : users) {
            if ("Active".equals(userObject.getStatus())) {
                usersActive.add(userObject);
            }
        }
        
        for (User user : usersActive) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        
        return null;
    }

    @Override
    public boolean addUser(UserTransfer userTransfer) {
        return false;
    }

    @Override
    public boolean updateUser(UserTransfer userTransfer) {
        return false;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
