/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bibd.tubespbo.view.supervisor.supervisorpanels;

import com.bibd.tubespbo.Di;
import com.bibd.tubespbo.data.model.KeranjangModel;
import com.bibd.tubespbo.data.model.PembelianModel;
import com.bibd.tubespbo.data.model.ProductModel;
import com.bibd.tubespbo.util.Formatter;
import com.bibd.tubespbo.util.Statics;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP VICTUS
 */
public class MenuCreatePembelian extends javax.swing.JPanel {

    int idWarehouse;
    int idEmployee;

    /**
     * Creates new form MenuCreatePembelian
     */
    private DefaultTableModel tableAllPembelianModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //super.isCellEditable(row, column);
        }

    };

    private TableRowSorter<DefaultTableModel> tablePembelianSorter = new TableRowSorter<>(tableAllPembelianModel);

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

    public MenuCreatePembelian() {
        initComponents();

        idWarehouse = Di.authPresenter.loggedInUser().getIdWarehouse();
        idEmployee = Di.authPresenter.loggedInUser().getId();
        setupTablepembelian();
        setupTableProduct();
        setupTableKeranjang();

        setupCbStatus();

        populateTablePembelian();
        populateTableKeranjang();
        populateTableProduct();

    }

    private ArrayList<String> listPembelianstatus = new ArrayList<>(
            Arrays.asList(
                    Statics.PEMBELIAN_STATUS_PENDING,
                    Statics.PEMBELIAN_STATUS_FINNISH,
                    Statics.PEMBELIAN_STATUS_RUNNING
            )
    );

    private void setupCbStatus() {
        cbStatusUpdate.removeAllItems();
        for (String payment : listPembelianstatus) {
            cbStatusUpdate.addItem(payment);
        }
    }

    private void populateTableKeranjang() {
        clearTable(tableKeranjangModel);
//        if (Di.pembelianPresenter.keranjang.isEmpty()) {
//            return;
//        }
        for (KeranjangModel keranjangMdl : Di.pembelianPresenter.keranjang) {
            String[] row = {
                String.valueOf(keranjangMdl.getProduk().getIdProduct()),
                keranjangMdl.getProduk().getProductName(),
                String.valueOf(keranjangMdl.getProduk().getBuyPrice()),
                String.valueOf(keranjangMdl.getQuantity())
            };
            tableKeranjangModel.addRow(row);
        }
        //showMessageDialog(null, " tes table keranjang");
        

    }

    private void clearTable(DefaultTableModel tblModel) {
        for (int i = tblModel.getRowCount() - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }

    }

    private void populateTablePembelian() {

        Di.pembelianPresenter.getHistoryPembelian(idWarehouse);

        clearTable(tableAllPembelianModel);
//ada salah
        for (PembelianModel pm : Di.pembelianPresenter.history) {
            String[] row = {
                String.valueOf(pm.getIdPembelian()),
                String.valueOf(pm.getTanggalOrder()), //.getNama()
                pm.getStatus().toString(),
//                String.valueOf(pm.getTotalBiaya()),
                Formatter.formatRupiah(pm.getTotalBiaya()),
                String.valueOf(pm.getIdOrder())
                
            };
           
            tableAllPembelianModel.addRow(row);
        }
//        showMessageDialog(null, " tes beli tab");

    }

    private void setupTablepembelian() {
        tDatapembelian.setModel(tableAllPembelianModel);
        tableAllPembelianModel.addColumn("IdPembelian");
        tableAllPembelianModel.addColumn("Tanggal");
        tableAllPembelianModel.addColumn("Status");
        tableAllPembelianModel.addColumn("Total");
        tableAllPembelianModel.addColumn("OrderId");
        tDatapembelian.getTableHeader().setReorderingAllowed(false);
        tDatapembelian.setRowSorter(tablePembelianSorter);

        tablePembelianSorter.setSortable(0, false);
        tablePembelianSorter.setSortable(1, false);
        tablePembelianSorter.setSortable(2, false);
        tablePembelianSorter.setSortable(3, false);
    }

    private void populateTableProduct() {

        Di.pembelianPresenter.showAllproduct();

        clearTable(tableProductModel);

        for (ProductModel productModel : Di.pembelianPresenter.allproduct) {
            String[] row = {
                String.valueOf(productModel.getIdProduct()),
                productModel.getProductName(),
                String.valueOf(productModel.getBuyPrice()),
//                String.valueOf(productModel.getQuantityInStock())
            };
            tableProductModel.addRow(row);
        }//showMessageDialog(null, " tes tab produj");
    }

    private void setupTableProduct() {
        tblAllProduk.setModel(tableProductModel);
        tableProductModel.addColumn("Id produk");
        tableProductModel.addColumn("Nama");
        tableProductModel.addColumn("Harga");
//        tableProductModel.addColumn("Stok");
        tblAllProduk.getTableHeader().setReorderingAllowed(false);
        tblAllProduk.setRowSorter(tableProductSorter);

        tableProductSorter.setSortable(0, false);
        tableProductSorter.setSortable(1, false);
        tableProductSorter.setSortable(2, false);
//        tableProductSorter.setSortable(3, false);
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

    private void resetFields() {
        cbStatusUpdate.setSelectedIndex(0);
        tfQtyItem.setText("1");
        calculateTotalKeranjang();
    }
    
    private void resetFieldsUpdate(){
        cbStatusUpdate.setSelectedIndex(0);
        tfIdpembelian.setText("");
        tfTanggalUpdate.setText("");

    }

    long totalKeranjang = 0;

    private void calculateTotalKeranjang() {
        totalKeranjang = 0;
        for (KeranjangModel item : Di.pembelianPresenter.keranjang) {
            totalKeranjang += item.getQuantity() * item.getProduk().getBuyPrice();
        }
        tfTotalkeranjang.setText(Formatter.formatRupiah(totalKeranjang));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllProduk = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKeranjang = new javax.swing.JTable();
        tfQtyItem = new javax.swing.JTextField();
        btnAddToKeranjang = new javax.swing.JButton();
        btnRemoveFromKeranjang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfIdpembelian = new javax.swing.JTextField();
        bSubmit = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tDatapembelian = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cbStatusUpdate = new javax.swing.JComboBox<>();
        bUpdate = new javax.swing.JButton();
        tfTotalkeranjang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTanggalUpdate = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CREATE PEMBELIAN");

        tblAllProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Product", "Nama", "Harga", "Stok"
            }
        ));
        tblAllProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAllProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAllProduk);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("MENU  >  CREATE PEMBELIAN");

        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Product", "Nama", "Harga", "Quantity"
            }
        ));
        tblKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeranjangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKeranjang);

        tfQtyItem.setText("1");

        btnAddToKeranjang.setText(">>");
        btnAddToKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToKeranjangActionPerformed(evt);
            }
        });

        btnRemoveFromKeranjang.setText("<<");
        btnRemoveFromKeranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromKeranjangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("IdPembelian:");

        tfIdpembelian.setEnabled(false);

        bSubmit.setBackground(new java.awt.Color(153, 255, 153));
        bSubmit.setText("Submit");
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitActionPerformed(evt);
            }
        });

        btnClean.setText("Bersihkan");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        tDatapembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IdPembelian", "Tanggal", "Status", "Total", "OrderId"
            }
        ));
        tDatapembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tDatapembelianMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tDatapembelian);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Status:");

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("TotalKeranjang:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tanggal:");

        tfTanggalUpdate.setEnabled(false);
        tfTanggalUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTanggalUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(26, 26, 26)
                                .addComponent(tfTanggalUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfIdpembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bUpdate)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(cbStatusUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(btnClean)
                        .addGap(65, 65, 65)
                        .addComponent(bSubmit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnAddToKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfQtyItem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnRemoveFromKeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfTotalkeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfTanggalUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfIdpembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbStatusUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdate)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClean)
                    .addComponent(bSubmit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfTotalkeranjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddToKeranjang)
                                .addGap(18, 18, 18)
                                .addComponent(tfQtyItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemoveFromKeranjang))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(106, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblAllProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAllProdukMouseClicked
        // TODO add your handling code here:
        Di.pembelianPresenter.keranjangModel = null;
        int row = tblAllProduk.getSelectedRow();

        int idProduct = Integer.parseInt(tblAllProduk.getValueAt(row, 0).toString());

        Di.pembelianPresenter.setSelectedAllProduct(
                idProduct
        );

        btnRemoveFromKeranjang.setEnabled(false);
        btnAddToKeranjang.setEnabled(true);
    }//GEN-LAST:event_tblAllProdukMouseClicked

    private void btnAddToKeranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToKeranjangActionPerformed
        // TODO add your handling code here:
        try {
            int qty = Integer.parseInt(tfQtyItem.getText());
            Di.pembelianPresenter.masukKeranjang(Di.pembelianPresenter.produkModel, qty);
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
            Di.pembelianPresenter.keluarItemKeranjang(Di.pembelianPresenter.keranjangModel.getProduk().getIdProduct(), qty);
            populateTableKeranjang();
            populateTableProduct();

            calculateTotalKeranjang();
        } catch (Exception e) {
            showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRemoveFromKeranjangActionPerformed

    private void tblKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeranjangMouseClicked
        // TODO add your handling code here:
        Di.pembelianPresenter.produkModel = null;
        int row = tblKeranjang.getSelectedRow();

        int idProduct = Integer.parseInt(tblKeranjang.getValueAt(row, 0).toString());

        Di.pembelianPresenter.setSelectedKeranjang(
                idProduct
        );

        btnRemoveFromKeranjang.setEnabled(true);
        btnAddToKeranjang.setEnabled(false);
    }//GEN-LAST:event_tblKeranjangMouseClicked

    private void bSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitActionPerformed
        // TODO add your handling code here:
        if (Di.pembelianPresenter.keranjang.isEmpty()) {
            showMessageDialog(null, "Keranjang Kosong");
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            // Saving code here

            Di.pembelianPresenter.submitPembelian(idEmployee, idWarehouse);
//                    customerId,
//                  idPembelian,
//                    Di.pembelianPresenter.keranjang,
//                    cbStatusUpdate.getSelectedItem().toString(),
//                    Statics.SHIPMENT_STATUS_PENDING,
//                    idWarehouse
//           );
            if (Di.pembelianPresenter.statusSubmitPembelian > 0) {
                showMessageDialog(null, "Submit Berhasil !");
                Di.pembelianPresenter.resetStatusPembelian();
//                showMessageDialog(null, "reset status Berhasil");
                Di.pembelianPresenter.resetClearKeranjang();
//                showMessageDialog(null, "reset keranjang Berhasil");
                populateTablePembelian();
//                showMessageDialog(null, " tabel beli Berhasil");
                populateTableProduct();
//                showMessageDialog(null, " tabel produk Berhasil");
                populateTableKeranjang();
//                showMessageDialog(null, " tabel keranjang Berhasil");
                resetFields();
//                showMessageDialog(null, " reset fiekd Berhasil");
                return;
            }
            showMessageDialog(null, "Terjadi Error");
        }
    }//GEN-LAST:event_bSubmitActionPerformed

    private void tDatapembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatapembelianMouseClicked
        // TODO add your handling code here:
        int row = tDatapembelian.getSelectedRow();
        int idPembelian = Integer.parseInt(tDatapembelian.getValueAt(row, 0).toString());
        Di.pembelianPresenter.setSelectedPembelian(idPembelian);

        PembelianModel pm = Di.pembelianPresenter.selectedPembelian;
        tfIdpembelian.setText(String.valueOf(pm.getIdPembelian()));
        tfTanggalUpdate.setText(String.valueOf(pm.getTanggalOrder()));
        cbStatusUpdate.setSelectedItem(pm.getStatus());
    }//GEN-LAST:event_tDatapembelianMouseClicked

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        Di.pembelianPresenter.updateStatusPembelian(
                Integer.parseInt(tfIdpembelian.getText()),
                cbStatusUpdate.getSelectedItem().toString()
        );

        if (Di.pembelianPresenter.statusUpdatePembelian > 0) {
            showMessageDialog(null, "Update Berhasil !");
            populateTablePembelian();
            Di.pembelianPresenter.resetStatusPembelian();
            populateTableKeranjang();
            resetFields();
            resetFieldsUpdate();
            return;
        }
        showMessageDialog(null, "Terjadi Error");
    }//GEN-LAST:event_bUpdateActionPerformed

    private void tfTanggalUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTanggalUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTanggalUpdateActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        // confirmation dialog
        int dialogResult = JOptionPane.showConfirmDialog(null, "Ini akan menghapus semua item di keranjang", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.NO_OPTION) {
            return;
        }
        Di.pembelianPresenter.resetClearKeranjang();
        populateTableKeranjang();
        populateTableProduct();
        calculateTotalKeranjang();
        resetFields();
        Di.pembelianPresenter.resetStatusPembelian();// TODO add your handling code here:
    }//GEN-LAST:event_btnCleanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSubmit;
    private javax.swing.JButton bUpdate;
    private javax.swing.JButton btnAddToKeranjang;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnRemoveFromKeranjang;
    private javax.swing.JComboBox<String> cbStatusUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tDatapembelian;
    private javax.swing.JTable tblAllProduk;
    private javax.swing.JTable tblKeranjang;
    private javax.swing.JTextField tfIdpembelian;
    private javax.swing.JTextField tfQtyItem;
    private javax.swing.JTextField tfTanggalUpdate;
    private javax.swing.JTextField tfTotalkeranjang;
    // End of variables declaration//GEN-END:variables
}
