/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rafid
 */
public class PenjualanModel {
    private int idPenjualan;
    private int customerId;
    private Date tanggal ;
    private ArrayList<KeranjangModel> keranjang = new ArrayList<>();

    public int getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public ArrayList<KeranjangModel> getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(ArrayList<KeranjangModel> keranjang) {
        this.keranjang = keranjang;
    }
    
    
}
