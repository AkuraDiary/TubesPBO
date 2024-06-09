/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;


import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.ProdusenModel;
import java.util.ArrayList;

/**
 *
 * @author rafid
 */
public class ProdusenDataSource {
    
    
    DbConnection db;

    public ProdusenDataSource(DbConnection db) {
        this.db = db;
    }
    
    //TODO
    public ArrayList<ProdusenModel> getAllProdusen() {
        
        return new ArrayList<> ();
    }
    
    
}
