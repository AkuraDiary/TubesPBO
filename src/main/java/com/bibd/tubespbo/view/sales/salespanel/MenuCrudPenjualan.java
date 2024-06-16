/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bibd.tubespbo.view.sales.salespanel;

import com.bibd.tubespbo.Di;
import com.bibd.tubespbo.data.model.*;
import com.bibd.tubespbo.util.Formatter;
import com.bibd.tubespbo.util.Statics;
import com.bibd.tubespbo.util.Validator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.util.ArrayList;
import java.util.Arrays;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author HP VICTUS
 */
public class MenuCrudPenjualan extends javax.swing.JPanel {

    int idWarehouse;
    int idEmployee;

    /**
     * Creates new form MenuCrudPenjualan
     */
    private DefaultTableModel tableAllPenjualanModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //super.isCellEditable(row, column);
        }

    };
    private TableRowSorter<DefaultTableModel> tablePenjualanSorter = new TableRowSorter<>(tableAllPenjualanModel);

    private DefaultTableModel tableProductModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //super.isCellEditable(row, column);
        }

    };
    private TableRowSorter<DefaultTableModel> tableProductSorter = new TableRowSorter<>(tableProductModel);

    private DefaultTableModel tableKeranjangModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //super.isCellEditable(row, column);
        }

    };
    private TableRowSorter<DefaultTableModel> tableKeranjangsSorter = new TableRowSorter<>(tableKeranjangModel);

    public MenuCrudPenjualan() {
        initComponents();

        idWarehouse = Di.authPresenter.loggedInUser().getIdWarehouse();
        idEmployee = Di.authPresenter.loggedInUser().getId();
        setupTablePenjualan();
        setupTableProduct();
        setupTableKeranjang();

        setupCbPayment();
        setupCbPaymentUpdate();

        populateTablePenjualan();
        populateTableProduct();
        populateTableKeranjang();
        populateCbCustomer();

    }

    private ArrayList<String> listPaymentsStats = new ArrayList<>(
            Arrays.asList(
                    Statics.ORDER_PAYMENT_STATUS_UNPAID,
                    Statics.ORDER_PAYMENT_STATUS_PAID,
                    Statics.ORDER_PAYMENT_STATUS_CANCELLED
            )
    );

    private void setupCbPayment() {
        cbPayment.removeAllItems();
        for (String payment : listPaymentsStats) {
            cbPayment.addItem(payment);
        }
    }

    private void setupCbPaymentUpdate() {
        cbPaymentUpdate.removeAllItems();
        for (String payment : listPaymentsStats) {
            cbPaymentUpdate.addItem(payment);
        }
    }

    private void populateCbCustomer() {

        Di.manageCustomerPresenter.getAllCustomer(tfCustomerSearch.getText());
        cbCustomer.removeAllItems();

        for (CustomerModel cust : Di.manageCustomerPresenter.customerList) {
            cbCustomer.addItem(cust);
        }

    }

    private void populateTableKeranjang() {
        clearTable(tableKeranjangModel);
        if (Di.penjualanPresenter.keranjang.isEmpty()) {
            return;
        }
        for (KeranjangModel keranjangMdl : Di.penjualanPresenter.keranjang) {
            String[] row = {
                String.valueOf(keranjangMdl.getProduk().getIdProduct()),
                keranjangMdl.getProduk().getProductName(),
                String.valueOf(keranjangMdl.getProduk().getSellPrice()),
                String.valueOf(keranjangMdl.getQuantity())
            };
            tableKeranjangModel.addRow(row);
        }

    }

    private void clearTable(DefaultTableModel tblModel) {
        for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }

    }

    private void populateTablePenjualan() {

        Di.penjualanPresenter.historyPenjualan(idWarehouse, idEmployee);

        clearTable(tableAllPenjualanModel);

        for (PenjualanModel penjualanModel : Di.penjualanPresenter.history) {
            String[] row = {
                String.valueOf(penjualanModel.getIdPenjualan()),
                penjualanModel.getShipmentStatus(),
                penjualanModel.getCustomerName(), //.getNama(),
                penjualanModel.getTanggalOrder().toString(),
                penjualanModel.getStatusPayment(),
                Formatter.formatRupiah(penjualanModel.getTotalBiaya()),};
            tableAllPenjualanModel.addRow(row);
        }

    }

    private void setupTablePenjualan() {
        tOrderpenjualan.setModel(tableAllPenjualanModel);
        tableAllPenjualanModel.addColumn("Id Penjualan");
        tableAllPenjualanModel.addColumn("Shipment Status");
        tableAllPenjualanModel.addColumn("Customer");
        tableAllPenjualanModel.addColumn("Tanggal");
        tableAllPenjualanModel.addColumn("Status Pembayaran");
        tableAllPenjualanModel.addColumn("Total");
        tOrderpenjualan.getTableHeader().setReorderingAllowed(false);
        tOrderpenjualan.setRowSorter(tablePenjualanSorter);

        tablePenjualanSorter.setSortable(0, false);
        tablePenjualanSorter.setSortable(1, false);
        tablePenjualanSorter.setSortable(2, false);
        tablePenjualanSorter.setSortable(3, false);
    }

    private void populateTableProduct() {

        Di.penjualanPresenter.getAllProductWarehouse(idWarehouse);

        clearTable(tableProductModel);

        for (ProductModel productModel : Di.penjualanPresenter.allproduct) {

            System.out.println("Populate product model : " + productModel.getProductName() + " " + productModel.getQuantityInStock());
            if (productModel.getQuantityInStock() > 0) {
                String[] row = {
                    String.valueOf(productModel.getIdProduct()),
                    productModel.getProductName(),
                    String.valueOf(productModel.getSellPrice()),
                    String.valueOf(productModel.getQuantityInStock())
                };
                tableProductModel.addRow(row);
            }

        }
    }

    private void setupTableProduct() {
        tblAllProduk.setModel(tableProductModel);
        tableProductModel.addColumn("Id produk");
        tableProductModel.addColumn("Nama");
        tableProductModel.addColumn("Harga");
        tableProductModel.addColumn("Stok");
        tblAllProduk.getTableHeader().setReorderingAllowed(false);
        tblAllProduk.setRowSorter(tableProductSorter);

        tableProductSorter.setSortable(0, false);
        tableProductSorter.setSortable(1, false);
        tableProductSorter.setSortable(2, false);
        tableProductSorter.setSortable(3, false);
    }

    private void setupTableKeranjang() {
        tblKeranjang.setModel(tableKeranjangModel);
        tableKeranjangModel.addColumn("Id produk");
        tableKeranjangModel.addColumn("Nama");
        tableKeranjangModel.addColumn("Harga");
        tableKeranjangModel.addColumn("Qty");
        tblKeranjang.getTableHeader().setReorderingAllowed(false);
        tblKeranjang.setRowSorter(tableKeranjangsSorter);

        tableKeranjangsSorter.setSortable(0, false);
        tableKeranjangsSorter.setSortable(1, false);
        tableKeranjangsSorter.setSortable(2, false);
        tableKeranjangsSorter.setSortable(3, false);
    }

    private void resetFieldsCustomer() {
        tfNamaCustomer.setText("");
        tfAlamat.setText("");
        tfEmailCustomer.setText("");
        tfNohpcustomer.setText("");
    }

    private void resetFields() {
//        tfCreateidpenjualan.setText("");
        tfIdPenjualan.setText("");
        tfCustPenjualanUpdate.setText("");
        tfTotalPenjualanUpdate.setText("");
        tfQtyItem.setText("1");
        cbCustomer.setSelectedIndex(0);
        cbPaymentUpdate.setSelectedIndex(0);
        btnAddToKeranjang.setEnabled(false);
        btnRemoveFromKeranjang.setEnabled(false);
    }

    long totalKeranjang = 0;

    private void calculateTotalKeranjang() {
        totalKeranjang = 0;
        for (KeranjangModel item : Di.penjualanPresenter.keranjang) {
            totalKeranjang += item.getQuantity() * item.getProduk().getSellPrice();
        }
        tfTotalKeranjang.setText(Formatter.formatRupiah(totalKeranjang));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfNamaCustomer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfAlamat = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bBersihkan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllProduk = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKeranjang = new javax.swing.JTable();
        cbCustomer = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfEmailCustomer = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfNohpcustomer = new javax.swing.JTextField();
        btnAddToKeranjang = new javax.swing.JButton();
        tfCustomerSearch = new javax.swing.JTextField();
        bTambahCustomer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tOrderpenjualan = new javax.swing.JTable();
        cbPaymentUpdate = new javax.swing.JComboBox<>();
        tfCustomerPenjualan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfIdPenjualan = new javax.swing.JTextField();
        tfCustPenjualanUpdate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfTotalPenjualanUpdate = new javax.swing.JTextField();
        tfCustomerPenjualan1 = new javax.swing.JLabel();
        btnRemoveFromKeranjang = new javax.swing.JButton();
        tfQtyItem = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();
        tfTotalKeranjang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbPayment = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        lblDetaulSelectedPembelian = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textAreaDetailPemb = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CREATE PENJUALAN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("MENU  >  CRUD PENJUALAN");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("NamaCustomer:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Alamat:");

        bTambah.setBackground(new java.awt.Color(153, 255, 153));
        bTambah.setText("Checkout");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUpdate.setBackground(new java.awt.Color(153, 255, 255));
        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        bBersihkan.setText("Bersihkan");
        bBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBersihkanActionPerformed(evt);
            }
        });

        tblAllProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "idproduct", "Harga", "stok"
            }
        ));
        tblAllProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAllProduk);

        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "IdProduct", "Harga", "quantity"
            }
        ));
        tblKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeranjangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKeranjang);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Pilih Customer:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Email:");

        tfEmailCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailCustomerActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("NoHp:");

        tfNohpcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNohpcustomerActionPerformed(evt);
            }
        });

        btnAddToKeranjang.setBackground(new java.awt.Color(204, 204, 204));
        btnAddToKeranjang.setText(">>");
        btnAddToKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToKeranjangActionPerformed(evt);
            }
        });

        bTambahCustomer.setBackground(new java.awt.Color(204, 204, 204));
        bTambahCustomer.setText("Daftarkan");
        bTambahCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahCustomerActionPerformed(evt);
            }
        });

        tOrderpenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Penjualan", "Shipment Status", "Date Shipped", "Order id", "Customer id", "Status Pembayaran"
            }
        ));
        tOrderpenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tOrderpenjualanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tOrderpenjualan);

        tfCustomerPenjualan.setText("Customer");

        jLabel12.setText("id");

        tfIdPenjualan.setEnabled(false);
        tfIdPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPenjualanActionPerformed(evt);
            }
        });

        tfCustPenjualanUpdate.setEnabled(false);

        jLabel13.setText("Payment");

        tfTotalPenjualanUpdate.setEnabled(false);

        tfCustomerPenjualan1.setText("Total");

        btnRemoveFromKeranjang.setBackground(new java.awt.Color(204, 204, 204));
        btnRemoveFromKeranjang.setText("<<");
        btnRemoveFromKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromKeranjangActionPerformed(evt);
            }
        });

        tfQtyItem.setText("1");

        btnSearchCustomer.setBackground(new java.awt.Color(153, 255, 153));
        btnSearchCustomer.setText("Cari");
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        tfTotalKeranjang.setEnabled(false);

        jLabel4.setText("Total Keranjang");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Payment");

        lblDetaulSelectedPembelian.setText("Detail Penjualan");

        jLabel6.setText("Product Name - Qty - Total");

        textAreaDetailPemb.setColumns(20);
        textAreaDetailPemb.setRows(5);
        textAreaDetailPemb.setEnabled(false);
        jScrollPane4.setViewportView(textAreaDetailPemb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bBersihkan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTambah)
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbPayment, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCustomer, javax.swing.GroupLayout.Alignment.TRAILING, 0, 138, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchCustomer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfQtyItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveFromKeranjang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddToKeranjang, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTotalKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblDetaulSelectedPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(tfCustomerPenjualan)
                            .addComponent(jLabel13)
                            .addComponent(tfCustomerPenjualan1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTotalPenjualanUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfCustPenjualanUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bUpdate)
                                .addComponent(cbPaymentUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel11)))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNohpcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfEmailCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bTambahCustomer)))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(1, 1, 1)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(52, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(tfIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfCustomerPenjualan)
                                    .addComponent(tfCustPenjualanUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfTotalPenjualanUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCustomerPenjualan1))
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbPaymentUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bUpdate))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblDetaulSelectedPembelian)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(tfNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(tfEmailCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNohpcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTambahCustomer)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(tfCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSearchCustomer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bTambah)
                                    .addComponent(bBersihkan))
                                .addGap(45, 45, 45))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfTotalKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addComponent(btnAddToKeranjang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQtyItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveFromKeranjang)
                        .addGap(61, 61, 61))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailCustomerActionPerformed

    private void tfNohpcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNohpcustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNohpcustomerActionPerformed

    private void tfIdPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPenjualanActionPerformed

    private void btnAddToKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToKeranjangActionPerformed
        try {
            int qty = Integer.parseInt(tfQtyItem.getText());
            Di.penjualanPresenter.masukKeranjang(Di.penjualanPresenter.produkModel, qty);
            if(!Di.penjualanPresenter.stockAvailable){
                showMessageDialog(this, "Stock tidak mencukupi");
                return;
            }
            populateTableKeranjang();
            populateTableProduct();

            calculateTotalKeranjang();
        } catch (Exception e) {
            showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnAddToKeranjangActionPerformed

    private void btnRemoveFromKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromKeranjangActionPerformed
        // TODO add your handling code here:
        try {
            int qty = Integer.parseInt(tfQtyItem.getText());
            Di.penjualanPresenter.keluarItemKeranjang(Di.penjualanPresenter.keranjangModel.getProduk().getIdProduct(), qty);
            populateTableKeranjang();
            populateTableProduct();

            calculateTotalKeranjang();
        } catch (Exception e) {
            showMessageDialog(this, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_btnRemoveFromKeranjangActionPerformed

    private void tblAllProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllProdukMouseClicked
        Di.penjualanPresenter.keranjangModel = null;
        int row = tblAllProduk.getSelectedRow();

        int idProduct = Integer.parseInt(tblAllProduk.getValueAt(row, 0).toString());

        Di.penjualanPresenter.setSelectedAllProduct(
                idProduct
        );

        btnRemoveFromKeranjang.setEnabled(false);
        btnAddToKeranjang.setEnabled(true);

    }//GEN-LAST:event_tblAllProdukMouseClicked

    private void tblKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeranjangMouseClicked

        Di.penjualanPresenter.produkModel = null;
        int row = tblKeranjang.getSelectedRow();

        int idProduct = Integer.parseInt(tblKeranjang.getValueAt(row, 0).toString());

        Di.penjualanPresenter.setSelectedKeranjang(
                idProduct
        );

        btnRemoveFromKeranjang.setEnabled(true);
        btnAddToKeranjang.setEnabled(false);
    }//GEN-LAST:event_tblKeranjangMouseClicked

    private void bTambahCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahCustomerActionPerformed
        // TODO add your handling code here

        if (formCustomerIsValid()) {
            CustomerModel cm = new CustomerModel();
            cm.setNama(tfNamaCustomer.getText());
            cm.setAlamat(tfAlamat.getText());
            cm.setEmail(tfEmailCustomer.getText());
            cm.setNoHp(tfNohpcustomer.getText());
            Di.manageCustomerPresenter.addNewCustomer(
                    cm
            );

            if (Di.manageCustomerPresenter.statusAddNewCust > 0) {
                showMessageDialog(null, "Customer Ditambahkan !");
                populateCbCustomer();
                Di.manageCustomerPresenter.resetManageCustomer();
                resetFieldsCustomer();
                populateTablePenjualan();
                populateTableProduct();
                return;
            }
            showMessageDialog(null, "Terjadi Error");

        }
    }//GEN-LAST:event_bTambahCustomerActionPerformed

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed

        populateCbCustomer();
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void bBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBersihkanActionPerformed
        // confirmation dialog
        int dialogResult = JOptionPane.showConfirmDialog(null, "Ini akan menghapus semua item di keranjang", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION) {
            return;
        }
        Di.penjualanPresenter.resetClearKeranjang();
        populateTableKeranjang();
        populateTableProduct();
        calculateTotalKeranjang();
        resetFields();
        Di.penjualanPresenter.resetCheckout();

    }//GEN-LAST:event_bBersihkanActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // show confirmation dialog
        if (Di.penjualanPresenter.keranjang.isEmpty()) {
            showMessageDialog(null, "Keranjang Kosong");
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Saving code here
            int customerId = ((CustomerModel) cbCustomer.getSelectedItem()).getIdCustomer();

            Di.penjualanPresenter.checkOut(
                    customerId,
                    idEmployee,
                    Di.penjualanPresenter.keranjang,
                    cbPaymentUpdate.getSelectedItem().toString(),
                    Statics.SHIPMENT_STATUS_PENDING,
                    idWarehouse
            );
            if (Di.penjualanPresenter.statusCheckout > 0) {
                showMessageDialog(null, "Checkout Berhasil !");
                Di.penjualanPresenter.resetCheckout();
                Di.penjualanPresenter.resetClearKeranjang();
                populateTablePenjualan();
                populateTableProduct();
                populateTableKeranjang();
                resetFields();
                return;
            }
            showMessageDialog(null, "Terjadi Error");
        }
    }//GEN-LAST:event_bTambahActionPerformed

    private void tOrderpenjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tOrderpenjualanMouseClicked
        int row = tOrderpenjualan.getSelectedRow();
        int idPenjualan = Integer.parseInt(tOrderpenjualan.getValueAt(row, 0).toString());
        Di.penjualanPresenter.setSelectedPenjualan(idPenjualan);

        PenjualanModel pm = Di.penjualanPresenter.selectedPenjualan;
        tfCustPenjualanUpdate.setText(pm.getCustomerName());
        tfIdPenjualan.setText(String.valueOf(pm.getIdPenjualan()));
        tfTotalPenjualanUpdate.setText(Formatter.formatRupiah(pm.getTotalBiaya()));
        cbPaymentUpdate.setSelectedItem(pm.getStatusPayment());

        cbPaymentUpdate.setEnabled(pm.getStatusPayment().equals(Statics.ORDER_PAYMENT_STATUS_UNPAID));

        textAreaDetailPemb.setText("");
        for (OrderDetailsModel itemDetail : Di.penjualanPresenter.selectedPenjualanDetail) {
            System.out.println("Selected Detail : " + itemDetail.getProductName());
            // show the detail of selected pembelian
            // product name, price, and qty
            // show all the data in one label, separated by new line
            textAreaDetailPemb.setText(
                    textAreaDetailPemb.getText() + itemDetail.getProductName() + " - " + itemDetail.getQuantity() + " - " + itemDetail.getTotalPrice() + "\n"
            );
        }

    }//GEN-LAST:event_tOrderpenjualanMouseClicked

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed

        if (Di.penjualanPresenter.selectedPenjualan == null) {
            showMessageDialog(null, "Pilih Penjualan Terlebih Dahulu");
            return;
        }

        Di.penjualanPresenter.updatePayment(
                Integer.parseInt(tfIdPenjualan.getText()),
                cbPaymentUpdate.getSelectedItem().toString()
        );

        if (Di.penjualanPresenter.statusUpdatePayment > 0) {
            showMessageDialog(null, "Update Berhasil !");
            populateTablePenjualan();
            Di.penjualanPresenter.resetUpdatePayment();
            populateTableKeranjang();
            resetFields();
            return;
        }
        showMessageDialog(null, "Terjadi Error");

    }//GEN-LAST:event_bUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBersihkan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTambahCustomer;
    private javax.swing.JButton bUpdate;
    private javax.swing.JButton btnAddToKeranjang;
    private javax.swing.JButton btnRemoveFromKeranjang;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JComboBox<CustomerModel> cbCustomer;
    private javax.swing.JComboBox<String> cbPayment;
    private javax.swing.JComboBox<String> cbPaymentUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblDetaulSelectedPembelian;
    private javax.swing.JTable tOrderpenjualan;
    private javax.swing.JTable tblAllProduk;
    private javax.swing.JTable tblKeranjang;
    private javax.swing.JTextArea textAreaDetailPemb;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfCustPenjualanUpdate;
    private javax.swing.JLabel tfCustomerPenjualan;
    private javax.swing.JLabel tfCustomerPenjualan1;
    private javax.swing.JTextField tfCustomerSearch;
    private javax.swing.JTextField tfEmailCustomer;
    private javax.swing.JTextField tfIdPenjualan;
    private javax.swing.JTextField tfNamaCustomer;
    private javax.swing.JTextField tfNohpcustomer;
    private javax.swing.JTextField tfQtyItem;
    private javax.swing.JTextField tfTotalKeranjang;
    private javax.swing.JTextField tfTotalPenjualanUpdate;
    // End of variables declaration//GEN-END:variables

    private boolean formCustomerIsValid() {
        boolean valid = false;
        if (tfNamaCustomer.getText().isBlank()) {
            showMessageDialog(null, "Nama Customer Tidak Boleh Kosong");
            return valid;
        }
        if (tfAlamat.getText().isBlank()) {
            showMessageDialog(null, "Alamat Customer Tidak Boleh Kosong");
            return valid;
        }
        if (tfEmailCustomer.getText().isBlank()) {
            showMessageDialog(null, "Email Customer Tidak Boleh Kosong");
            return valid;
        }
        if (tfNohpcustomer.getText().isBlank()) {
            showMessageDialog(null, "No Hp Customer Tidak Boleh Kosong");
            return valid;
        }
        if (!Validator.isValidEmail(tfEmailCustomer.getText())) {
            showMessageDialog(null, "Email Tidak Valid");
            return valid;
        }

        return !valid;
    }
}
