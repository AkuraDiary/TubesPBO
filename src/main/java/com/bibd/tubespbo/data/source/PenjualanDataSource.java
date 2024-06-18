/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bibd.tubespbo.data.source;

import com.bibd.tubespbo.data.DbConnection;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.OrderDetailsModel;
import com.bibd.tubespbo.data.model.PenjualanModel;
import com.bibd.tubespbo.util.Parser;
import com.bibd.tubespbo.util.Statics;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            System.out.println("Ayam Penjualan Data Source Open");
            String query = "SELECT od.id, od.unitPrice,od.quantity, od.subTotalPrice, od.idProduct,p.idProduct,p.productName,p.description,p.buyPrice\n"
                    + ",p.sellPrice, p.categoryId,p.produsenId\n"
                    + "FROM orderdetails od \n"
                    + "JOIN orders o on o.orderId= od.orderId\n"
                    + "JOIN product p on p.idProduct=od.idProduct\n"
                    + "WHERE o.orderId = " + idorder;
            ResultSet rs = db.getData(query);
            System.out.println("Ayam Penjualan Data Source getData");

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

                OrderDetailsModel orderDetailModel = new OrderDetailsModel(id, unitPrice, quantity, subTotalPrice,
                        idProduct, productName, description, buyPrice, sellPrice, categoryId, produsenId);
                odm.add(orderDetailModel);
            }

            System.out.println("Ayam Penjualan Data Source Done");
            return odm;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
