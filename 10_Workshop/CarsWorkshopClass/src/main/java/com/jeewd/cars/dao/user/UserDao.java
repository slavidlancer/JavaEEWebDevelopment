package com.jeewd.cars.dao.user;

import java.util.List;
import com.jeewd.cars.entities.user.AutoUser;

public interface UserDao {
    AutoUser getUser(String username);
    List<AutoUser> getUsers(String username, String status);
}
