package com.jeewd.cars.services.user;

import java.util.List;
import com.jeewd.cars.entities.user.AutoUser;

public interface UserService {
    List<AutoUser> getUsers(String username, String status);
}
