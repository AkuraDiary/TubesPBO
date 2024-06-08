/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.CityModel;
import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.ProvinceModel;
import com.bibd.tubespbo.data.model.WarehouseModel;
import com.bibd.tubespbo.data.source.LoginDataSource;
import com.bibd.tubespbo.data.source.WarehouseDataSource;

/**
 *
 * @author asthiseta
 */
public class LoginRepository {
    
    LoginDataSource loginDataSource;
    WarehouseDataSource warehouseDataSource;

    public LoginRepository(LoginDataSource loginDataSource, WarehouseDataSource warehouseDataSource) {
        this.loginDataSource = loginDataSource;
        this.warehouseDataSource = warehouseDataSource;
    }
    
    EmployeeModel loggedInUser = null;
    String msg = "";
    WarehouseModel employeeWarehouse;

    public WarehouseModel getEmployeeWarehouse() {
        return employeeWarehouse;
    }
    
   
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
            System.out.println("LoginRepo " + msg);
        }
    }
    
    public void getEmployeeDetailWarehouse(int idWarehouse){
       try{
           employeeWarehouse = warehouseDataSource.getWarehouseById(idWarehouse);
           CityModel city = warehouseDataSource.getCityById(employeeWarehouse.getCityId());
           ProvinceModel prov = warehouseDataSource.getProvinceById(city.getIdProvince());
           city.setProvinceModel(prov);
           employeeWarehouse.setCity(city);
           
       }catch(Exception e){
           msg = e.getLocalizedMessage();
           System.out.println("LoginRepo " + msg);
       }
    }
        
    
}
