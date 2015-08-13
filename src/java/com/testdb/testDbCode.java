/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdb;

import com.beans.UserLogin;
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
public class testDbCode {

    public static void main(String[] args) throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            DbUtil dbUtil = new DbUtil();
            dbUtil.connectToDb();;
            
            dbUtil.printAllProducts();
            
            //case sensitive with result true
            UserLogin userLogin1 = new UserLogin("JohnDoe","JohnDoe");
            boolean validateLogin1 = dbUtil.validateLogin(userLogin1);
            System.out.println(validateLogin1);
            
            //case sensitive with result false due to lower case 'doe'
            UserLogin userLogin2 = new UserLogin("Johndoe","JohnDoe");
            boolean validateLogin2 = dbUtil.validateLogin(userLogin2);
            System.out.println(validateLogin2);
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

    }
}
