/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PenjualanDataSource {
    
    DbConnection db;

    public PenjualanDataSource(DbConnection db) {
        this.db = db;
    }

    public ArrayList<PenjualanModel> getHistoryPenjualan(int idWareHouse) {
        try {
            db.openConnection();
            String query = ""
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null ;
        } finally {
            db.closeConnection();
        }
        
        
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int doCheckout(int customerId, int employeeId, ArrayList<KeranjangModel> keranjang, String statusPayment, String typeOrder, LocalDateTime waktu, PenjualanDataSource penjualanDataSource) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int updateStatusShipment(int idPenjualan, String statusShipment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

