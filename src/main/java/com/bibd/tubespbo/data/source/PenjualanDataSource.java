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

    private void queryOrder(LocalDateTime orderDate, String orderType, int employeeid) {
        String query = "INSERT INTO orders (orderDate, orderType, employeeId) "
                + "VALUES ('" + orderDate + "', '" + orderType + "', " + employeeid + ")";
        db.executeStatement(query);
    }

    private void queryOrderDetails(int harga, int jumlah, int totalHarga, int idProduct) throws SQLException {
        String querygetIdOrder = "SELECT o.orderId\n"
                + "FROM orders o\n"
                + "ORDER BY o.orderDate DESC\n"
                + "LIMIT 1 ";
        ResultSet rs = db.getData(querygetIdOrder);

        int getIdOrder = -1;
        while (rs.next()) {
            getIdOrder = rs.getInt("orderId");
        }

        if (getIdOrder != -1) {
            String query = "INSERT INTO orderdetails \n"
                    + "(unitPrice, quantity, subTotalPrice, idProduct, orderId) \n"
                    + "VALUES ("+harga+", "+jumlah+", "+totalHarga+", "+idProduct+","+getIdOrder+")";
            db.executeStatement(query);
        }

    }

    public int doCheckout(int customerId, int employeeId, ArrayList<KeranjangModel> keranjang, String statusPayment,
            String typeOrder, LocalDateTime waktu, PenjualanDataSource penjualanDataSource) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//          order,orderdetil,orderpenjualan, stok product

        try {
            db.openConnection();
//            String queryorder = "INSERT INTO orders (orderDate, orderType, employeeId) \n"
//                    + "VALUES ('"+waktu+"', '"+typeOrder+"', "+employeeId+")";
//            String queryorderdetil = "")";
//            String queryorderpenjualan = "INSERT INTO orders (orderDate, orderType, employeeId) \n"
//                    + "VALUES ('" + waktu + "', '" + typeOrder + "', " + employeeId + ")";

            queryOrder();
            queryOrderDetails();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public int updateStatusShipment(int idPenjualan, String statusShipment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
