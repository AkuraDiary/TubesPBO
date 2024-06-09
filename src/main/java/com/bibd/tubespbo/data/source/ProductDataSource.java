/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CategoryModel;
import com.bibd.tubespbo.data.model.ProductModel;
import java.sql.ResultSet;
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

    public ArrayList<ProductModel> getAllProduct() {

        try {
            ArrayList<ProductModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT productId, productName, description, buyPrice, sellPrice, categoryId, produsenId FROM product";

            ResultSet rs = db.getData(query);

            // TODO to edit 
            while (rs.next()) {
                // Parsing the data

                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                int buyPrice = rs.getInt("buyPrice");
                int sellPrice = rs.getInt("sellPrice");
                int categoryId = rs.getInt("categoryId");
                int produsenId = rs.getInt("produsenId");

                // Creating a ProductModel object
                ProductModel product = new ProductModel();
                product.setIdProduct(productId);
                product.setProductName(productName);
                product.setDescription(description);
                product.setBuyPrice((long) buyPrice);
                product.setSellPrice((long) sellPrice);
                product.setCategoryId(categoryId);
                product.setProdusenId(produsenId);

                // Adding the product to the list
                dataResult.add(product);
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int updateProductStock(int idproduct, int jumlah, int idEmployee) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int insertProduct(String productName, int quantityInStock, long buyPrice, long sellPrice, int categoryId, int produsenId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int insertCategory(String namaCategory, String descCategory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<CategoryModel> getAllCategory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
