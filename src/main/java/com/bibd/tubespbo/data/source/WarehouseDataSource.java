    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CityModel;
import com.bibd.tubespbo.data.model.ProdusenModel;
import com.bibd.tubespbo.data.model.ProvinceModel;
import com.bibd.tubespbo.data.model.WarehouseModel;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asthiseta
 */
public class WarehouseDataSource {

    DbConnection db;

    public WarehouseDataSource(DbConnection conn) {
        this.db = conn;
    }

    //TODO RAPID
    public ArrayList<WarehouseModel> getAllWarehouse() {
        try {
            ArrayList<WarehouseModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT id, address, postalCode, cityId FROM warehouse";

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                // Parsing the data

                int id = rs.getInt("id");
                String address = rs.getString("address");
                String postalCode = rs.getString("postalCode");
                int cityId = rs.getInt("cityId");

                // Creating a WarehouseModel object and using setters
                WarehouseModel warehouse = new WarehouseModel();
                warehouse.setIdWarehouse(id);
                warehouse.setAddress(address);
                warehouse.setPostalCode(postalCode);
                warehouse.setCityId(cityId);

                // Adding the warehouse to the list
                dataResult.add(warehouse);

            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {
            db.closeConnection();
        }
    }

    // get warehouse by id
    public WarehouseModel getWarehouseById(int id) {
        try {
            WarehouseModel dataResult = new WarehouseModel();;
            db.openConnection();
            String query = "SELECT id, address, postalCode, cityId FROM warehouse";

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                // Parsing the data

                int idWarehouse = rs.getInt("id");
                String address = rs.getString("address");
                String postalCode = rs.getString("postalCode");
                int cityId = rs.getInt("cityId");

                // Creating a WarehouseModel object and using setters
                dataResult.setIdWarehouse(idWarehouse);
                dataResult.setAddress(address);
                dataResult.setPostalCode(postalCode);
                dataResult.setCityId(cityId);
                // Adding the warehouse to the list
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {
            db.closeConnection();
        }
    }

    // getCityByProvinceId
    public ArrayList<CityModel> getCityInProvince(int provinceId) {
        try {
            ArrayList<CityModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT id, city, idProvinsi FROM city WHERE idProvinsi=" + provinceId;

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                // Parsing the data
                int id = rs.getInt("id");
                String city = rs.getString("city");
                int idProvince = rs.getInt("idProvinsi");

                // Creating a CityModel object and using setters
                CityModel cityModel = new CityModel();
                cityModel.setId(id);
                cityModel.setCity(city);
                cityModel.setIdProvince(idProvince);

                // Adding the city to the list
                dataResult.add(cityModel);

            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {
            db.closeConnection();
        }
    }

    // get city by id
    public CityModel getCityById(int cityId) {
         try {
            CityModel dataResult = new CityModel();;
            db.openConnection();
            String query = "SELECT id, city, idProvinsi FROM city WHERE id=" + cityId;

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                // Parsing the data
                int id = rs.getInt("id");
                String city = rs.getString("city");
                int idProvince = rs.getInt("idProvinsi");

                // Creating a CityModel object and using setters
                dataResult.setId(id);
                dataResult.setCity(city);
                dataResult.setIdProvince(idProvince);
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {
            db.closeConnection();
        }

    }

    // get province by id
    public ProvinceModel getProvinceById(int provinceId) {
        try {
            ProvinceModel dataResult = new ProvinceModel();
            db.openConnection();
            String query = "SELECT id, province FROM ciry WHERE id=" + provinceId;

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                 // Parsing the data
                int id = rs.getInt("id");
                String province = rs.getString("province");
                

                // Creating a CityModel object and using setters
                dataResult = new ProvinceModel(id, province);
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {
            db.closeConnection();
        }
    }

}
