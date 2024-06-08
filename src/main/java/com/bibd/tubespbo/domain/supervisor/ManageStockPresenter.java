/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.repository.ProductRepository;

/**
 *
 * @author asthiseta
 */
public class ManageStockPresenter {
    
    ProductRepository productRepository;
    ProductRepository productModel ;
    
    
    
    public ManageStockPresenter(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    public void updateStockProduct(){
        
    }
    
}
