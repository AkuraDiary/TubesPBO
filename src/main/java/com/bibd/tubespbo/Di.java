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
import com.bibd.tubespbo.data.repository.PenjualanRepository;
import com.bibd.tubespbo.data.repository.ProductRepository;
import com.bibd.tubespbo.data.repository.ProdusenRepository;
import com.bibd.tubespbo.data.source.CustomerDataSource;
import com.bibd.tubespbo.data.source.EmployeesDataSource;
import com.bibd.tubespbo.data.source.LoginDataSource;
import com.bibd.tubespbo.data.source.PembelianDataSource;
import com.bibd.tubespbo.data.source.PenjualanDataSource;
import com.bibd.tubespbo.data.source.ProductDataSource;
import com.bibd.tubespbo.data.source.ProdusenDataSource;
import com.bibd.tubespbo.data.source.WarehouseDataSource;
import com.bibd.tubespbo.domain.auth.AuthPresenter;
import com.bibd.tubespbo.domain.manager.ApprovePembelianPresenter;
import com.bibd.tubespbo.domain.manager.ManageEmployeePresenter;
import com.bibd.tubespbo.domain.manager.ManageProductPresenter;
import com.bibd.tubespbo.domain.sales.PenjualanPresenter;
import com.bibd.tubespbo.domain.supervisor.ManageCustomerPresenter;
import com.bibd.tubespbo.domain.supervisor.ManageStockPresenter;
import com.bibd.tubespbo.domain.supervisor.PantauPenjualanPresenter;
import com.bibd.tubespbo.domain.supervisor.PembelianPresenter;

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
    public static PenjualanDataSource penjualanDataSource;
    public static ProductDataSource productDataSource;
    public static ProdusenDataSource produsenDataSource;
    
    
    //Repository
    public static CustomerRepository customerRepository;
    public static EmployeeRepository employeeRepository;
    public static LoginRepository loginRepository;
    public static PembelianRepository pembelianRepository;
    public static PenjualanRepository penjualanRepository;
    public static ProductRepository productRepository;
    public static ProdusenRepository produsenRepository;
    
    //Domain Presenters
    public static AuthPresenter authPresenter;
    
    //manager
    public static ApprovePembelianPresenter approvePembelianPresenter;
    public static ManageEmployeePresenter manageEmployeePresenter;
    public static ManageProductPresenter manageProductPresenter;
    
    //supervisor
    public static ManageCustomerPresenter manageCustomerPresenter;
    public static ManageStockPresenter manageStockPresenter;
    public static PantauPenjualanPresenter pantauPenjualanPresenter;
    public static PembelianPresenter pembelianPresenter;
    
    //sales
    public static PenjualanPresenter penjualanPresenter;
    
    public static void init(){
        System.out.println("Initializing DI");
   
        
        // DB
        dbConnection = new DbConnection();
        
        // Data source
        loginDataSource = new LoginDataSource(Di.dbConnection);
        warehouseDataSource = new WarehouseDataSource(Di.dbConnection);
        pembelianDataSource = new PembelianDataSource(Di.dbConnection);
        employeesDataSource = new EmployeesDataSource(Di.dbConnection);
        customerDataSource = new CustomerDataSource(Di.dbConnection);
        penjualanDataSource = new PenjualanDataSource(Di.dbConnection);
        productDataSource = new ProductDataSource(Di.dbConnection);
        produsenDataSource = new ProdusenDataSource(Di.dbConnection);
        
        // Repository
        loginRepository = new LoginRepository(Di.loginDataSource, Di.warehouseDataSource);
        customerRepository = new CustomerRepository(Di.customerDataSource);
        pembelianRepository = new PembelianRepository(Di.pembelianDataSource);
        employeeRepository = new EmployeeRepository(Di.employeesDataSource, Di.warehouseDataSource);
        productRepository = new ProductRepository(Di.productDataSource, Di.produsenDataSource);
        penjualanRepository = new PenjualanRepository(Di.penjualanDataSource);
        produsenRepository = new ProdusenRepository(Di.produsenDataSource);
        
        // Domain presenter
        authPresenter = new AuthPresenter(Di.loginRepository);
        
        approvePembelianPresenter = new ApprovePembelianPresenter(Di.pembelianRepository);
        manageEmployeePresenter = new ManageEmployeePresenter(Di.employeeRepository);
        manageProductPresenter = new ManageProductPresenter(Di.productRepository, Di.produsenRepository);
        
        manageCustomerPresenter = new ManageCustomerPresenter(customerRepository);
        manageStockPresenter = new ManageStockPresenter(Di.productRepository);
        pantauPenjualanPresenter = new PantauPenjualanPresenter(Di.penjualanRepository);
        pembelianPresenter = new PembelianPresenter(Di.pembelianRepository, Di.productRepository);
        
        penjualanPresenter = new PenjualanPresenter(Di.penjualanRepository, Di.productRepository);
        
        System.out.println("DI Initialized");
        
    }
}
