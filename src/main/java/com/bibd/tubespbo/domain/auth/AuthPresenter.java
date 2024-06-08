/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.auth;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.WarehouseModel;
import com.bibd.tubespbo.data.repository.LoginRepository;

/**
 *
 * @author asthiseta
 */
public class AuthPresenter {
    LoginRepository loginRepository;

    public AuthPresenter(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    
    public EmployeeModel loggedInUser = loginRepository.getLoggedInUser();
    public String msg = loginRepository.getMsg();
    public WarehouseModel empWarehouse = loginRepository.getEmployeeWarehouse();
    
    public void doLogout(){
        // TODO
        loginRepository.doLogout();
    }
    
    public void doLogin(String email, String password){
        // TODO
        // if you need to do processing
        // like ecrypt the password
        // do it here
        
        loginRepository.doLogin(email, password);
        if(loggedInUser != null && loggedInUser.getIdWarehouse() != -1){
            loginRepository.getEmployeeDetailWarehouse(loggedInUser.getIdWarehouse());
        }
    }
}
