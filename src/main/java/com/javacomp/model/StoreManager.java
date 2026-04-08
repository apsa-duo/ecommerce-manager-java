package com.javacomp.model;

import com.javacomp.util.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Central data manager that holds and persists the application's core data stores.
 *
 * <p>Acts as a simple in-memory repository backed by Java serialization to
 * {@code .dat} files. Provides static access to the product catalog,
 * customer registry, and sales history.</p>
 *
 * <p><strong>Design note:</strong> Using static fields is intentional here to
 * maintain compatibility with the original Swing-based architecture where
 * multiple JFrame instances share the same data. A future refactoring could
 * migrate this to a proper singleton or dependency-injected service.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class StoreManager {

    private static final Logger LOGGER = Logger.getLogger(StoreManager.class.getName());

    /** Product catalog: maps product title → Product object. */
    public static Map<String, Product> productCatalog = new HashMap<>();

    /** Sales history: list of all completed purchases. */
    public static List<Purchase> salesHistory = new ArrayList<>();

    /** Customer registry: maps customer email → Customer object. */
    public static Map<String, Customer> customerRegistry = new HashMap<>();

    // ── Private constructor ─────────────────────────────────────────────

    private StoreManager() {
        // Utility class — prevent instantiation
    }

    // ── Generic Persistence Methods ─────────────────────────────────────

    /**
     * Loads a serialized object from the specified file.
     *
     * <p>This generic method eliminates the code duplication that existed
     * in the original three nearly-identical {@code cargarDatos*} methods.</p>
     *
     * @param <T>      the type of the deserialized object
     * @param filePath the path to the {@code .dat} file
     * @return the deserialized object, or {@code null} if loading failed
     */
    @SuppressWarnings("unchecked")
    private static <T> T loadFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            LOGGER.log(Level.INFO, "Data file not found, starting with empty data: {0}", filePath);
            return null;
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            T data = (T) ois.readObject();
            LOGGER.log(Level.INFO, "Successfully loaded data from: {0}", filePath);
            return data;

        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Failed to load data from: " + filePath, ex);
            return null;
        }
    }

    /**
     * Saves a serializable object to the specified file.
     *
     * @param data     the object to serialize
     * @param filePath the destination file path
     */
    private static void saveToFile(Object data, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(data);
            LOGGER.log(Level.INFO, "Successfully saved data to: {0}", filePath);

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to save data to: " + filePath, ex);
        }
    }

    // ── Product Persistence ─────────────────────────────────────────────

    /**
     * Loads the product catalog from the data file.
     */
    public static void loadProducts() {
        Map<String, Product> loaded = loadFromFile(Constants.PRODUCTS_DATA_FILE);
        if (loaded != null) {
            productCatalog = loaded;
        }
    }

    /**
     * Saves the product catalog to the data file.
     */
    public static void saveProducts() {
        if (!productCatalog.isEmpty()) {
            saveToFile(productCatalog, Constants.PRODUCTS_DATA_FILE);
        } else {
            LOGGER.log(Level.WARNING, "Product catalog is empty — skipping save.");
        }
    }

    // ── Customer Persistence ────────────────────────────────────────────

    /**
     * Loads the customer registry from the data file.
     */
    public static void loadCustomers() {
        Map<String, Customer> loaded = loadFromFile(Constants.CUSTOMERS_DATA_FILE);
        if (loaded != null) {
            customerRegistry = loaded;
        }
    }

    /**
     * Saves the customer registry to the data file.
     */
    public static void saveCustomers() {
        if (!customerRegistry.isEmpty()) {
            saveToFile(customerRegistry, Constants.CUSTOMERS_DATA_FILE);
        } else {
            LOGGER.log(Level.WARNING, "Customer registry is empty — skipping save.");
        }
    }

    // ── Sales Persistence ───────────────────────────────────────────────

    /**
     * Loads the sales history from the data file.
     */
    public static void loadSales() {
        List<Purchase> loaded = loadFromFile(Constants.SALES_DATA_FILE);
        if (loaded != null) {
            salesHistory = loaded;
        }
    }

    /**
     * Saves the sales history to the data file.
     */
    public static void saveSales() {
        if (!salesHistory.isEmpty()) {
            saveToFile(salesHistory, Constants.SALES_DATA_FILE);
        } else {
            LOGGER.log(Level.WARNING, "Sales history is empty — skipping save.");
        }
    }

    // ── Convenience Accessors ───────────────────────────────────────────

    /** @return the product catalog map */
    public static Map<String, Product> getProductCatalog() {
        return productCatalog;
    }

    /** @param productCatalog the new product catalog */
    public static void setProductCatalog(Map<String, Product> productCatalog) {
        StoreManager.productCatalog = productCatalog;
    }

    /** @return the sales history list */
    public static List<Purchase> getSalesHistory() {
        return salesHistory;
    }

    /** @param salesHistory the new sales history */
    public static void setSalesHistory(List<Purchase> salesHistory) {
        StoreManager.salesHistory = salesHistory;
    }

    /** @return the customer registry map */
    public static Map<String, Customer> getCustomerRegistry() {
        return customerRegistry;
    }

    /** @param customerRegistry the new customer registry */
    public static void setCustomerRegistry(Map<String, Customer> customerRegistry) {
        StoreManager.customerRegistry = customerRegistry;
    }
}
