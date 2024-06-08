/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.manager;

import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.repository.PembelianRepository;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author asthiseta
 */
public class ApprovePembelianPresenter {

    PembelianRepository pembelianRepository;

    public ApprovePembelianPresenter(PembelianRepository pembelianRepository) {
        this.pembelianRepository = pembelianRepository;
    }

    public ArrayList<PembelianModel> listPembelian = new ArrayList();
    public PembelianModel selectedPembelian;

    public void resetSelected() {
        selectedPembelian = null;
    }

    public void getListPembelian() {
        listPembelian = pembelianRepository.getAllpembelian();
    }

    int statusUpdatePembelian = 0; // 0 default state; -1 error ; -2 not selected 

    public void updateStatusPembelian(String status) {
        if (selectedPembelian == null) {
            statusUpdatePembelian = -2;
            return;
        }

        statusUpdatePembelian = pembelianRepository.updateStatusPembelian(
                selectedPembelian.getIdPembelian(), 
                status
        );
    }

    public void selectDataPembelian(int idPembelian) {
        selectedPembelian = listPembelian.stream()
                .filter(item -> item.getIdPembelian() == idPembelian)
                .findFirst()
                .orElse(null);
    }

}
