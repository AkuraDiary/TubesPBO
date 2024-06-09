/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PembelianModel {
   private int idPembelian;
   private int idSupervisor;
   private String Status;
   private ArrayList<OrderDetails> keranjang = new ArrayList<>();
   

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
    
    
    
    
}