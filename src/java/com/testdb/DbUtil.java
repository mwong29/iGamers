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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
                if (result.getString(i).equals("1")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    //This function creates a uer profile
    //returns true if the login exists
    //return false if the login does not exist
    public boolean updateProfile(UserProfile userProfile) throws SQLException {
        String preparedSQL = "SELECT EXISTS(SELECT 1 FROM user_profile WHERE username=?)";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, userProfile.getUserLogin().getUsername());
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            //if it exists return false which means the username doesn't exist. 
            if (result.getString(1).equals("0")) {
                return false;
            }
        }

        Integer idBillingAddress = null;
        Integer idShippingAddress = null;
        Integer idCreditCardInfo = null;
        String preparedSQL2 = "SELECT * FROM user_profile WHERE username=?";
        PreparedStatement ps2 = connection.prepareStatement(preparedSQL2);
        ps2.setString(1, userProfile.getUserLogin().getUsername());
        ResultSet result2 = ps2.executeQuery();
        while (result2.next()) {
            idBillingAddress = result2.getInt("idbilling_address");
            idShippingAddress = result2.getInt("idshipping_address");
            idCreditCardInfo = result2.getInt("idcredit_card_info");
        }

        //if the username doesn't exist then add the addresses, credit card info, user profile and return true
        boolean updateBillingAddResult = updateBillingAddress(userProfile.getBillingAddress(), idBillingAddress);
        boolean updateShippingAddResult = updateShippingAddress(userProfile.getShippingAddress(), idShippingAddress);
        boolean updateCreditCardResult = updateCreditCardInfo(userProfile.getCreditCardInfo(), idCreditCardInfo);

        String preparedQuery3 = "UPDATE user_profile SET first_name=?, last_name=?, email_address=? WHERE username=?;";
        PreparedStatement ps3 = connection.prepareStatement(preparedQuery3);
        ps3.setString(1, userProfile.getFirstName());
        ps3.setString(2, userProfile.getLastName());
        ps3.setString(3, userProfile.getEmailAddress());
        ps3.setString(4, userProfile.getUserLogin().getUsername());
        ps3.executeUpdate();
        return true;

    }

    //This function creates a user profile
    //returns true if the login creation succesful
    //return false if the login already exists
    public boolean createProfile(UserProfile userProfile) throws SQLException {
        //first check to see if the username exists already. Passwords, firstName, and lastName can be reused between users
        String preparedSQL = "SELECT EXISTS(SELECT 1 FROM user_profile WHERE username=?)";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, userProfile.getUserLogin().getUsername());
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            //if it exists return false which means the username already exists. 
            //A JSP should probably show the error to the user saying that the usename already exists, pick another username
            if (result.getString(1).equals("1")) {
                return false;
            }
        }
        //if the username doesn't exist then add the addresses, credit card info, user profile and return true
        Integer idbilling_address = insertBillingAddress(userProfile.getBillingAddress());
        Integer idshipping_address = insertShippingAddress(userProfile.getShippingAddress());
        Integer idcredit_card_info = insertCreditCardInfo(userProfile.getCreditCardInfo());

        if (idcredit_card_info == 0) {
            System.out.println("error inserting credit card info. There was a null value");
            return false;
        }else{
            String preparedQuery2 = "INSERT INTO user_profile (first_Name, last_name, username, password, idbilling_address, idshipping_address, idcredit_card_info, email_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps2 = connection.prepareStatement(preparedQuery2);
            ps2.setString(1, userProfile.getFirstName());
            ps2.setString(2, userProfile.getLastName());
            ps2.setString(3, userProfile.getUserLogin().getUsername());
            ps2.setString(4, userProfile.getUserLogin().getPassword());
            ps2.setInt(5, idbilling_address);
            ps2.setInt(6, idshipping_address);
            ps2.setInt(7, idcredit_card_info);
            ps2.setString(8, userProfile.getEmailAddress());
            ps2.executeUpdate();
            return true;
        }

    }

    //This function gets/selects a user profile from the database
    //returns null if it isn't found
    //this function could be used when a user is going to checkout and you want to populate his form data for him
    public UserProfile selectUserProfileByUserLogin(UserLogin userLogin) throws SQLException {
        UserProfile userProfile = null;
        Address billingAddress = null;
        Address shippingAddress = null;
        CreditCardInfo creditCardInfo = null;
        String firstName = null;
        String lastName = null;
        String emailAddress = null;
        Integer idBillingAddress = null;
        Integer idShippingAddress = null;
        Integer idCreditCardInfo = null;

        String preparedSQL = "SELECT * FROM user_profile WHERE username=?";
        PreparedStatement ps = connection.prepareStatement(preparedSQL);
        ps.setString(1, userLogin.getUsername());
        ResultSet result = ps.executeQuery();

        boolean foundUser = false;
        while (result.next()) {
            firstName = result.getString("first_name");
            lastName = result.getString("last_name");
            emailAddress = result.getString("email_address");
            idBillingAddress = result.getInt("idbilling_address");
            idShippingAddress = result.getInt("idshipping_address");
            idCreditCardInfo = result.getInt("idcredit_card_info");
            foundUser = true;
        }

        if (foundUser) {
            String preparedQuery2 = "SELECT * FROM billing_address WHERE idbilling_address=?;";
            PreparedStatement ps2 = connection.prepareStatement(preparedQuery2);
            ps2.setInt(1, idBillingAddress);
            ResultSet result2 = ps2.executeQuery();
            while (result2.next()) {
                String streetAddress = result2.getString("street_address");
                String city = result2.getString("city");
                String state = result2.getString("state");
                Integer zip = result2.getInt("zip");
                billingAddress = new Address(streetAddress, city, state, zip);
            }

            String preparedQuery3 = "SELECT * FROM shipping_address WHERE idshipping_address=?;";
            PreparedStatement ps3 = connection.prepareStatement(preparedQuery3);
            ps3.setInt(1, idShippingAddress);
            ResultSet result3 = ps3.executeQuery();
            while (result3.next()) {
                String streetAddress = result3.getString("street_address");
                String city = result3.getString("city");
                String state = result3.getString("state");
                Integer zip = result3.getInt("zip");
                shippingAddress = new Address(streetAddress, city, state, zip);
            }

            String preparedQuery4 = "SELECT * FROM credit_card_info WHERE idcredit_card_info=?;";
            PreparedStatement ps4 = connection.prepareStatement(preparedQuery4);
            ps4.setInt(1, idCreditCardInfo);
            ResultSet result4 = ps4.executeQuery();
            while (result4.next()) {
                String company = result4.getString("company");
                String number = result4.getString("number");
                String nameOnCard = result4.getString("name_on_card");
                String expirationDate = result4.getString("expiration_date");
                Integer cvv = result4.getInt("cvv");
                creditCardInfo = new CreditCardInfo(company, number, nameOnCard, expirationDate, cvv);
            }

            userProfile = new UserProfile(userLogin, firstName, lastName, billingAddress, shippingAddress, creditCardInfo, emailAddress);
        }
        return userProfile;
    }

    private Integer insertBillingAddress(Address address) throws SQLException {

        String preparedQuery = "INSERT INTO billing_address (street_address, city, state, zip) VALUES (?, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, address.getStreetAddress());
        ps.setString(2, address.getCity());
        ps.setString(3, address.getState());
        ps.setInt(4, address.getZip());
        ps.executeUpdate();

        String preparedSQL2 = "SELECT idbilling_address FROM billing_address WHERE street_address=? AND city=? AND state=? AND zip=? ORDER BY idbilling_address DESC LIMIT 1";
        PreparedStatement ps2 = connection.prepareStatement(preparedSQL2);
        ps2.setString(1, address.getStreetAddress());
        ps2.setString(2, address.getCity());
        ps2.setString(3, address.getState());
        ps2.setInt(4, address.getZip());
        Integer idbilling_address = null;
        ResultSet result4 = ps2.executeQuery();
        while (result4.next()) {
            idbilling_address = result4.getInt("idbilling_address");
        }
        return idbilling_address;
    }

    private Integer insertShippingAddress(Address address) throws SQLException {

        String preparedQuery = "INSERT INTO shipping_address (street_address, city, state, zip) VALUES (?, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, address.getStreetAddress());
        ps.setString(2, address.getCity());
        ps.setString(3, address.getState());
        ps.setInt(4, address.getZip());
        ps.executeUpdate();

        String preparedSQL2 = "SELECT idshipping_address FROM shipping_address WHERE street_address=? AND city=? AND state=? AND zip=? ORDER BY idshipping_address DESC LIMIT 1";
        PreparedStatement ps2 = connection.prepareStatement(preparedSQL2);
        ps2.setString(1, address.getStreetAddress());
        ps2.setString(2, address.getCity());
        ps2.setString(3, address.getState());
        ps2.setInt(4, address.getZip());
        Integer idshipping_address = null;
        ResultSet result4 = ps2.executeQuery();
        while (result4.next()) {
            idshipping_address = result4.getInt("idshipping_address");
        }
        return idshipping_address;
    }

    private Integer insertCreditCardInfo(CreditCardInfo creditCardInfo) throws SQLException {

        if (creditCardInfo.getCompany() == null) {
            System.out.println("company for credit card null. NOT inserting credit card into database");
            return 0;
        } else if (creditCardInfo.getNumber() == null) {
            System.out.println("number for credit card null. NOT inserting credit card into database");
            return 0;
        } else if (creditCardInfo.getNameOnCard() == null) {
            System.out.println("name on card for credit card null. NOT inserting credit card into database");
            return 0;
        } else if (creditCardInfo.getExpirationDate() == null) {
            System.out.println("expiration data on card for credit card null. NOT inserting credit card into database");
            return 0;
        } else if (creditCardInfo.getCvv() == 0) {
            System.out.println("CVV data on card for credit card zero. NOT inserting credit card into database");
            return 0;
        } else {

            String preparedQuery = "INSERT INTO credit_card_info (company, number, name_on_card, expiration_date, cvv) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, creditCardInfo.getCompany());
            ps.setString(2, creditCardInfo.getNumber());
            ps.setString(3, creditCardInfo.getNameOnCard());
            ps.setString(4, creditCardInfo.getExpirationDate());
            ps.setInt(5, creditCardInfo.getCvv());
            ps.executeUpdate();

            String preparedSQL2 = "SELECT idcredit_card_info FROM credit_card_info WHERE company=? AND number=? AND name_on_card=? AND expiration_date=? AND cvv=? ORDER BY idcredit_card_info DESC LIMIT 1";
            PreparedStatement ps2 = connection.prepareStatement(preparedSQL2);
            ps2.setString(1, creditCardInfo.getCompany());
            ps2.setString(2, creditCardInfo.getNumber());
            ps2.setString(3, creditCardInfo.getNameOnCard());
            ps2.setString(4, creditCardInfo.getExpirationDate());
            ps2.setInt(5, creditCardInfo.getCvv());
            Integer idcredit_card_info = null;
            ResultSet result4 = ps2.executeQuery();
            while (result4.next()) {
                idcredit_card_info = result4.getInt("idcredit_card_info");
            }
            return idcredit_card_info;
        }
    }

    private boolean updateBillingAddress(Address address, Integer idBillingAddress) throws SQLException {

        String preparedQuery = "UPDATE billing_address SET street_address=?, city=?, state=?, zip=? WHERE idbilling_address=?;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, address.getStreetAddress());
        ps.setString(2, address.getCity());
        ps.setString(3, address.getState());
        ps.setInt(4, address.getZip());
        ps.setInt(5, idBillingAddress);
        ps.executeUpdate();
        return true;
    }

    private boolean updateShippingAddress(Address address, Integer idShippingAddress) throws SQLException {

        String preparedQuery = "UPDATE shipping_address SET street_address=?, city=?, state=?, zip=? WHERE idshipping_address=?;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, address.getStreetAddress());
        ps.setString(2, address.getCity());
        ps.setString(3, address.getState());
        ps.setInt(4, address.getZip());
        ps.setInt(5, idShippingAddress);
        ps.executeUpdate();
        return true;
    }

    private boolean updateCreditCardInfo(CreditCardInfo creditCardInfo, Integer idCreditCardInfo) throws SQLException {

        String preparedQuery = "UPDATE credit_card_info SET company=?, number=?, name_on_card=?, expiration_date=?, cvv=? WHERE idcredit_card_info=?;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, creditCardInfo.getCompany());
        ps.setString(2, creditCardInfo.getNumber());
        ps.setString(3, creditCardInfo.getNameOnCard());
        ps.setString(4, creditCardInfo.getExpirationDate());
        ps.setInt(5, creditCardInfo.getCvv());
        ps.setInt(6, idCreditCardInfo);
        ps.executeUpdate();
        return true;
    }

    public ArrayList<Product> getProductsByCategory(String categoryDesired) throws SQLException {
        ArrayList<Product> productsList = new ArrayList();
        String preparedQuery = "SELECT * FROM products WHERE category=?;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, categoryDesired);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            Product product = new Product(productCode, description, price, specialDeals, imagePath, category, title);
            productsList.add(product);
        }
        return productsList;
    }

    public ArrayList<Product> getXAmountProductsByCategory(String categoryDesired, int xAmount) throws SQLException {
        ArrayList<Product> productsList = new ArrayList();
        String preparedQuery = "SELECT * FROM products WHERE category=? LIMIT ?;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, categoryDesired);
        ps.setInt(2, xAmount);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            Product product = new Product(productCode, description, price, specialDeals, imagePath, category, title);
            productsList.add(product);
        }
        return productsList;
    }

    public ArrayList<Product> getAllCategoriesProducts() throws SQLException {
        ArrayList<Product> productsList = new ArrayList();
        String preparedQuery = "SELECT * FROM products;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            Product product = new Product(productCode, description, price, specialDeals, imagePath, category, title);
            productsList.add(product);
        }
        return productsList;
    }

    public ArrayList<Product> getXAmountAllCategoriesProducts(int xAmount) throws SQLException {
        ArrayList<Product> productsList = new ArrayList();
        String preparedQuery = "SELECT * FROM products LIMIT ?;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setInt(1, xAmount);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            Product product = new Product(productCode, description, price, specialDeals, imagePath, category, title);
            productsList.add(product);
        }
        return productsList;
    }

    public Product getProductByTitle(String titleDesired) throws SQLException {
        Product product = null;
        String preparedQuery = "SELECT * FROM products where title=? LIMIT 1;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, titleDesired);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            product = new Product(productCode, description, price, specialDeals, imagePath, category, title);

        }
        return product;
    }

    public Product getProductByTitleAndCategory(String titleDesired, String categoryDesired) throws SQLException {
        Product product = null;
        String preparedQuery = "SELECT * FROM products where title=? AND category=? LIMIT 1;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, titleDesired);
        ps.setString(2, categoryDesired);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            product = new Product(productCode, description, price, specialDeals, imagePath, category, title);
        }
        return product;
    }

    public Product getProductByProductCode(Integer productCodeDesired) throws SQLException {
        Product product = null;
        String preparedQuery = "SELECT * FROM products where product_code=? LIMIT 1;";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setInt(1, productCodeDesired);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Integer productCode = result.getInt("product_code");
            String description = result.getString("description");
            Double price = result.getDouble("price");
            String specialDeals = result.getString("special_deals");
            String imagePath = result.getString("image_path");
            String category = result.getString("category");
            String title = result.getString("title");
            product = new Product(productCode, description, price, specialDeals, imagePath, category, title);
        }
        return product;
    }
}