//        return odm;
    }

    public ArrayList<PenjualanModel> getHistoryPenjualanSales(int idWareHouse, int idEmployee) {
        ArrayList<PenjualanModel> pm = new ArrayList<>();
        try {
            db.openConnection();
            String query = "SELECT op.idPenjualan, \n"
                    + "    op.shipmentStatus, \n"
                    + "    op.dateShipped, \n"
                    + "    op.orderId, \n"
                    + "    op.customerId, \n"
                    + "    op.statuspayment, \n"
                    + "    o.orderDate, \n"
                    + "    o.orderType, \n"
                    + "    o.employeeId, \n"
                    + "    c.nama AS \"nama_cust\", \n"
                    + "    c.idCustomer, \n"
                    + "    e.nama AS \"nama_emp\", \n"
                    + "    wh.id AS \"warehouse_id\",\n"
                    + "    SUM(od.unitPrice * od.quantity) AS \"totalbiaya\"\n"
                    + "FROM \n"
                    + "    orderpenjualan op\n"
                    + "LEFT JOIN \n"
                    + "    orders o ON o.orderId = op.orderId\n"
                    + "LEFT JOIN \n"
                    + "    employees e ON e.idEmployee = o.employeeId\n"
                    + "LEFT JOIN \n"
                    + "    customers c ON c.idCustomer = op.customerId\n"
                    + "LEFT JOIN \n"
                    + "    orderdetails od ON od.orderId = o.orderId\n"
                    + "LEFT JOIN \n"
                    + "    warehouse wh ON e.idWarehouse = wh.id\n"
                    + "GROUP BY op.orderId, op.idPenjualan\n"
                    + "HAVING wh.id = " + idWareHouse + " AND o.employeeId = " + idEmployee;
//            String query = "SELECT op.idPenjualan, op.shipmentStatus, op.dateShipped, op.orderId, op.customerId, op.statuspayment, o.orderId, o.orderDate, o.orderType, o.employeeId, c.nama, c.idCustomer\n"
//                    + "FROM orderpenjualan op \n"
//                    + "JOIN orders o on o.orderId=op.orderId\n"
//                    + "JOIN employees e on e.idEmployee=o.employeeId \n"
//                    + "JOIN warehouse w on e.idWarehouse = w.id\n"
//                    + "JOIN customers c on c.idCustomer = op.customerId\n"
//                    + "WHERE w.id = " + idWareHouse + " AND o.employeeId = " + idEmployee;

            ResultSet rs = db.getData(query);

            System.out.println(query);
            PenjualanModel penjualanModel;

            while (rs.next()) {

                int idPenjualan = rs.getInt("idPenjualan");
                String shipmentStatus = rs.getString("shipmentStatus");
                Date dateShipped = rs.getDate("dateShipped");
                int orderId = rs.getInt("orderId");

                System.out.println("Penjualan Data Source IdOrder : " + orderId);
                int customerId = rs.getInt("customerId");
                String statusPayment = rs.getString("statuspayment");
                Date orderDate = rs.getDate("orderDate");
                String orderType = rs.getString("orderType");
                int employeeId = rs.getInt("employeeId");

//                String customerName = rs.getString("nama");
                String customerName = rs.getString("nama_cust");
                String employeeName = rs.getString("nama_emp");
                int totalbiaya = rs.getInt("totalbiaya");

                penjualanModel = new PenjualanModel(idPenjualan, shipmentStatus, dateShipped, orderId,
                        customerId, statusPayment, orderDate, orderType, employeeId);

                penjualanModel.setCustomerName(customerName);
                penjualanModel.setEmployeeName(employeeName);
                penjualanModel.setTotalBiaya(totalbiaya);
//                System.out.println(penjualanModel.getTotalBiaya());
                pm.add(penjualanModel);
            }

            return pm;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList<PenjualanModel> getHistoryPenjualanByWarehouse(int idWareHouse) {
        ArrayList<PenjualanModel> pm = new ArrayList<>();
        // TODO @Rapid Bug Query id order always 1g
        try {
            db.openConnection();
            String query = "SELECT \n"
                    + "    op.idPenjualan, \n"
                    + "    op.shipmentStatus, \n"
                    + "    op.dateShipped, \n"
                    + "    op.orderId, \n"
                    + "    op.customerId, \n"
                    + "    op.statuspayment, \n"
                    + "    o.orderDate, \n"
                    + "    o.orderType, \n"
                    + "    o.employeeId, \n"
                    + "    c.nama AS \"nama_cust\", \n"
                    + "    c.idCustomer, \n"
                    + "    e.nama AS \"nama_emp\", \n"
                    + "    wh.id AS \"warehouse_id\",\n"
                    + "    SUM(od.unitPrice * od.quantity) AS \"totalbiaya\"\n"
                    + "FROM \n"
                    + "    orderpenjualan op\n"
                    + "LEFT JOIN \n"
                    + "    orders o ON o.orderId = op.orderId\n"
                    + "LEFT JOIN \n"
                    + "    employees e ON e.idEmployee = o.employeeId\n"
                    + "LEFT JOIN \n"
                    + "    customers c ON c.idCustomer = op.customerId\n"
                    + "LEFT JOIN \n"
                    + "    orderdetails od ON od.orderId = o.orderId\n"
                    + "LEFT JOIN \n"
                    + "    warehouse wh ON e.idWarehouse = wh.id\n"
                    + "GROUP BY \n"
                    + "    op.orderId, op.idPenjualan\n"
                    + "HAVING \n"
                    + "    wh.id = " + idWareHouse;

//            System.out.println(query);
            ResultSet rs = db.getData(query);

//            PenjualanModel penjualanModel;
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

                String customerName = rs.getString("nama_cust");
                String employeeName = rs.getString("nama_emp");
                int totalbiaya = rs.getInt("totalbiaya");

//                String productName = rs.getString("productName");
//                long hargaSatuan = rs.getLong("sellPrice");
//                int jumlahOrder = rs.getInt("jumlahOrder");
                PenjualanModel penjualanModel = new PenjualanModel(idPenjualan, shipmentStatus, dateShipped, orderId,
                        customerId, statusPayment, orderDate, orderType, employeeId);
                penjualanModel.setCustomerName(customerName);
                penjualanModel.setEmployeeName(employeeName);
                penjualanModel.setTotalBiaya(totalbiaya);
//                penjualanModel.setProductName (productName);
//                penjualanModel.setUnitPrice(hargaSatuan);
//                penjualanModel.setQuantity(jumlahOrder);

                System.out.println("Penjualan Data Source Data : " + penjualanModel.getCustomerName() + " " + penjualanModel.getEmployeeName() + " " + penjualanModel.getTotalBiaya());

                pm.add(penjualanModel);
            }

            return pm;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;
        } finally {
            db.closeConnection();
        }
    }

    private int queryOrder(String orderDate, String orderType, int employeeid) {
        String query = "INSERT INTO orders (orderDate, orderType, employeeId) "
                + "VALUES ('" + orderDate + "', '" + orderType + "', " + employeeid + ")";
        return db.executeStatement(query);
    }

    private int queryOrderDetails(KeranjangModel itemkeranjang) throws SQLException {
        String querygetIdOrder = "SELECT o.orderId\n"
                + "FROM orders o\n"
                + "ORDER BY o.orderId DESC\n"
                + "LIMIT 1 ";
        ResultSet rs = db.getData(querygetIdOrder);

        int getIdOrder = -1;
        while (rs.next()) {
            getIdOrder = rs.getInt("orderId");
        }

        System.out.println("queryOrderDetail ");
        System.out.println(getIdOrder);
        long totaPrice = itemkeranjang.getProduk().getSellPrice() * itemkeranjang.getQuantity();

        if (getIdOrder > 0) {
            String query = "INSERT INTO orderdetails \n"
                    + "(unitPrice, quantity, subTotalPrice, idProduct, orderId) \n"
                    + "VALUES (" + itemkeranjang.getProduk().getSellPrice() + ", " + itemkeranjang.getQuantity() + ", \n"
                    //                    + "(unitPrice, quantity, subTotalPrice, idProduct, orderId) \n"
                    //                    + "VALUES (" + itemkeranjang.getProduk().getSellPrice() + ", " + itemkeranjang.getQuantity() + ", \n"

                    + totaPrice + ", " + itemkeranjang.getProduk().getIdProduct() + "," + getIdOrder + ")";
            return db.executeStatement(query);
        }
        return getIdOrder;
    }

    private int queryOrderPenjualan(String shipmentStatus, String dateShipped, int customerId,
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
            String query = "";
            if (getIdOrder > 0) {
                if (statusPayment.equalsIgnoreCase(Statics.ORDER_PAYMENT_STATUS_UNPAID)) {
                    dateShipped = "NULL";
                    query = "INSERT INTO orderpenjualan\n"
                            + "(shipmentStatus, dateShipped, orderId, customerId, statuspayment) \n"
                            + "VALUES ('" + shipmentStatus + "', " + dateShipped + ", " + getIdOrder + ", " + customerId + ", '" + statusPayment + "')";
                } else {
                    query = "INSERT INTO orderpenjualan\n"
                            + "(shipmentStatus, dateShipped, orderId, customerId, statuspayment) \n"
                            + "VALUES ('" + shipmentStatus + "', '" + dateShipped + "', " + getIdOrder + ", " + customerId + ", '" + statusPayment + "')";
                }

                return db.executeStatement(query);
            }
            return getIdOrder;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }

    }

    private int queryStokProduct(int jumlahBeli, String dateLastUpdate, int idProduct, int idWareHouse) {

        int stoksebelum = 0;

        try {
            String queryGetStok = "SELECT ps.totalStock FROM productstock ps\n"
                    + "WHERE ps.productId= " + idProduct + " AND ps.idWarehouse =" + idWareHouse;
            ResultSet rs = db.getData(queryGetStok);

            System.out.println("query get stok");
//            System.out.println(queryGetStok);
            while (rs.next()) {
                stoksebelum = rs.getInt("totalStock");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return 0;
        }

        int finishStock = stoksebelum - jumlahBeli;
        String querySubmit = "UPDATE productstock ps\n"
                + "SET ps.totalStock =" + finishStock + " , ps.lastUpdate ='" + dateLastUpdate + "'\n"
                + "WHERE ps.productId =" + idProduct + " AND ps.idWarehouse = " + idWareHouse;

        System.out.println("update stok");
//        System.out.println(querySubmit);

        return db.executeStatement(querySubmit);
    }

    public int updateStockPaid(int idPenjualan, String statusShipment, String statusPayment, ArrayList<OrderDetailsModel> listProduk, int idWarehouse) {
        try {

            int resultStatus = updateStatusShipPay(idPenjualan, statusShipment, statusPayment);

            String lastUpdate = Parser.parseDateToStringSQL(new Date());

            int resultStock = 0;
            if (resultStatus > 0) {
                for (OrderDetailsModel item : listProduk) {
                    resultStock += queryStokProduct((int) item.getQuantity(), lastUpdate, (int) item.getIdProduct(), idWarehouse);
                }
            }
            return resultStock;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        }
    }

    public int doCheckout(int customerId, int employeeId, ArrayList<KeranjangModel> keranjang, String statusPayment,
            String typeOrder, String waktu, String statusShip, int idWarehouse) {
        try {
            db.openConnection();
//           

            int result = queryOrder(waktu, typeOrder, employeeId);

            for (KeranjangModel i : keranjang) {
                queryOrderDetails(i);
            }

            queryOrderPenjualan(statusShip, waktu, customerId, statusPayment);

            //if status = paid ini di panggil
            if (statusPayment.equals(Statics.ORDER_PAYMENT_STATUS_PAID)) {
                for (KeranjangModel i : keranjang) {
                    queryStokProduct(i.getQuantity(), waktu, i.getProduk().getIdProduct(), idWarehouse);
                }
            }

//            queryStokProduct(keranjang, waktu, employeeId, employeeId);
//            return 1;
//            queryOrderDetails(keranjang);
            return result;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
    }

    public int updateStatusShipPay(int idPenjualan, String statusShipment, String statusPayment) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        try {
            db.openConnection();
            String queryGetpenjualan = "";

            String queryupdateShip = "UPDATE orderpenjualan op \n"
                    + "SET op.shipmentStatus = '" + statusShipment + "', op.statuspayment='" + statusPayment + "'\n"
                    + "WHERE op.idPenjualan = " + idPenjualan;

            return db.executeStatement(queryupdateShip);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
    }

}
