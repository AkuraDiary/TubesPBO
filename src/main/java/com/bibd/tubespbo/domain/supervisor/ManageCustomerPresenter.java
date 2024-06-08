/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.CustomerModel;
import com.bibd.tubespbo.data.repository.CustomerRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class ManageCustomerPresenter {

    CustomerRepository customerRepository;

    ArrayList<CustomerModel> customerList = new ArrayList<>();

    public ManageCustomerPresenter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getAllCustomer() {
        this.customerList = customerRepository.getAllgetAllCustomers();
    }

    CustomerModel selectedDataCustomer;

    int statusUpdateCustomer = 0; // 0 default state; -1 error ; -2 not selected 

    public void updateDataCustomer() {
        if (selectedDataCustomer == null) {
            statusUpdateCustomer = -2;
            return;
        }
        statusUpdateCustomer = customerRepository.updateDataEmployee(selectedDataCustomer);
    }

    public void resetSelectedDataCustomer() {
        statusUpdateCustomer = 0;
        selectedDataCustomer = null;
    }
    
    int statusAddNewCust = 0;
    public void resetAddNewCustomer(){
        statusAddNewCust = 0;
    }
    
    public void addNewCustomer(CustomerModel customer){
        statusAddNewCust = customerRepository.addNewCustomer(customer);
    }

}
