/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo;

import com.bibd.tubespbo.data.DbConnection;

/**
 *
 * @author asthiseta
 */
public class Di {
    public static DbConnection dbConnection;
    
    public static void init(){
        System.out.println("Initializing DI");
        dbConnection = new DbConnection();
        
        System.out.println("DI Initialized");
        
    }
}
