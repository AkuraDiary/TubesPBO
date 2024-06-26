/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author rafid
 */
public class PenjualanModel {

    private int customerId, employeeId,idPenjualan, idorder;
    private int  totalBiaya, quantity;

    private long unitPrice;
    private String shipmentStatus, statusPayment, orderType;
    private Date tanggalOrder, dateShipped;
    private ArrayList<OrderDetailsModel> keranjang = new ArrayList<>();
    private String customerName, employeeName, productName;

    public int getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(int totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public PenjualanModel(int idPenjualan1, String shipmentStatus1, Date dateShipped1, int orderId, int customerId1, String statusPayment1, Date orderDate, String orderType1, int employeeId1) {
        this.idPenjualan = idPenjualan1;
        this.shipmentStatus = shipmentStatus1;
        this.dateShipped = dateShipped1;
        this.idorder = orderId;
        this.customerId = customerId1;
        this.statusPayment = statusPayment1;
        this.tanggalOrder = orderDate;
        this.orderType = orderType1;
        this.employeeId = employeeId1;
    }

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

    public ArrayList<OrderDetailsModel> getKeranjang() {
        return keranjang;
    }

    public void setKeranjang(ArrayList<OrderDetailsModel> keranjang) {
        this.keranjang = keranjang;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
