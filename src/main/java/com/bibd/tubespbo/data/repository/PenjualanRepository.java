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
        try {
            return penjualanDataSource.doCheckout(customerId, employeeId, keranjang, statusPayment, typeOrder, waktu);
        } catch (Exception e) {
            System.out.println("Penjualan Repo " + e.getLocalizedMessage());
            return -1;
        }

    }

    public int updateStatusShipment(int idPenjualan, String statusShipment) {
        try {
            return penjualanDataSource.updateStatusShipment(idPenjualan, statusShipment);
        } catch (Exception e) {
            System.out.println("Penjualan Repo " + e.getLocalizedMessage());
            return -1;
        }
    }

}
