package com.javacomp.ui;

import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Admin dashboard — provides navigation to product, user, and sales management.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class AdminMenuFrame extends javax.swing.JFrame {

    public AdminMenuFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CUSUARIOSBOTON = new javax.swing.JButton();
        CPRODUCTOSBOTON = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        CVENTAS = new javax.swing.JButton();
        LOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        setResizable(false);

        CUSUARIOSBOTON.setText("VIEW USERS");
        CUSUARIOSBOTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CUSUARIOSBOTONActionPerformed(evt);
            }
        });

        CPRODUCTOSBOTON.setText("VIEW PRODUCTS");
        CPRODUCTOSBOTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPRODUCTOSBOTONActionPerformed(evt);
            }
        });

        jButton1.setText("LOGOUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CVENTAS.setText("VIEW SALES");
        CVENTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CVENTASActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CPRODUCTOSBOTON)
                            .addComponent(CUSUARIOSBOTON)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CVENTAS)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(CUSUARIOSBOTON)
                .addGap(34, 34, 34)
                .addComponent(CPRODUCTOSBOTON)
                .addGap(28, 28, 28)
                .addComponent(CVENTAS)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(LOGO, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CPRODUCTOSBOTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPRODUCTOSBOTONActionPerformed
        ProductManagementFrame pmf = new ProductManagementFrame();
        pmf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CPRODUCTOSBOTONActionPerformed

    private void CUSUARIOSBOTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CUSUARIOSBOTONActionPerformed
        UserManagementFrame umf = new UserManagementFrame();
        umf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CUSUARIOSBOTONActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminLoginFrame alf = new AdminLoginFrame();
        alf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CVENTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CVENTASActionPerformed
        SalesQueryFrame sqf = new SalesQueryFrame();
        sqf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CVENTASActionPerformed

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new AdminMenuFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CPRODUCTOSBOTON;
    private javax.swing.JButton CUSUARIOSBOTON;
    private javax.swing.JButton CVENTAS;
    private javax.swing.JLabel LOGO;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
