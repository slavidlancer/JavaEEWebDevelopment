package com.jeewd.jdbc_bank.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Repository;
import com.jeewd.constants.DbConstants;
import com.jeewd.jdbc_bank.entities.BankAccount;

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
    public boolean performDeposit(BankAccount bankAccount,
            BigDecimal changeAmount) {
        String sqlUpdate = "UPDATE accounts SET amount = ? WHERE account_number"
                + " = ? AND username = ?";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlUpdate);) {
            preparedStatement.setBigDecimal(1,
                    bankAccount.getAmount().add(changeAmount));
            preparedStatement.setString(2, bankAccount.getNumber());
            preparedStatement.setString(3, bankAccount.getUsername());
            
            preparedStatement.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }

    @Override
    public boolean performWithdraw(BankAccount bankAccount,
            BigDecimal changeAmount) {
        String sqlUpdate = "UPDATE accounts SET amount = ? WHERE account_number"
                + " = ? AND username = ?";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlUpdate);) {
            preparedStatement.setBigDecimal(1,
                    bankAccount.getAmount().subtract(changeAmount));
            preparedStatement.setString(2, bankAccount.getNumber());
            preparedStatement.setString(3, bankAccount.getUsername());
            
            preparedStatement.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean registerOperation(String accountNumber, String operation,
            BigDecimal amount, String currency, String performedBy) {
        String sqlInsert = "INSERT INTO operations (id, account_number, "
                + "operation, amount, currency, performed_by) VALUES (?, ?, ?, "
                + "?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlInsert);) {
            String sqlRetrieve = "SELECT COUNT(*) FROM operations";
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            
            long lastId = 0L;
            
            while (resultSet.next()) {
                lastId = resultSet.getLong(1);
            }
            
            preparedStatement.setLong(1, ++lastId);
            preparedStatement.setString(2, accountNumber);
            preparedStatement.setString(3, operation);
            preparedStatement.setBigDecimal(4, amount);
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
