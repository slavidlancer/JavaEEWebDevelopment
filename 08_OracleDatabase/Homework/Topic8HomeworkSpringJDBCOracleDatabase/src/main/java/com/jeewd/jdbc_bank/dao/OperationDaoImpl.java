package com.jeewd.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String sqlInsert = "INSERT INTO operations (id, account_umber,"
                + "operation, amount, currency, performed_by) VALUES (?, ?, ?, "
                + "?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlInsert);) {
            String sqlRetrieve = "SELECT LAST_INSERT_ID() FROM operations";
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            long lastId = Long.parseLong(resultSet.getString(1));
            
            preparedStatement.setLong(1, ++lastId);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setString(3, operation);
            preparedStatement.setString(4, amount);
            preparedStatement.setString(5, currency);
            preparedStatement.setString(6, performedBy);
            
            preparedStatement.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
}
