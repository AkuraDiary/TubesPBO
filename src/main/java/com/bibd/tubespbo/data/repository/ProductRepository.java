/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.source.ProductDataSource;
import com.bibd.tubespbo.data.source.ProdusenDataSource;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
//Rapid D.
public class ProductRepository {

    ProductDataSource productDataSource;
    ProdusenDataSource produsenDataSource;

    public ArrayList<ProductModel> getAllProduct() {
        productDataSource.getAllProduct();
        return new ArrayList<>();
    }

    public int updateProductStock(int idproduct, int jumlah, int idEmployee) {
        try {

            return productDataSource.updateProductStock(idproduct, jumlah, idEmployee);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }

    public int addProduct(ProductModel pm) {
        try {
            return productDataSource.insertProduct(
                    pm.getProductName(),
                    pm.getQuantityInStock(),
                    pm.getBuyPrice(),
                    pm.getSellPrice(),
                    pm.getCategoryId(),
                    pm.getProdusenId()
            );
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }

    public void addCategory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    

}
