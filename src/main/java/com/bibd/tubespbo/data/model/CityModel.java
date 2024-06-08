/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

/**
 *
 * @author asthiseta
 */
public class CityModel {
    int id, idProvince;
    String city;
    ProvinceModel provinceModel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ProvinceModel getProvinceModel() {
        return provinceModel;
    }

    public void setProvinceModel(ProvinceModel provinceModel) {
        this.provinceModel = provinceModel;
    }
    
    
}
