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
import com.javacomp.model.CreditCard;
import com.javacomp.model.IndividualCustomer;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Registration form for individual (personal) customers.
 *
 * <p>Collects name, email, password, phone, DNI, credit card details,
 * and mailing address, then creates a new {@link IndividualCustomer}
 * and adds it to the customer registry.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class IndividualRegistrationFrame extends javax.swing.JFrame {

    public IndividualRegistrationFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NOMBRETXT = new javax.swing.JLabel();
        CORREOTXT = new javax.swing.JLabel();
        CLAVETXT = new javax.swing.JLabel();
        CAMPOCLAVE = new javax.swing.JPasswordField();
        CAMPOMAIL = new javax.swing.JTextField();
        CAMPONOMBRE = new javax.swing.JTextField();
        TELEFONOTXT = new javax.swing.JLabel();
        CAMPOTELEFONO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CAMPODNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CAMPONUMEROT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Date hoy = new Date();
        jSpinner1 = new javax.swing.JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.MONTH));
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CAMPOCALLE = new javax.swing.JTextField();
        CAMPONUMEROD = new javax.swing.JTextField();
        CAMPOCP = new javax.swing.JTextField();
        CAMPOCIUDAD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        CAMPOTITULAR = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        LOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Individual Registration");
        setResizable(false);

        jLabel1.setText("Fill in the required information:");
        NOMBRETXT.setText("Name:");
        CORREOTXT.setText("Email:");
        CLAVETXT.setText("Password:");
        TELEFONOTXT.setText("Phone:");
        jLabel2.setText("ID (DNI):");
        jLabel3.setText("Enter your credit card details:");
        jLabel4.setText("Cardholder:");
        jLabel5.setText("Number:");
        jLabel6.setText("Expiration Date:");

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner1, "yyyy/MM/dd");
        jSpinner1.setEditor(editor);
        jSpinner1.setModel(new SpinnerDateModel(new Date(), new Date(), null, Calendar.DAY_OF_MONTH));

        jLabel7.setText("Enter your address details:");
        jLabel8.setText("Street:");
        jLabel9.setText("Number:");
        jLabel10.setText("Zip Code:");
        jLabel11.setText("City:");

        jButton1.setText("CANCEL");
        jButton1.addActionListener(evt -> handleCancel());

        jButton2.setText("CONFIRM REGISTRATION");
        jButton2.addActionListener(evt -> handleConfirmRegistration());

        // Simplified layout — use a basic vertical arrangement
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
                    .addComponent(CAMPOTELEFONO).addComponent(CAMPODNI))
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4).addComponent(CAMPOTITULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5).addComponent(CAMPONUMEROT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6).addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel7)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8).addComponent(CAMPOCALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10).addComponent(CAMPOCP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9).addComponent(CAMPONUMEROD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11).addComponent(CAMPOCIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel12)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1).addGap(50).addComponent(jButton2))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NOMBRETXT).addComponent(CAMPONOMBRE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CORREOTXT).addComponent(CAMPOMAIL))
            .addComponent(jLabel12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(CLAVETXT).addComponent(CAMPOCLAVE).addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TELEFONOTXT).addComponent(CAMPOTELEFONO))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(CAMPODNI))
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
                .addComponent(jLabel10).addComponent(CAMPOCP))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9).addComponent(CAMPONUMEROD)
                .addComponent(jLabel11).addComponent(CAMPOCIUDAD))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1).addComponent(jButton2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Validates the credit card number has exactly 16 digits.
     *
     * @return {@code true} if the card number is valid
     */
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

    /**
     * Converts the date spinner value to a {@link LocalDate}.
     *
     * @return the selected date as a LocalDate
     */
    private LocalDate getSpinnerDate() {
        Date date = (Date) jSpinner1.getValue();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Creates a new IndividualCustomer from the form fields and adds it to the registry.
     */
    private void createIndividualCustomer() {
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

        IndividualCustomer customer = new IndividualCustomer(
                CAMPODNI.getText(),
                CAMPONOMBRE.getText(),
                CAMPOMAIL.getText(),
                valueOf(CAMPOCLAVE.getPassword()),
                address,
                card,
                Integer.parseInt(CAMPOTELEFONO.getText()));

        StoreManager.customerRegistry.put(customer.getEmail(), customer);
    }

    /** Handles the confirm registration button click. */
    private void handleConfirmRegistration() {
        if (isCreditCardValid()) {
            createIndividualCustomer();
            JOptionPane.showMessageDialog(this,
                    "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            CustomerLoginFrame clf = new CustomerLoginFrame();
            clf.setVisible(true);
            this.dispose();
        }
    }

    /** Handles the cancel button click. */
    private void handleCancel() {
        CustomerRegistrationFrame crf = new CustomerRegistrationFrame();
        crf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new IndividualRegistrationFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CAMPOCALLE;
    private javax.swing.JTextField CAMPOCIUDAD;
    private javax.swing.JPasswordField CAMPOCLAVE;
    private javax.swing.JTextField CAMPOCP;
    private javax.swing.JTextField CAMPODNI;
    private javax.swing.JTextField CAMPOMAIL;
    private javax.swing.JTextField CAMPONOMBRE;
    private javax.swing.JTextField CAMPONUMEROD;
    private javax.swing.JTextField CAMPONUMEROT;
    private javax.swing.JTextField CAMPOTELEFONO;
    private javax.swing.JTextField CAMPOTITULAR;
    private javax.swing.JLabel CLAVETXT;
    private javax.swing.JLabel CORREOTXT;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel NOMBRETXT;
    private javax.swing.JLabel TELEFONOTXT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
