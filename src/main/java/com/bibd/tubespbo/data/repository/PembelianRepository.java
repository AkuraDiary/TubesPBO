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
    
    PembelianDataSource pembelianDataSource;

    public PembelianRepository(PembelianDataSource pembelianremotedatasource) {
        this.pembelianDataSource = pembelianremotedatasource;
    }

    // TODO
    public ArrayList<PembelianModel> getAllpembelian() {
        return pembelianDataSource.getAllPembelian();
    }

    public int updateStatusPembelian(int idPembelian, String status) {
        try{
            return pembelianDataSource.updateStatusPembelian(idPembelian, status);
        }catch(Exception e){
            System.out.println("Pembelian Repo " + e.getLocalizedMessage());
            return -1;
        }
    }
    
}
