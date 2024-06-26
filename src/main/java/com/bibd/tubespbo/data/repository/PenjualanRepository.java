/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.OrderDetailsModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.data.source.PenjualanDataSource;

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

    public ArrayList<PenjualanModel> getHistoryPenjualan(int idWareHouse, int idEmployee) {

        return penjualanDataSource.getHistoryPenjualanSales(idWareHouse, idEmployee);
    }
    public ArrayList<OrderDetailsModel> getDetilPenjualan( int idOrder) {
        return penjualanDataSource.getAllDetilOrder(idOrder);    
        
    }
    
    

    public ArrayList<PenjualanModel> getHistoryPenjualan(int idWareHouse) {

        return penjualanDataSource.getHistoryPenjualanByWarehouse(idWareHouse);
    }
    public int doCheckOut(int employeeId, int customerId, String statusPayment, String waktu, String typeOrder, ArrayList<KeranjangModel> keranjang, String shipStatus, int idWarehouse) {
        try {
            return penjualanDataSource.doCheckout(customerId, employeeId, keranjang, statusPayment, typeOrder, waktu,shipStatus,idWarehouse);
          
        } catch (Exception e) {
            System.out.println("Penjualan Repo " + e.getLocalizedMessage());
            return -1;
        }

    }

    public int updateStatusShipmentPayment(int idPenjualan, String statusShipment, String statusPayment) {
        try {
            return penjualanDataSource.updateStatusShipPay(idPenjualan, statusShipment, statusPayment);
        } catch (Exception e) {
            System.out.println("Penjualan Repo " + e.getLocalizedMessage());
            return -1;
        }
    }
    
    public int updateStockPaid(int idPenjualan, String statusShipment, String statusPayment, ArrayList<OrderDetailsModel> listProduk, int idWarehouse){
        try {
            return penjualanDataSource.updateStockPaid(idPenjualan, statusShipment, statusPayment, listProduk, idWarehouse);
        } catch (Exception e) {
            System.out.println("Penjualan Repo " + e.getLocalizedMessage());
            return -1;
        }
    }

}
