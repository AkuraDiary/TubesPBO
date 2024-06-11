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
import java.util.stream.Collectors;

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

    public ArrayList<ProductModel> listProduct = new ArrayList<>();
    public ArrayList<ProdusenModel> listProdusen = new ArrayList<>();
    public ArrayList<CategoryModel> listCategory = new ArrayList<>();

    public ManageProductPresenter(ProductRepository productRepository, ProdusenRepository produsenRepository) {
        this.productRepository = productRepository;
        this.produsenRepository = produsenRepository;
    }

    public void showAllProduct(String filterSearch) {
        listProduct = productRepository.getAllProduct();
        if(!filterSearch.isBlank()){
            this.listProduct = (ArrayList<ProductModel>) this.listProduct.stream()
                    .filter(emp -> emp.getProductName().toLowerCase().contains(filterSearch)
                    )
                    .collect(Collectors.toList());
        }
    }

    public int resultUpdateProduct = 0;

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
        resultUpdateProduct = 0;
        stateAddProduct=0;
    }

    public ProductModel selectedProduct;
    public void resetSelectedProduct(){
        selectedProduct= null;
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

    public void setSelectedProduct(int productId) {
        selectedProduct = listProduct.stream()
                .filter(item -> item.getIdProduct() == productId)
                .findFirst()
                .orElse(null);
    }
    public int stateAddProduct = 0;
    public void addNewProduct(ProductModel pm) {
     stateAddProduct =  productRepository.addProduct(pm);
    }

    public void updateDataProduct(){
        productRepository.editDataProduct(selectedProduct);
    }
}
