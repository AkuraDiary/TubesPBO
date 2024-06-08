/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.WarehouseModel;

/**
 *
 * @author asthiseta
 */
public class WarehouseDataSource {
    
    DbConnection conn;

    public WarehouseDataSource(DbConnection conn) {
        this.conn = conn;
    }
    
    
    //TODO RAPID
    
    // get warehouse by id
    public WarehouseModel getWarehouseById(int id){
        // TODO
        return new WarehouseModel();
    }
    
    // get city by id
    
    // get province by id
    
}
