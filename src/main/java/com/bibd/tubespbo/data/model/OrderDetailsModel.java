/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

/**
 *
 * @author rafid
 */
public class OrderDetailsModel {
    private long idOrderDetails, unitPrice, jumlah, totalPrice, idProduct;
    private ProductModel productModel ;
    private String productName ;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public OrderDetailsModel(
            int id, long unitPrice, 
            int quantity, long subTotalPrice, 
            int idProduct, String productName, 
            String description, long buyPrice, 
            long sellPrice, int categoryId, 
            int produsenId) {
        this.idOrderDetails = id;
        this.productName = productName;
        this.totalPrice = subTotalPrice;
        this.jumlah = quantity;
                
        this.productModel = new ProductModel();
        this.idProduct = idProduct;
        this.productModel.setIdProduct(idProduct);
        this.productModel.setProdusenId(produsenId);
        this.productModel.setBuyPrice(buyPrice);
//        this.productModel.
        
             
        
    }

    public long getIdOrderDetails() {
        return idOrderDetails;
    }

    public void setIdOrderDetails(int idOrderDetails) {
        this.idOrderDetails = idOrderDetails;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    
    
    
}
