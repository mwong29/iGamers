/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdb;

import com.beans.Address;
import com.beans.CreditCardInfo;
import com.beans.Product;
import com.beans.UserLogin;
import com.beans.UserProfile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            
            //tests createProfile using all fields
            //if the username already exists in the database then this returns false. IF you want a true result
            //you may need to change the username in the UserLogin below since the username in this code has probably 
            //already be inserted into the database. 
            Address billingAddress = new Address("5867 Underhill Lane", "Franklin", "MD", 12367);
            Address shippingAddress = new Address("5867 Underhill Lane", "Franklin", "MD", 12367);
            CreditCardInfo creditCardInfo = new CreditCardInfo("Visa", "1234567812345678", "Bob Thorton", "06/15/2017", 4567);
            UserLogin userLogin3 = new UserLogin("BobThor2", "BobThorn");
            UserProfile userProfile = new UserProfile(userLogin3, "Bob", "Thorton", billingAddress, shippingAddress, creditCardInfo, "frankUnderhill@gmail.com");
            boolean createProfileSuccess = dbUtil.createProfile(userProfile);
            System.out.println("createProfileSuccess = " + createProfileSuccess);
            
            UserProfile userProfile5 = dbUtil.selectUserProfileByUserLogin(userLogin3);
            if(userProfile5!=null){
                System.out.println("selected user profile where username = " + userLogin3.getUsername() + "and it has first name = " + userProfile5.getFirstName());
            } else{
                System.out.println("User not found");
            }
            
            UserLogin userLogin4 = new UserLogin("BOBThor2", "BobThorn");
            UserProfile userProfile6 = dbUtil.selectUserProfileByUserLogin(userLogin4);
            if(userProfile6!=null){
                System.out.println("selected user profile where username = " + userLogin4.getUsername() + "and it has first name = " + userProfile5.getFirstName());
            } else{
                System.out.println("User not found");
            }
            
            
            Address billingAddress2 = new Address("1000 Underhill Lane", "Franklin", "MD", 12367);
            Address shippingAddress2 = new Address("5867 Underhill Lane", "Somewere", "VA", 11834);
            CreditCardInfo creditCardInfo2 = new CreditCardInfo("MasterCard", "7474747474747474", "Bob Thorton", "06/18/2017", 4567);
            UserLogin userLogin6 = new UserLogin("BobThor2", "BobThorn");
            UserProfile userProfile2 = new UserProfile(userLogin6, "Bob", "Thorton", billingAddress2, shippingAddress2, creditCardInfo2, "bobbob@gmail.com");
            boolean resultUpdateProfile = dbUtil.updateProfile(userProfile2);
            System.out.println(resultUpdateProfile);
            
            ArrayList<Product> productsList = dbUtil.getProductsByCategory("XBOX ONE");
            
            ArrayList<Product> productsList2 = dbUtil.getXAmountProductsByCategory("XBOX ONE", 3);
            
            ArrayList<Product> productsList3 = dbUtil.getAllCategoriesProducts();
        
            ArrayList<Product> productsList4 = dbUtil.getXAmountAllCategoriesProducts(2);
            
            Product product1 = dbUtil.getProductByTitle("Destiny");
            
            Product product2 = dbUtil.getProductByTitleAndCategory("Destiny", "PS4");
            
            Product product3 = dbUtil.getProductByProductCode(10);
            
            
            UserLogin userLogin9 = new UserLogin("BenBiggie", "Tux");
            userProfile2.setUserLogin(userLogin9);
            boolean resetPassBool = dbUtil.resetPassword(userProfile2, "Lux");
            System.out.println("reset password test = " + resetPassBool );
            
            System.out.println("DONE TEST");
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

    }
}
