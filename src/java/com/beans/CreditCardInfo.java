/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.io.Serializable;
/**
 *This address can be used for a shipping address or a billing address
 * @author Christopher
 */
public class CreditCardInfo implements Serializable {
    private String company;
    private String number;
    private String nameOnCard;
    private String expirationDate;
    private int cvv;
        
    public CreditCardInfo() {
        company = "";
        number = "";
        nameOnCard = "";
        expirationDate = "";
        cvv = 0;
    }
    
    public CreditCardInfo(String company, String number, String nameOnCard, String expirationDate, int cvv) {
        this.company = company;
        this.number = number;
        this.nameOnCard = nameOnCard;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }
    
    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @param nameOnCard the nameOnCard to set
     */
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }
    
    /**
     * @return the nameOnCard
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    /**
     * @return the expirationDate
     */
    public String getExpirationDate() {
        return expirationDate;
    }
    
    /**
     * @return the cvv
     */
    public int getCvv() {
        return cvv;
    }

    /**
     * @param cvv the cvv to set
     */
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}
