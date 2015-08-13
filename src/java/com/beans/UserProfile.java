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
public class UserProfile implements Serializable {
    private UserLogin userLogin;
    private String firstName;
    private String lastName;
    private Address billingAddress;
    private Address shippingAddress;
    private CreditCardInfo creditCardInfo;
    private String emailAddress;
    
    public UserProfile() {
        userLogin = null;
        firstName = "";
        lastName = "";
        billingAddress = null;
        shippingAddress = null;
        creditCardInfo = null;
        emailAddress = "";
    }
    
    public UserProfile(UserLogin userLogin, String firstName, String lastName, Address billingAddress, Address shippingAddress, CreditCardInfo creditCardInfo, String emailAddress) {
        this.userLogin = userLogin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.creditCardInfo = creditCardInfo;
        this.emailAddress = emailAddress;
    }

    /**
     * @return the userLogin
     */
    public UserLogin getUserLogin() {
        return userLogin;
    }

    /**
     * @param userLogin the userLogin to set
     */
    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @return the shippingAddress
     */
    public Address getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @param shippingAddress the shippingAddress to set
     */
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    /**
     * @return the billingAddress
     */
    public Address getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress the billingAddress to set
     */
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    /**
     * @return the creditCardInfo
     */
    public CreditCardInfo getCreditCardInfo() {
        return creditCardInfo;
    }

    /**
     * @param creditCardInfo the creditCardInfo to set
     */
    public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }
    
    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
