package com.jeewd.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jeewd.constants.DbConstants;
import com.jeewd.jdbc_bank.entities.BankAccount;
import com.jeewd.jdbc_bank.entities.CurrencyID;

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
    
    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        String sqlInsert = "INSERT INTO accounts (id, account_number, username,"
                + " amount, currency, created_by) VALUES (?, ?, ?, ?, ?, ?)";
        
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
            
            if ("user".equals(bankAccount.getUsername())) {
                preparedStatement.setLong(3, 2);
            }
            
            preparedStatement.setBigDecimal(4, bankAccount.getAmount());
            preparedStatement.setObject(5, bankAccount.getCurrency().
                    toString());
            
            if ("admin".equals(bankAccount.getCreatedBy())) {
                preparedStatement.setLong(6, 1);
            }
            
            preparedStatement.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean containsBankAccount(BankAccount bankAccount) {
        String sqlRetrieve = "SELECT COUNT(1) FROM accounts WHERE username = '"
                + bankAccount.getUsername() + "' AND account_number = '" +
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
        String sqlRetrieve = "SELECT * FROM accounts WHERE username = '"
                + username + "' AND account_number = '" + number + "'";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement =
                        connection.prepareStatement(sqlRetrieve);) {
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            
            while (resultSet.next()) {
                bankAccount = new BankAccount();
                CurrencyID currency = null;
                    
                bankAccount.setNumber(resultSet.getString(2));
                bankAccount.setUsername(resultSet.getString(3));
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
                bankAccount.setCreatedBy(resultSet.getString(6));
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
            String sql = "SELECT * FROM accounts";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                BankAccount bankAccount = new BankAccount();
                CurrencyID currency = null;
                
                bankAccount.setNumber(resultSet.getString(2));
                bankAccount.setUsername(resultSet.getString(3));
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
                bankAccount.setCreatedBy(resultSet.getString(6));
                
                bankAccounts.add(bankAccount);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return null;
        }
        
        return bankAccounts;
    }
}
