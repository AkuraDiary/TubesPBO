/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.sales;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.repository.PenjualanRepository;
import com.bibd.tubespbo.data.repository.ProductRepository;
import com.bibd.tubespbo.util.Parser;
import com.bibd.tubespbo.util.Statics;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
//Rapid D.
public class PenjualanPresenter {

    PenjualanRepository penjualanRepository;
    ProductRepository productRepository;

    public ArrayList<KeranjangModel> keranjang = new ArrayList<>();
    public ArrayList<PenjualanModel> history = new ArrayList<>();
    public ArrayList<ProductModel> allproduct = new ArrayList<>();

    public PenjualanPresenter(PenjualanRepository penjualanRepository, ProductRepository productRepository) {
        this.penjualanRepository = penjualanRepository;
        this.productRepository = productRepository;
    }

    public void historyPenjualan(int idWarehouse, int idEmployee) {
        history = penjualanRepository.getHistoryPenjualan(idWarehouse, idEmployee);

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
        // get product in keranjang
        // if quantity in keranjang == qty in all product
        // or quantity = qty in keranjang
        // remove product in keranjang
        // else minus quantity in keranjang

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
////        boolean cek = true;
////        int idx = 0 ;
//        for (int i = 0; i < keranjang.size(); i++) {
//            if (keranjang.get(i).getProduk().getIdProduct() == idproduk) {
//                int jumlahSekarang = keranjang.get(i).getQuantity();
//                int jumlahupdate = jumlahSekarang += quantity;
//                if (jumlahupdate == 0) {
//                    keranjang.remove(i);
////                cek = false ;
////                idx=i;
//                } else {
//                    keranjang.get(i).setQuantity(jumlahupdate);
//                }
//
//            }
//        }
////        if (cek = false){
////            keranjang.remove(idx);
////        }
//
//    }

    public void getAllProductWarehouse(int idWarehouse) {
        this.allproduct = productRepository.getAllProductWarehouse(idWarehouse);

        // filter empty product
        // remove product in allproduct if quantityInStock == 0
        for (int i = 0; i < allproduct.size(); i++) {
            if (allproduct.get(i).getQuantityInStock() == 0) {
                allproduct.remove(i);
            }
        }
    }

    public int statusCheckout = 0;

    public void checkOut(int customerId, int employeeId, ArrayList<KeranjangModel> keranjang, String statusPayment,
             String statusShip, int idWarehouse) {
        Date waktu = new Date();

        // make sure date format is correct
        // yyyy-MM-dd
//        waktu = java.sql.Timestamp.valueOf(LocalDateTime.now());

        String typeOrder = Statics.ORDER_TYPE_PENJUALAN;
        statusCheckout = penjualanRepository.doCheckOut(
                employeeId, customerId, statusPayment, Parser.parseDateToStringSQL(waktu), typeOrder,
                keranjang, statusShip, idWarehouse
        );
    }
    public void resetCheckout(){
        keranjang.clear();
        statusCheckout=0;
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

    public void resetClearKeranjang(){
        keranjang.clear();
        produkModel = null;
        keranjangModel = null;
    }

    public int statusUpdatePayment=0;
    public PenjualanModel selectedPenjualan;
    public void setSelectedPenjualan(int idPenjualan) {
        PenjualanModel penjualanModel = history.stream()
                .filter(item -> item.getIdPenjualan() == idPenjualan)
                .findFirst()
                .orElse(null);
        if (penjualanModel != null) {
            this.selectedPenjualan = penjualanModel;
        }
    }

    public void updatePayment(int idPenjualan, String statusPayment){
        // if status is paid, set status shipment to shipped
        String statusShipment = Statics.SHIPMENT_STATUS_PENDING;
        if (statusPayment.equals(Statics.ORDER_PAYMENT_STATUS_PAID)) {
                statusShipment = Statics.SHIPMENT_STATUS_SHIPPED;
        }
        statusUpdatePayment = penjualanRepository.updateStatusShipmentPayment(idPenjualan, statusShipment, statusPayment);

    }

    public void resetUpdatePayment(){
        statusUpdatePayment=0;
        selectedPenjualan=null;
    }
}
