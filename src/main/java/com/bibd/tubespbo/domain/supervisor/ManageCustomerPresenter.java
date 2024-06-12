/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.CustomerModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author asthiseta
 */
public class ManageCustomerPresenter {

    CustomerRepository customerRepository;

    public ArrayList<CustomerModel> customerList = new ArrayList<>();

    public ManageCustomerPresenter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getAllCustomer(String filterSearch) {
        this.customerList = customerRepository.getAllgetAllCustomers();
        if(!filterSearch.isBlank()){
            this.customerList = (ArrayList<CustomerModel>) this.customerList.stream()
                    .filter(emp -> emp.getNama().toLowerCase().contains(filterSearch) ||
                            emp.getAlamat().toLowerCase().contains(filterSearch) ||
                            emp.getNoHp().toLowerCase().contains(filterSearch) ||
                            emp.getEmail().toLowerCase().contains(filterSearch)
                    )
                    .collect(Collectors.toList());
        }
    }

    public CustomerModel selectedDataCustomer;

    public int statusUpdateCustomer = 0; // 0 default state; -1 error ; -2 not selected 

    public void updateDataCustomer() {
        if (selectedDataCustomer == null) {
            statusUpdateCustomer = -2;
            return;
        }
        statusUpdateCustomer = customerRepository.updateDataCustomer(selectedDataCustomer);
    }

    public void resetManageCustomer() {
        statusAddNewCust=0;
        statusUpdateCustomer = 0;
        selectedDataCustomer = null;
    }
    
    public int statusAddNewCust = 0; // 0 default state; -1 error ;
    
    public void addNewCustomer(CustomerModel customer){
        statusAddNewCust = customerRepository.addNewCustomer(customer);
    }
    
    public void setSelectedCustomer(int idCustomer){
        selectedDataCustomer = customerList.stream()
                .filter(item -> item.getIdCustomer()==idCustomer)
                .findFirst()
                .orElse(null);
    }

}
