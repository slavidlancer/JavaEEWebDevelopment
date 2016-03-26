package com.jeewd.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.jeewd.constants.DbConstants;
import com.jeewd.jdbc_bank.entities.UserDb;

@Repository
public class UserDaoImpl implements UserDao {
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    @Override
    public Map<Long, UserDb> getAllUsers() {
        Map<Long, UserDb> users = new HashMap<>();
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();) {
            String sql = "SELECT * FROM users";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                UserDb userDb = new UserDb();
                
                userDb.setId(resultSet.getLong(1));
                userDb.setUsername(resultSet.getString(2));
                userDb.setPassword(resultSet.getString(3));
                userDb.setRole(resultSet.getString(4));
                
                users.put(userDb.getId(), userDb);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return null;
        }
        
        return users;
    }
}
