package com.javacomp.ui;

import static java.lang.String.valueOf;
import javax.swing.JComboBox;

import com.javacomp.model.BusinessCustomer;
import com.javacomp.model.Customer;
import com.javacomp.model.IndividualCustomer;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Admin screen for viewing registered customer details.
 *
 * <p>Selects a customer by email from a combo box and displays
 * all their profile information. Uses {@code instanceof} for
 * type-specific fields (DNI for individuals, CIF/Website for businesses).</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class UserManagementFrame extends javax.swing.JFrame {

    public UserManagementFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JLABELNOMBRE = new javax.swing.JLabel();
        JLABELCORREO = new javax.swing.JLabel();
        NOMBRE = new javax.swing.JTextField();
        CORREO = new javax.swing.JTextField();
        CALLE = new javax.swing.JTextField();
        CP = new javax.swing.JTextField();
        NUMEROD = new javax.swing.JTextField();
        CIUDAD = new javax.swing.JTextField();
        NOMBRET = new javax.swing.JTextField();
        FECHA = new javax.swing.JTextField();
        NUMEROT = new javax.swing.JTextField();
        TELEFONO = new javax.swing.JTextField();
        ATRAS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Ciudad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JLABELTFONO = new javax.swing.JLabel();
        DNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CIF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        WEB = new javax.swing.JTextField();
        LOGO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Management");
        setResizable(false);

        // Populate combo box with customer emails
        loadCustomerEmails();
        usuarios.addItemListener(evt -> onCustomerSelected());

        jLabel2.setText("Select a user:");
        JLABELNOMBRE.setText("NAME:");
        JLABELCORREO.setText("EMAIL:");
        jLabel1.setText("ADDRESS:");
        Ciudad.setText("City:");
        jLabel4.setText("Zip Code:");
        jLabel3.setText("Street:");
        jLabel5.setText("Number:");
        jLabel6.setText("Name:");
        jLabel7.setText("Expiration Date:");
        jLabel8.setText("Number:");
        jLabel9.setText("CREDIT CARD:");
        JLABELTFONO.setText("PHONE:");
        jLabel10.setText("ID (DNI):");
        jLabel11.setText("ID (CIF):");
        jLabel12.setText("WEBSITE:");

        ATRAS.setText("BACK");
        ATRAS.addActionListener(evt -> handleBack());

        // Initial population if a customer is already selected
        displaySelectedCustomer();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JLABELNOMBRE).addComponent(NOMBRE, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30).addComponent(JLABELCORREO).addComponent(CORREO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addComponent(jLabel3).addComponent(CALLE, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4).addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80).addComponent(jLabel5).addComponent(NUMEROD, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Ciudad).addComponent(CIUDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9).addComponent(jLabel6).addComponent(NOMBRET, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7).addComponent(FECHA, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(150).addComponent(jLabel8).addComponent(NUMEROT, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(JLABELTFONO).addComponent(TELEFONO, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30).addComponent(jLabel10).addComponent(DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200).addComponent(jLabel11).addComponent(CIF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ATRAS).addGap(50).addComponent(jLabel12).addComponent(WEB, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(usuarios))
            .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(JLABELNOMBRE).addComponent(NOMBRE)
                .addComponent(JLABELCORREO).addComponent(CORREO))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1).addComponent(jLabel3).addComponent(CALLE)
                .addComponent(jLabel4).addComponent(CP))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5).addComponent(NUMEROD)
                .addComponent(Ciudad).addComponent(CIUDAD))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9).addComponent(jLabel6).addComponent(NOMBRET)
                .addComponent(jLabel7).addComponent(FECHA))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8).addComponent(NUMEROT))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(JLABELTFONO).addComponent(TELEFONO)
                .addComponent(jLabel10).addComponent(DNI))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11).addComponent(CIF))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ATRAS).addComponent(jLabel12).addComponent(WEB))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadCustomerEmails() {
        usuarios = new JComboBox<>(StoreManager.customerRegistry.keySet().toArray(new String[0]));
    }

    /**
     * Displays the selected customer's details in all form fields.
     * Uses instanceof to cleanly determine customer type (KISS improvement
     * over the original fragile getClass().toString().equals() approach).
     */
    private void displaySelectedCustomer() {
        if (usuarios.getSelectedItem() == null) return;

        String email = usuarios.getSelectedItem().toString();
        Customer customer = StoreManager.customerRegistry.get(email);
        if (customer == null) return;

        NOMBRE.setText(customer.getName());
        CORREO.setText(customer.getEmail());
        CALLE.setText(customer.getAddress().getStreet());
        CP.setText(valueOf(customer.getAddress().getPostalCode()));
        NUMEROD.setText(valueOf(customer.getAddress().getStreetNumber()));
        CIUDAD.setText(customer.getAddress().getCity());
        NOMBRET.setText(customer.getCreditCard().getHolderName());
        FECHA.setText(customer.getCreditCard().getExpirationDate().toString());
        NUMEROT.setText(valueOf(customer.getCreditCard().getCardNumber()));
        TELEFONO.setText(valueOf(customer.getPhoneNumber()));

        // Use instanceof for clean type discrimination
        if (customer instanceof IndividualCustomer individual) {
            DNI.setText(individual.getDni());
            CIF.setText("---");
            WEB.setText("---");
        } else if (customer instanceof BusinessCustomer business) {
            DNI.setText("---");
            CIF.setText(business.getCif());
            WEB.setText(business.getWebsite());
        }
    }

    private void onCustomerSelected() {
        displaySelectedCustomer();
    }

    private void handleBack() {
        AdminMenuFrame amf = new AdminMenuFrame();
        amf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new UserManagementFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JTextField CALLE;
    private javax.swing.JTextField CIF;
    private javax.swing.JTextField CIUDAD;
    private javax.swing.JTextField CORREO;
    private javax.swing.JTextField CP;
    private javax.swing.JLabel Ciudad;
    private javax.swing.JTextField DNI;
    private javax.swing.JTextField FECHA;
    private javax.swing.JLabel JLABELCORREO;
    private javax.swing.JLabel JLABELNOMBRE;
    private javax.swing.JLabel JLABELTFONO;
    private javax.swing.JLabel LOGO;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JTextField NOMBRET;
    private javax.swing.JTextField NUMEROD;
    private javax.swing.JTextField NUMEROT;
    private javax.swing.JTextField TELEFONO;
    private javax.swing.JTextField WEB;
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
    private javax.swing.JComboBox<String> usuarios;
    // End of variables declaration//GEN-END:variables
}
