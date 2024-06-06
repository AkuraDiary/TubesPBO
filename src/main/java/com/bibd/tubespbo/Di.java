/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.source.LoginDataSource;

/**
 *
 * @author asthiseta
 */
public class Di {
    public static DbConnection dbConnection;
    
    // Data Sources
    public static LoginDataSource loginDataSource;
    
    //Repository
    
    
    //domain
    
    public static void init(){
        System.out.println("Initializing DI");
        
        dbConnection = new DbConnection();
        
        loginDataSource = new LoginDataSource(Di.dbConnection);
        
        System.out.println("DI Initialized");
        
    }
}
