/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.data.repository.PenjualanRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PantauPenjualanPresenter {
    
    PenjualanRepository penjualanRepository;

    public PantauPenjualanPresenter(PenjualanRepository penjualanRepository) {
        this.penjualanRepository = penjualanRepository;
    }
    
    
    
    public ArrayList<PenjualanModel> listPenjualanWarehouse = new ArrayList<>(); 
    
    public void getAllPenjualanInWarehouse(int idWarehouse){
        
        
    }
}
