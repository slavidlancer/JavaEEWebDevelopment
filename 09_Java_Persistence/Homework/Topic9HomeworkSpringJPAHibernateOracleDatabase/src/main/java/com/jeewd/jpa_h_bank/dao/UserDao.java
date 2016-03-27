package com.jeewd.jpa_h_bank.dao;

import java.util.List;
import java.util.Map;

import com.jeewd.jpa_h_bank.entities.UserDb;

public interface UserDao {
    Map<Long, UserDb> getAllUsers();
    List<String> getAllUsernames();
}
