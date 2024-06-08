/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.CityModel;
import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.WarehouseModel;
import com.bibd.tubespbo.data.source.LoginDataSource;

/**
 *
 * @author asthiseta
 */
public class LoginRepository {
    
    LoginDataSource loginDataSource;

    public LoginRepository(LoginDataSource loginDataSource) {
        this.loginDataSource = loginDataSource;
    }
    
    EmployeeModel loggedInUser = null;
    String msg = "";
    WarehouseModel employeeWarehouse;
    CityModel employeeCity;
    

    public EmployeeModel getLoggedInUser() {
        return loggedInUser;
    }

    public String getMsg() {
        return msg;
    }
    
    public void doLogout(){
   
        loggedInUser = null;
        msg = "";
    }
    
    public void doLogin(String email, String password){
        try{
           loggedInUser = loginDataSource.doLogin(email, password);
        }catch(Exception e){
            msg = e.getLocalizedMessage();
        }
    }
        
    
}
