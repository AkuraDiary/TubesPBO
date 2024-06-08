/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.ProdusenModel;
import com.bibd.tubespbo.data.source.ProdusenDataSource;
import java.util.ArrayList;

/**
 *
 * @author rafid
 */
public class ProdusenRepository {
    ProdusenDataSource produsenDataSource;
    
    public ArrayList<ProdusenModel> getAllProdusen (){
     produsenDataSource.getAllProduct();
    return new ArrayList<>();
    }

    public void addProdusen(ProdusenModel pm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
