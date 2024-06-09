/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bibd.tubespbo.view.supervisor;
import com.bibd.tubespbo.view.supervisor.supervisorpanels.MenuCreatePembelian;
import com.bibd.tubespbo.view.supervisor.supervisorpanels.MenuCrudCustomer;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author asthiseta
 */
public class SupervisorDashboard extends javax.swing.JFrame {

    /**
     * Creates new form SalesDashboard
     */
    public SupervisorDashboard() {
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
        pn_main1 = new javax.swing.JPanel();
        pn_cp = new javax.swing.JPanel();
        btn_CreatePembelian = new javax.swing.JLabel();
        pn_main2 = new javax.swing.JPanel();
        pn_cc = new javax.swing.JPanel();
        btn_CrudCustomer = new javax.swing.JLabel();
        pn_main3 = new javax.swing.JPanel();
        pn_cpn = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pn_main4 = new javax.swing.JPanel();
        pn_ps = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnKanan = new javax.swing.JPanel();
        jPanelGradient1 = new com.bibd.tubespbo.view.manager.jPanelGradient();
        pnDasar = new javax.swing.JPanel();
        pnUtama = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnKiri.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("SUPERVISOR");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Dashboard");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("MENU:");

        pn_main1.setBackground(new java.awt.Color(255, 255, 255));

        pn_cp.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_cpLayout = new javax.swing.GroupLayout(pn_cp);
        pn_cp.setLayout(pn_cpLayout);
        pn_cpLayout.setHorizontalGroup(
            pn_cpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pn_cpLayout.setVerticalGroup(
            pn_cpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        btn_CreatePembelian.setBackground(new java.awt.Color(255, 255, 255));
        btn_CreatePembelian.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_CreatePembelian.setText("CREATE PEMBELIAN");
        btn_CreatePembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CreatePembelianMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CreatePembelianMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CreatePembelianMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main1Layout = new javax.swing.GroupLayout(pn_main1);
        pn_main1.setLayout(pn_main1Layout);
        pn_main1Layout.setHorizontalGroup(
            pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_CreatePembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_main1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(205, Short.MAX_VALUE)))
        );
        pn_main1Layout.setVerticalGroup(
            pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_main1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_CreatePembelian, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_main1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_main1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pn_main2.setBackground(new java.awt.Color(255, 255, 255));

        pn_cc.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_ccLayout = new javax.swing.GroupLayout(pn_cc);
        pn_cc.setLayout(pn_ccLayout);
        pn_ccLayout.setHorizontalGroup(
            pn_ccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pn_ccLayout.setVerticalGroup(
            pn_ccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        btn_CrudCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btn_CrudCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_CrudCustomer.setText("CRUD CUSTOMER");
        btn_CrudCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CrudCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CrudCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CrudCustomerMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pn_main2Layout = new javax.swing.GroupLayout(pn_main2);
        pn_main2.setLayout(pn_main2Layout);
        pn_main2Layout.setHorizontalGroup(
            pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btn_CrudCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_main2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(205, Short.MAX_VALUE)))
        );
        pn_main2Layout.setVerticalGroup(
            pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_main2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_CrudCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_main2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_main2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pn_main3.setBackground(new java.awt.Color(255, 255, 255));

        pn_cpn.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_cpnLayout = new javax.swing.GroupLayout(pn_cpn);
        pn_cpn.setLayout(pn_cpnLayout);
        pn_cpnLayout.setHorizontalGroup(
            pn_cpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pn_cpnLayout.setVerticalGroup(
            pn_cpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("CEK PENJUALAN");

        javax.swing.GroupLayout pn_main3Layout = new javax.swing.GroupLayout(pn_main3);
        pn_main3.setLayout(pn_main3Layout);
        pn_main3Layout.setHorizontalGroup(
            pn_main3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(pn_cpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_main3Layout.setVerticalGroup(
            pn_main3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_main3Layout.createSequentialGroup()
                .addGroup(pn_main3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_main3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pn_cpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pn_main4.setBackground(new java.awt.Color(255, 255, 255));

        pn_ps.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pn_psLayout = new javax.swing.GroupLayout(pn_ps);
        pn_ps.setLayout(pn_psLayout);
        pn_psLayout.setHorizontalGroup(
            pn_psLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pn_psLayout.setVerticalGroup(
            pn_psLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("UPDATE STOK");

        javax.swing.GroupLayout pn_main4Layout = new javax.swing.GroupLayout(pn_main4);
        pn_main4.setLayout(pn_main4Layout);
        pn_main4Layout.setHorizontalGroup(
            pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_main4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(261, Short.MAX_VALUE)))
        );
        pn_main4Layout.setVerticalGroup(
            pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_main4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pn_main4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_main4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pn_ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnKiriLayout = new javax.swing.GroupLayout(pnKiri);
        pnKiri.setLayout(pnKiriLayout);
        pnKiriLayout.setHorizontalGroup(
            pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKiriLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnKiriLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKiriLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pn_main4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnKiriLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(303, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKiriLayout.createSequentialGroup()
                        .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pn_main1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_main2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pn_main3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))))
        );
        pnKiriLayout.setVerticalGroup(
            pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKiriLayout.createSequentialGroup()
                .addGroup(pnKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKiriLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKiriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(pn_main1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_main2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_main4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pn_main3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        getContentPane().add(pnKiri, java.awt.BorderLayout.LINE_START);

        pnKanan.setBackground(new java.awt.Color(255, 255, 255));
        pnKanan.setLayout(new java.awt.BorderLayout());

        jPanelGradient1.setColorEnd(new java.awt.Color(0, 102, 153));
        jPanelGradient1.setColorStart(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout jPanelGradient1Layout = new javax.swing.GroupLayout(jPanelGradient1);
        jPanelGradient1.setLayout(jPanelGradient1Layout);
        jPanelGradient1Layout.setHorizontalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
        );
        jPanelGradient1Layout.setVerticalGroup(
            jPanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        pnKanan.add(jPanelGradient1, java.awt.BorderLayout.PAGE_START);

        pnDasar.setBackground(new java.awt.Color(255, 255, 255));

        pnUtama.setBackground(new java.awt.Color(255, 255, 255));
        pnUtama.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnDasarLayout = new javax.swing.GroupLayout(pnDasar);
        pnDasar.setLayout(pnDasarLayout);
        pnDasarLayout.setHorizontalGroup(
            pnDasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDasarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        pnDasarLayout.setVerticalGroup(
            pnDasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnUtama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnKanan.add(pnDasar, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnKanan, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CreatePembelianMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CreatePembelianMouseEntered
        pn_main1.setBackground(new Color(250, 250, 250));
        pn_cp.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btn_CreatePembelianMouseEntered

    private void btn_CreatePembelianMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CreatePembelianMouseExited
        pn_main1.setBackground(new Color(255, 255, 255));
        pn_cp.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_CreatePembelianMouseExited

    private void btn_CreatePembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CreatePembelianMouseClicked
        pn_main1.setBackground(new Color(240, 240, 240));
        pn_cp.setBackground(new Color(0, 102, 153));
        
        pnUtama.removeAll();
        pnUtama.add(new MenuCreatePembelian());
        pnUtama.repaint();
        pnUtama.revalidate();
        
    }//GEN-LAST:event_btn_CreatePembelianMouseClicked

    private void btn_CrudCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CrudCustomerMouseEntered
        pn_main2.setBackground(new Color(250, 250, 250));
        pn_cc.setBackground(new Color(0, 102, 153));
    }//GEN-LAST:event_btn_CrudCustomerMouseEntered

    private void btn_CrudCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CrudCustomerMouseExited
        pn_main2.setBackground(new Color(255, 255, 255));
        pn_cc.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_CrudCustomerMouseExited

    private void btn_CrudCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CrudCustomerMouseClicked
        pn_main2.setBackground(new Color(240, 240, 240));
        pn_cc.setBackground(new Color(0, 102, 153));
        
        pnUtama.removeAll();
        pnUtama.add(new MenuCrudCustomer());
        pnUtama.repaint();
        pnUtama.revalidate();
    }//GEN-LAST:event_btn_CrudCustomerMouseClicked

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
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupervisorDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupervisorDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_CreatePembelian;
    private javax.swing.JLabel btn_CrudCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private com.bibd.tubespbo.view.manager.jPanelGradient jPanelGradient1;
    private javax.swing.JPanel pnDasar;
    private javax.swing.JPanel pnKanan;
    private javax.swing.JPanel pnKiri;
    private javax.swing.JPanel pnUtama;
    private javax.swing.JPanel pn_cc;
    private javax.swing.JPanel pn_cp;
    private javax.swing.JPanel pn_cpn;
    private javax.swing.JPanel pn_main1;
    private javax.swing.JPanel pn_main2;
    private javax.swing.JPanel pn_main3;
    private javax.swing.JPanel pn_main4;
    private javax.swing.JPanel pn_ps;
    // End of variables declaration//GEN-END:variables
}
