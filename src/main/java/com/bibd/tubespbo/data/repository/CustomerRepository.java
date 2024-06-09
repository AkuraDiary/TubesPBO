/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.CustomerModel;
import com.bibd.tubespbo.data.source.CustomerDataSource;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class CustomerRepository {

    CustomerDataSource customerDataSource;

    public CustomerRepository(CustomerDataSource customerDataSource) {
        this.customerDataSource = customerDataSource;
    }
    

    public ArrayList<CustomerModel> getAllgetAllCustomers() {
        return customerDataSource.getAllCustomer();
    }

    public int updateDataCustomer(CustomerModel cm) {
        try {
            return customerDataSource.updateDataCustomer(
                    cm.getIdCustomer(),
                    cm.getNama(),
                    cm.getNoHp(),
                    cm.getEmail(),
                    cm.getAlamat()
            );
        } catch (Exception e) {
            System.out.println("Customer Repo : " + e.getLocalizedMessage());
            return -1;
        }
    }

    public int addNewCustomer(CustomerModel cm) {
        try {
            return customerDataSource.insertNewCustomer(
                    cm.getNama(),
                    cm.getNoHp(),
                    cm.getEmail(),
                    cm.getAlamat()
            );
        } catch (Exception e) {
            System.out.println("Customer Repo : " + e.getLocalizedMessage());
            return -1;
        }
    }

}
