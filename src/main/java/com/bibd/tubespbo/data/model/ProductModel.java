/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
public class ProductModel {

    int idProduct, categoryId, produsenId, quantityInStock;
    long buyPrice, sellPrice;
    String productName, description;

    //new
    Date lastUpdate;
    String categoryName, produsenName, warehouseName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getProdusenName() {
        return produsenName;
    }

    public void setProdusenName(String produsenName) {
        this.produsenName = produsenName;
    }
    

    

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public ProductModel(int idProduct, int categoryId, int produsenId, int quantityInStock, long buyPrice, long sellPrice, String productName, String description) {
        this.idProduct = idProduct;
        this.categoryId = categoryId;
        this.produsenId = produsenId;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.productName = productName;
        this.description = description;
    }

    public ProductModel() {
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProdusenId() {
        return produsenId;
    }

    public void setProdusenId(int produsenId) {
        this.produsenId = produsenId;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public long getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
