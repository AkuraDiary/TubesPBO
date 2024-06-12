/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bibd.tubespbo.view.manager;

import com.bibd.tubespbo.Di;
import com.bibd.tubespbo.view.login.LoginView;
import com.bibd.tubespbo.view.manager.panels.MenuApprovePembelian;
import com.bibd.tubespbo.view.manager.panels.MenuCrudEmployees;
import com.bibd.tubespbo.view.manager.panels.MenuCrudProduct;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author asthiseta
 */
public class ManagerDashboard extends javax.swing.JFrame {

    int xx,xy;
    /**
     * Creates new form ManagerDashboard
     */
    public ManagerDashboard() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnKiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pMain_Create = new javax.swing.JPanel();
        pnBeforeimgCreate = new javax.swing.JPanel();
        btnCreate = new javax.swing.JLabel();
        pMain_AprovePembelian = new javax.swing.JPanel();
        pnBeforeApprove = new javax.swing.JPanel();
        btnAprove = new javax.swing.JLabel();
        pMain_CRUDProducts = new javax.swing.JPanel();
        pnBeforeCRUDProducts = new javax.swing.JPanel();
        btnCRUDProducts = new javax.swing.JLabel();
        pnKanan = new javax.swing.JPanel();
        pnDasar = new javax.swing.JPanel();
        pn_Utama = new javax.swing.JPanel();
        jPanelGradient1 = new com.bibd.tubespbo.view.manager.jPanelGradient();
        bLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        pnKiri.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Manager");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Dashboard");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("MENU:");

        pMain_Create.setBackground(new java.awt.Color(255, 255, 255));
        pMain_Create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pMain_CreateMouseEntered(evt);
            }
        });

        pnBeforeimgCreate.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnBeforeimgCreateLayout = new javax.swing.GroupLayout(pnBeforeimgCreate);
        pnBeforeimgCreate.setLayout(pnBeforeimgCreateLayout);
        pnBeforeimgCreateLayout.setHorizontalGroup(
            pnBeforeimgCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnBeforeimgCreateLayout.setVerticalGroup(
            pnBeforeimgCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        btnCreate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(102, 102, 102));
        btnCreate.setText("MANAGEMENT EMPLOYEES");
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pMain_CreateLayout = new javax.swing.GroupLayout(pMain_Create);
        pMain_Create.setLayout(pMain_CreateLayout);
        pMain_CreateLayout.setHorizontalGroup(
            pMain_CreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMain_CreateLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnBeforeimgCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCreate)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pMain_CreateLayout.setVerticalGroup(
            pMain_CreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMain_CreateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMain_CreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnBeforeimgCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pMain_AprovePembelian.setBackground(new java.awt.Color(255, 255, 255));

        pnBeforeApprove.setBackground(new java.awt.Color(255, 255, 255));
        pnBeforeApprove.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                pnBeforeApproveAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout pnBeforeApproveLayout = new javax.swing.GroupLayout(pnBeforeApprove);
        pnBeforeApprove.setLayout(pnBeforeApproveLayout);
        pnBeforeApproveLayout.setHorizontalGroup(
            pnBeforeApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnBeforeApproveLayout.setVerticalGroup(
            pnBeforeApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        btnAprove.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAprove.setForeground(new java.awt.Color(102, 102, 102));
        btnAprove.setText("APPROVE PEMBELIAN");
        btnAprove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAproveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAproveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAproveMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pMain_AprovePembelianLayout = new javax.swing.GroupLayout(pMain_AprovePembelian);
        pMain_AprovePembelian.setLayout(pMain_AprovePembelianLayout);
        pMain_AprovePembelianLayout.setHorizontalGroup(
            pMain_AprovePembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMain_AprovePembelianLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnBeforeApprove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pMain_AprovePembelianLayout.setVerticalGroup(
            pMain_AprovePembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMain_AprovePembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMain_AprovePembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMain_AprovePembelianLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnBeforeApprove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAprove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pMain_CRUDProducts.setBackground(new java.awt.Color(255, 255, 255));

        pnBeforeCRUDProducts.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnBeforeCRUDProductsLayout = new javax.swing.GroupLayout(pnBeforeCRUDProducts);
        pnBeforeCRUDProducts.setLayout(pnBeforeCRUDProductsLayout);
        pnBeforeCRUDProductsLayout.setHorizontalGroup(
            pnBeforeCRUDProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        pnBeforeCRUDProductsLayout.setVerticalGroup(
            pnBeforeCRUDProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        btnCRUDProducts.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnCRUDProducts.setForeground(new java.awt.Color(102, 102, 102));
        btnCRUDProducts.setText("MANAGEMENT PRODUCTS");
        btnCRUDProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCRUDProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCRUDProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCRUDProductsMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pMain_CRUDProductsLayout = new javax.swing.GroupLayout(pMain_CRUDProducts);
        pMain_CRUDProducts.setLayout(pMain_CRUDProductsLayout);
        pMain_CRUDProductsLayout.setHorizontalGroup(
            pMain_CRUDProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMain_CRUDProductsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(pnBeforeCRUDProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCRUDProducts)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pMain_CRUDProductsLayout.setVerticalGroup(
            pMain_CRUDProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMain_CRUDProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMain_CRUDProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pMain_CRUDProductsLayout.createSequentialGroup()
                        .addComponent(pnBeforeCRUDProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCRUDProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnKiriLayout = new javax.swing.GroupLayout(pnKiri);
        pnKiri.setLayout(pnKiriLayout);
        pnKiriLayout.setHorizontalGroup(
            pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKiriLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pMain_CRUDProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pMain_Create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnKiriLayout.createSequentialGroup()
                            .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnKiriLayout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2))
                        .addComponent(pMain_AprovePembelian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnKiriLayout.setVerticalGroup(
            pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKiriLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(65, 65, 65)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(pMain_Create, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pMain_AprovePembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pMain_CRUDProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(445, Short.MAX_VALUE))
        );

        getContentPane().add(pnKiri, java.awt.BorderLayout.LINE_START);

        pnKanan.setBackground(new java.awt.Color(255, 255, 255));
        pnKanan.setLayout(new java.awt.BorderLayout());

        pnDasar.setBackground(new java.awt.Color(255, 255, 255));

        pn_Utama.setBackground(new java.awt.Color(255, 255, 255));
        pn_Utama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnDasarLayout = new javax.swing.GroupLayout(pnDasar);
        pnDasar.setLayout(pnDasarLayout);
        pnDasarLayout.setHorizontalGroup(
            pnDasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pn_Utama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pnDasarLayout.setVerticalGroup(
            pnDasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_Utama, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );

        pnKanan.add(pnDasar, java.awt.BorderLayout.CENTER);

        jPanelGradient1.setColorEnd(new java.awt.Color(0, 102, 153));
        jPanelGradient1.setColorStart(new java.awt.Color(0, 255, 204));

        bLogout.setBackground(new java.awt.Color(204, 255, 255));
        bLogout.setText("Log-out");
        bLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGradient1Layout.createSequentialGroup()
                .addContainerGap(849, Short.MAX_VALUE)
                .addComponent(bLogout)
                .addGap(48, 48, 48))
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradient1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(bLogout)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnKanan.add(jPanelGradient1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnKanan, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pMain_CreateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pMain_CreateMouseEntered
//tidak usah diisi
    }//GEN-LAST:event_pMain_CreateMouseEntered

    private void btnCreateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseExited
        pMain_Create.setBackground(new Color(255, 255, 255));
        pnBeforeimgCreate.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCreateMouseExited

    private void btnCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseClicked
        pMain_Create.setBackground(new Color(240, 240, 240));
        pnBeforeimgCreate.setBackground(new Color(0, 102, 153));
        
        pn_Utama.removeAll();
        pn_Utama.add(new MenuCrudEmployees());
        pn_Utama.repaint();
        pn_Utama.revalidate();
    }//GEN-LAST:event_btnCreateMouseClicked

    private void btnCreateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseEntered
        pMain_Create.setBackground(new Color(250, 250, 250));
        pnBeforeimgCreate.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnCreateMouseEntered

    private void btnAproveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAproveMouseEntered
        pMain_AprovePembelian.setBackground(new Color(250, 250, 250));
        pnBeforeApprove.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnAproveMouseEntered

    private void btnAproveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAproveMouseExited
        pMain_AprovePembelian.setBackground(new Color(255, 255, 255));
        pnBeforeApprove.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnAproveMouseExited

    private void pnBeforeApproveAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_pnBeforeApproveAncestorMoved
        //gausah diisi bagian ini
    }//GEN-LAST:event_pnBeforeApproveAncestorMoved

    private void btnAproveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAproveMouseClicked
        pMain_AprovePembelian.setBackground(new Color(240, 240, 240));
        pnBeforeApprove.setBackground(new Color(0, 102, 153));
        
        pn_Utama.removeAll();
        pn_Utama.add(new MenuApprovePembelian());
        pn_Utama.repaint();
        pn_Utama.revalidate();
    }//GEN-LAST:event_btnAproveMouseClicked

    private void btnCRUDProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCRUDProductsMouseEntered
        pMain_CRUDProducts.setBackground(new Color(250, 250, 250));
        pnBeforeCRUDProducts.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btnCRUDProductsMouseEntered

    private void btnCRUDProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCRUDProductsMouseExited
        pMain_CRUDProducts.setBackground(new Color(255, 255, 255));
        pnBeforeCRUDProducts.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnCRUDProductsMouseExited

    private void btnCRUDProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCRUDProductsMouseClicked
        pMain_CRUDProducts.setBackground(new Color(240, 240, 240));
        pnBeforeCRUDProducts.setBackground(new Color(0, 102, 153));
        
        pn_Utama.removeAll();
        pn_Utama.add(new MenuCrudProduct());
        pn_Utama.repaint();
        pn_Utama.revalidate();
    }//GEN-LAST:event_btnCRUDProductsMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void bLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoutActionPerformed
        // TODO add your handling code here:
        Di.authPresenter.doLogout();
        LoginView lv = new LoginView();
        lv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bLogoutActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLogout;
    private javax.swing.JLabel btnAprove;
    private javax.swing.JLabel btnCRUDProducts;
    private javax.swing.JLabel btnCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private com.bibd.tubespbo.view.manager.jPanelGradient jPanelGradient1;
    private javax.swing.JPanel pMain_AprovePembelian;
    private javax.swing.JPanel pMain_CRUDProducts;
    private javax.swing.JPanel pMain_Create;
    private javax.swing.JPanel pnBeforeApprove;
    private javax.swing.JPanel pnBeforeCRUDProducts;
    private javax.swing.JPanel pnBeforeimgCreate;
    private javax.swing.JPanel pnDasar;
    private javax.swing.JPanel pnKanan;
    private javax.swing.JPanel pnKiri;
    private javax.swing.JPanel pn_Utama;
    // End of variables declaration//GEN-END:variables
}
