/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bibd.tubespbo;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.util.Formatter;
import com.bibd.tubespbo.util.Parser;
import com.bibd.tubespbo.view.login.LoginView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author asthiseta
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Di.init();
        new LoginView().setVisible(true);

    }

}
