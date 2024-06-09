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
    private int idPenjualan,idorder;
    private int customerId,employeeId;
    private String shipmentStatus, statusPayment, orderType ;
    private Date tanggalOrder,dateShipped ;
    private ArrayList<OrderDetails> keranjang = new ArrayList<>();
    

    public int getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(int idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Date getTanggalOrder() {
        return tanggalOrder;
    }

    public void setTanggalOrder(Date tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public ArrayList<OrderDetails> getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(ArrayList<OrderDetails> keranjang) {
        this.keranjang = keranjang;
    }
    
    

    
    
    
}
