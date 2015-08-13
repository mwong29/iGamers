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
            DbUtil dbUtil = new DbUtil();
            dbUtil.connectToDb();;
            dbUtil.printAllProducts();
            UserLogin userLogin = new UserLogin("JohnDoe","JohnDoe");
            dbUtil.validateLogin(userLogin);
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

    }
}
