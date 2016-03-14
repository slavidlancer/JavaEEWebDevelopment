package com.jeewd.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.jeewd.constants.DbConstants;
import com.jeewd.jdbc_bank.entity.BankAccount;
import com.jeewd.jdbc_bank.entity.CurrencyID;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    @Override
    public boolean addBankAccount(BankAccount bankAccount, String user) {
        String sqlInsert = "INSERT INTO accounts (id, account_number, username,"
                + " amount, currency, created_by) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sqlInsert);) {
            String sqlRetrieve = "SELECT LAST_INSERT_ID() FROM operations";
            ResultSet resultSet = statement.executeQuery(sqlRetrieve);
            long lastId = Long.parseLong(resultSet.getString(1));
            
            preparedStatement.setLong(1, ++lastId);
            preparedStatement.setString(2, bankAccount.getNumber());
            preparedStatement.setString(3, bankAccount.getUsername());
            preparedStatement.setBigDecimal(4, bankAccount.getAmount());
            preparedStatement.setObject(5, bankAccount.getCurrency().
                    toString());
            preparedStatement.setString(6, bankAccount.getCreatedBy());
            
            preparedStatement.executeQuery();
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
        String sql = "SELECT * FROM accounts WHERE username = '?' AND "
                + "account_number = '?'";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, number);
            
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            
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
