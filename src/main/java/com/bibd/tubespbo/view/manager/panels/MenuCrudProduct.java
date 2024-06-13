/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bibd.tubespbo.view.manager.panels;

import com.bibd.tubespbo.Di;
import com.bibd.tubespbo.data.model.*;
import com.bibd.tubespbo.util.Validator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author HP VICTUS
 */
public class MenuCrudProduct extends javax.swing.JPanel {

    /**
     * Creates new form MenuCrudProduct
     */
    public MenuCrudProduct() {
        initComponents();
        setupCategoryProduct();
        setupCbProdusen();
        setupTableProduct();

        populateTableProduct();
    }

    private DefaultTableModel tableProductModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //super.isCellEditable(row, column);
        }

    };
    private TableRowSorter<DefaultTableModel> tableProductSorter = new TableRowSorter<>(tableProductModel);

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfIdProduct = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tViewdataproduct = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfStok = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfHargajual = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfHargabeli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bCreateProduct = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        taProductDesc = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        tfidProductsearch = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bUpdate = new javax.swing.JButton();
        bBersihkan = new javax.swing.JButton();
        cbCategory = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbProdusen = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("CREATE UPDATE AND DELETE PRODUCT");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("idProduct: ");

        tfIdProduct.setEnabled(false);

        tViewdataproduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idProduct", "Nama", "Kategori", "Stok", "HargaJual", "HargaBeli", "lastUpdate", "Deskripsi"
            }
        ));
        tViewdataproduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tViewdataproductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tViewdataproduct);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("NamaProduct: ");

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Stok: ");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Harga Jual: ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Harga Beli: ");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Deskripsi: ");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Kategori:");

        bCreateProduct.setBackground(new java.awt.Color(153, 255, 153));
        bCreateProduct.setText("Add");
        bCreateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateProductActionPerformed(evt);
            }
        });

        taProductDesc.setColumns(20);
        taProductDesc.setRows(5);
        jScrollPane2.setViewportView(taProductDesc);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Cari Produk");

        tfidProductsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidProductsearchActionPerformed(evt);
            }
        });

        btnSearchProduct.setBackground(new java.awt.Color(153, 255, 255));
        btnSearchProduct.setText("Search");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("MENU > CRUD Product");

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Produsen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfHargajual, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfHargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfidProductsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchProduct))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(cbProdusen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bBersihkan)
                                    .addComponent(bCreateProduct)
                                    .addComponent(bUpdate)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11)
                    .addComponent(cbProdusen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHargajual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHargabeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(tfidProductsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearchProduct))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(bCreateProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bBersihkan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void bCreateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateProductActionPerformed
        ProductModel pm = new ProductModel();


        long hargaBeli = Integer.parseInt(tfHargabeli.getText());
        long hargaJual = Integer.parseInt(tfHargajual.getText());
//        int intProduct = Integer.parseInt(tfIdProduct.getText());
        String namaProduct = tfNama.getText();
        int stock = Integer.parseInt(tfStok.getText());
        String productDesc = taProductDesc.getText();
        int idCategory =((CategoryModel) cbCategory.getSelectedItem()).getIdCategory();
        int idProdusen = ((ProdusenModel) cbProdusen.getSelectedItem()).getIdProdusen();

        if(!formIsValid()){
            return;
        }
        pm.setProductName(namaProduct);
        pm.setQuantityInStock(stock);
        pm.setSellPrice(hargaJual);
        pm.setBuyPrice(hargaBeli);
        pm.setDescription(productDesc);
        pm.setCategoryId(idCategory);
        pm.setProdusenId(idProdusen);

        Di.manageProductPresenter.addNewProduct(pm);

        int result = Di.manageProductPresenter.stateAddProduct;
        if (result <= 0) {
            System.out.println("Error ");
            return;
        }
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan!");
        Di.manageProductPresenter.resetResult();
        resetField();
        populateTableProduct();
        
    }//GEN-LAST:event_bCreateProductActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        ProductModel pm = Di.manageProductPresenter.selectedProduct;


        long hargaBeli = Integer.parseInt(tfHargabeli.getText());
        long hargaJual = Integer.parseInt(tfHargajual.getText());
