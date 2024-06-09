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

    public ProdusenRepository(ProdusenDataSource produsenDataSource) {
        this.produsenDataSource = produsenDataSource;
    }
    
    
    public ArrayList<ProdusenModel> getAllProdusen (){
     return produsenDataSource.getAllProdusen();
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
         try {
            return produsenDataSource.updateDataProdusen(
                    pm.getIdProdusen(),
                    pm.getEmail(),
                    pm.getNama(),
                    pm.getContact(),
                    pm.getAddres()
            );
        } catch (Exception e) {
            System.out.println("Produsen Repo " + e.getLocalizedMessage());
            return -1;
        }
    }
    
    public int setStatusProdusen(int idProdusen, String status){
         try {
            return produsenDataSource.updateStatusProdusen(idProdusen, status);
        } catch (Exception e) {
            System.out.println("Produsen Repo " + e.getLocalizedMessage());
            return -1;
        }
    }
    
}
