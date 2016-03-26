package com.jeewd.jdbc_bank.dao;

import java.util.Set;
import org.springframework.stereotype.Repository;
import com.jeewd.jdbc_bank.entities.UserDb;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public Set<UserDb> getAllUsers() {
        return null;
    }
}
