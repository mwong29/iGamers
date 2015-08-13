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
            
            //tests createProfile using UserLogin(username,password), firstName, and lastName. No addresses or credit card info
            //if the username already exists in the database then this returns false. IF you want a true result
            //you may need to change the username in the UserLogin below since the username in this code has probably 
            //already be inserted into the database. 
            UserProfile userProfile = new UserProfile(new UserLogin("KevinSpacey", "EricHogan"), "Eric", "Hogan");
            boolean createProfileSuccess = dbUtil.createProfile(userProfile);
            System.out.println(createProfileSuccess);
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

    }
}
