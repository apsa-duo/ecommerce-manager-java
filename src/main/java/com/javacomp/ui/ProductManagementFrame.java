package com.javacomp.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.javacomp.model.Product;
import com.javacomp.model.Review;
import com.javacomp.model.StoreManager;
import com.javacomp.util.Constants;
import com.javacomp.util.UIHelper;

/**
 * Admin screen for managing the product catalog (CRUD operations).
 *
 * <p>Supports adding, modifying, deleting products, and viewing
 * product details with associated customer reviews. Features search
 * by category and sort by price/relevance.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class ProductManagementFrame extends javax.swing.JFrame {

    private final DefaultTableModel tableModel = new DefaultTableModel();

    public ProductManagementFrame() {
        initComponents();
        UIHelper.loadScaledIcon(Constants.LOGO_PATH, LOGO);
        configureTable();
        refreshTable();
    }

    /** Sets up the table columns for the product listing. */
    private void configureTable() {
        tableModel.addColumn("Name");
        tableModel.addColumn("Description");
        tableModel.addColumn("Category");
        tableModel.addColumn("Price");
        tableModel.addColumn("Stock");
        jTable1.setModel(tableModel);
    }

    /** Reloads all products from the catalog into the table. */
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Product product : StoreManager.productCatalog.values()) {
            tableModel.addRow(new Object[]{
                product.getTitle(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),
                product.getStock()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        NOMBRE = new javax.swing.JTextField();
        CARACTERISTICAS = new javax.swing.JTextField();
        COMBO = new javax.swing.JComboBox<>(Constants.PRODUCT_CATEGORIES);
        PRECIO = new javax.swing.JTextField();
        STOCK = new javax.swing.JTextField();
        IMAGEN = new javax.swing.JTextField();
        ANADIR = new javax.swing.JButton();
        MODIFICAR = new javax.swing.JButton();
        ELIMINAR = new javax.swing.JButton();
        ATRAS = new javax.swing.JButton();
        LOGO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        OPINION = new javax.swing.JTextField();
        FOTOPRODUCTO = new javax.swing.JLabel();
        COMBOBUSCAR = new javax.swing.JComboBox<>(Constants.PRODUCT_CATEGORIES);
        BUSCAR = new javax.swing.JButton();
        COMBOORDEN = new javax.swing.JComboBox<>(Constants.SORT_OPTIONS);
        ORDENAR = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MOSTRAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Management");
        setResizable(false);

        jTable1.setModel(tableModel);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onTableRowClicked();
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Name:");
        jLabel2.setText("Description:");
        jLabel3.setText("Category:");
        jLabel4.setText("Price:");
        jLabel5.setText("Stock:");
        jLabel6.setText("Image:");
        jLabel7.setText("Reviews:");
        jLabel8.setText("Search by category:");
        jLabel9.setText("Sort by:");

        ANADIR.setText("ADD");
        ANADIR.addActionListener(evt -> handleAdd());

        MODIFICAR.setText("MODIFY");
        MODIFICAR.addActionListener(evt -> handleModify());

        ELIMINAR.setText("DELETE");
        ELIMINAR.addActionListener(evt -> handleDelete());

        ATRAS.setText("BACK");
        ATRAS.addActionListener(evt -> handleBack());

        BUSCAR.setText("SEARCH");
        BUSCAR.addActionListener(evt -> handleSearch());

        ORDENAR.setText("SORT");
        ORDENAR.addActionListener(evt -> handleSort());

        MOSTRAR.setText("SHOW ALL");
        MOSTRAR.addActionListener(evt -> refreshTable());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3)
                    .addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NOMBRE, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(CARACTERISTICAS).addComponent(COMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PRECIO, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(STOCK, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IMAGEN).addComponent(OPINION))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FOTOPRODUCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ANADIR).addComponent(MODIFICAR).addComponent(ELIMINAR)
                .addGap(30).addComponent(ATRAS))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8).addComponent(COMBOBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(BUSCAR)
                .addGap(20).addComponent(jLabel9).addComponent(COMBOORDEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(ORDENAR)
                .addGap(20).addComponent(MOSTRAR))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8).addComponent(COMBOBUSCAR).addComponent(BUSCAR)
                .addComponent(jLabel9).addComponent(COMBOORDEN).addComponent(ORDENAR)
                .addComponent(MOSTRAR))
            .addGap(10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1).addComponent(NOMBRE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(CARACTERISTICAS)
                .addComponent(FOTOPRODUCTO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3).addComponent(COMBO))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4).addComponent(PRECIO)
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5).addComponent(STOCK))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6).addComponent(IMAGEN))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7).addComponent(OPINION))
            .addGap(10)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(ANADIR).addComponent(MODIFICAR).addComponent(ELIMINAR).addComponent(ATRAS))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /** Populates form fields when a table row is clicked. */
    private void onTableRowClicked() {
        int row = jTable1.getSelectedRow();
        if (row < 0) return;

        String title = (String) tableModel.getValueAt(row, 0);
        Product product = StoreManager.productCatalog.get(title);
        if (product == null) return;

        NOMBRE.setText(product.getTitle());
        CARACTERISTICAS.setText(product.getDescription());
        COMBO.setSelectedItem(product.getCategory());
        PRECIO.setText(String.valueOf(product.getPrice()));
        STOCK.setText(String.valueOf(product.getStock()));
        IMAGEN.setText(product.getImageName());

        // Display reviews as comma-separated string
        StringBuilder reviewText = new StringBuilder();
        for (Review review : product.getReviews()) {
            reviewText.append(review.toString()).append(" | ");
        }
        OPINION.setText(reviewText.toString());

        // Load product image
        try {
            ImageIcon icon = new ImageIcon(Constants.IMAGES_DIR + product.getImageName());
            ImageIcon scaled = new ImageIcon(icon.getImage().getScaledInstance(
                    FOTOPRODUCTO.getWidth(), FOTOPRODUCTO.getHeight(), java.awt.Image.SCALE_SMOOTH));
            FOTOPRODUCTO.setIcon(scaled);
        } catch (Exception e) {
            FOTOPRODUCTO.setIcon(null);
        }
    }

    /** Adds a new product to the catalog. */
    private void handleAdd() {
        String title = NOMBRE.getText();
        if (title.isEmpty() || StoreManager.productCatalog.containsKey(title)) {
            JOptionPane.showMessageDialog(this,
                    "Product name is empty or already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Product product = new Product(
                title,
                CARACTERISTICAS.getText(),
                (String) COMBO.getSelectedItem(),
                Double.parseDouble(PRECIO.getText()),
                IMAGEN.getText(),
                Integer.parseInt(STOCK.getText()),
                LocalDate.now());

        StoreManager.productCatalog.put(title, product);
        StoreManager.saveProducts();
        refreshTable();
    }

    /** Modifies the selected product's details. */
    private void handleModify() {
        int row = jTable1.getSelectedRow();
        if (row < 0) return;

        String originalTitle = (String) tableModel.getValueAt(row, 0);
        Product product = StoreManager.productCatalog.get(originalTitle);
        if (product == null) return;

        product.setTitle(NOMBRE.getText());
        product.setDescription(CARACTERISTICAS.getText());
        product.setCategory((String) COMBO.getSelectedItem());
        product.setPrice(Double.parseDouble(PRECIO.getText()));
        product.setStock(Integer.parseInt(STOCK.getText()));
        product.setImageName(IMAGEN.getText());

        // If the title changed, update the map key
        if (!originalTitle.equals(NOMBRE.getText())) {
            StoreManager.productCatalog.remove(originalTitle);
            StoreManager.productCatalog.put(product.getTitle(), product);
        }

        StoreManager.saveProducts();
        refreshTable();
    }

    /** Deletes the selected product from the catalog. */
    private void handleDelete() {
        int row = jTable1.getSelectedRow();
        if (row < 0) return;

        String title = (String) tableModel.getValueAt(row, 0);
        StoreManager.productCatalog.remove(title);
        StoreManager.saveProducts();
        refreshTable();
    }

    /**
     * Filters products by the selected category.
     * Replaces the original manual iteration with a stream-like approach.
     */
    private void handleSearch() {
        String category = (String) COMBOBUSCAR.getSelectedItem();
        tableModel.setRowCount(0);

        for (Product product : StoreManager.productCatalog.values()) {
            if (product.getCategory().equals(category)) {
                tableModel.addRow(new Object[]{
                    product.getTitle(), product.getDescription(),
                    product.getCategory(), product.getPrice(), product.getStock()
                });
            }
        }
    }

    /**
     * Sorts the displayed products using {@link Collections#sort} with
     * {@link Comparator}, replacing the original hand-written bubble sort (DRY, KISS).
     */
    private void handleSort() {
        String sortOption = (String) COMBOORDEN.getSelectedItem();
        List<Product> products = new ArrayList<>(StoreManager.productCatalog.values());

        if (Constants.SORT_BY_PRICE_DESC.equals(sortOption)) {
            products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        } else if (Constants.SORT_BY_PRICE_ASC.equals(sortOption)) {
            products.sort(Comparator.comparingDouble(Product::getPrice));
        } else {
            // Sort by relevance = average rating descending
            products.sort(Comparator.comparingDouble(Product::getAverageRating).reversed());
        }

        tableModel.setRowCount(0);
        for (Product product : products) {
            tableModel.addRow(new Object[]{
                product.getTitle(), product.getDescription(),
                product.getCategory(), product.getPrice(), product.getStock()
            });
        }
    }

    private void handleBack() {
        AdminMenuFrame amf = new AdminMenuFrame();
        amf.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        UIHelper.setNimbusLookAndFeel();
        java.awt.EventQueue.invokeLater(() -> new ProductManagementFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ANADIR;
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton BUSCAR;
    private javax.swing.JTextField CARACTERISTICAS;
    private javax.swing.JComboBox<String> COMBO;
    private javax.swing.JComboBox<String> COMBOBUSCAR;
    private javax.swing.JComboBox<String> COMBOORDEN;
    private javax.swing.JButton ELIMINAR;
    private javax.swing.JLabel FOTOPRODUCTO;
    private javax.swing.JTextField IMAGEN;
    private javax.swing.JLabel LOGO;
    private javax.swing.JButton MODIFICAR;
    private javax.swing.JButton MOSTRAR;
    private javax.swing.JTextField NOMBRE;
    private javax.swing.JTextField OPINION;
    private javax.swing.JButton ORDENAR;
    private javax.swing.JTextField PRECIO;
    private javax.swing.JTextField STOCK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
