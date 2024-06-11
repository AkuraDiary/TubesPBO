/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.bibd.tubespbo.view.manager.panels;

import com.bibd.tubespbo.Di;
import com.bibd.tubespbo.data.model.EmployeeModel;
import com.bibd.tubespbo.data.model.WarehouseModel;
import com.bibd.tubespbo.util.Statics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author HP VICTUS
 */
public class MenuCrudEmployees extends javax.swing.JPanel {

    /**
     * Creates new form ManageEmployeePanel
     */
    public MenuCrudEmployees() {
        initComponents();

        setupStatusEmployee();
        setupWarehouse();
        setupTableEMployee();
        
        populateTableEmployee();
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
        tfIDEmployees = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfNamaEmployees = new javax.swing.JTextField();
        tfRoleEmployees = new javax.swing.JTextField();
        tfNoHpEmployees = new javax.swing.JTextField();
        tfEmailEmployees = new javax.swing.JTextField();
        tfPasswordEmployees = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tViewdataemployees = new javax.swing.JTable();
        bUpdateDataEmployees = new javax.swing.JButton();
        bDeleteDataEmployees = new javax.swing.JButton();
        bNew = new javax.swing.JButton();
        bSearchEmployees = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tFSearchEmployee = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfEntriesEmployeesData = new javax.swing.JTextField();
        bEntriesDataEmployee = new javax.swing.JButton();
        cbStatusEmploees = new javax.swing.JComboBox<>();
        cbWarehouse = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MANAGE EMPLOYEES");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("Nama            :");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("No.HP           :");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Email             :");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Role               :");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Status             :");

        tfNamaEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaEmployeesActionPerformed(evt);
            }
        });

        tfRoleEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRoleEmployeesActionPerformed(evt);
            }
        });

        tfNoHpEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoHpEmployeesActionPerformed(evt);
            }
        });

        tfEmailEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailEmployeesActionPerformed(evt);
            }
        });

        tfPasswordEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordEmployeesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Warehouse      :");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Password          :");

        tViewdataemployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "IDEmployees", "Nama", "Status", "Role", "IDWarehouse"
            }
        ));
        jScrollPane1.setViewportView(tViewdataemployees);

        bUpdateDataEmployees.setBackground(new java.awt.Color(204, 204, 204));
        bUpdateDataEmployees.setText("Update");
        bUpdateDataEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateDataEmployeesActionPerformed(evt);
            }
        });

        bDeleteDataEmployees.setBackground(new java.awt.Color(204, 204, 204));
        bDeleteDataEmployees.setText("Delete");
        bDeleteDataEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteDataEmployeesActionPerformed(evt);
            }
        });

        bNew.setBackground(new java.awt.Color(204, 204, 204));
        bNew.setText("Add");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });

        bSearchEmployees.setBackground(new java.awt.Color(204, 204, 204));
        bSearchEmployees.setText("Search");
        bSearchEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchEmployeesActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText(" Cari Employee");

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setText("IDEmployees        :");

        tFSearchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tFSearchEmployeeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Show");

        tfEntriesEmployeesData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEntriesEmployeesDataActionPerformed(evt);
            }
        });

        bEntriesDataEmployee.setBackground(new java.awt.Color(204, 204, 204));
        bEntriesDataEmployee.setText("Entries");

        jButton1.setText("Clear");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("MENU > CRUD OPERATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tfPasswordEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNoHpEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNamaEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEmailEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfRoleEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbStatusEmploees, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIDEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bNew)
                        .addGap(41, 41, 41)
                        .addComponent(bUpdateDataEmployees)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(81, 81, 81)))
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(tfEntriesEmployeesData, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEntriesDataEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2)
                        .addGap(177, 177, 177))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tFSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bSearchEmployees)
                        .addGap(18, 18, 18)
                        .addComponent(bDeleteDataEmployees)
                        .addGap(123, 123, 123))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tFSearchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bDeleteDataEmployees)
                            .addComponent(bSearchEmployees))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tfEntriesEmployeesData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEntriesDataEmployee)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIDEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNamaEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNoHpEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEmailEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfRoleEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbStatusEmploees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPasswordEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bUpdateDataEmployees)
                            .addComponent(bNew))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private DefaultTableModel tableEmployeeModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; //super.isCellEditable(row, column);
        }

    };
    private TableRowSorter<DefaultTableModel> tableEmployeeSorter = new TableRowSorter<>(tableEmployeeModel);

    ArrayList<String> employeeStatus = new ArrayList<>(
            Arrays.asList(Statics.EMPLOYEE_STATUS_AKTIF, Statics.EMPLOYEE_STATUS_NONAKTIF)
    );

    private void setupStatusEmployee() {
        cbStatusEmploees.removeAllItems();
        for (String empStatus : employeeStatus) {
            cbStatusEmploees.addItem(empStatus);
        }
    }

    private void setupTableEMployee() {

        tViewdataemployees.setModel(tableEmployeeModel);
        tViewdataemployees.setRowSorter(tableEmployeeSorter);
        tViewdataemployees.getTableHeader().setReorderingAllowed(false);
        
        tableEmployeeModel.addColumn("IdEmployee");
        tableEmployeeModel.addColumn("Nama");
        tableEmployeeModel.addColumn("Status");
        tableEmployeeModel.addColumn("Role");
        tableEmployeeModel.addColumn("idWarehouse");


    }
    
    private void resetField() {
        
    }
    
    private void clearTable(){
        for (int i = tableEmployeeModel.getRowCount() - 1; i >= 0; i--) {
            tableEmployeeModel.removeRow(i);
        }
    }

    private void populateTableEmployee() {
        Di.manageEmployeePresenter.getAllEmplyoees();
          //Remove rows one by one from the end of the table
        
        clearTable();
        
        String filterSearch = tFSearchEmployee.getText();
        
        ArrayList<EmployeeModel> data = new ArrayList<>();
        
        data.addAll(Di.manageEmployeePresenter.listEmployee);
        
        if(!filterSearch.isBlank()){
                data = (ArrayList<EmployeeModel>) data.stream()
                   .filter(emp -> emp.getNama().equalsIgnoreCase(filterSearch)
//                                  emp.getStatus().toLowerCase().contains(filterSearch) || 
//                                  emp.getRole().toLowerCase().contains(filterSearch))
                           )
                   .collect(Collectors.toList());
            
        }
        
        for (EmployeeModel emp : data) {
            String[] row = {
                String.valueOf(emp.getId()), 
                emp.getNama(), 
                emp.getStatus(), 
                emp.getRole(), 
                String.valueOf(emp.getIdWarehouse())
            };
            tableEmployeeModel.addRow(row);
        }
        
    }

    private void setupWarehouse() {
        Di.manageEmployeePresenter.getDataWarehouse();
        cbWarehouse.removeAllItems();
        for (WarehouseModel item : Di.manageEmployeePresenter.listWarehouse) {
            cbWarehouse.addItem(item);
        }
    }

    private void tfNamaEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaEmployeesActionPerformed

    private void tfRoleEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRoleEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRoleEmployeesActionPerformed

    private void tfNoHpEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoHpEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNoHpEmployeesActionPerformed

    private void tfEmailEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailEmployeesActionPerformed

    private void tfPasswordEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordEmployeesActionPerformed

    private void bDeleteDataEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteDataEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bDeleteDataEmployeesActionPerformed

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bNewActionPerformed

    private void bUpdateDataEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateDataEmployeesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bUpdateDataEmployeesActionPerformed

    private void bSearchEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchEmployeesActionPerformed
        // TODO add your handling code here:
        populateTableEmployee();
    }//GEN-LAST:event_bSearchEmployeesActionPerformed

    private void tFSearchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tFSearchEmployeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tFSearchEmployeeActionPerformed

    private void tfEntriesEmployeesDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEntriesEmployeesDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEntriesEmployeesDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeleteDataEmployees;
    private javax.swing.JButton bEntriesDataEmployee;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bSearchEmployees;
    private javax.swing.JButton bUpdateDataEmployees;
    private javax.swing.JComboBox<String> cbStatusEmploees;
    private javax.swing.JComboBox<WarehouseModel> cbWarehouse;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tFSearchEmployee;
    private javax.swing.JTable tViewdataemployees;
    private javax.swing.JTextField tfEmailEmployees;
    private javax.swing.JTextField tfEntriesEmployeesData;
    private javax.swing.JTextField tfIDEmployees;
    private javax.swing.JTextField tfNamaEmployees;
    private javax.swing.JTextField tfNoHpEmployees;
    private javax.swing.JTextField tfPasswordEmployees;
    private javax.swing.JTextField tfRoleEmployees;
    // End of variables declaration//GEN-END:variables
}
