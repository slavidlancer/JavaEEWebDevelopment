package com.jeewd.jpa_h_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.constants.DbConstants;
import com.jeewd.jpa_h_bank.entities.BankAccount;
import com.jeewd.jpa_h_bank.entities.CurrencyID;
import com.jeewd.jpa_h_bank.entities.UserDb;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
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
    private OperationDao operationDao;
    
    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        String sqlInsert = "INSERT INTO accounts (id, account_number, username,"
                + " amount, currency, created_by) VALUES (?, ?, ?, ?, ?, ?)";
        
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlInsert);) {
            String sqlRetrieve = "SELECT COUNT(*) FROM accounts";
            
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            
            long lastId = 0L;
            
            while (resultSet.next()) {
                lastId = resultSet.getLong(1);
            }
            
            preparedStatement.setLong(1, ++lastId);
            preparedStatement.setString(2, bankAccount.getNumber());
            
            for (Entry<Long, UserDb> user : users.entrySet()) {
                if (user.getValue().getUsername().equals(
                        bankAccount.getUsername())) {
                    preparedStatement.setLong(3, user.getKey());
                }
                
                if (user.getValue().getUsername().equals(
                        bankAccount.getCreatedBy())) {
                    preparedStatement.setLong(6, user.getKey());
                }
            }
            
            preparedStatement.setBigDecimal(4, bankAccount.getAmount());
            preparedStatement.setObject(5, bankAccount.getCurrency().
                    toString());
            
            preparedStatement.executeQuery();
            
            operationDao.registerOperation(bankAccount.getNumber(), "deposit",
                    bankAccount.getAmount(),
                    bankAccount.getCurrency().toString(),
                    bankAccount.getCreatedBy());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean containsBankAccount(BankAccount bankAccount) {
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        String usernameId = null;
        
        for (Entry<Long, UserDb> user : users.entrySet()) {
            if (user.getValue().getUsername().equals(
                    bankAccount.getUsername())) {
                usernameId = user.getKey().toString();
            }
        }
        
        String sqlRetrieve = "SELECT COUNT(1) FROM accounts WHERE username = '"
                + usernameId + "' AND account_number = '" +
                bankAccount.getNumber() + "'";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement =
                        connection.prepareStatement(sqlRetrieve);) {
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            
            while (resultSet.next()) {
                if (resultSet.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    @Override
    public BankAccount getBankAccountNumberByUsername(String username,
            String number) {
        BankAccount bankAccount = null;
        
        HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                userDao.getAllUsers();
        
        String usernameId = null;
        
        for (Entry<Long, UserDb> user : users.entrySet()) {
            if (user.getValue().getUsername().equals(username)) {
                usernameId = user.getKey().toString();
            }
        }
        
        String sqlRetrieve = "SELECT * FROM accounts WHERE username = '"
                + usernameId + "' AND account_number = '" + number + "'";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement =
                        connection.prepareStatement(sqlRetrieve);) {
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            
            while (resultSet.next()) {
                bankAccount = new BankAccount();
                CurrencyID currency = null;
                
                bankAccount.setId(resultSet.getLong(1));
                bankAccount.setNumber(resultSet.getString(2));
                
                for (Entry<Long, UserDb> user : users.entrySet()) {
                    if (user.getKey().equals(resultSet.getLong(3))) {
                        bankAccount.setUsername(user.getValue().getUsername());
                    }
                    
                    if (user.getKey().equals(resultSet.getLong(6))) {
                        bankAccount.setCreatedBy(user.getValue().getUsername());
                    }
                }
                
                bankAccount.setAmount(resultSet.getBigDecimal(4));
                
                switch (resultSet.getString(5)) {
                    case "BGN":
                        currency = CurrencyID.BGN;
                        
                        break;
                        
                    case "USD":
                        currency = CurrencyID.USD;
                        
                        break;
                        
                    case "EUR":
                        currency = CurrencyID.EUR;
                        
                        break;
                        
                    default:
                        currency = CurrencyID.BGN;
                        
                        break;
                }
                
                bankAccount.setCurrency(currency);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return null;
        }
        
        return bankAccount;
    }

    @Override
    public Set<BankAccount> getAllBankAccounts() {
        Set<BankAccount> bankAccounts = new HashSet<>();
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();) {
            HashMap<Long, UserDb> users = (HashMap<Long, UserDb>)
                    userDao.getAllUsers();
            
            String sql = "SELECT * FROM accounts";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                BankAccount bankAccount = new BankAccount();
                CurrencyID currency = null;
                
                bankAccount.setId(resultSet.getLong(1));
                bankAccount.setNumber(resultSet.getString(2));
                
                for (Entry<Long, UserDb> user : users.entrySet()) {
                    if (user.getKey().equals(resultSet.getLong(3))) {
                        bankAccount.setUsername(user.getValue().getUsername());
                    }
                    
                    if (user.getKey().equals(resultSet.getLong(6))) {
                        bankAccount.setCreatedBy(user.getValue().getUsername());
                    }
                }
                
                bankAccount.setAmount(resultSet.getBigDecimal(4));
                
                switch (resultSet.getString(5)) {
                    case "BGN":
                        currency = CurrencyID.BGN;
                    
                        break;
                        
                    case "USD":
                        currency = CurrencyID.USD;
                    
                        break;
                        
                    case "EUR":
                        currency = CurrencyID.EUR;
                    
                        break;

                    default:
                        currency = CurrencyID.BGN;
                        
                        break;
                }
                
                bankAccount.setCurrency(currency);
                
                bankAccounts.add(bankAccount);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return null;
        }
        
        return bankAccounts;
    }
}
