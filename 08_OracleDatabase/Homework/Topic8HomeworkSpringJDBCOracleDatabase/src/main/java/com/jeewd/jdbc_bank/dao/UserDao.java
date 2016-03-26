package com.jeewd.jdbc_bank.dao;

import java.util.Map;
import com.jeewd.jdbc_bank.entities.UserDb;

public interface UserDao {
    Map<Long, UserDb> getAllUsers();
}
