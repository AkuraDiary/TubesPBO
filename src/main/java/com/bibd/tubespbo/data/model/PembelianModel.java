/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
public class PembelianModel {
   private int idPembelian,idorder;
   private int idSupervisor;
   private String Status;
   private ArrayList<OrderDetails> keranjang = new ArrayList<>();
   private Date tanggalOrder;
   private String typeOrder;
   

    public int getIdorder() {
        return idorder;
    }

    public void setIdorder(int idorder) {
        this.idorder = idorder;
    }

    public int getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(int Employeeid) {
        this.Employeeid = Employeeid;
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
 
   
    public int getIdPembelian() {
        return idPembelian;
    }

    public void setIdPembelian(int idPembelian) {
        this.idPembelian = idPembelian;
    }
    
    public int getIdSupervisor() {
        return idSupervisor;
    }
    
    public void setIdSupervisor(int idSupervisor) {
        this.idSupervisor = idSupervisor;
    }
    
    public String getStatus() {
        return Status;
    }
    
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public ArrayList<OrderDetails> getkeranjang() {
        return keranjang;
    }
    
  public void setKeranjang(ArrayList<OrderDetails> keranjang) {
        this.keranjang = keranjang;
    }

    public void setOrderId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}