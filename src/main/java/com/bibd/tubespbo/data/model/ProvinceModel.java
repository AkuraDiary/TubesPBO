/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

/**
 *
 * @author asthiseta
 */
public class ProvinceModel {
    int id;
    String province;

    public void setId(int id) {
        this.id = id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public ProvinceModel(int id, String province) {
        this.id = id;
        this.province = province;
    }

    public ProvinceModel() {
    }
    
    

    public int getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }
    
    
}
