package com.jeewd.web_store.services.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.web_store.dao.user.UserDao;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.dto.user.UserTransfer;
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
    public User getUserById(Long id) {
        return userDao.getUserById(id);
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
