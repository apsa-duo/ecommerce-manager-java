package com.javacomp.ui;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.javacomp.model.Purchase;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Admin screen for querying sales history filtered by date.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class SalesQueryFrame extends javax.swing.JFrame {

    public SalesQueryFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Date hoy = new Date();
        jSpinner1 = new javax.swing.JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.MONTH));
        BUSCAR = new javax.swing.JButton();
        VENTAS = new javax.swing.JTextField();
        LOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales Query");

        jLabel1.setText("Search from a date");

        jButton1.setText("BACK");
        jButton1.addActionListener(evt -> handleBack());

        jLabel2.setText("Sales:");

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner1, "yyyy/MM/dd");
        jSpinner1.setEditor(editor);

        BUSCAR.setText("SEARCH");
        BUSCAR.addActionListener(evt -> handleSearch());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BUSCAR))
            .addComponent(jLabel2)
            .addComponent(VENTAS, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(50)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1).addComponent(jSpinner1).addComponent(BUSCAR))
            .addComponent(jLabel2)
            .addComponent(VENTAS)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Searches sales history for purchases made after the selected date.
     */
    private void handleSearch() {
        Date d = (Date) jSpinner1.getValue();
        Instant instant = Instant.ofEpochMilli(d.getTime());
        LocalDate filterDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();

        ArrayList<Purchase> results = new ArrayList<>();
        for (Purchase purchase : StoreManager.salesHistory) {
            if (purchase.getPurchaseDate().isAfter(filterDate)) {
                results.add(purchase);
            }
        }

        VENTAS.setText(Arrays.toString(results.toArray()));
    }

    private void handleBack() {
        AdminMenuFrame amf = new AdminMenuFrame();
        amf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new SalesQueryFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUSCAR;
    private javax.swing.JLabel LOGO;
    private javax.swing.JTextField VENTAS;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
