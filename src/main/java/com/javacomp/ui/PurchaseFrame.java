package com.javacomp.ui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.javacomp.exception.PurchaseException;
import com.javacomp.exception.StockException;
import com.javacomp.exception.CreditCardException;
import com.javacomp.model.Customer;
import com.javacomp.model.Product;
import com.javacomp.model.Purchase;
import com.javacomp.model.PurchaseItem;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Full shopping experience — browse products, manage a cart, and complete a purchase.
 *
 * <p>This is the most complex screen in the application. It handles:
 * product browsing with search/sort, adding items to cart with stock
 * validation, cart management (remove, clear), total calculation
 * with shipping, credit card validation, invoice generation,
 * and purchase persistence.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class PurchaseFrame extends javax.swing.JFrame {

    private static final Logger LOGGER = Logger.getLogger(PurchaseFrame.class.getName());
    private static final DateTimeFormatter INVOICE_DATE_FORMAT =
            DateTimeFormatter.ofPattern(Constants.SHORT_DATE_PATTERN);

    private final DefaultTableModel catalogModel = new DefaultTableModel();
    private final DefaultTableModel cartModel = new DefaultTableModel();
    private final List<PurchaseItem> cartItems = new ArrayList<>();

    public PurchaseFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
        configureTables();
        refreshCatalog();
    }

    private void configureTables() {
        catalogModel.addColumn("Name");
        catalogModel.addColumn("Description");
        catalogModel.addColumn("Category");
        catalogModel.addColumn("Price");
        catalogModel.addColumn("Stock");
        TABLACATALOGO.setModel(catalogModel);

        cartModel.addColumn("Product");
        cartModel.addColumn("Quantity");
        cartModel.addColumn("Subtotal");
        TABLACARRITO.setModel(cartModel);
    }

    private void refreshCatalog() {
        catalogModel.setRowCount(0);
        for (Product product : StoreManager.productCatalog.values()) {
            catalogModel.addRow(new Object[]{
                product.getTitle(), product.getDescription(),
                product.getCategory(), product.getPrice(), product.getStock()
            });
        }
    }

    private void refreshCart() {
        cartModel.setRowCount(0);
        for (PurchaseItem item : cartItems) {
            cartModel.addRow(new Object[]{
                item.getProduct().getTitle(),
                item.getQuantity(),
                item.getSubtotal()
            });
        }
        updateTotals();
    }

    private void updateTotals() {
        double subtotal = 0;
        int totalItems = 0;
        for (PurchaseItem item : cartItems) {
            subtotal += item.getSubtotal();
            totalItems += item.getQuantity();
        }
        double total = subtotal + (cartItems.isEmpty() ? 0 : Constants.SHIPPING_COST);
        SUBTOTAL.setText(String.valueOf(subtotal));
        TOTAL.setText(String.valueOf(total));
        NUMPRODUCTOS.setText(String.valueOf(totalItems));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TABLACATALOGO = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABLACARRITO = new javax.swing.JTable();
        LOGO = new javax.swing.JLabel();
        FOTOPRODUCTO = new javax.swing.JLabel();
        OPINION = new javax.swing.JTextField();

        COMBOBUSCAR = new javax.swing.JComboBox<>(Constants.PRODUCT_CATEGORIES);
        COMBOORDEN = new javax.swing.JComboBox<>(Constants.SORT_OPTIONS);
        CANTIDAD = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1, 1, 999, 1));

        BUSCAR = new javax.swing.JButton();
        MOSTRAR = new javax.swing.JButton();
        ORDENAR = new javax.swing.JButton();
        AGREGAR = new javax.swing.JButton();
        QUITAR = new javax.swing.JButton();
        VACIAR = new javax.swing.JButton();
        COMPRAR = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();

        SUBTOTAL = new javax.swing.JTextField();
        TOTAL = new javax.swing.JTextField();
        NUMPRODUCTOS = new javax.swing.JTextField();

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shopping");
        setResizable(false);

        TABLACATALOGO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) { onCatalogRowClicked(); }
        });
        jScrollPane1.setViewportView(TABLACATALOGO);
        jScrollPane2.setViewportView(TABLACARRITO);

        jLabel1.setText("Product Catalog");
        jLabel2.setText("Shopping Cart");
        jLabel3.setText("Search:");
        jLabel4.setText("Sort:");
        jLabel5.setText("Quantity:");
        jLabel6.setText("Subtotal:");
        jLabel7.setText("Total (+ shipping):");
        jLabel8.setText("Reviews:");

        BUSCAR.setText("SEARCH");
        BUSCAR.addActionListener(evt -> handleCatalogSearch());
        MOSTRAR.setText("SHOW ALL");
        MOSTRAR.addActionListener(evt -> refreshCatalog());
        ORDENAR.setText("SORT");
        ORDENAR.addActionListener(evt -> handleCatalogSort());
        AGREGAR.setText("ADD TO CART");
        AGREGAR.addActionListener(evt -> handleAddToCart());
        QUITAR.setText("REMOVE");
        QUITAR.addActionListener(evt -> handleRemoveFromCart());
        VACIAR.setText("EMPTY CART");
        VACIAR.addActionListener(evt -> handleClearCart());
        COMPRAR.setText("SHOP");
        COMPRAR.addActionListener(evt -> handlePurchase());
        ATRAS.setText("BACK");
        ATRAS.addActionListener(evt -> handleBack());

        SUBTOTAL.setEditable(false);
        TOTAL.setEditable(false);
        NUMPRODUCTOS.setEditable(false);
        OPINION.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3).addComponent(COMBOBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(BUSCAR)
                .addGap(10).addComponent(jLabel4).addComponent(COMBOORDEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(ORDENAR)
                .addGap(10).addComponent(MOSTRAR))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8).addComponent(OPINION, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(FOTOPRODUCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5).addComponent(CANTIDAD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(AGREGAR).addComponent(QUITAR).addComponent(VACIAR))
            .addComponent(jLabel2)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6).addComponent(SUBTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7).addComponent(TOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(NUMPRODUCTOS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(COMPRAR).addGap(30).addComponent(ATRAS))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3).addComponent(COMBOBUSCAR).addComponent(BUSCAR)
                .addComponent(jLabel4).addComponent(COMBOORDEN).addComponent(ORDENAR).addComponent(MOSTRAR))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8).addComponent(OPINION)
                .addComponent(FOTOPRODUCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5).addComponent(CANTIDAD).addComponent(AGREGAR).addComponent(QUITAR).addComponent(VACIAR))
            .addGap(10)
            .addComponent(jLabel2)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6).addComponent(SUBTOTAL).addComponent(jLabel7).addComponent(TOTAL).addComponent(NUMPRODUCTOS))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(COMPRAR).addComponent(ATRAS))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onCatalogRowClicked() {
        int row = TABLACATALOGO.getSelectedRow();
        if (row < 0) return;
        String title = (String) catalogModel.getValueAt(row, 0);
        Product product = StoreManager.productCatalog.get(title);
        if (product == null) return;

        StringBuilder reviews = new StringBuilder();
        for (var r : product.getReviews()) {
            reviews.append(r.toString()).append(" | ");
        }
        OPINION.setText(reviews.toString());

        try {
            ImageIcon icon = new ImageIcon(Constants.IMAGES_DIR + product.getImageName());
            ImageIcon scaled = new ImageIcon(icon.getImage().getScaledInstance(
                    FOTOPRODUCTO.getWidth(), FOTOPRODUCTO.getHeight(), java.awt.Image.SCALE_SMOOTH));
            FOTOPRODUCTO.setIcon(scaled);
        } catch (Exception e) {
            FOTOPRODUCTO.setIcon(null);
        }
    }

    private void handleCatalogSearch() {
        String category = (String) COMBOBUSCAR.getSelectedItem();
        catalogModel.setRowCount(0);
        for (Product p : StoreManager.productCatalog.values()) {
            if (p.getCategory().equals(category)) {
                catalogModel.addRow(new Object[]{p.getTitle(), p.getDescription(), p.getCategory(), p.getPrice(), p.getStock()});
            }
        }
    }

    /** Sorts catalog using Comparator instead of the original hand-written bubble sort. */
    private void handleCatalogSort() {
        String sortOption = (String) COMBOORDEN.getSelectedItem();
        List<Product> products = new ArrayList<>(StoreManager.productCatalog.values());

        if (Constants.SORT_BY_PRICE_DESC.equals(sortOption)) {
            products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        } else if (Constants.SORT_BY_PRICE_ASC.equals(sortOption)) {
            products.sort(Comparator.comparingDouble(Product::getPrice));
        } else {
            products.sort(Comparator.comparingDouble(Product::getAverageRating).reversed());
        }

        catalogModel.setRowCount(0);
        for (Product p : products) {
            catalogModel.addRow(new Object[]{p.getTitle(), p.getDescription(), p.getCategory(), p.getPrice(), p.getStock()});
        }
    }

    /** Adds the selected product to the cart with stock validation. */
    private void handleAddToCart() {
        int row = TABLACATALOGO.getSelectedRow();
        if (row < 0) return;

        String title = (String) catalogModel.getValueAt(row, 0);
        Product product = StoreManager.productCatalog.get(title);
        int quantity = (int) CANTIDAD.getValue();

        try {
            // Check if already in cart
            for (PurchaseItem item : cartItems) {
                if (item.getProduct().getTitle().equals(title)) {
                    throw new PurchaseException(PurchaseException.PRODUCT_ALREADY_ADDED);
                }
            }
            // Validate stock
            if (product.getStock() == 0) {
                throw new StockException(StockException.OUT_OF_STOCK);
            }
            if (quantity > product.getStock()) {
                throw new StockException(StockException.INSUFFICIENT_STOCK);
            }

            cartItems.add(new PurchaseItem(product, quantity));
            refreshCart();

        } catch (PurchaseException | StockException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void handleRemoveFromCart() {
        int row = TABLACARRITO.getSelectedRow();
        if (row >= 0 && row < cartItems.size()) {
            cartItems.remove(row);
            refreshCart();
        }
    }

    private void handleClearCart() {
        cartItems.clear();
        refreshCart();
    }

    /** Completes the purchase: validates card, deducts stock, generates invoice, persists data. */
    private void handlePurchase() {
        if (cartItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty.",
                    "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Customer customer = CustomerLoginFrame.getActiveCustomer();

        // Validate credit card
        try {
            String cardNum = String.valueOf(customer.getCreditCard().getCardNumber());
            if (cardNum.length() != 16) {
                throw new CreditCardException(CreditCardException.INVALID_DIGIT_COUNT);
            }
            if (!customer.getCreditCard().isValid()) {
                throw new CreditCardException(CreditCardException.CARD_EXPIRED);
            }
        } catch (CreditCardException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Payment Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Deduct stock for each item
        for (PurchaseItem item : cartItems) {
            Product product = item.getProduct();
            product.setStock(product.getStock() - item.getQuantity());
        }

        // Create and save the purchase
        double total = Double.parseDouble(TOTAL.getText());
        int itemCount = Integer.parseInt(NUMPRODUCTOS.getText());
        Purchase purchase = new Purchase(total, itemCount, customer,
                new ArrayList<>(cartItems), LocalDate.now());
        StoreManager.salesHistory.add(purchase);

        // Generate invoice file
        generateInvoice(purchase);

        // Persist all data
        StoreManager.saveProducts();
        StoreManager.saveSales();
        StoreManager.saveCustomers();

        JOptionPane.showMessageDialog(this,
                "Purchase completed! Invoice saved to " + Constants.INVOICES_DIR,
                "Success", JOptionPane.INFORMATION_MESSAGE);

        CustomerMenuFrame cmf = new CustomerMenuFrame();
        cmf.setVisible(true);
        this.dispose();
    }

    /**
     * Generates a text invoice file for the completed purchase.
     *
     * @param purchase the completed purchase to invoice
     */
    private void generateInvoice(Purchase purchase) {
        LocalDate today = LocalDate.now();
        String dateStr = today.format(INVOICE_DATE_FORMAT);
        String fileName = Constants.INVOICES_DIR + "/Invoice(" + dateStr.replace("/", "_") + ").txt";

        // Ensure the invoices directory exists
        new File(Constants.INVOICES_DIR).mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("-------------------------------- Purchase Invoice --------------------------------");
            writer.newLine();
            writer.newLine();
            writer.write("-------------------------------- Date: " + dateStr + " -------------------------------");
            writer.newLine();
            writer.newLine();

            for (PurchaseItem item : purchase.getCartItems()) {
                writer.newLine();
                writer.write("Product Name: " + item.getProduct().getTitle());
                writer.newLine();
                writer.write("Características: " + item.getProduct().getDescription());
                writer.newLine();
                writer.write("Categoría: " + item.getProduct().getCategory());
                writer.newLine();
                writer.write("Unit Price: " + item.getProduct().getPrice());
                writer.newLine();
                writer.write("Cantidad: " + item.getQuantity());
                writer.newLine();
                writer.newLine();
            }

            Customer customer = purchase.getCustomer();
            writer.write("CUSTOMER DETAILS:");
            writer.newLine();
            writer.write("    Name: " + customer.getName());
            writer.newLine();
            writer.write("    Email: " + customer.getEmail());
            writer.newLine();
            writer.write("    Card Number: " + customer.getCreditCard().getCardNumber());
            writer.newLine();
            writer.write("    Phone: " + customer.getPhoneNumber());
            writer.newLine();
            writer.write("---------------------------------------------------------------------------------");
            writer.newLine();
            writer.write("TOTAL: " + purchase.getTotalAmount());
            writer.newLine();
            writer.newLine();
            writer.write("-------------------------------------------------------------------------------");

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to generate invoice", ex);
        }
    }

    private void handleBack() {
        CustomerMenuFrame cmf = new CustomerMenuFrame();
        cmf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new PurchaseFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AGREGAR;
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton BUSCAR;
    private javax.swing.JSpinner CANTIDAD;
    private javax.swing.JComboBox<String> COMBOBUSCAR;
    private javax.swing.JComboBox<String> COMBOORDEN;
    private javax.swing.JButton COMPRAR;
    private javax.swing.JLabel FOTOPRODUCTO;
    private javax.swing.JLabel LOGO;
    private javax.swing.JButton MOSTRAR;
    private javax.swing.JTextField NUMPRODUCTOS;
    private javax.swing.JTextField OPINION;
    private javax.swing.JButton ORDENAR;
    private javax.swing.JButton QUITAR;
    private javax.swing.JTextField SUBTOTAL;
    private javax.swing.JTable TABLACATALOGO;
    private javax.swing.JTable TABLACARRITO;
    private javax.swing.JTextField TOTAL;
    private javax.swing.JButton VACIAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
