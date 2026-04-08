package com.javacomp.ui;

import static java.lang.String.valueOf;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.javacomp.exception.CreditCardException;
import com.javacomp.model.IndividualCustomer;
import com.javacomp.model.Customer;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Profile editing form for individual (personal) customers.
 *
 * <p>Pre-fills all fields with the active customer's current data.
 * On confirm, updates the customer object in-place.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class EditIndividualFrame extends javax.swing.JFrame {

    public EditIndividualFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
        populateFields();
    }

    /** Pre-fills form fields with the active customer's current data. */
    private void populateFields() {
        Customer active = CustomerLoginFrame.getActiveCustomer();
        NOMBRE.setText(active.getName());
        CALLE.setText(active.getAddress().getStreet());
        CP.setText(valueOf(active.getAddress().getPostalCode()));
        NUMEROD.setText(valueOf(active.getAddress().getStreetNumber()));
        CIUDAD.setText(active.getAddress().getCity());
        NUMEROT.setText(valueOf(active.getCreditCard().getCardNumber()));
        NOMBRET.setText(active.getCreditCard().getHolderName());
        TELEFONO.setText(valueOf(active.getPhoneNumber()));
        DNI.setText(((IndividualCustomer) active).getDni());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LOGO = new javax.swing.JLabel();
        TELEFONO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DNI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NUMEROT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Date hoy = new Date();
        jSpinner1 = new javax.swing.JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.MONTH));
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CALLE = new javax.swing.JTextField();
        NOMBRETXT = new javax.swing.JLabel();
        NUMEROD = new javax.swing.JTextField();
        CP = new javax.swing.JTextField();
        CIUDAD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NOMBRE = new javax.swing.JTextField();
        NOMBRET = new javax.swing.JTextField();
        TELEFONOTXT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Profile - Individual");
        setResizable(false);

        jLabel2.setText("ID (DNI):");
        jLabel3.setText("Enter your credit card details:");
        jLabel4.setText("Cardholder:");
        jLabel5.setText("Number:");
        jLabel6.setText("Expiration Date:");
        JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner1, "yyyy/MM/dd");
        jSpinner1.setEditor(editor);
        jLabel7.setText("Enter your address details:");
        jLabel8.setText("Street:");
        jLabel9.setText("Number:");
        jLabel10.setText("Zip Code:");
        jLabel11.setText("City:");
        jLabel1.setText("Fill in the required information:");
        NOMBRETXT.setText("Name:");
        TELEFONOTXT.setText("Phone:");

        jButton1.setText("CANCEL");
        jButton1.addActionListener(evt -> handleCancel());

        jButton2.setText("CONFIRM REGISTRATION");
        jButton2.addActionListener(evt -> handleConfirm());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NOMBRETXT).addComponent(jLabel2).addComponent(TELEFONOTXT))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(DNI).addComponent(TELEFONO))
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4).addComponent(NOMBRET, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5).addComponent(NUMEROT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6).addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel7)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8).addComponent(CALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10).addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11).addComponent(CIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9).addComponent(NUMEROD, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1).addGap(50).addComponent(jButton2))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NOMBRETXT).addComponent(NOMBRE)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(DNI))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TELEFONOTXT).addComponent(TELEFONO))
            .addGap(20)
            .addComponent(jLabel3)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4).addComponent(NOMBRET)
                .addComponent(jLabel5).addComponent(NUMEROT)
                .addComponent(jLabel6).addComponent(jSpinner1))
            .addGap(20)
            .addComponent(jLabel7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8).addComponent(CALLE)
                .addComponent(jLabel10).addComponent(CP)
                .addComponent(jLabel11).addComponent(CIUDAD))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9).addComponent(NUMEROD))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1).addComponent(jButton2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean isCreditCardValid() {
        try {
            if (NUMEROT.getText().length() != 16) {
                throw new CreditCardException(CreditCardException.INVALID_DIGIT_COUNT);
            }
            return true;
        } catch (CreditCardException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void handleConfirm() {
        if (isCreditCardValid()) {
            Customer active = CustomerLoginFrame.getActiveCustomer();

            active.setName(NOMBRE.getText());
            active.setPhoneNumber(Integer.parseInt(TELEFONO.getText()));
            active.getCreditCard().setCardNumber(Long.parseLong(NUMEROT.getText()));
            active.getCreditCard().setHolderName(NOMBRET.getText());
            active.getAddress().setStreet(CALLE.getText());
            active.getAddress().setCity(CIUDAD.getText());
            active.getAddress().setPostalCode(Integer.parseInt(CP.getText()));
            active.getAddress().setStreetNumber(Integer.parseInt(NUMEROD.getText()));
            ((IndividualCustomer) active).setDni(DNI.getText());

            // Update card expiration date from the spinner
            Date d = (Date) jSpinner1.getValue();
            Instant instant = Instant.ofEpochMilli(d.getTime());
            LocalDate expDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
            active.getCreditCard().setExpirationDate(expDate);

            JOptionPane.showMessageDialog(this,
                    "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            CustomerMenuFrame cmf = new CustomerMenuFrame();
            cmf.setVisible(true);
            this.dispose();
        }
    }

    private void handleCancel() {
        CustomerMenuFrame cmf = new CustomerMenuFrame();
        cmf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new EditIndividualFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CALLE;
    private javax.swing.JTextField CIUDAD;
    private javax.swing.JTextField CP;
    private javax.swing.JTextField DNI;
    private javax.swing.JLabel LOGO;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JTextField NOMBRET;
    private javax.swing.JLabel NOMBRETXT;
    private javax.swing.JTextField NUMEROD;
    private javax.swing.JTextField NUMEROT;
    private javax.swing.JTextField TELEFONO;
    private javax.swing.JLabel TELEFONOTXT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
