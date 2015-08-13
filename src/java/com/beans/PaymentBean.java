/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Maurice Wong
 */
public class PaymentBean
{
    private String creditCardType = "";
    private String creditCardNumber = "";
    private String creditCardExpirationDate = "";
    private String messages = "";
    private double total_payment = 0.0;
    private boolean isValid = true;
    
    public PaymentBean()
    {
        this.creditCardExpirationDate = "";
        this.creditCardNumber = "";
        this.creditCardType = "";
        this.messages = "";
        this.total_payment = 0.0;
        
        //checkPayment();
    }
    
    public PaymentBean(String cctype, String creditcardnum, String creditcardexp, double total_payment)
    {
        this.creditCardExpirationDate = creditcardexp;
        this.creditCardNumber = creditcardnum;
        this.creditCardType = cctype;
        this.total_payment = total_payment;
        this.messages = "";
        checkPayment();
    }
    
    public void checkPayment()
    {
        if (checkCreditCardNum(this.creditCardNumber) == false ||
                validateExpireDate(this.creditCardExpirationDate) == false ||
                checkCctype(this.creditCardType) == false)
        {
            this.isValid = false;
        }
    }
    
    public boolean validateExpireDate(String creditCardExpirationDate) 
    {
        if (creditCardExpirationDate.matches("(?:0[1-9]|1[0-2])/[0-9]{2}"))
        {
            return true;
        }
        else
        {
            this.messages += "Check expiration <br/>";
            return false;
        }
    } 
    
    public boolean checkCctype(String cctype)
    {
        String[] validCards = new String[]{"AmericanExpress", "Visa", "MasterCard"};

        for (String x : validCards)
        {
            if (x.equals(cctype))
            {
                return true;
            }
        }
        
        this.messages += "Check credit card type <br/>";
        
        return false;
    }
    
    public boolean checkCreditCardNum(String creditCardNumber)
    {
        String card = creditCardNumber.trim();
        String[] number_array = card.split("");
        String[] valid_array = "0123456789".split("");
        
        if (number_array.length < 16 || number_array.length > 17)
        {
            this.messages += "Check credit card number length<br/>";
            return false;
        }
        
        for(String x : number_array)
        {
            if (!Arrays.asList(valid_array).contains(x))
            {
                this.messages += "Check credit card numbers <br/>";
                return false;
            }
        }
        
        return true;
    }

    public String getCreditCardType()
    {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType)
    {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardNumber()
    {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber)
    {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExpirationDate()
    {
        return creditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate)
    {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public double getTotal_payment()
    {
        return total_payment;
    }

    public void setTotal_payment(double total_payment)
    {
        this.total_payment = total_payment;
    }

    public boolean isIsValid()
    {
        return isValid;
    }

    public void setIsValid(boolean isValid)
    {
        this.isValid = isValid;
    }

    public String getMessages()
    {
        return messages;
    }

    public void setMessages(String messages)
    {
        this.messages = messages;
    }
}
