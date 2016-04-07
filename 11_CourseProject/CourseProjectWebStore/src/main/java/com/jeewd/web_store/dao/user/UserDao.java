package com.jeewd.web_store.dao.user;

import java.util.List;
import com.jeewd.web_store.dto.user.UserSearch;
import com.jeewd.web_store.entities.user.User;

public interface UserDao {
    List<User> getAllUsers();
    List<User> getUsersBySearch(UserSearch userSearch);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
