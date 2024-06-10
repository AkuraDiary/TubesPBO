/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.domain.manager;

import com.bibd.tubespbo.data.model.CategoryModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.model.ProdusenModel;
import com.bibd.tubespbo.data.repository.ProductRepository;
import com.bibd.tubespbo.data.repository.ProdusenRepository;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
//Rapid D.
//fitur tambahan :
//getallprodusen
//getallcategory
//addnewcategory
//addnewprodusen
//addnewproduct/
//showall - editstockproduct
public class ManageProductPresenter {

    ProductRepository productRepository;
    ProdusenRepository produsenRepository;

    ArrayList<ProductModel> listProduct = new ArrayList<>();
    ArrayList<ProdusenModel> listProdusen = new ArrayList<>();
    ArrayList<CategoryModel> listCategory = new ArrayList<>();

    public ManageProductPresenter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void showAllProduct() {
        listProduct = productRepository.getAllProduct();
    }

    int result = 0;

//    public void updateStockProduct(int idProduct, int jumlah, int idEmployee) {
//          int jumlahedit =0;
//        //mencari product 
//        for (int i = 0; i < listProduct.size(); i++) {
//            if (listProduct.get(i).getIdProduct() == idProduct) {
//             jumlahedit = listProduct.get(i).getQuantityInStock()+jumlah;
//            }
//
//        }
//
//        result = productRepository.updateProductStock(idProduct, jumlahedit, idEmployee);
//    }

    public void resetResult() {
        result = 0;
    }

    public void showAllProdusen() {
        listProdusen = produsenRepository.getAllProdusen();
    }

    public void showAllCategory() {
        //bingung objek arraylistnya apa
        listCategory = productRepository.getAllCategory();
    }

    public void addCategory(CategoryModel cm) {
        productRepository.addCategory(cm);

    }

    public void addNewProdusen(ProdusenModel pm) {
        produsenRepository.addProdusen(pm);

    }

    public void addNewProduct(ProductModel pm) {
        productRepository.addProduct(pm);
    }
}
