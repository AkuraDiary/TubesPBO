/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CustomerModel;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class CustomerDataSource {
    DbConnection conn;

    public CustomerDataSource(DbConnection conn) {
        this.conn = conn;
    }

    // TODO
    public ArrayList<CustomerModel> getAllCustomer() {
        return new ArrayList<>();
    }

    public int updateDataCustomer(int idCustomer, String nama, String noHp, String email, String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int insertNewCustomer(String nama, String noHp, String email, String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
    