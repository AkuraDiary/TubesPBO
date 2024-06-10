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
 *
 * @author asthiseta
 */
public class Main {

    public static void main(String[] args) {
        
//        ArrayList<KeranjangModel> pm = new ArrayList<KeranjangModel>();
//        
//        ProductModel product1 = new ProductModel();
//        ProductModel product2 = new ProductModel();
//        ProductModel product3 = new ProductModel();
//        
//        product1.setIdProduct(1);
//        product2.setIdProduct(2);
//        product3.setIdProduct(3);
//       
//        KeranjangModel km1 = new KeranjangModel();
//        KeranjangModel km2 = new KeranjangModel();
//        KeranjangModel km3 = new KeranjangModel();
//        
//        km1.setProduk(product1);
//        km2.setProduk(product2);
//        km3.setProduk(product3);
//        
//        km1.setQuantity(1);
//        km2.setQuantity(1);
//        km3.setQuantity(1);
//        
//        
//        pm.add(km1);
//        pm.add(km2);
//        pm.add(km3);
//        
//        System.out.println("Before");
//        for(KeranjangModel item : pm){
//            
//            System.out.println("idProduct " + item.getProduk().getIdProduct());
//            System.out.println("Qty " + item.getQuantity());
//            System.out.println("");
//        }
//        
//        // edit one of the item
//        pm.get(1).setQuantity(3);
//        
//        System.out.println("After");
//        for(KeranjangModel item : pm){
//            
//            System.out.println("idProduct " + item.getProduk().getIdProduct());
//            System.out.println("Qty " + item.getQuantity());
//            System.out.println("");
//        }
//        System.out.println(LocalDateTime.now());
        
        System.out.println("Hello World!");
        Date dt = new Date();
        System.out.println(dt);
        System.out.println(Parser.parseDateToStringSQL(dt));
        System.out.println(Formatter.formatDate(dt));
//        Di.init();
//    
//        // testing
////        EmployeeModel data = Di.loginDataSource.doLogin("rawr@gmail.com", "rawrbibd");
////        
////        System.out.println(data.getNama());
//        
//         new LoginView().setVisible(true);
     
    }
    
}
