/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.OrderDetailsModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.mysql.cj.protocol.Resultset;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asthiseta
 */
//Rapid D.
public class PenjualanDataSource {

    DbConnection db;

    public PenjualanDataSource(DbConnection db) {
        this.db = db;
    }

    public ArrayList<OrderDetailsModel> getAllDetilOrder(int idorder) {
        ArrayList<OrderDetailsModel> odm = new ArrayList<>();
        try {
            db.openConnection();

            String query = "SELECT od.id, od.unitPrice,od.quantity, od.subTotalPrice, od.idProduct,p.idProduct,p.productName,p.description,p.buyPrice\n"
                    + ",p.sellPrice, p.categoryId,p.produsenId\n"
                    + "FROM orderdetails od \n"
                    + "JOIN orders o on o.orderId= od.orderId\n"
                    + "JOIN product p on p.idProduct=od.idProduct\n"
                    + "WHERE o.orderId = " + idorder;
            ResultSet rs = db.getData(query);

//            OrderDetailsModel orderDetailModel ;
            while (rs.next()) {

                int id = rs.getInt("id");
                double unitPrice = rs.getDouble("unitPrice");
                int quantity = rs.getInt("quantity");
                double subTotalPrice = rs.getDouble("subTotalPrice");
                int idProduct = rs.getInt("idProduct");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                double buyPrice = rs.getDouble("buyPrice");
                double sellPrice = rs.getDouble("sellPrice");
                int categoryId = rs.getInt("categoryId");
                int produsenId = rs.getInt("produsenId");

//            OrderDetailsModel orderDetailModel =;
                OrderDetailsModel orderDetailModel = new OrderDetailsModel(id, unitPrice, quantity, subTotalPrice,
                        idProduct, productName, description, buyPrice, sellPrice, categoryId, produsenId);
                odm.add(orderDetailModel);
            }
//            String query = ""
            return odm;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
//        return odm;
    }

    public ArrayList<PenjualanModel> getHistoryPenjualan(int idWareHouse) {
        ArrayList<PenjualanModel> pm = new ArrayList<>();
        try {
            db.openConnection();
            String query = "SELECT op.idPenjualan, op.shipmentStatus, op.dateShipped, op.orderId, op.customerId, op.statuspayment, o.orderId, o.orderDate, o.orderType, o.employeeId\n"
                    + "FROM orderpenjualan op \n"
                    + "JOIN orders o on o.orderId=op.orderId\n"
                    + "JOIN employees e on e.idEmployee=o.employeeId \n"
                    + "JOIN warehouse w on e.idWarehouse = w.id\n"
                    + "WHERE w.id = " + idWareHouse;
            ResultSet rs = db.getData(query);

            PenjualanModel penjualanModel;

            while (rs.next()) {

                int idPenjualan = rs.getInt("idPenjualan");
                String shipmentStatus = rs.getString("shipmentStatus");
                Date dateShipped = rs.getDate("dateShipped");
                int orderId = rs.getInt("orderId");
                int customerId = rs.getInt("customerId");
                String statusPayment = rs.getString("statuspayment");
                Date orderDate = rs.getDate("orderDate");
                String orderType = rs.getString("orderType");
                int employeeId = rs.getInt("employeeId");

                pm.add(new PenjualanModel(idPenjualan, shipmentStatus, dateShipped, orderId,
                        customerId, statusPayment, orderDate, orderType, employeeId));
            }

//                    return pm;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
        return pm;
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int queryOrder(LocalDateTime orderDate, String orderType, int employeeid) {
        String query = "INSERT INTO orders (orderDate, orderType, employeeId) "
                + "VALUES ('" + orderDate + "', '" + orderType + "', " + employeeid + ")";
        return db.executeStatement(query);
    }

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

    private int queryOrderPenjualan(String shipmentStatus, LocalDateTime dateShipped, int customerId,
            String statusPayment) {
        try {
            String querygetIdOrder = "SELECT o.orderId\n"
                    + "FROM orders o\n"
                    + "ORDER BY o.orderDate DESC\n"
                    + "LIMIT 1 ";
            ResultSet rs = db.getData(querygetIdOrder);

            int getIdOrder = -1;
            while (rs.next()) {
                getIdOrder = rs.getInt("orderId");
            }

            if (getIdOrder > 0) {
                String query = "INSERT INTO orderpenjualan\n"
                        + "(shipmentStatus, dateShipped, orderId, customerId, statuspayment) \n"
                        + "VALUES ('" + shipmentStatus + "', " + dateShipped + ", " + getIdOrder + ", " + customerId + ", " + statusPayment + ")";
                return db.executeStatement(query);
            }
            return getIdOrder;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }

    }

    private int queryStokProduct(int finishStock, LocalDateTime dateLastUpdate, int idProduct, int idWareHouse) {
        String query = "UPDATE productstock ps\n"
                + "SET ps.totalStock ="+finishStock+" , ps.lastUpdate ="+ dateLastUpdate+"\n"
                + "WHERE ps.id ="+idProduct+" AND ps.idWarehouse = "+idWareHouse;
        return db.executeStatement(query);
    }

    public int doCheckout(int customerId, int employeeId, ArrayList<KeranjangModel> keranjang, String statusPayment,
            String typeOrder, LocalDateTime waktu, String statusShip) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          order,orderdetil,orderpenjualan, stok product

        try {
            db.openConnection();
//           

            queryOrder(waktu, typeOrder, employeeId);
            
            for (KeranjangModel i : keranjang) {
                queryOrderDetails(i);
            }
            
            queryOrderPenjualan(statusShip, waktu, customerId, statusPayment);

            return 1;
//            queryOrderDetails(keranjang);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
    }

    public int updateStatusShipment(int idPenjualan, String statusShipment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
