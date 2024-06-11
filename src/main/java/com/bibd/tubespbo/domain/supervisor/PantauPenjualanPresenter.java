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

    public void getAllPenjualanInWarehouse(int idWarehouse, String filterSearch) {
        listPenjualanWarehouse = penjualanRepository.getHistoryPenjualan(idWarehouse);
        
        
         if(!filterSearch.isBlank()){
            this.listPenjualanWarehouse = (ArrayList<PenjualanModel>) this.listPenjualanWarehouse.stream()
                    .filter(emp -> emp.getCustomerName().toLowerCase().contains(filterSearch) ||
                            String.valueOf(emp.getIdPenjualan()).contains(filterSearch) ||
                            emp.getEmployeeName().toLowerCase().contains(filterSearch)
                    )
                    .collect(java.util.stream.Collectors.toList());
        }
    }

    PenjualanModel selectedPenjualan;

    public void setSelectedPenjualan(int idPenjualan) {
        selectedPenjualan = listPenjualanWarehouse.stream()
                .filter(item -> item.getIdPenjualan() == idPenjualan)
                .findFirst()
                .orElse(null);
    }

    public void resetStatusUpdatePenjualan() {
        selectedPenjualan = null;
        updateStatusPenjualanState = 0;
    }

    int updateStatusPenjualanState = 0; // 0 default; -2 not selected; -1 error

    


    public void updateStatusShipmentPenjualan(int idPenjualan, String statusShipment, String statusPayment) {


        if (selectedPenjualan == null) {
            updateStatusPenjualanState = -2;
            return;
        }

        updateStatusPenjualanState = penjualanRepository.updateStatusShipmentPayment(idPenjualan, statusShipment, statusPayment);      

        updateStatusPenjualanState = penjualanRepository.updateStatusShipmentPayment(idPenjualan, statusShipment, statusPayment);

    }
}

