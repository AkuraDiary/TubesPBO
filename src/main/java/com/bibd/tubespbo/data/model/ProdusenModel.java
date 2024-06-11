/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.model;

/**
 *
 * @author rafid
 */
public class ProdusenModel {
    int idProdusen;
    String nama,email,contact, addres, status ;

    public ProdusenModel(String nama, String email, String contact, String addres, String status) {
        this.nama = nama;
        this.email = email;
        this.contact = contact;
        this.addres = addres;
        this.status = status;
    }

    @Override
    public String toString() {
        return nama;
    }
    
    

    public ProdusenModel() {
    }

    
    public int getIdProdusen() {
        return idProdusen;
    }

    public void setIdProdusen(int idProdusen) {
        this.idProdusen = idProdusen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
    
    
}
