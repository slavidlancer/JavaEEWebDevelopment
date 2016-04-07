package com.jeewd.web_store.services.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.user.UserDao;
import com.jeewd.web_store.dto.user.UserSearch;
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
    public List<User> getUsersBySearch(UserSearch userSearch) {
        return userDao.getUsersBySearch(userSearch);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
