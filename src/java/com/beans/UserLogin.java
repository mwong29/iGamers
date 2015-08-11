/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.io.Serializable;
/**
 *
 * @author Christopher
 */
public class UserLogin implements Serializable {
    private String username;
    private String password;
    private Boolean isValidLogin = true;
    private String INVALID_LOGIN = "Invalid Username/Password";
        
    public UserLogin() {
        username = "";
        password = "";
    }
    
    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * @return the isValidLogin
     */
    public Boolean getIsValidLogin() {
        return isValidLogin;
    }
    
    /**
     * @param isValidLogin the isValidLogin to set
     */
    public void setIsValidLogin(Boolean isValidLogin) {
        this.isValidLogin = isValidLogin;
    }
    
    /**
     * @return the invalid_login message
     */
    public String getInvalidLogin() {
        return INVALID_LOGIN;
    }
    
    
}
