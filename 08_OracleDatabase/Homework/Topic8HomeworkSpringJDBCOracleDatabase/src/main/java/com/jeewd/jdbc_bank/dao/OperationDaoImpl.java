package com.jeewd.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
import com.jeewd.constants.DbConstants;

@Repository
public class OperationDaoImpl implements OperationDao {
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    @Override
    public boolean registerOperation(String accountNumber, String operation,
            String amount, String currency, String performedBy) {
        String sql = "INSERT INTO operations (id, account_umber, operation, "
                + "amount, currency, performedBy) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement statement =
                        connection.prepareStatement(sql);) {
            statement.setLong(1, 2);
            statement.setString(2, accountNumber);
            statement.setString(3, operation);
            statement.setString(4, amount);
            statement.setString(5, currency);
            statement.setString(6, performedBy);
            
            statement.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
}
