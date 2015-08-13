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
public class Product implements Serializable {
    private Integer productCode;
    private String description;
    private Double price;
    private String specialDeals;
    private String imagePath;
    private String category;
    private String title;
    
    public Product() {
        productCode = null;
        description = "";
        price = null;
        specialDeals = "";
        imagePath = "";
        category = "";
        title = "";
    }
    
    public Product(Integer productCode, String description, Double price, String specialDeals, String imagePath, String category, String title) {
        this.productCode = productCode;
        this.description = description;
        this.price = price;
        this.specialDeals = specialDeals;
        this.imagePath = imagePath;
        this.category = category;
        this.title = title;
    }

    
    /**
     * @return the productCode
     */
    public Integer getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setProductCode(Double price) {
        this.price = price;
    }
    
    /**
     * @return the specialDeals
     */
    public String getSpecialDeals() {
        return specialDeals;
    }

    /**
     * @param specialDeals the specialDeals to set
     */
    public void setSpecialDeals(String specialDeals) {
        this.specialDeals = specialDeals;
    }
    
    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
