/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.sales;

import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.repository.PenjualanRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */

//Rapid D.
public class PenjualanPresenter {
    PenjualanRepository penjualanRepository ;

    ArrayList<KeranjangModel> keranjang = new ArrayList<>();
    ArrayList<PenjualanModel> history = new ArrayList<>();

    public PenjualanPresenter(PenjualanRepository penjualanRepository) {
        this.penjualanRepository = penjualanRepository;
    }
    
    public void historyPenjualan() {
        history = penjualanRepository.getHistoryPenjualan() ;
        
    }

    public void masukKeranjang(ProductModel produk, int quantity) {
        
        //cek duplikasi
        for (int  i = 0; i < keranjang.size();i++){
            int currentItem =  keranjang.get(i).getProduk().getIdProduct();
            if(currentItem == produk.getIdProduct()){
                int sebelum = keranjang.get(i).getQuantity();
                keranjang.get(i).setQuantity(quantity+sebelum);
                return; //agar langsung keluar dari function
            }
        }
        
        KeranjangModel newItem = new KeranjangModel();
        newItem.setProduk(produk);
        newItem.setQuantity(quantity);
        keranjang.add(newItem);
    }
    
    public void keluarItemKeranjang(int idproduk, int quantity){
        //mencari barang yang ingin di keluarkan
        for (int i = 0 ;i < keranjang.size();i++){
            if(keranjang.get(i).getProduk().getIdProduct() == idproduk){
                keranjang.remove(i);
            }
        }
    }
    
    public void editQuantity (){
    
    }

    public void showProduk() {
        
    }

    public void checkOut() {

    }

}
