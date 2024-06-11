/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bibd.tubespbo.view.sales.salespanel;

import com.bibd.tubespbo.Di;
import com.bibd.tubespbo.data.model.CustomerModel;
import com.bibd.tubespbo.data.model.PenjualanModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP VICTUS
 */
public class MenuCrudPenjualan extends javax.swing.JPanel {

    int idWarehouse ;
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
        idWarehouse = Di.authPresenter.loggedInUser().getIdWarehouse();
        idEmployee = Di.authPresenter.loggedInUser().getId();

        initComponents();
        setupTablePenjualan();
        setupTableProduct();
        setupTableKeranjang();
        
        populateTablePenjualan();
        populateTableProduct();
        populateTableKeranjang();
        
    }

    private void populateTableKeranjang() {
    }

    private void populateTableProduct() {
        
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
                    penjualanModel.getStatusPayment()
            };
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
        tOrderpenjualan.getTableHeader().setReorderingAllowed(false);
        tOrderpenjualan.setRowSorter(tablePenjualanSorter);

        tablePenjualanSorter.setSortable(0, false);
        tablePenjualanSorter.setSortable(1, false);
        tablePenjualanSorter.setSortable(2, false);
        tablePenjualanSorter.setSortable(3, false);
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
        tblAllProduk.setModel(tableProductModel);
        tableProductModel.addColumn("Id produk");
        tableProductModel.addColumn("Nama");
        tableProductModel.addColumn("Harga");
        tableProductModel.addColumn("Qty");
        tblAllProduk.getTableHeader().setReorderingAllowed(false);
        tblAllProduk.setRowSorter(tableProductSorter);

        tableProductSorter.setSortable(0, false);
        tableProductSorter.setSortable(1, false);
        tableProductSorter.setSortable(2, false);
        tableProductSorter.setSortable(3, false);
    }

    private void resetFieldsCustomer(){
        tfNamaCustomer.setText("");
        tfAlamat.setText("");
        tfEmailCustomer.setText("");
        tfNohpcustomer.setText("");
    }
    private  void resetFields(){
        tfCreateidpenjualan.setText("");
     
        tfIdPenjualan.setText("");
        tfCustPenjualan.setText("");
        tfTotal.setText("");
        tfQtyItem.setText("1");
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
        jLabel3 = new javax.swing.JLabel();
        tfCreateidpenjualan = new javax.swing.JTextField();
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
        jComboBox2 = new javax.swing.JComboBox<>();
        tfCustomerPenjualan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfIdPenjualan = new javax.swing.JTextField();
        tfCustPenjualan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfTotal = new javax.swing.JTextField();
        tfCustomerPenjualan1 = new javax.swing.JLabel();
        btnRemoveFromKeranjang = new javax.swing.JButton();
        tfQtyItem = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CREATE PENJUALAN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("MENU  >  CRUD PENJUALAN");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("IdPenjualan:");

        tfCreateidpenjualan.setEnabled(false);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("NamaCustomer:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Alamat:");

        bTambah.setBackground(new java.awt.Color(153, 255, 153));
        bTambah.setText("Tambah");

        bUpdate.setBackground(new java.awt.Color(153, 255, 255));
        bUpdate.setText("Update");

        bBersihkan.setText("Bersihkan");

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
        bTambahCustomer.setText("Tambah");

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
        jScrollPane3.setViewportView(tOrderpenjualan);

        tfCustomerPenjualan.setText("Customer");

        jLabel12.setText("id");

        tfIdPenjualan.setEnabled(false);
        tfIdPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPenjualanActionPerformed(evt);
            }
        });

        tfCustPenjualan.setEnabled(false);

        jLabel13.setText("Payment");

        tfTotal.setEnabled(false);

        tfCustomerPenjualan1.setText("Total");

        btnRemoveFromKeranjang.setBackground(new java.awt.Color(204, 204, 204));
        btnRemoveFromKeranjang.setText("<<");
        btnRemoveFromKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromKeranjangActionPerformed(evt);
            }
        });

        btnSearchCustomer.setBackground(new java.awt.Color(153, 255, 153));
        btnSearchCustomer.setText("Cari");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfCreateidpenjualan)
                                    .addComponent(cbCustomer, 0, 138, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bBersihkan)
                                .addGap(9, 9, 9)
                                .addComponent(bTambah)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchCustomer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfQtyItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemoveFromKeranjang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddToKeranjang, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12)
                                .addComponent(tfCustomerPenjualan)
                                .addComponent(jLabel13))
                            .addComponent(tfCustomerPenjualan1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfCustPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bUpdate)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNamaCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5))
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
                        .addContainerGap(41, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCustomerPenjualan)
                            .addComponent(tfCustPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCustomerPenjualan1))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdate)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfCreateidpenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(tfCustomerSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchCustomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bBersihkan)
                            .addComponent(bTambah)))
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
                        .addComponent(bTambahCustomer)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddToKeranjangActionPerformed

    private void btnRemoveFromKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromKeranjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveFromKeranjangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBersihkan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTambahCustomer;
    private javax.swing.JButton bUpdate;
    private javax.swing.JButton btnAddToKeranjang;
    private javax.swing.JButton btnRemoveFromKeranjang;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JComboBox<String> cbCustomer;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tOrderpenjualan;
    private javax.swing.JTable tblAllProduk;
    private javax.swing.JTable tblKeranjang;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfCreateidpenjualan;
    private javax.swing.JTextField tfCustPenjualan;
    private javax.swing.JLabel tfCustomerPenjualan;
    private javax.swing.JLabel tfCustomerPenjualan1;
    private javax.swing.JTextField tfCustomerSearch;
    private javax.swing.JTextField tfEmailCustomer;
    private javax.swing.JTextField tfIdPenjualan;
    private javax.swing.JTextField tfNamaCustomer;
    private javax.swing.JTextField tfNohpcustomer;
    private javax.swing.JTextField tfQtyItem;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
