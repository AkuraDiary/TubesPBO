/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.manager;

import com.bibd.tubespbo.data.model.PembelianModel;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class ApprovePembelianPresenter {
    
    public ArrayList<PembelianModel> listPembelian = new ArrayList();
    
    public PembelianModel selectedPembelian;
    
    public void resetSelected(){
        selectedPembelian = null;
    }
    
    public void getListPembelian(){
        
    }
    
    public void updateStatusPembelian(){
        
    }
    
}
