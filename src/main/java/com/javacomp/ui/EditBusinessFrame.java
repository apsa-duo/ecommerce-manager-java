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
import com.javacomp.model.BusinessCustomer;
import com.javacomp.model.Customer;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Profile editing form for business customers.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class EditBusinessFrame extends javax.swing.JFrame {

    public EditBusinessFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
        populateFields();
    }

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
        WEB.setText(((BusinessCustomer) active).getWebsite());
        CIF.setText(((BusinessCustomer) active).getCif());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NOMBRETXT = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        WEB = new javax.swing.JTextField();
        CALLE = new javax.swing.JTextField();
        MODIFICAR = new javax.swing.JButton();
        NOMBRET = new javax.swing.JTextField();
        NUMEROD = new javax.swing.JTextField();
        NOMBRE = new javax.swing.JTextField();
        CP = new javax.swing.JTextField();
        TELEFONOTXT = new javax.swing.JLabel();
        CIUDAD = new javax.swing.JTextField();
        TELEFONO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CANCELAR = new javax.swing.JButton();
        CIF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NUMEROT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LOGO = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Date hoy = new Date();
        jSpinner1 = new javax.swing.JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.MONTH));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Profile - Business");
        setResizable(false);

        NOMBRETXT.setText("Name:");
        jLabel11.setText("City:");
        jLabel12.setText("WEBSITE:");
        TELEFONOTXT.setText("Phone:");
        jLabel2.setText("ID (CIF):");
        jLabel3.setText("Enter your credit card details:");
        jLabel4.setText("Cardholder:");
        jLabel5.setText("Number:");
        jLabel6.setText("Expiration Date:");
        jLabel9.setText("Number:");
        jLabel7.setText("Enter your address details:");
        jLabel8.setText("Street:");
        jLabel10.setText("Zip Code:");

        MODIFICAR.setText("MODIFY");
        MODIFICAR.addActionListener(evt -> handleModify());

        CANCELAR.setText("CANCEL");
        CANCELAR.addActionListener(evt -> handleCancel());

        JSpinner.DateEditor editor = new JSpinner.DateEditor(jSpinner1, "yyyy/MM/dd");
        jSpinner1.setEditor(editor);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NOMBRETXT).addComponent(TELEFONOTXT).addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(TELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CIF, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup().addComponent(jLabel12).addComponent(WEB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jLabel3)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4).addComponent(NOMBRET, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5).addComponent(NUMEROT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6).addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel7)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8).addComponent(CALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10).addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11).addComponent(CIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9).addComponent(NUMEROD, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(CANCELAR).addGap(50).addComponent(MODIFICAR))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(NOMBRETXT).addComponent(NOMBRE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(TELEFONOTXT).addComponent(TELEFONO)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(CIF)
                .addComponent(jLabel12).addComponent(WEB))
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
                .addComponent(CANCELAR).addComponent(MODIFICAR))
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

    private void handleModify() {
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
            ((BusinessCustomer) active).setCif(CIF.getText());
            ((BusinessCustomer) active).setWebsite(WEB.getText());

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
        java.awt.EventQueue.invokeLater(() -> new EditBusinessFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CALLE;
    private javax.swing.JButton CANCELAR;
    private javax.swing.JTextField CIF;
    private javax.swing.JTextField CIUDAD;
    private javax.swing.JTextField CP;
    private javax.swing.JLabel LOGO;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JTextField NOMBRET;
    private javax.swing.JLabel NOMBRETXT;
    private javax.swing.JTextField NUMEROD;
    private javax.swing.JTextField NUMEROT;
    private javax.swing.JTextField TELEFONO;
    private javax.swing.JLabel TELEFONOTXT;
    private javax.swing.JTextField WEB;
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
