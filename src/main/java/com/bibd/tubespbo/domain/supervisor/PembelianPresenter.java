/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.repository.PembelianRepository;
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

    public ArrayList<KeranjangModel> keranjang = new ArrayList<>();

    public ArrayList<PembelianModel> history = new ArrayList<>();
    
    public ArrayList<ProductModel> allproduct = new ArrayList<>();

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

        // find product in allproduct
        // minus stock product by quantity
        for (ProductModel productModel : allproduct) {
            if (productModel.getIdProduct() == produk.getIdProduct()) {
                int stock = productModel.getQuantityInStock();
                productModel.setQuantityInStock(stock - quantity);
            }
        }
        keranjang.add(newItem);
    }

    public void keluarItemKeranjang(int idproduk, int qty) {
        //mencari barang yang ingin di keluarkan
        for (int i = 0; i < keranjang.size(); i++) {
            if (keranjang.get(i).getProduk().getIdProduct() == idproduk) {
                if (keranjang.get(i).getQuantity() == qty) {
                    keranjang.remove(i);
                } else {
                    int jumlahSekarang = keranjang.get(i).getQuantity();
                    int jumlahupdate = jumlahSekarang -= qty;
                    keranjang.get(i).setQuantity(jumlahupdate);
                }
            }
        }
    }

//    public void editQuantity(int idproduk, int quantity) {
//        for (int i = 0; i < keranjang.size(); i++) {
//            if (keranjang.get(i).getProduk().getIdProduct() == idproduk) {
//                int jumlahSekarang = keranjang.get(i).getQuantity();
//                int jumlahupdate = jumlahSekarang += quantity;
//                if (jumlahupdate == 0) {
//                    keranjang.remove(i);
//                } else {
//                    keranjang.get(i).setQuantity(jumlahupdate);
//                }
//
//            }
//        }
//    }
    public void showAllproduct() {
        System.out.println("showAllProduct Presenter");
        this.allproduct = pembelianRepository.getAllProduct();
    }

    public int statusSubmitPembelian = 0; // 0 default ; -1 error; else success

    public void submitPembelian(int employeeId) {
        LocalDateTime waktu = LocalDateTime.now();
        String statusOrder = Statics.PEMBELIAN_STATUS_PENDING;
        String orderType = Statics.ORDER_TYPE_PEMBELIAN;

        statusSubmitPembelian = pembelianRepository.submitPembelian(
                employeeId, orderType, waktu, statusOrder, keranjang
        );

    }

    public KeranjangModel keranjangModel;
    public ProductModel produkModel;

    public void setSelectedAllProduct(int idProduk) {
        produkModel = allproduct.stream()
                .filter(item -> item.getIdProduct() == idProduk)
                .findFirst()
                .orElse(null);
    }

    public void setSelectedKeranjang(int idProduk) {
        keranjangModel = keranjang.stream()
                .filter(item -> item.getProduk().getIdProduct() == idProduk)
                .findFirst()
                .orElse(null);
    }

    public void resetClearKeranjang() {
        keranjang.clear();
        produkModel = null;
        keranjangModel = null;
    }

    public int statusUpdatePembelian = 0;

    public void updateStatusPembelian(int idPenjualan, String statusPembelian) {
        statusUpdatePembelian = pembelianRepository.updateStatusPembelian(idPenjualan, statusPembelian);
    }

    public PembelianModel selectedPembelian;

    public void setSelectedPembelian(int idPembelian) {
        PembelianModel pembelianModel = history.stream()
                .filter(item -> item.getIdPembelian() == idPembelian)
                .findFirst()
                .orElse(null);
        if (pembelianModel != null) {
            this.selectedPembelian = pembelianModel;
        }
    }

    public void resetStatusPembelian() {
        statusUpdatePembelian = 0;
        keranjang.clear();
    }

//    public void getAllProductWarehouse(int idWarehouse) {
////        pembelianRepository.getAllpembelian(idWarehouse);
//        this.allproduct = productRepository.getAllProduct();
//    }

}
