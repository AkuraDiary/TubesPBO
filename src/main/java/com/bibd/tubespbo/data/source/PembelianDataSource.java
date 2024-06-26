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
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.util.Parser;
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
        try {
            db.openConnection();

            // Query untuk mengupdate status pembelian
            String query = "UPDATE orderpembelian SET status = '" + status + "' WHERE idPembelian = " + idPembelian;

            // Eksekusi query
            db.executeStatement(query);

            //Jika semua berjalan lancar tanpa pengecualian, metode akan mengembalikan nilai 1 yang fungsinya berhasil dipakai
            return 1;

            //ika terjadi pengecualian selama eksekusi kode dalam blok try, blok catch akan menangkap pengecualian tersebut.
// Pesan kesalahan akan dicetak ke output dengan menggunakan System.out.print(), dan mengembalikan nilai -1 untuk menunjukkan bahwa operasi gagal.
        } catch (Exception e) {
            System.out.print("erorr update status pembelian: " + e.getLocalizedMessage());
            return -1;

        } finally {
            db.closeConnection();
        }
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
                        + " 	wh.address,e.idEmployee,\n"
                        + " 	SUM(od.quantity*od.unitPrice) \"totalbiaya\"\n"
                        + "FROM \n"
                        + "    orderpembelian op\n"
                        + "JOIN orders o on o.orderId = op.orderId\n"
                        + "JOIN employees e on e.idEmployee = o.employeeId\n"
                        + "JOIN warehouse wh on wh.id = e.idWarehouse\n"
                        + "JOIN orderdetails od on od.orderId = o.orderId\n"
                        + "WHERE wh.id = " + idWarehouse
                        + " GROUP by op.idPembelian ";
            }
            System.out.println("tumbas data source");
            System.out.println(query);
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

                PembelianModel pm = new PembelianModel();
                pm.setIdPembelian(idPembelian);
                pm.setIdSupervisor(idSupervisor);
                pm.setIdOrder(idOrder);
                pm.setStatus(Status);
                pm.setTanggalOrder(tanggalorder);
                pm.setTypeOrder(typeorder);

                if (idWarehouse == Statics.GET_ALL_PEMBELIAN) {
                    int warehouseId = rs.getInt("id");
                    String addresWarehouse = rs.getString("address");
                    pm.setAddresWarehouse(warehouse);

                    pm.setWarehouseId(warehouseId);
                }

                pm.setTotalBiaya(totalbiaya);
                BeliModel.add(pm);

            }

            System.out.println(BeliModel);
            return BeliModel;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    public int submitPembelian(int employeeId, String orderType, Date waktu, String statusOrder, ArrayList<KeranjangModel> keranjang, int wareHouseId) {

        int orderId = -1;

        try {
            db.openConnection();
            System.out.println("Pembelian Data Source");
            String waktuString = Parser.parseDateToStringSQL(waktu);
            //order pembelian 
//            orders
//            order details
//            product stok 

            //Eksekusi INSERT ke Tabel orders:
            String query = "INSERT INTO orders (employeeid, orderType, orderDate) VALUES ("
                    + employeeId + ", '" + orderType + "', '" + waktuString + "')";
            db.executeStatement(query);

            System.out.println("Pembelian Data Source");
            System.out.println(query);
            //Mengambil orderId Terakhir yang Baru Ditambahkan: lalu langsung add orderpembelian
//            ResultSet rs = db.getData("SELECT orderId AS last_id from orders order by orderId desc limit 1");
//            String sql = "iki order pembelian rek";
//            while (rs.next()) {
//                orderId = rs.getInt("last_id");
//                //Menambahkan Status ke Tabel orderpembelian:
//            }
//            if (orderId != -1) {
//                sql = "INSERT INTO orderpembelian  (status, orderId) VALUES ('" + statusOrder + "'," + orderId + " ) ";
//
//                db.executeStatement(sql);
//            }
            //orderpembelian
            queryOrderPembelian(statusOrder);

//           Setiap item dalam keranjang diproses dan dimasukkan ke dalam tabel detail pesanan melalui fungsi queryOrderDetails(km).
            for (KeranjangModel km : keranjang) {
                queryOrderDetails(km);
            }

            //
            for (KeranjangModel km : keranjang) {
                int productId = km.getProduk().getIdProduct();
                queryStokProduct(km.getQuantity(), waktu, productId, wareHouseId);
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return -1;
        } finally {
            db.closeConnection();
        }
        return 1;
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

    //nambah dikit Rapid D,
    public ArrayList<ProductModel> getDetailPantau() {
        try {
            ArrayList<ProductModel> dataResult = new ArrayList<>();
            db.openConnection();
            String query = "SELECT \n"
                    + "    p.idProduct, \n"
                    + "    p.productName, \n"
                    + "    p.description, \n"
                    + "    p.buyPrice, \n"
                    + "    p.sellPrice, \n"
                    + "    p.categoryId, \n"
                    + "    p.produsenId,\n"
                    + "    c.category, \n"
                    + "    prod.name, \n"
//                    + "    ps.totalStock, \n"
                    + "    ps.lastUpdate, \n"
                    + "    w.address\n"
                    + "FROM \n"
                    + "    product p\n"
                    + "JOIN \n"
                    + "    category c ON p.categoryId = c.idCategory\n"
                    + "JOIN \n"
                    + "    produsen prod ON prod.idProdusen = p.produsenId\n"
                    + "LEFT JOIN \n"
                    + "    productstock ps ON ps.productId = p.idProduct\n"
                    + "LEFT JOIN \n"
                    + "    warehouse w ON ps.idWarehouse = w.id\n"
                    + "WHERE prod.status='active' ";

            System.out.println("Product Active");
            System.out.println(query);
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
//                int totalstok = rs.getInt("totalStock");
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
//                product.setQuantityInStock(totalstok);
//                product.setQuantityInStock();
                product.setLastUpdate(lastUpdateProduct);
                product.setWarehouseName(warehouseAlamat);

                // Adding the product to the list
                dataResult.add(product);
            }

            System.out.println(query);
            return dataResult;

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return null;

        } finally {

            db.closeConnection();
        }
    }

    // Tutup koneksi
    private int queryOrderDetails(KeranjangModel itemkeranjang) throws SQLException {
        String querygetIdOrder = "SELECT o.orderId\n"
                + "FROM orders o\n"
                + "ORDER BY o.orderId DESC\n"
                + "LIMIT 1 ";
        ResultSet rs = db.getData(querygetIdOrder); //result set digunakan untuk menyimpan query dari getIdOrder

        int getIdOrder = -1; //membuat get order nilainya menjadi default
        while (rs.next()) {  // while (rs.next()) memastikan bahwa jika ada hasil, nilai orderId akan diambil dan disimpan dalam variabel getIdOrder.
            getIdOrder = rs.getInt("orderId"); //jika rs orderId mengembalikan hasil maka akan mngembalikan ke IdOrder
        }
        //item keranjang mengambil produk lalu mengalikan sellprice dengan quantiti yang ada didalam item keranjang
        long totaPrice = itemkeranjang.getProduk().getBuyPrice() * itemkeranjang.getQuantity();

        if (getIdOrder > 0) { //jik get order lebih dari 0 maka artinya valid
            String query = "INSERT INTO orderdetails \n"
                    + "(unitPrice, quantity, subTotalPrice, idProduct, orderId) \n"
                    + "VALUES (" + itemkeranjang.getProduk().getBuyPrice() + ", " + itemkeranjang.getQuantity() + ", \n"
                    + totaPrice + ", " + itemkeranjang.getProduk().getIdProduct() + "," + getIdOrder + ")";
            return db.executeStatement(query); // menggunakan db.excuteStatment unttuk mengeksekusi query
        }
        return getIdOrder; //jika getIdorder kurang dari 0 maka akan mengembalikan nilai getIdorder
    }

    private int queryOrderPembelian(String status) {
        try {
            String querygetIdOrder = "SELECT o.orderId\n"
                    + "FROM orders o\n"
                    + "ORDER BY o.orderId DESC\n"
                    + "LIMIT 1 ";
            ResultSet rs = db.getData(querygetIdOrder);

            int getIdOrder = 0;
            while (rs.next()) {
                getIdOrder = rs.getInt("orderId");
            }

            if (getIdOrder > 0) {
                String query = "INSERT INTO orderpembelian\n"
                        + "(status, orderId) \n"
                        + "VALUES ('" + status + "', " + getIdOrder + ")";
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

    private int queryStokProduct(int jumlahBeli, Date dateLastUpdate, int idProduct, int idWareHouse) {
        String waktuString = Parser.parseDateToStringSQL(dateLastUpdate);
        int stoksebelum = 0; //menyimpan stok produk sebelum pembaruan makannya dinamakan dengan stok sebelum dan diberi nilai 0
        try {
            String queryGetStok = "SELECT ps.totalStock FROM productstock ps\n"
                    + "WHERE ps.productId= " + idProduct + " AND ps.idWarehouse =" + idWareHouse;
            ResultSet rs = db.getData(queryGetStok); // hasil query akan disimpan di objek Resultset 

            while (rs.next()) { //jika query berhasil maka while akan mengambil nilai total stok dan akan disimpan di stoksebelum
                stoksebelum = rs.getInt("totalStock");
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage()); // Jika terjadi pengecualian selama eksekusi query, pesan kesalahan akan dicetak ke konsol, dan metode akan di kembalikan nilai 0.
            return 0;
        }

        int finishStock = stoksebelum + jumlahBeli; // finish stok akan menambhkan stoksebelum dengan jumlah beli

        String querySubmit = "UPDATE productstock ps\n"
                + "SET "
//                + "ps.totalStock =" + finishStock + " , "
                + "ps.lastUpdate ='" + waktuString + "'\n"
                + "WHERE ps.id =" + idProduct + " AND ps.idWarehouse = " + idWareHouse;

        int result = db.executeStatement(querySubmit);

        // if result is 0, then do create a new product stock
        //else return result
        if (result > 0) {
            return result;
        }

        String queryNewStock = "INSERT INTO \n"
                + "productstock (productId, totalStock, idWarehouse, lastUpdate) \n"
                + "VALUES(\n"
                + "    "+idProduct+", 0, "+idWareHouse+", '"+waktuString+"'\n"
                + ")";
        
        int resultCreateProductStock = db.executeStatement(queryNewStock);
        return resultCreateProductStock;

    }

}
