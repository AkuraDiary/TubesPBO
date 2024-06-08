/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.repository.CustomerRepository;
import com.bibd.tubespbo.data.repository.EmployeeRepository;
import com.bibd.tubespbo.data.repository.LoginRepository;
import com.bibd.tubespbo.data.repository.PembelianRepository;
import com.bibd.tubespbo.data.source.CustomerDataSource;
import com.bibd.tubespbo.data.source.EmployeesDataSource;
import com.bibd.tubespbo.data.source.LoginDataSource;
import com.bibd.tubespbo.data.source.PembelianDataSource;
import com.bibd.tubespbo.data.source.WarehouseDataSource;
import com.bibd.tubespbo.domain.auth.AuthPresenter;
import com.bibd.tubespbo.domain.manager.ApprovePembelianPresenter;
import com.bibd.tubespbo.domain.manager.ManageEmployeePresenter;
import com.bibd.tubespbo.domain.supervisor.ManageCustomerPresenter;

/**
 *
 * @author asthiseta
 */
public class Di {
    
    // DB
    public static DbConnection dbConnection;
    
    // Data Sources
    
    public static LoginDataSource loginDataSource;
    public static WarehouseDataSource warehouseDataSource;
    public static PembelianDataSource pembelianDataSource;
    public static EmployeesDataSource employeesDataSource;
    public static CustomerDataSource customerDataSource;
    
    //Repository
    public static LoginRepository loginRepository;
    public static PembelianRepository pembelianRepository;
    public static EmployeeRepository employeeRepository;
    public static CustomerRepository customerRepository;
    
    //Domain Presenters
    public static AuthPresenter authPresenter;
    
    //manager
    public static ApprovePembelianPresenter approvePembelianPresenter;
    public static ManageEmployeePresenter manageEmployeePresenter;
    
    //supervisor
    public static ManageCustomerPresenter manageCustomerPresenter;
    
    //sales
    
    public static void init(){
        System.out.println("Initializing DI");
   
        
        // DB
        dbConnection = new DbConnection();
        
        // Data source
        loginDataSource = new LoginDataSource(Di.dbConnection);
        warehouseDataSource = new WarehouseDataSource(Di.dbConnection);
        pembelianDataSource = new PembelianDataSource(Di.dbConnection);
        employeesDataSource = new EmployeesDataSource(Di.dbConnection);
        
        // Repository
        loginRepository = new LoginRepository(Di.loginDataSource, Di.warehouseDataSource);
        pembelianRepository = new PembelianRepository(Di.pembelianDataSource);
        employeeRepository = new EmployeeRepository(Di.employeesDataSource);
        
        // Domain presenter
        authPresenter = new AuthPresenter(Di.loginRepository);
        approvePembelianPresenter = new ApprovePembelianPresenter(Di.pembelianRepository);
        manageEmployeePresenter = new ManageEmployeePresenter(Di.employeeRepository);
        
        manageCustomerPresenter = new ManageCustomerPresenter(customerRepository);
        
        System.out.println("DI Initialized");
        
    }
}
