/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

/**
 *
 * @author asthiseta
 */
import java.util.ArrayList;
import java.util.Date;

public class PembelianModel {

   private int idPembelian,idOrder;
   private int idSupervisor;
   private String status;
   private ArrayList<OrderDetailsModel> keranjang = new ArrayList<>();
   private Date tanggalOrder;
   private String typeOrder;
    private long totalBiaya;
    private String warehouse;
    private int warehouseId;


    // Getters and Setters
    public int getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<OrderDetailsModel> getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(ArrayList<OrderDetailsModel> keranjang) {
        this.keranjang = keranjang;
    }

    public Date getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(Date tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

  

    public void setOrderId(int aInt) {
      this.idOrder = aInt;
    }


    public void setTotalBiaya(long totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public long getTotalBiaya() {
        return totalBiaya;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }
}

