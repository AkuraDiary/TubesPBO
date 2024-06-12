/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.CustomerModel;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.OrderDetailsModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.util.Statics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            ArrayList<PembelianModel> BeliModel = new ArrayList<>();
            db.openConnection();
            String query = "";
            if (idWarehouse == Statics.GET_ALL_PEMBELIAN) {
                query = "SELECT \n"
                        + "orderpembelian.idPembelian, employees.idEmployee, orderpembelian.status, orders.orderDate, warehouse.address, orders.orderType, warehouse.id, orders.orderId , SUM(orderdetails.unitPrice * orderdetails.quantity) AS \"totalbiaya\"\n"
                        + "\n"
                        + "FROM orderpembelian JOIN orders ON orders.orderId = orderpembelian.idPembelian \n"
                        + "JOIN employees ON employees.idEmployee = orders.employeeId\n"
                        + "JOIN warehouse ON warehouse.id = employees.idWarehouse\n"
                        + "JOIN orderdetails ON orderdetails.orderId = orders.orderId\n"
                        + "GROUP BY orders.orderId\n" + " ";
            } else {
                query = "SELECT \n"
                        + "    op.idPembelian, op.status,\n"
                        + " 	o.orderId, o.orderDate, o.orderType,\n"
                        + " 	wh.address,\n"
                        + " 	SUM(od.quantity*od.unitPrice) \"totalbiaya\"\n"
                        + "FROM \n"
                        + "    orderpembelian op\n"
                        + "JOIN orders o on o.orderId = op.orderId\n"
                        + "JOIN employees e on e.idEmployee = o.employeeId\n"
                        + "JOIN warehouse wh on wh.id = e.idWarehouse\n"
                        + "JOIN orderdetails od on od.orderId = o.orderId\n"
                        + "\n"
                        + "GROUP by op.idPembelian\n"
                        + "HAVING wh.id = " + idWarehouse;
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
                long totalbiaya = (long) rs.getInt("totalbiaya");
                int warehouseId = rs.getInt("id");
//                String addresWarehouse = rs.getString("address");

                PembelianModel pm = new PembelianModel();
                pm.setIdPembelian(idPembelian);
                pm.setIdSupervisor(idSupervisor);
                pm.setIdOrder(idOrder);
                pm.setStatus(Status);
                pm.setTanggalOrder(tanggalorder);
                pm.setTypeOrder(typeorder);

                pm.setAddresWarehouse(warehouse);
                
                pm.setWarehouseId(warehouseId);
                pm.setTotalBiaya(totalbiaya);
                BeliModel.add(pm);

            }
            return BeliModel;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int submitPembelian(int employeeId, String orderType, LocalDateTime waktu, String statusOrder, ArrayList<KeranjangModel> keranjang) {
        //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        // order,orderdetil,orderpenjualan, stok product
        int orderId = -1;
//

        try {
//            db.openConnection();
//
//            String query = "INSERT INTO orders (employeeid, orderType, orderDate, StatusOrder) VALUES ("
//                    + employeeId + ", '" + orderType + "', '" + waktu + "', '" + statusOrder + "')";
//            db.executeStatement(query);
//
//            ResultSet rs = db.getData("SELECT orderId AS last_id from orders order by orderId desc limit 1");
//            if (rs.next()) {
//                orderId = rs.getInt("last_id");
//            }
////           untuk mendapatkan ID dari entri yang baru ditambahkan menggunakan LAST_INSERT_ID(). 
////           ID ini disimpan dalam variabel orderId.
//            for (KeranjangModel km : keranjang) {
//                queryOrderDetails(km);
//            }
//
//            queryOrderPembelian(statusOrder, orderId);
            db.openConnection();
            //Eksekusi INSERT ke Tabel orders:
            String query = "INSERT INTO orders (employeeid, orderType, orderDate) VALUES ("
                    + employeeId + ", '" + orderType + "', '" + waktu + "')";
            db.executeStatement(query);
            //Mengambil orderId Terakhir yang Baru Ditambahkan:
            ResultSet rs = db.getData("SELECT orderId AS last_id from orders order by orderId desc limit 1");
            if (rs.next()) {
                orderId = rs.getInt("last_id");
                //Menambahkan Status ke Tabel orderpembelian:
                String sql = "INSERT INTO orderpembelian (status) VALUES '" + statusOrder + "' WHERE orderId = '" + orderId + "' ";
                db.executeStatement(sql);
            }
//           Setiap item dalam keranjang diproses dan dimasukkan ke dalam tabel detail pesanan melalui fungsi queryOrderDetails(km).
            for (KeranjangModel km : keranjang) {
                queryOrderDetails(km);
            }

            queryOrderPembelian(statusOrder, orderId);

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
        return orderId;
    }

//
    public ArrayList<OrderDetailsModel> getDetailPembelian(int idorder) {
        ArrayList<OrderDetailsModel> odm = new ArrayList<>();
        try {
            db.openConnection();

            String query = "SELECT od.id, od.unitPrice, od.quantity, od.subTotalPrice, od.idProduct, "
                    + "p.idProduct, p.productName, p.description, p.buyPrice, p.sellPrice, "
                    + "p.categoryId, p.produsenId "
                    + "FROM orderdetails od "
                    + "JOIN orders o ON o.orderId = od.orderId "
                    + "JOIN product p ON p.idProduct = od.idProduct "
                    + "WHERE o.orderId = " + idorder;

            ResultSet rs = db.getData(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                long unitPrice = rs.getLong("unitPrice");
                int quantity = rs.getInt("quantity");
                long subTotalPrice = rs.getLong("subTotalPrice");
                int idProduct = rs.getInt("idProduct");
                String productName = rs.getString("productName");
                String description = rs.getString("description");
                long buyPrice = rs.getLong("buyPrice");
                long sellPrice = rs.getLong("sellPrice");
                int categoryId = rs.getInt("categoryId");
                int produsenId = rs.getInt("produsenId");

                // Membuat objek OrderDetailsModel dengan data yang diambil dari ResultSet
                OrderDetailsModel orderDetailModel = new OrderDetailsModel(id, unitPrice, quantity, subTotalPrice,
                        idProduct, productName, description, buyPrice, sellPrice, categoryId, produsenId);
                odm.add(orderDetailModel);
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            db.closeConnection();
        }
        return odm;
    }

    // Tutup koneksi
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

    private int queryOrderPembelian(String status, int orderId) {
        try {
            String querygetIdOrder = "SELECT o.orderId\n"
                    + "FROM orders o\n"
                    + "ORDER BY o.orderDate DESC\n"
                    + "LIMIT 1 ";
            ResultSet rs = db.getData(querygetIdOrder);

            int getIdOrder = 0;
            while (rs.next()) {
                getIdOrder = rs.getInt("orderId");
            }

            if (getIdOrder > 0) {
                String query = "INSERT INTO orderpembeli\n"
                        + "(status, orderId,) \n"
                        + "VALUES ('" + status + ", " + getIdOrder + ")";
                return db.executeStatement(query);
            }
            return getIdOrder;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }

    }

    private int queryOrder(LocalDateTime orderDate, String orderType, int employeeid) {
        String query = "INSERT INTO orders (orderDate, orderType, employeeId) "
                + "VALUES ('" + orderDate + "', '" + orderType + "', " + employeeid + ")";
        return db.executeStatement(query);
    }

    private int queryStokProduct(int jumlahBeli, LocalDateTime dateLastUpdate, int idProduct, int idWareHouse) {
        int stoksebelum = 0;
        try {
            String queryGetStok = "SELECT ps.totalStock FROM productstock ps\n"
                    + "WHERE ps.productId= " + idProduct + " AND ps.idWarehouse =" + idWareHouse;
            ResultSet rs = db.getData(queryGetStok);

            while (rs.next()) {
                stoksebelum = rs.getInt("totalStock");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return 0;
        }

        int finishStock = stoksebelum + jumlahBeli;
        String querySubmit = "UPDATE productstock ps\n"
                + "SET ps.totalStock =" + finishStock + " , ps.lastUpdate =" + dateLastUpdate + "\n"
                + "WHERE ps.id =" + idProduct + " AND ps.idWarehouse = " + idWareHouse;

        return db.executeStatement(querySubmit);

    }

}
