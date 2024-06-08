/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.ProductModel;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */

//Rapid D.
public class ProductDataSource {

    DbConnection db;

    public ProductDataSource(DbConnection db) {
        this.db = db;
    }

    
    //TODO
    public ArrayList<ProductModel> getAllProduct() {
        
        return new ArrayList<> ();
    }

    public int updateProductStock(int idproduct, int jumlah, int idEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int insertProduct(String productName, int quantityInStock, long buyPrice, long sellPrice, int categoryId, int produsenId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
