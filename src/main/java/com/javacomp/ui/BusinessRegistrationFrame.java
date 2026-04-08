package com.javacomp.ui;

import static java.lang.String.valueOf;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.javacomp.exception.CreditCardException;
import com.javacomp.model.Address;
import com.javacomp.model.BusinessCustomer;
import com.javacomp.model.CreditCard;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Registration form for business customers.
 *
 * <p>Collects company info (CIF, website) in addition to the standard
 * customer fields, then creates a {@link BusinessCustomer}.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class BusinessRegistrationFrame extends javax.swing.JFrame {

    public BusinessRegistrationFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        CORREOTXT = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CLAVETXT = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CAMPOCLAVE = new javax.swing.JPasswordField();
        CAMPOCALLE = new javax.swing.JTextField();
        CAMPOMAIL = new javax.swing.JTextField();
        CAMPONUMEROD = new javax.swing.JTextField();
        CAMPONOMBRE = new javax.swing.JTextField();
        CAMPOCP = new javax.swing.JTextField();
        TELEFONOTXT = new javax.swing.JLabel();
        CAMPOCIUDAD = new javax.swing.JTextField();
        CAMPOTELEFONO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CANCELAR = new javax.swing.JButton();
        CAMPOCIF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CAMPONUMEROT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NOMBRETXT = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CAMPOWEB = new javax.swing.JTextField();
        CONFIRMAR = new javax.swing.JButton();
        CAMPOTITULAR = new javax.swing.JTextField();
        Date hoy = new Date();
        jSpinner1 = new javax.swing.JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.MONTH));
        LOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Business Registration");
        setResizable(false);

        jLabel9.setText("Number:");
        CORREOTXT.setText("Email:");
        jLabel10.setText("Zip Code:");
        CLAVETXT.setText("Password:");
        jLabel11.setText("City:");
        TELEFONOTXT.setText("Phone:");
        jLabel2.setText("ID (CIF):");
        jLabel3.setText("Enter your credit card details:");
        jLabel4.setText("Cardholder:");
        jLabel5.setText("Number:");
        jLabel6.setText("Expiration Date:");
        jLabel7.setText("Enter your address details:");
        jLabel8.setText("Street:");
        jLabel1.setText("Fill in the required information:");
        NOMBRETXT.setText("Name:");
        jLabel12.setText("WEBSITE:");

        CANCELAR.setText("CANCEL");
        CANCELAR.addActionListener(evt -> handleCancel());

        CONFIRMAR.setText("CONFIRM REGISTRATION");
        CONFIRMAR.addActionListener(evt -> handleConfirmRegistration());

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner1, "yyyy/MM/dd");
        jSpinner1.setEditor(editor);
        jSpinner1.setModel(new SpinnerDateModel(new Date(), new Date(), null, Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NOMBRETXT).addComponent(CORREOTXT).addComponent(CLAVETXT)
                    .addComponent(TELEFONOTXT).addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CAMPONOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(CAMPOMAIL).addComponent(CAMPOCLAVE)
                    .addComponent(CAMPOTELEFONO).addComponent(CAMPOCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel12).addComponent(CAMPOWEB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jLabel3)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4).addComponent(CAMPOTITULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5).addComponent(CAMPONUMEROT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6).addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel7)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8).addComponent(CAMPOCALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10).addComponent(CAMPOCP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11).addComponent(CAMPOCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9).addComponent(CAMPONUMEROD, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(CANCELAR).addGap(50).addComponent(CONFIRMAR))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NOMBRETXT).addComponent(CAMPONOMBRE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CORREOTXT).addComponent(CAMPOMAIL)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CLAVETXT).addComponent(CAMPOCLAVE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TELEFONOTXT).addComponent(CAMPOTELEFONO))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(CAMPOCIF)
                .addComponent(jLabel12).addComponent(CAMPOWEB))
            .addGap(20)
            .addComponent(jLabel3)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4).addComponent(CAMPOTITULAR)
                .addComponent(jLabel5).addComponent(CAMPONUMEROT)
                .addComponent(jLabel6).addComponent(jSpinner1))
            .addGap(20)
            .addComponent(jLabel7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8).addComponent(CAMPOCALLE)
                .addComponent(jLabel10).addComponent(CAMPOCP)
                .addComponent(jLabel11).addComponent(CAMPOCIUDAD))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9).addComponent(CAMPONUMEROD))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CANCELAR).addComponent(CONFIRMAR))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isCreditCardValid() {
        try {
            if (CAMPONUMEROT.getText().length() != 16) {
                throw new CreditCardException(CreditCardException.INVALID_DIGIT_COUNT);
            }
            return true;
        } catch (CreditCardException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private LocalDate getSpinnerDate() {
        Date date = (Date) jSpinner1.getValue();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    private void createBusinessCustomer() {
        LocalDate expirationDate = getSpinnerDate();

        CreditCard card = new CreditCard(
                CAMPOTITULAR.getText(),
                Long.parseLong(CAMPONUMEROT.getText()),
                expirationDate);

        Address address = new Address(
                CAMPOCALLE.getText(),
                Integer.parseInt(CAMPONUMEROD.getText()),
                Integer.parseInt(CAMPOCP.getText()),
                CAMPOCIUDAD.getText());

        BusinessCustomer customer = new BusinessCustomer(
                CAMPOCIF.getText(),
                CAMPOWEB.getText(),
                CAMPONOMBRE.getText(),
                CAMPOMAIL.getText(),
                valueOf(CAMPOCLAVE.getPassword()),
                address,
                card,
                Integer.parseInt(CAMPOTELEFONO.getText()));

        StoreManager.customerRegistry.put(customer.getEmail(), customer);
    }

    private void handleConfirmRegistration() {
        if (isCreditCardValid()) {
            createBusinessCustomer();
            JOptionPane.showMessageDialog(this,
                    "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            CustomerLoginFrame clf = new CustomerLoginFrame();
            clf.setVisible(true);
            this.dispose();
        }
    }

    private void handleCancel() {
        CustomerRegistrationFrame crf = new CustomerRegistrationFrame();
        crf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new BusinessRegistrationFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CAMPOCALLE;
    private javax.swing.JTextField CAMPOCIF;
    private javax.swing.JTextField CAMPOCIUDAD;
    private javax.swing.JPasswordField CAMPOCLAVE;
    private javax.swing.JTextField CAMPOCP;
    private javax.swing.JTextField CAMPOMAIL;
    private javax.swing.JTextField CAMPONOMBRE;
    private javax.swing.JTextField CAMPONUMEROD;
    private javax.swing.JTextField CAMPONUMEROT;
    private javax.swing.JTextField CAMPOTELEFONO;
    private javax.swing.JTextField CAMPOTITULAR;
    private javax.swing.JTextField CAMPOWEB;
    private javax.swing.JButton CANCELAR;
    private javax.swing.JLabel CLAVETXT;
    private javax.swing.JButton CONFIRMAR;
    private javax.swing.JLabel CORREOTXT;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel NOMBRETXT;
    private javax.swing.JLabel TELEFONOTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
