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
        String sql = "INSERT INTO accounts (, , ....) VALUES (?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                PreparedStatement statement =
                        connection.prepareStatement(sql);) {
            /*statement.setLong(1, 2);
            statement.setString(2, student.getFacultyNumber());
            statement.setString(3, student.getName());*/
            
            statement.executeQuery();
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
        
        try (Connection connection = DriverManager.getConnection(
                DbConstants.URL, DbConstants.USERNAME, DbConstants.PASSWORD);
                Statement statement = connection.createStatement();) {
            String sql = "SELECT * FROM accounts";
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                bankAccount = new BankAccount();
                
                /*student.setId(resultSet.getLong("id"));
                student.setFacultyNumber(resultSet.getString("faculty_number"));
                student.setName(resultSet.getString("name"));*/
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
                
                /*student.setId(resultSet.getLong("id"));
                student.setFacultyNumber(resultSet.getString("faculty_number"));
                student.setName(resultSet.getString("name"));*/
                
                bankAccounts.add(bankAccount);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return null;
        }
        
        return bankAccounts;
    }
}
