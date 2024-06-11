/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

import java.util.Date;

/**
 *
 * @author asthiseta
 */
public class ProductStockModel {
     private int id;
    private int totalStock;
    private Date lastUpdate;
    private int productId;
    private int idWarehouse;

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Default constructor
    public ProductStockModel() {
    }

    // Parameterized constructor
    public ProductStockModel(int id, int totalStock, Date lastUpdate, int productId, int idWarehouse) {
        this.id = id;
        this.totalStock = totalStock;
        this.lastUpdate = lastUpdate;
        this.productId = productId;
        this.idWarehouse = idWarehouse;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    // toString method
    @Override
    public String toString() {
        return "ProductStock{" +
                "id=" + id +
                ", totalStock=" + totalStock +
                ", lastUpdate=" + lastUpdate +
                ", productId=" + productId +
                ", idWarehouse=" + idWarehouse +
                '}';
    }
    
}
