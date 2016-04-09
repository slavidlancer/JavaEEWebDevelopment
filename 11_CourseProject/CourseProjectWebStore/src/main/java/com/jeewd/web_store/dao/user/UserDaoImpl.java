package com.jeewd.web_store.dao.user;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
import com.jeewd.web_store.entities.user.User;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> getUsersBySearch(UserSearch userSearch) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        List<User> users = null;
        
        return users != null ? users.get(0) : null;
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
