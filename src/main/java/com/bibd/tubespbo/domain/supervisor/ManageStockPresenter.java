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

    public int stateAddstock=0;
    ProductRepository productRepository;

    public ArrayList<ProductModel> listProduct = new ArrayList<>();
    public ArrayList<ProductStockModel> listProductStock = new ArrayList<>();

    public ManageStockPresenter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void showAllProduct() {
        this.listProduct = productRepository.getAllProduct();

        if(!this.listProductStock.isEmpty()){
            // filter the already shown product
            this.listProduct = (ArrayList<ProductModel>) this.listProduct.stream()
                    .filter(emp -> this.listProductStock.stream().noneMatch(stock -> stock.getProductId() == emp.getIdProduct()))
                    .collect(java.util.stream.Collectors.toList());
        }
    }
    
    public void showStockProduct( int idWarehouse, String filterSearch){
        this.listProductStock = productRepository.getStockProduct(idWarehouse);
        if(!filterSearch.isBlank()){
            this.listProductStock = (ArrayList<ProductStockModel>) this.listProductStock.stream()
                    .filter(emp -> emp.getProductName().toLowerCase().contains(filterSearch) ||
                            String.valueOf(emp.getTotalStock()).contains(filterSearch) ||
                            emp.getLastUpdate().toString().contains(filterSearch)
                    )
                    .collect(java.util.stream.Collectors.toList());
        }
    }

    int result = 0;

    public void updateStockProduct(int idStock, int jumlahBaru, int idEmployee) {
        int jumlahPerubahan = 0;
        for (ProductStockModel productStockModel : listProductStock) {
            if (productStockModel.getId() == idStock) {
                jumlahPerubahan = jumlahBaru - productStockModel.getTotalStock();
            }
        }
        result = productRepository.updateProductStock(idStock, jumlahBaru, idEmployee,jumlahPerubahan);
    }

    public void resetResult() {
        selectedDataStock = null;
        result = 0;
    }

    public ProductStockModel selectedDataStock;
    public void selectDataStock(int idStockProduct) {
        for (int i = 0; i < listProductStock.size(); i++) {
            if (listProductStock.get(i).getId() == idStockProduct) {
                selectedDataStock = listProductStock.get(i);
            }
        }
    }

    public void createNewStockProduct(int idProduct, int quantity, int idEmployee, int idWarehouse) {
        stateAddstock = productRepository.addNewStockProduct(idProduct, quantity, idEmployee, idWarehouse);
    }
}
