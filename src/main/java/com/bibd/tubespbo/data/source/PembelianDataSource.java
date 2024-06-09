/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.PembelianModel;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PembelianDataSource {
    
    DbConnection db;

    public PembelianDataSource(DbConnection conn) {
        this.db = conn;
    }

    public int updateStatusPembelian(int idPembelian, String status) {
        // TODO
       return -1;
    }

    public ArrayList<PembelianModel> getAllPembelian() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
