/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.ProdusenModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author rafid
 */
public class ProdusenDataSource {

    DbConnection db;

    public ProdusenDataSource(DbConnection db) {
        this.db = db;
    }

    public int insertProdusen(String nama, String email, String contact, String addres, String status) {
        try {
            db.openConnection();

            String query = "INSERT INTO produsen (email, name, contact, address, status) VALUES"
                    + "('" + email + "', '" + nama + "', '" + contact + "', '" + addres + "', '" + status + "' )";

            int result = db.executeStatement(query);
            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }
    }

    public ArrayList<ProdusenModel> getAllProdusen() {

        try {
            ArrayList<ProdusenModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT idProdusen, email, name, contact, address, status FROM produsen";

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                // Parsing the data
                int idProdusen = rs.getInt("idProdusen");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String contact = rs.getString("contact");
                String address = rs.getString("address");
                String status = rs.getString("status");

                // Creating a ProdusenModel object and using setters
                ProdusenModel produsen = new ProdusenModel();
                produsen.setIdProdusen(idProdusen);
                produsen.setEmail(email);
                produsen.setNama(name);
                produsen.setContact(contact);
                produsen.setAddres(address);
                produsen.setStatus(status);

                // Adding the produsen to the list
                dataResult.add(produsen);

            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int updateStatusProdusen(int idProdusen, String status) {
          try {

            db.openConnection();
            String query = "UPDATE customers SET status='" + status + "' WHERE idProdusen=" + idProdusen;

            return db.executeStatement(query);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {

            db.closeConnection();
        }
    }

    public int updateDataProdusen(int idProdusen, String email, String nama, String contact, String addres) {
        try {

            db.openConnection();
            String query = "UPDATE customers SET name='" + nama + "', contact='" + contact + "', "
                    + "email='" + email + "', address='" + addres + "' WHERE idProdusen=" + idProdusen;

            return db.executeStatement(query);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {

            db.closeConnection();
        }
    }

}
