/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdb;

import com.beans.UserLogin;
import com.beans.UserProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eventurino
 */
public class DbUtil {

    public Connection connection;
     //This function connects to the database. 
    //This  needs to be called before you call any function which interacs with the database.

    public void connectToDb() throws SQLException {
        String dbURL = "jdbc:mysql://localhost:3306/igamers";
        String username = "root";
        String password = "iGamers";
        connection = DriverManager.getConnection(dbURL, username, password);
    }

    //This function prints all the products (games) in the products table in the database
    public void printAllProducts() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet products = statement.executeQuery("SELECT * FROM products ");
        ResultSetMetaData rsmd = products.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (products.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnValue = products.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

    //This function validates a login with a username and password
    //returns true if the login exists
    //return false if the login does not exist
    public boolean validateLogin(UserLogin userLogin) throws SQLException {
        String preparedSQL = "SELECT EXISTS(SELECT 1 FROM user_profile WHERE username=? && password=?)"; 
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, userLogin.getUsername());
        ps.setString(2, userLogin.getPassword());
        ResultSet result = ps.executeQuery();
        ResultSetMetaData rsmd = result.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (result.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if(result.getString(i).equals("1")){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
    
    //This function creates a uer profile
    //returns true if the login exists
    //return false if the login does not exist
    public boolean createProfile(UserProfile userProfile) throws SQLException {
        //first check to see if the username exists already. Passwords, firstName, and lastName can be reused between users
        String preparedSQL = "SELECT EXISTS(SELECT 1 FROM user_profile WHERE username=?)"; 
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, userProfile.getUserLogin().getUsername());
        ResultSet result = ps.executeQuery();
        boolean userNameExists=false;
        while (result.next()) {
                if(result.getString(1).equals("1")){
                    userNameExists=true;
                }
        }
        
        //if it exists return false which means the username already exists. 
        //A JSP should probably show the error to the user saying that the usename already exists, pick another username
        if(userNameExists){
            return false;
        }
        //if the username doesn't exist then add the user profile and return true
        else{
              String preparedQuery = "INSERT INTO user_profile (first_Name, last_name, username, password) VALUES (?, ?, ?, ?);"; 
              PreparedStatement ps2 = connection.prepareStatement(preparedQuery); 
              ps2.setString(1, userProfile.getFirstName()); 
              ps2.setString(2, userProfile.getLastName()); 
              ps2.setString(3, userProfile.getUserLogin().getUsername()); 
              ps2.setString(4, userProfile.getUserLogin().getPassword()); 
              ps2.executeUpdate(); 
              return true;
        }
    }

}
