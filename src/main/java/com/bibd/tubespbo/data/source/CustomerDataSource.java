/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CustomerModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class CustomerDataSource {

    DbConnection db;

    public CustomerDataSource(DbConnection conn) {
        this.db = conn;
    }

    
    public ArrayList<CustomerModel> getAllCustomer() {

        try {
            ArrayList<CustomerModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT idCustomer, nama, noHp, email, alamat FROM cutomers";

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                 // Parsing the data
            int idCustomer = rs.getInt("idCustomer");
            String nama = rs.getString("nama");
            String noHp = rs.getString("noHp");
            String email = rs.getString("email");
            String alamat = rs.getString("alamat");

            // Creating a new CustomerModel object
            CustomerModel customer = new CustomerModel(idCustomer, nama, noHp, email, alamat);

            // Adding the customer to the dataResult list
            dataResult.add(customer);

            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int updateDataCustomer(int idCustomer, String nama, String noHp, String email, String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int insertNewCustomer(String nama, String noHp, String email, String alamat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
