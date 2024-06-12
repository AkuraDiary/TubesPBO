/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.OrderDetailsModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.source.PembelianDataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PembelianRepository {

    PembelianDataSource pembelianDataSource;

    public PembelianRepository(PembelianDataSource pembelianremotedatasource) {
        this.pembelianDataSource = pembelianremotedatasource;
    }

    public ArrayList<PembelianModel> getAllpembelian(int idWarehouse) {
        return pembelianDataSource.getAllPembelian(idWarehouse);
    }

    public int updateStatusPembelian(int idPembelian, String status) {
        try {
            return pembelianDataSource.updateStatusPembelian(idPembelian, status);
        } catch (Exception e) {
            System.out.println("Pembelian Repo " + e.getLocalizedMessage());
            return -1;
        }
    }

    public int submitPembelian(int employeeId, String orderType, LocalDateTime waktu, String statusOrder, ArrayList<KeranjangModel> keranjang) {
        try {
            return pembelianDataSource.submitPembelian(employeeId, orderType, waktu, statusOrder, keranjang);
        } catch (Exception e) {
            System.out.println("Pembelian Repo " + e.getLocalizedMessage());
            return -1;
        }
    }

    public ArrayList<OrderDetailsModel> getAllProduct() {
        return pembelianDataSource.getDetailPantau();
    }

}
