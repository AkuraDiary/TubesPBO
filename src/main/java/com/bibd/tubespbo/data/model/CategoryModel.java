/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

/**
 *
 * @author rafid
 */
public class CategoryModel {
    private int idCategory ;
    private String namaCategory, descCategory ;

    public CategoryModel(String namaCategory, String descCategory) {
        this.namaCategory = namaCategory;
        this.descCategory = descCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNamaCategory() {
        return namaCategory;
    }

    public void setNamaCategory(String namaCategory) {
        this.namaCategory = namaCategory;
    }

    public String getDescCategory() {
        return descCategory;
    }

    public void setDescCategory(String descCategory) {
        this.descCategory = descCategory;
    }
    
    
}
