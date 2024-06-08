/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.repository.LoginRepository;
import com.bibd.tubespbo.data.source.LoginDataSource;
import com.bibd.tubespbo.data.source.WarehouseDataSource;
import com.bibd.tubespbo.domain.auth.AuthPresenter;

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
    
    //Repository
    public static LoginRepository loginRepository;
    
    //Domain Presenters
    public static AuthPresenter authPresenter;
    
    public static void init(){
        System.out.println("Initializing DI");
   
        
        // DB
        dbConnection = new DbConnection();
        
        // Data source
        loginDataSource = new LoginDataSource(Di.dbConnection);
        warehouseDataSource = new WarehouseDataSource(Di.dbConnection);
        
        // Repository
        loginRepository = new LoginRepository(Di.loginDataSource, Di.warehouseDataSource);
        
        // Domain presenter
        authPresenter = new AuthPresenter(Di.loginRepository);
        
        System.out.println("DI Initialized");
        
    }
}
