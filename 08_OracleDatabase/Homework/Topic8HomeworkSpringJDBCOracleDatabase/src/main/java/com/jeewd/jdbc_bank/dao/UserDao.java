package com.jeewd.jdbc_bank.dao;

import java.util.Set;
import com.jeewd.jdbc_bank.entities.UserDb;

public interface UserDao {
    Set<UserDb> getAllUsers();
}
