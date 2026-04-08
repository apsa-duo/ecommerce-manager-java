package com.javacomp.ui;

import javax.swing.JComboBox;

import com.javacomp.model.Review;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Form for customers to submit a product review (rating + comment).
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class SubmitReviewFrame extends javax.swing.JFrame {

    public SubmitReviewFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PRODUCTOTXT = new javax.swing.JLabel();
        COMBOALMACEN = new javax.swing.JComboBox<>();
        calificacion = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comentario = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        LOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Submit Review");
        setResizable(false);

        PRODUCTOTXT.setText("Select a product:");

        // Populate combo box with product titles from the catalog
        loadProducts();

        calificacion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jLabel1.setText("Rating:");
        jLabel2.setText("Comment:");

        cancelar.setText("CANCEL");
        cancelar.addActionListener(evt -> handleCancel());

        confirmar.setText("CONFIRM");
        confirmar.addActionListener(evt -> handleConfirm());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PRODUCTOTXT)
                .addComponent(COMBOALMACEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addComponent(calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addComponent(comentario, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cancelar).addGap(50).addComponent(confirmar))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(PRODUCTOTXT).addComponent(COMBOALMACEN)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1).addComponent(calificacion))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(comentario))
            .addGap(30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cancelar).addComponent(confirmar))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /** Loads product titles into the combo box from the catalog. */
    private void loadProducts() {
        COMBOALMACEN = new JComboBox<>(StoreManager.productCatalog.keySet().toArray(new String[0]));
    }

    private void handleConfirm() {
        int rating = (int) calificacion.getValue();
        String comment = comentario.getText();
        Review review = new Review(rating, comment);

        String selectedProduct = (String) COMBOALMACEN.getSelectedItem();
        if (selectedProduct != null) {
            StoreManager.productCatalog.get(selectedProduct).getReviews().add(review);
        }

        CustomerMenuFrame cmf = new CustomerMenuFrame();
        cmf.setVisible(true);
        this.dispose();
    }

    private void handleCancel() {
        CustomerMenuFrame cmf = new CustomerMenuFrame();
        cmf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new SubmitReviewFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> COMBOALMACEN;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel PRODUCTOTXT;
    private javax.swing.JSpinner calificacion;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField comentario;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
