package com.jeewd.cars.services.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeewd.cars.dao.user.UserDao;
import com.jeewd.cars.entities.user.AutoUser;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    
    @Override
    public List<AutoUser> getUsers(String username, String status) {
        return userDao.getUsers(username, status);
    }
}
