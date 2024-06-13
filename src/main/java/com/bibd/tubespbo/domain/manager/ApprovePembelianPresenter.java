/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.manager;

import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.OrderDetailsModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.repository.PembelianRepository;
import com.bibd.tubespbo.util.Statics;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static javax.swing.JOptionPane.showMessageDialog;

/**
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
        statusUpdatePembelian = 0;
        detailPembelian.clear();
    }

    public void getListPembelian(String filterSearch) {
        listPembelian = pembelianRepository.getAllpembelian(Statics.GET_ALL_PEMBELIAN);

        if (!filterSearch.isBlank()) {
            this.listPembelian = (ArrayList<PembelianModel>) this.listPembelian.stream()
                    .filter(emp -> String.valueOf(emp.getIdPembelian()).contains(filterSearch)||
                                  emp.getStatus().toLowerCase().contains(filterSearch)||
                                  emp.getTanggalOrder().toString().toLowerCase().contains(filterSearch)
                    )
                    .collect(Collectors.toList());

        }
    }

    public int statusUpdatePembelian = 0; // 0 default state; -1 error ; -2 not selected

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

    public ArrayList<OrderDetailsModel> detailPembelian = new ArrayList<>();
    public void selectDataPembelian(int idPembelian) {
        selectedPembelian = listPembelian.stream()
                .filter(item -> item.getIdPembelian() == idPembelian)
                .findFirst()
                .orElse(null);
        if (selectedPembelian != null) {
//            this.selectedPembelian = pembelianModel;
            this.detailPembelian = pembelianRepository.getDetailPembelian(idPembelian);
        }
    }

}