//        int intProduct = Integer.parseInt(tfIdProduct.getText());
        String namaProduct = tfNama.getText();
        int stock = Integer.parseInt(tfStok.getText());
        String productDesc = taProductDesc.getText();
        int idCategory =((CategoryModel) cbCategory.getSelectedItem()).getIdCategory();
        int idProdusen = ((ProdusenModel) cbProdusen.getSelectedItem()).getIdProdusen();

        if(!formIsValid()){
            return;
        }
        pm.setProductName(namaProduct);
        pm.setQuantityInStock(stock);
        pm.setSellPrice(hargaJual);
        pm.setBuyPrice(hargaBeli);
        pm.setDescription(productDesc);
        pm.setCategoryId(idCategory);
        pm.setProdusenId(idProdusen);

        Di.manageProductPresenter.updateDataProduct();

        int result = Di.manageProductPresenter.stateAddProduct;
        if (result <= 0) {
            System.out.println("Error ");
            return;
        }
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
//        Di.manageProductPresenter.resetResult();
//        resetField();
        populateTableProduct();

    }//GEN-LAST:event_bUpdateActionPerformed

    private void bBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBersihkanActionPerformed
        resetField();
        Di.manageProductPresenter.resetResult();
        Di.manageProductPresenter.resetSelectedProduct();
        bCreateProduct.setEnabled(true);
        bUpdate.setEnabled(false);
    }//GEN-LAST:event_bBersihkanActionPerformed

    private void tfidProductsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidProductsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidProductsearchActionPerformed

    private void tViewdataproductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tViewdataproductMouseClicked
        // TODO add your handling code here:
        int row = tViewdataproduct.getSelectedRow();

        int idProduct = Integer.parseInt(tViewdataproduct.getValueAt(row, 0).toString());

        Di.manageProductPresenter.setSelectedProduct(
                idProduct
        );
        ProductModel selectedProduct = Di.manageProductPresenter.selectedProduct;

        tfIdProduct.setText(String.valueOf(idProduct));
        tfNama.setText(selectedProduct.getProductName());
        tfStok.setText(String.valueOf(selectedProduct.getQuantityInStock()));
        tfHargajual.setText(String.valueOf(selectedProduct.getSellPrice()));
        tfHargabeli.setText(String.valueOf(selectedProduct.getBuyPrice()));
        taProductDesc.setText(String.valueOf(selectedProduct.getDescription()));

        int idxCategory = Di.manageProductPresenter.listCategory.indexOf(
                Di.manageProductPresenter.listCategory
                        .stream()
                        .filter(p -> p.getIdCategory() == selectedProduct.getCategoryId())
                        .findFirst().orElse(new CategoryModel())
        );
        int idxProdusen = Di.manageProductPresenter.listProdusen.indexOf(
                Di.manageProductPresenter.listProdusen
                        .stream()
                        .filter(p -> p.getIdProdusen() == selectedProduct.getProdusenId())
                        .findFirst().orElse(new ProdusenModel())
        );
        cbCategory.setSelectedIndex(idxCategory);
        cbProdusen.setSelectedIndex(idxProdusen);

        bCreateProduct.setEnabled(false);
        bUpdate.setEnabled(true);

    }//GEN-LAST:event_tViewdataproductMouseClicked

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        // TODO add your handling code here:
        populateTableProduct();
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void resetField() {

        tfHargabeli.setText("");
        tfHargajual.setText("");
        tfIdProduct.setText("");
        tfNama.setText("");
        tfStok.setText("");
        taProductDesc.setText("");
        cbCategory.setSelectedIndex(0);
        cbProdusen.setSelectedIndex(0);
    }

    private void setupCbProdusen() {
        cbProdusen.removeAllItems();
        Di.manageProductPresenter.showAllProdusen();
        for (ProdusenModel produsenModel : Di.manageProductPresenter.listProdusen) {
            cbProdusen.addItem(produsenModel);
        }
    }

    private boolean formIsValid() {
        boolean valid = false;

        if (tfNama.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nama Produk Tidak Boleh Kosong!");
            return valid;
        }

        if (tfNama.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Nama Produk Tidak Boleh Kosong!");
            return valid;
        }

        try {
            Integer.parseInt(tfStok.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Stok Harus Angka!");
            return valid;
        }

        try {
            Integer.parseInt(tfHargajual.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga Jual Harus Angka!");
            return valid;
        }

        try {
            Integer.parseInt(tfHargabeli.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Harga Beli Harus Angka!");
            return valid;
        }
        return !valid;
    }

    private void setupTableProduct() {
        tViewdataproduct.setModel(tableProductModel);
        tViewdataproduct.setRowSorter(tableProductSorter);
        tViewdataproduct.getTableHeader().setReorderingAllowed(false);
        tableProductModel.setColumnIdentifiers(new String[]{
            "idProduct", "Nama", "Kategori", "Stok", "HargaJual", "HargaBeli", "lastUpdate", "Warehouse"
        });
        tableProductSorter.setSortable(0, false);
        tableProductSorter.setSortable(1, false);
        tableProductSorter.setSortable(2, false);
        tableProductSorter.setSortable(3, false);

    }

    private void populateTableProduct() {
        String filterSearch = tfidProductsearch.getText();
        Di.manageProductPresenter.showAllProduct(filterSearch);
        //Remove rows one by one from the end of the table

        clearTable();

        for (ProductModel product : Di.manageProductPresenter.listProduct) {
            String[] row = {
                String.valueOf(product.getIdProduct()),
                product.getProductName(),
                product.getCategoryName(),
                String.valueOf(product.getQuantityInStock()),
                String.valueOf(product.getSellPrice()),
                String.valueOf(product.getBuyPrice()),
                String.valueOf(product.getLastUpdate()),//.toString(),
                product.getWarehouseName()
            };
            tableProductModel.addRow(row);
        }
    }

    private void clearTable() {
        for (int i = tableProductModel.getRowCount() - 1; i >= 0; i--) {
            tableProductModel.removeRow(i);
        }
    }

    private void setupCategoryProduct() {
        cbCategory.removeAllItems();
        Di.manageProductPresenter.showAllCategory();
        for (CategoryModel categoryModel : Di.manageProductPresenter.listCategory) {
            cbCategory.addItem(categoryModel);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBersihkan;
    private javax.swing.JButton bCreateProduct;
    private javax.swing.JButton bUpdate;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JComboBox<CategoryModel> cbCategory;
    private javax.swing.JComboBox<ProdusenModel> cbProdusen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tViewdataproduct;
    private javax.swing.JTextArea taProductDesc;
    private javax.swing.JTextField tfHargabeli;
    private javax.swing.JTextField tfHargajual;
    private javax.swing.JTextField tfIdProduct;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfStok;
    private javax.swing.JTextField tfidProductsearch;
    // End of variables declaration//GEN-END:variables
}
