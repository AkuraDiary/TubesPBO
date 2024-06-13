/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CategoryModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.data.model.ProductStockModel;
import com.bibd.tubespbo.util.Parser;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
//Rapid D.
public class ProductDataSource {

    DbConnection db;

    public ProductDataSource(DbConnection db) {
        this.db = db;
    }

    public ArrayList<ProductModel> getAllProduct() {

        try {
            ArrayList<ProductModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT p.idProduct, p.productName, p.description, \n"
                    + "p.buyPrice, p.sellPrice, p.categoryId, p.produsenId,\n"
                    + " c.category, prod.name, ps.totalStock, ps.lastUpdate, w.address\n"
                    + "FROM product p\n"
                    + "JOIN category c on p.categoryId = c.idCategory\n"
                    + "JOIN produsen prod on prod.idProdusen = p.produsenId\n"
                    + "LEFT JOIN productstock ps on ps.productId = p.idProduct\n"
                    + "LEFT JOIN warehouse w on ps.idWarehouse = w.id\n";

            ResultSet rs = db.getData(query);

            // TODO to edit 
            while (rs.next()) {
                // Parsing the data
                
                int productId = rs.getInt("idProduct");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                int buyPrice = rs.getInt("buyPrice");
                int sellPrice = rs.getInt("sellPrice");
                int categoryId = rs.getInt("categoryId");
                int produsenId = rs.getInt("produsenId");
                
                String categoryName = rs.getString("category");
                String produsenName = rs.getString("name");
                int totalstok = rs.getInt("totalStock");
                Date lastUpdateProduct = rs.getDate("lastUpdate");
                String warehouseAlamat = rs.getString("address");

                // Creating a ProductModel object
                ProductModel product = new ProductModel();
                product.setIdProduct(productId);
                product.setProductName(productName);
                product.setDescription(description);
                product.setBuyPrice((long) buyPrice);
                product.setSellPrice((long) sellPrice);
                product.setCategoryId(categoryId);
                product.setProdusenId(produsenId);
                
                
                //new
                product.setCategoryName(categoryName);
                product.setProdusenName(produsenName);
                product.setQuantityInStock(totalstok);
                product.setLastUpdate(lastUpdateProduct);
                product.setWarehouseName(warehouseAlamat);
                
                

                // Adding the product to the list
                dataResult.add(product);
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int updateProductStock(int idProductStock, int jumlahBaru, int idEmployee, int perubahan) {
        try {

            db.openConnection();
            Date now = new Date();
            String dateLastUpdated = Parser.parseDateToStringSQL(now);
            System.out.println("dateLastUpdated: " + dateLastUpdated);
            System.out.println("jumlahBaru: " + jumlahBaru);
            String query = "UPDATE productstock SET totalStock=" + jumlahBaru + ", lastUpdate='" + dateLastUpdated + "' "
                    + "WHERE id=" + idProductStock;//productId="+ idproduct + " AND idWarehouse=" + idWarehouse + "";

            int updateeProductStokResult = db.executeStatement(query);

            if (updateeProductStokResult != 0) {

                String queryInsertLog = "INSERT INTO logstockproduct (tanggal, idproductstock, idEmployee, perubahan) VALUES"
                        + "('" + dateLastUpdated + "', " + idProductStock + ", " + idEmployee + ", " + perubahan + " )";
                return db.executeStatement(queryInsertLog);
            }

            return updateeProductStokResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {

            db.closeConnection();
        }
    }

    public int insertProductStock(int idproduct, int jumlahBaru, int idEmployee, int idWarehouse) {

        try {
            db.openConnection();
            // Assuming that we have a `lastUpdate` field that we need to set to the current date
            java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());

            String query = "INSERT INTO productstock (totalStock, lastUpdate, productId, idWarehouse) "
                    + "VALUES (" + jumlahBaru + ", '" + currentDate + "', " + idproduct + ", " + idWarehouse + ")";

            int result = db.executeStatement(query);

            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }
    }

    public int insertProduct(String productName, int quantityInStock, long buyPrice, long sellPrice, int categoryId, int produsenId, String description) {
        try {
            db.openConnection();

            String query = "INSERT INTO product (productName, description, buyPrice, sellPrice, categoryId, produsenId) "
                    + "VALUES ('" + productName + "', '" + description + "', " + buyPrice + ", " + sellPrice
                    + ", " + categoryId + ", " + produsenId + ")";

            int result = db.executeStatement(query);
            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }

    }

    public int insertCategory(String namaCategory, String descCategory) {

        try {
            db.openConnection();

            String query = "INSERT INTO category (category, description) "
                    + "VALUES ('" + namaCategory + "', '" + descCategory + "')";

            int result = db.executeStatement(query);
            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }

    }

    public int updateCategory(int idCategory, String namaCategory, String descCategory) {

        try {
            db.openConnection();

            String query = "UPDATE category SET category = '" + namaCategory + "', "
                    + "description = '" + descCategory + "' "
                    + "WHERE idCategory = " + idCategory;

            int result = db.executeStatement(query);
            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }

    }

    public ArrayList<CategoryModel> getAllCategory() {
        try {
            ArrayList<CategoryModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT idCategory, category, description FROM category";

            ResultSet rs = db.getData(query);

            // TODO to edit 
            while (rs.next()) {
                // Parsing the data
                int idCategory = rs.getInt("idCategory");
                String category = rs.getString("category");
                String description = rs.getString("description");

                // Creating a CategoryModel object and using setters
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setIdCategory(idCategory);
                categoryModel.setNamaCategory(category);
                categoryModel.setDescCategory(description);

                // Adding the category to the list
                dataResult.add(categoryModel);
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int updateDataProduct(int idProduct, String productName,
//                                 int quantityInStock,
                                 long buyPrice, long sellPrice, int categoryId, int produsenId, String description) {

        try {
            db.openConnection();

            String query = "UPDATE product SET "
                    + "productName = '" + productName + "', "
                    + "description = '" + description + "', "
                    + "buyPrice = " + buyPrice + ", "
                    + "sellPrice = " + sellPrice + ", "
                    + "categoryId = " + categoryId + ", "
                    + "produsenId = " + produsenId + " "
                    + "WHERE idProduct = " + idProduct;

            int result = db.executeStatement(query);
            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }

    }

    public ArrayList<ProductStockModel> getAllStockProduct(int idWarehouse) {
        try {
            ArrayList<ProductStockModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT ps.id, ps.totalStock, ps.lastUpdate, ps.productId, ps.idWarehouse, p.productName\n" +
                    "FROM productstock ps JOIN product p ON p.idProduct = ps.productId\n" +
                    "WHERE idWarehouse = " + idWarehouse + " ORDER BY p.productName ASC";

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                int totalStock = rs.getInt("totalStock");
                Date lastUpdate = rs.getDate("lastUpdate");
                int productId = rs.getInt("productId");
                int idWarehouseResult = rs.getInt("idWarehouse");
                String productName = rs.getString("productName");

                ProductStockModel stock = new ProductStockModel(id, totalStock, lastUpdate, productId, idWarehouseResult);
                stock.setProductName(productName);
                dataResult.add(stock);
            }

            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public ArrayList<ProductModel> getAllProductWarehouse(int idWarehouse) {

        try {
            ArrayList<ProductModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT p.idProduct, p.productName, p.description, \n"
                    + "p.buyPrice, p.sellPrice, p.categoryId, p.produsenId,\n"
                    + " c.category, prod.name, ps.totalStock, ps.lastUpdate, w.address\n"
                    + "FROM product p\n"
                    + "JOIN category c on p.categoryId = c.idCategory\n"
                    + "JOIN produsen prod on prod.idProdusen = p.produsenId\n"
                    + "LEFT JOIN productstock ps on ps.productId = p.idProduct\n"
                    + "LEFT JOIN warehouse w on ps.idWarehouse = w.id\n"
                    + "WHERE w.id=" + idWarehouse;

            ResultSet rs = db.getData(query);

            // TODO to edit 
            while (rs.next()) {
                // Parsing the data
                
                int productId = rs.getInt("idProduct");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                int buyPrice = rs.getInt("buyPrice");
                int sellPrice = rs.getInt("sellPrice");
                int categoryId = rs.getInt("categoryId");
                int produsenId = rs.getInt("produsenId");
                
                String categoryName = rs.getString("category");
                String produsenName = rs.getString("name");
                int totalstok = rs.getInt("totalStock");
                Date lastUpdateProduct = rs.getDate("lastUpdate");
                String warehouseAlamat = rs.getString("address");

                // Creating a ProductModel object
                ProductModel product = new ProductModel();
                product.setIdProduct(productId);
                product.setProductName(productName);
                product.setDescription(description);
                product.setBuyPrice((long) buyPrice);
                product.setSellPrice((long) sellPrice);
                product.setCategoryId(categoryId);
                product.setProdusenId(produsenId);
                
                //new
                product.setCategoryName(categoryName);
                product.setProdusenName(produsenName);
                product.setQuantityInStock(totalstok);
                product.setLastUpdate(lastUpdateProduct);
                product.setWarehouseName(warehouseAlamat);
                
                

                // Adding the product to the list
                dataResult.add(product);
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
