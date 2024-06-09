/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author rafid
 */
public class PenjualanRepository {

    public ArrayList<PenjualanModel> getHistoryPenjualan(int idWareHouse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int doCheckOut(int employeeId, int customerId, String statusPayment, LocalDateTime waktu, String typeOrder, ArrayList<KeranjangModel> keranjang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int updateStatusShipment(int idPenjualan, String statusShipment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int submitPembelian(int employeeId, String orderType, LocalDateTime waktu, String statusOrder, ArrayList<KeranjangModel> keranjang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
