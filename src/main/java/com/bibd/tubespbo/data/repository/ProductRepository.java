/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.source.ProductDataSource;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class ProductRepository {
    ProductDataSource productDataSource ;
    
    public ArrayList<ProductModel> getAllProduct(){
        return new ArrayList<>();
    }
    
    
}
