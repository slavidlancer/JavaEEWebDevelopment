package com.jee.database;

import java.sql.*;

public class JDBCTest {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/blog";
    static final String USER = "";
    static final String PASSWORD = "";
    
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT id, username, password, first_name, last_name, email FROM users";
        
        try {
            Class.forName(JDBC_DRIVER);
            
            System.out.println("connecting to the db ....");
            
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            System.out.println("creating statement:\n");
            
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                
                System.out.println("id: " + id);
                System.out.println("username: " + username);
                System.out.println("password: " + password);
                System.out.println("first name: " + firstName);
                System.out.println("last name: " + lastName);
                System.out.println("email: " + email);
                System.out.println();
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            
            System.out.println("connection and statement closed");
        }
    }
}
