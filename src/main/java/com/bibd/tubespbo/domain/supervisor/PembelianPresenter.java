/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.repository.PembelianRepository;
import com.bibd.tubespbo.data.repository.PenjualanRepository;
import com.bibd.tubespbo.data.repository.ProductRepository;
import com.bibd.tubespbo.util.Statics;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class PembelianPresenter {
    
    PembelianRepository pembelianRepository;
    ProductRepository productRepository;

    ArrayList<KeranjangModel> keranjang = new ArrayList<>();
    
    ArrayList<PembelianModel> history = new ArrayList<>();
    ArrayList<ProductModel> allproduct = new ArrayList<>();

    public PembelianPresenter(PembelianRepository pembelianRepository, ProductRepository productRepository) {
        this.pembelianRepository = pembelianRepository;
        this.productRepository = productRepository;
    }

    public void getHistoryPembelian(int idWarehouse) {
        history = pembelianRepository.getAllpembelian(idWarehouse);

    }

    public void masukKeranjang(ProductModel produk, int quantity) {

        //cek duplikasi
        for (int i = 0; i < keranjang.size(); i++) {
            int currentItem = keranjang.get(i).getProduk().getIdProduct();
            if (currentItem == produk.getIdProduct()) {
                int sebelum = keranjang.get(i).getQuantity();
                keranjang.get(i).setQuantity(quantity + sebelum);
                return; //agar langsung keluar dari function
            }
        }

        KeranjangModel newItem = new KeranjangModel();
        newItem.setProduk(produk);
        newItem.setQuantity(quantity);
        keranjang.add(newItem);
    }

    public void keluarItemKeranjang(int idproduk) {
        //mencari barang yang ingin di keluarkan
        for (int i = 0; i < keranjang.size(); i++) {
            if (keranjang.get(i).getProduk().getIdProduct() == idproduk) {
                keranjang.remove(i);
            }
        }
    }

    public void editQuantity(int idproduk, int quantity) {
        for (int i = 0; i < keranjang.size(); i++) {
            if (keranjang.get(i).getProduk().getIdProduct() == idproduk) {
                int jumlahSekarang = keranjang.get(i).getQuantity();
                int jumlahupdate = jumlahSekarang += quantity;
                if (jumlahupdate == 0) {
                    keranjang.remove(i);
                } else {
                    keranjang.get(i).setQuantity(jumlahupdate);
                }

            }
        }

    }

    public void showAllproduct() {
        this.allproduct = productRepository.getAllProduct();
    }
    
    public void resetPembelian(){
        statusSubmitPembelian = 0;
        keranjang.clear();
    }
    
    int statusSubmitPembelian = 0; // 0 default ; -1 error; else success
    public void submitPembelian(int employeeId) {
        LocalDateTime waktu = LocalDateTime.now();
        String statusOrder = Statics.PEMBELIAN_STATUS_PENDING;
        String orderType = Statics.ORDER_TYPE_PEMBELIAN;
        
        statusSubmitPembelian = pembelianRepository.submitPembelian(
                employeeId, orderType, waktu, statusOrder, keranjang
        );

    }
}
