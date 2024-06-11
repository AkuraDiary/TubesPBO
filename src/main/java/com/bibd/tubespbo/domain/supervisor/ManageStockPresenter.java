/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.supervisor;

import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.model.ProductStockModel;
import com.bibd.tubespbo.data.repository.ProductRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
//Rapid D.
public class ManageStockPresenter {

    ProductRepository productRepository;

    public ArrayList<ProductModel> listProduct = new ArrayList<>();
    public ArrayList<ProductStockModel> listProductStock = new ArrayList<>();

    public ManageStockPresenter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void showAllProduct() {
        this.listProduct = productRepository.getAllProduct();
    }
    
    public void showStockProduct( int idWarehouse){
        this.listProductStock = productRepository.getStockProduct(idWarehouse);
    }

    int result = 0;

    public void updateStockProduct(int idStock, int idProduct, int jumlahPerubahan, int idEmployee, int idWarehouse) {
        int jumlahBaru = 0;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getIdProduct() == idProduct) {
                jumlahBaru = listProduct.get(i).getQuantityInStock() + jumlahPerubahan;
            }

        }
        result = productRepository.updateProductStock(idStock, idProduct, jumlahBaru, idEmployee, idWarehouse, jumlahPerubahan);
    }

    public void resetResult() {
        result = 0;
    }

}
