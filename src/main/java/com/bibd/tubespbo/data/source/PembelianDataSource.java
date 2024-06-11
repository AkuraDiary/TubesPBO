/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CustomerModel;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.util.Statics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
public class PembelianDataSource {

    /// buatlah dua metodh get all pembelian dan get detail pembelian parametere id order,
    DbConnection db;

    public PembelianDataSource(DbConnection conn) {
        this.db = conn;
    }

    public int updateStatusPembelian(int idPembelian, String status) {
        // TODO
        return -1;
    }

    public ArrayList<PembelianModel> getAllPembelian(int idWarehouse) {
        try {
            ArrayList<PembelianModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "";
            if (idWarehouse == Statics.GET_ALL_PEMBELIAN) {
                query = "SELECT \n" +
                        "orderpembelian.idPembelian, employees.idEmployee, orderpembelian.status, orders.orderDate, warehouse.address, orders.orderType, warehouse.id, orders.orderId , SUM(orderdetails.unitPrice * orderdetails.quantity) AS \"totalbiaya\"\n" +
                        "\n" +
                        "FROM orderpembelian JOIN orders ON orders.orderId = orderpembelian.idPembelian \n" +
                        "JOIN employees ON employees.idEmployee = orders.employeeId\n" +
                        "JOIN warehouse ON warehouse.id = employees.idWarehouse\n" +
                        "JOIN orderdetails ON orderdetails.orderId = orders.orderId\n" +
                        "GROUP BY orders.orderId\n" + " ";
            } else {
                query = "SELECT \n" +
                        "orderpembelian.idPembelian, employees.idEmployee, orderpembelian.status, orders.orderDate, warehouse.address, orders.orderType, warehouse.id, orders.orderId , SUM(orderdetails.unitPrice * orderdetails.quantity) AS \"totalbiaya\"\n" +
                        "\n" +
                        "FROM orderpembelian JOIN orders ON orders.orderId = orderpembelian.idPembelian \n" +
                        "JOIN employees ON employees.idEmployee = orders.employeeId\n" +
                        "JOIN warehouse ON warehouse.id = employees.idWarehouse\n" +
                        "JOIN orderdetails ON orderdetails.orderId = orders.orderId\n" +
                        "GROUP BY orders.orderId\n" + " HAVING warehouse.id = " + idWarehouse;
            }
            ResultSet rs = db.getData(query);

            //buatkan method jika <0 = "SELECT orderpembelian.idPembelian, employees.idEmployee, orderpembelian.status, orders.orderDate, orders.orderType, orders.orderId  FROM orderpembelian JOIN orders ON orders.orderId = orderpembelian.idPembelian JOIN employees ON employees.idEmployee = orders.employeeId";
            while (rs.next()) {

                int idPembelian = rs.getInt("idPembelian");
                int idOrder = rs.getInt("orderId");
                int idSupervisor = rs.getInt("idEmployee");
                String Status = rs.getString("status");
                String typeorder = rs.getString("orderType");
                Date tanggalorder = rs.getDate("orderDate");

                String warehouse = rs.getString("address");
                long totalbiaya =(long) rs.getInt("totalbiaya");
                int warehouseId = rs.getInt("id");

                PembelianModel pm = new PembelianModel();
                pm.setIdPembelian(idPembelian);
                pm.setIdSupervisor(idSupervisor);
                pm.setIdorder(idOrder);
                pm.setStatus(Status);
                pm.setTanggalOrder(tanggalorder);
                pm.setTypeOrder(typeorder);

                pm.setWarehouse(warehouse);
                pm.setWarehouseId(warehouseId);
                pm.setTotalBiaya(totalbiaya);

                dataResult.add(pm);

            }
            return dataResult;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }



    public int submitPembelian(int employeeId, String orderType, LocalDateTime waktu, String statusOrder, ArrayList<KeranjangModel> keranjang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //cccccccccccspublic PembelianModel getDetailPembelian(int idOrder, int IdPembelian, Date OrderDate, String OrderType, int Quantity) {

    //    try {
    //        db.openConnection();

    //        String query = "Detail Pembelian "
    //                + " orderId = '" + idOrder + "', "
    //                + "idPembelian = '" + IdPembelian + "', "
    //                + "orderDate = " + OrderDate + ", "
    //                + "orderType = " + OrderType + ", "
    //                + "Quantity = " + Quantity + ", "
    //                + "WHERE idPembelian = " + IdPembelian;

    //        PreparedStatement stmt = db.prepareStatement(query);
    //        stmt.setInt(1, idOrder);
    //        stmt.setInt(2, idPembelian);
    //        stmt.setDate(3, new java.sql.Date(orderDate.getTime()));
    //        stmt.setString(4, orderType);
    //        stmt.setInt(5, quantity);

    //        ResultSet rs = stmt.executeQuery();

   //         return pm;
    //    }else {
     //       return null; // Data tidak ditemukan
      //  }
    //}
    //catch (Exception e

    
      //  ) {
      //  System.out.println(e.getLocalizedMessage());
       // return null;
    //}

    
      //  finally {
       // db.closeConnection();
    
        
        
     private int queryOrderDetails(KeranjangModel itemkeranjang) throws SQLException {
        String querygetIdOrder = "SELECT o.orderId\n"
                + "FROM orders o\n"
                + "ORDER BY o.orderDate DESC\n"
                + "LIMIT 1 ";
        ResultSet rs = db.getData(querygetIdOrder);

        int getIdOrder = -1;
        while (rs.next()) {
            getIdOrder = rs.getInt("orderId");
        }

        long totaPrice = itemkeranjang.getProduk().getSellPrice() * itemkeranjang.getQuantity();

        if (getIdOrder > 0) {
            String query = "INSERT INTO orderdetails \n"
                    + "(unitPrice, quantity, subTotalPrice, idProduct, orderId) \n"
                    
                    
                    + "VALUES (" + itemkeranjang.getProduk().getBuyPrice() + ", " + itemkeranjang.getQuantity() + ", \n"
                    + totaPrice + ", " + itemkeranjang.getProduk().getIdProduct() + "," + getIdOrder + ")";
            return db.executeStatement(query);
        }
        return getIdOrder;
    }   
     
     
     
     
 //     private int queryOrderPembelian(String status, int orderId) {
 //       try {
 //           String querygetIdOrder = "SELECT o.orderId\n"
 //                   + "FROM orders o\n"
 //                   + "ORDER BY o.orderDate DESC\n"
 //                   + "LIMIT 1 ";
 //           ResultSet rs = db.getData(querygetIdOrder);
//
 //           int getIdOrder = 0;
 //           while (rs.next()) {
 //               getIdOrder = rs.getInt("orderId");
 //           }
//
 //           if (getIdOrder > 0) {
 //               String query = "INSERT INTO orderpembeli\n"
 //                       + "(status, orderId,) \n"
 //                       + "VALUES ('" + status + ", " + getIdOrder + ")";
 //               return db.executeStatement(query);
 //           }
 //           return getIdOrder;

 //       } catch (Exception e) {
 //           System.out.println(e.getLocalizedMessage());
 //           return -1;
 //       }

//    }
     
     private int queryOrderPembelian(String status, int orderId) {
    try {
        db.openConnection();

        String querygetIdOrder = "SELECT o.orderId FROM orders o ORDER BY o.orderDate DESC LIMIT 1";
        ResultSet rs = db.getData(querygetIdOrder);

        int getIdOrder = 0;
        if (rs.next()) {
            getIdOrder = rs.getInt("orderId");
        }

        if (getIdOrder > 0) {
            String query = "INSERT INTO orderpembelian (status, orderId) VALUES (?, ?)";
            PreparedStatement stmt = db.prepareStatement(query);
            stmt.setString(1, status);
            stmt.setInt(2, getIdOrder);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0 ? getIdOrder : -1;
        } else {
            return -1; // Tidak ada orderId yang valid
        }
    } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
        return -1;
    } finally {
        db.closeConnection();
    }
}
     
     private int queryOrders(LocalDateTime orderDate, String orderType, int employeeid) {
        String query = "INSERT INTO orders (orderDate, orderType, employeeId) "
                + "VALUES ('" + orderDate + "', '" + orderType + "', " + employeeid + ")";
        return db.executeStatement(query);
    }


}


