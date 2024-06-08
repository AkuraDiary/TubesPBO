/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.repository;

import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.source.PembelianDataSource;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PembelianRepository {
    
    PembelianDataSource pembelianremotedatasource;

    public PembelianRepository(PembelianDataSource pembelianremotedatasource) {
        this.pembelianremotedatasource = pembelianremotedatasource;
    }

    // TODO
    public ArrayList<PembelianModel> getAllpembelian() {
        return new ArrayList();
    }

    public int updateStatusPembelian(int idPembelian, String status) {
        try{
            return pembelianremotedatasource.updateStatusPembelian(idPembelian, status);
        }catch(Exception e){
            System.out.println("Pembelian Repo " + e.getLocalizedMessage());
            return -1;
        }
    }
    
}
