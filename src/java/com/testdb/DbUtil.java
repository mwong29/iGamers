/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdb;

import java.sql.Connection;
import java.sql.DriverManager;
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
     public void connectToDb() throws SQLException{
            String dbURL = "jdbc:mysql://localhost:3306/iGamers";
            String username = "root";
            String password = "iGamers";
            connection = DriverManager.getConnection(dbURL, username, password);
     }
     
     public void printAllProducts() throws SQLException{
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
     
     
}
