/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.ProdusenModel;
import com.bibd.tubespbo.data.source.ProdusenDataSource;
import java.util.ArrayList;

/**
 *
 * @author rafid
 */
public class ProdusenRepository {
    ProdusenDataSource produsenDataSource;
    
    public ArrayList<ProdusenModel> getAllProdusen (){
     return produsenDataSource.getAllProdusen();
//    return new ArrayList<>();
    }

    public int addProdusen(ProdusenModel pm) {
    
        try {
            return produsenDataSource.insertProdusen(
                    pm.getNama(),
                    pm.getEmail(),
                    pm.getContact(),
                    pm.getAddres(),
                    pm.getStatus()
            );
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }
    
    public int updateDataProdusen(ProdusenModel pm){
        // TODO
        return -1;
    }
    
    public int setStatusProdusen(int idProdusen, String status){
        return -1;
    }
    
}
