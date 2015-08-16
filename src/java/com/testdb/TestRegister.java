/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testdb;

import com.beans.Address;
import com.beans.CreditCardInfo;
import com.beans.UserLogin;
import com.beans.UserProfile;
import java.sql.SQLException;

/**
 *
 * @author eventurino
 */
public class TestRegister {
     public static void main(String[] args) throws Exception {
         
         String username = "Ghosty23";
        String password = "cup";
        String first = "Jordan";
        String last = "Kemp";
        String billStreet = "9898 Ghost Avenue";
        String billCity = "Lorton";
        String billState = "VA";
        String billZip = "22079";
        String shipStreet = "9898 Ghost Avenue";
        String shipCity = "Lorton";
        String shipState = "VA";
        String shipZip = "22079";
        String ccCompany = "Visa";
        String ccNumber = null; //if this value, or any string for credit card info, is null then the database credit card insert will not work
        String ccName = "Jordan Kemp";
        String ccExpDate = "06/07/2017";
        String ccCVV = "4573";
        String email = "ghosty@gmail.com";
        
        //String goLogin = "";
        //String account = "";
        //String update = "";
        //String register = "value";
        
        //UserLogin user = new UserLogin(username, password);
        //UserProfile profile = (UserProfile) session.getAttribute("prof");
        DbUtil dbUtil = new DbUtil();
         
         int billZipNum = 0;
                int shipZipNum = 0;
                int ccCVVNum = 0;
                if (!billZip.equals("")) {
                    try {
                        billZipNum = Integer.parseInt(billZip);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }
                if (!shipZip.equals("")) {
                    try {
                        shipZipNum = Integer.parseInt(shipZip);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }
                if (!ccCVV.equals("")) {
                    try {
                        ccCVVNum = Integer.parseInt(ccCVV);
                    } catch (NumberFormatException nfe) {
                        nfe.getMessage();
                    }
                }

                UserLogin newUserLogin = new UserLogin(username, password);
                Address newBilling = new Address(billStreet, billCity, billState, billZipNum);
                Address newShipping = new Address(shipStreet, shipCity, shipState, shipZipNum);
                CreditCardInfo newCC = new CreditCardInfo(ccCompany, ccNumber, ccName, ccExpDate, ccCVVNum);
                UserProfile newUserProfile = new UserProfile(newUserLogin, first, last, newBilling, newShipping, newCC, email);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbUtil.connectToDb();
                    Boolean isUserExists = dbUtil.createProfile(newUserProfile);
                    System.out.println("success = " + isUserExists);
                } catch (SQLException e) {
                    for (Throwable t : e) {
                        t.printStackTrace();
                    }
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
     }
}
