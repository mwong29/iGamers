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
public class Address implements Serializable {
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
        
    public Address() {
        streetAddress = "";
        city = "";
        state = "";
        zip = 0;
    }
    
    public Address(String streetAddress, String city, String state, int zip) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * @return the zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * @param zip the state to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

}
