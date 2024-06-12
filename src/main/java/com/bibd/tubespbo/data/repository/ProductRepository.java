/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.CategoryModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.model.ProductStockModel;
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

    public ProductRepository(ProductDataSource productDataSource, ProdusenDataSource produsenDataSource) {
        this.productDataSource = productDataSource;
        this.produsenDataSource = produsenDataSource;
    }
    
    

    public ArrayList<ProductModel> getAllProduct() {
        return productDataSource.getAllProduct();
    }

    public int updateProductStock(int idStock, int jumlahBaru, int idEmployee, int perubahan) {
        try {
            return productDataSource.updateProductStock(idStock, jumlahBaru, idEmployee, perubahan);
        } catch (Exception e) {
            System.out.println("Product Repo " + e.getLocalizedMessage());
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
                    pm.getProdusenId(),
                    pm.getDescription()
            );
        } catch (Exception e) {
            System.out.println("Product Repo " + e.getLocalizedMessage());
            return -1;
        }
    }
    
    public int editDataProduct(ProductModel pm){
        try {
            return productDataSource.updateDataProduct(
                    pm.getIdProduct(),
                    pm.getProductName(),
//                    pm.getQuantityInStock(),
                    pm.getBuyPrice(),
                    pm.getSellPrice(),
                    pm.getCategoryId(),
                    pm.getProdusenId(),
                    pm.getDescription()
            );
        } catch (Exception e) {
            System.out.println("Product Repo " + e.getLocalizedMessage());
            return -1;
        }
    }

    public int addCategory(CategoryModel cm) {
        try {
            return productDataSource.insertCategory(
                    cm.getNamaCategory(),
                    cm.getDescCategory()
            );
        } catch (Exception e) {
            System.out.println("Product Repo " + e.getLocalizedMessage());
            return -1;
        }
    }

    public ArrayList<CategoryModel> getAllCategory() {
        return productDataSource.getAllCategory();
    }

    public ArrayList<ProductStockModel> getStockProduct(int idWarehouse) {
        return productDataSource.getAllStockProduct( idWarehouse);
    }


    public int addNewStockProduct(int idProduct, int quantity, int idEmployee, int idWarehouse) {
        try{
            return productDataSource.insertProductStock(idProduct, quantity, idEmployee, idWarehouse);
        }catch (Exception e){
            System.out.println("Product Repo " + e.getLocalizedMessage());
            return -1;
        }

    }
}
