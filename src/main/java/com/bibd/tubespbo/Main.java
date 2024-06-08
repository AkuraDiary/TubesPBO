/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bibd.tubespbo;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.view.login.LoginView;

/**
 *
 * @author asthiseta
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("yanto ganteng");
        Di.init();
    
        // testing
//        EmployeeModel data = Di.loginDataSource.doLogin("rawr@gmail.com", "rawrbibd");
//        
//        System.out.println(data.getNama());
        
         new LoginView().setVisible(true);
     
    }
    
}
