/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.repository.ProductRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */

//Rapid D.
public class ManageStockPresenter {
    
    ProductRepository productRepository;
    
    ArrayList<ProductModel> listProduct = new ArrayList<>();
    
    
    
    public ManageStockPresenter(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    public void showAll(){
        this.listProduct = productRepository.getAllProduct();
    }
    
     int result = 0;
    public void updateStockProduct(int idProduct, int jumlah, int idEmployee){
         result = productRepository.updateProductStock(idProduct,jumlah,idEmployee);
    }
    
    public void resetResult(){
        result = 0 ;
    }
    
}
