/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.data.source.PenjualanDataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author rafid
 */
public class PenjualanRepository {
    
    PenjualanDataSource penjualanDataSource;

    public PenjualanRepository(PenjualanDataSource penjualanDataSource) {
        this.penjualanDataSource = penjualanDataSource;
    }
    

    public ArrayList<PenjualanModel> getHistoryPenjualan(int idWareHouse) {
    
        return penjualanDataSource.getHistoryPenjualan(idWareHouse);
    }
    
    public int doCheckOut(int employeeId, int customerId, String statusPayment, LocalDateTime waktu, String typeOrder, ArrayList<KeranjangModel> keranjang) {
        return penjualanDataSource.doCheckout(customerId, employeeId, keranjang, statusPayment, typeOrder, waktu, penjualanDataSource);
    }

    public int updateStatusShipment(int idPenjualan, String statusShipment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
