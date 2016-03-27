package com.jeewd.jpa_h_bank.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.jpa_h_bank.entities.BankAccount;
import com.jeewd.jpa_h_bank.entities.UserDb;

@Repository
public class OperationDaoImpl implements OperationDao {
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BankAccountDao bankAccountDao;
    
    @Override
    public boolean performDeposit(BankAccount bankAccount,
            BigDecimal changeAmount) {
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        
        String sqlUpdate = "UPDATE accounts SET amount = ? WHERE account_number"
                + " = ? AND username = ?";
        
        try (Connection connection = DriverManager.getConnection("", "", "");
                //DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlUpdate);) {
            preparedStatement.setBigDecimal(1,
                    bankAccount.getAmount().add(changeAmount));
            preparedStatement.setString(2, bankAccount.getNumber());
            
            for (Entry<Long, UserDb> user : users.entrySet()) {
                if (user.getValue().getUsername().equals(
                        bankAccount.getUsername())) {
                    preparedStatement.setLong(3, user.getKey());
                }
            }
            
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
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        
        String sqlUpdate = "UPDATE accounts SET amount = ? WHERE account_number"
                + " = ? AND username = ?";
        
        try (Connection connection = DriverManager.getConnection("", "", "");
                //DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlUpdate);) {
            preparedStatement.setBigDecimal(1,
                    bankAccount.getAmount().subtract(changeAmount));
            preparedStatement.setString(2, bankAccount.getNumber());
            
            for (Entry<Long, UserDb> user : users.entrySet()) {
                if (user.getValue().getUsername().equals(
                        bankAccount.getUsername())) {
                    preparedStatement.setLong(3, user.getKey());
                }
            }
            
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
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        HashSet<BankAccount> bankAccounts = (HashSet<BankAccount>)
                bankAccountDao.getAllBankAccounts();
        
        String sqlInsert = "INSERT INTO operations (id, account_number, "
                + "operation, amount, currency, performed_by) VALUES (?, ?, ?, "
                + "?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection("", "", "");
                //DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
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
            
            for (BankAccount bankAccount : bankAccounts) {
                if (bankAccount.getNumber().equals(accountNumber)) {
                    preparedStatement.setLong(2, bankAccount.getId());
                }
            }
            
            preparedStatement.setString(3, operation);
            preparedStatement.setBigDecimal(4, amount);
            preparedStatement.setString(5, currency);
            
            for (Entry<Long, UserDb> user : users.entrySet()) {
                if (user.getValue().getUsername().equals(performedBy)) {
                    preparedStatement.setLong(6, user.getKey());
                }
            }
            
            preparedStatement.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
}
