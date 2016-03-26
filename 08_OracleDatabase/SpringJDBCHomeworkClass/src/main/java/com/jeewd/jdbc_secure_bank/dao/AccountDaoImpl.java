package com.jeewd.jdbc_secure_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jeewd.jdbc_secure_bank.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USERNAME = "WebBank";
    public static final String PASSWORD = "WebBank";
    
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }
    
    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
                Statement statement = connection.createStatement();) {
            String sql = "SELECT a.*, u.username FROM accounts a, users u "
                    + "WHERE u.id = a.username";
            
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                Account account = new Account();
                
                account.setId(resultSet.getLong("id"));
                account.setAccountNumber(resultSet.getString("account_number"));
                account.setUsername(resultSet.getString("username"));
                account.setAmount(resultSet.getBigDecimal("amount"));
                account.setCurrency(resultSet.getString("currency"));
                account.setCreatedBy(resultSet.getString("created_by"));
                
                accounts.add(account);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            
            return null;
        }
        
        return accounts;
    }

    @Override
    public boolean addAccount(Account account) {
        return false;
    }
}
