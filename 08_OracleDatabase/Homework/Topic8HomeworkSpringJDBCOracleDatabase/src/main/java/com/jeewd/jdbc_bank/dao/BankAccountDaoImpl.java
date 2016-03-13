package com.jeewd.jdbc_bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jeewd.jdbc_bank.entity.BankAccount;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USERNAME = "University";
    public static final String PASSWORD = "University";
    
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    @Override
    public List<BankAccount> getBankAccounts() {
        List<BankAccount> bankAccounts = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
                Statement statement = connection.createStatement();) {
            String sql = "SELECT * FROM students";
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

    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        String sql = "INSERT INTO accounts (, , ....) VALUES (?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME,
                    PASSWORD);
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
}
