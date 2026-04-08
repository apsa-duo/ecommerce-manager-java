package com.javacomp.util;

/**
 * Centralized application constants.
 *
 * <p>Grouping all magic strings, file paths, and shared configuration
 * in one place follows the DRY principle and makes future changes
 * easy to propagate across the entire application.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public final class Constants {

    private Constants() {
        // Prevent instantiation — utility class
    }

    // ── Authentication ──────────────────────────────────────────────────
    /** Default administrator email used for admin login. */
    public static final String ADMIN_EMAIL = "admin@javacomp.com";

    /** Default administrator password used for admin login. */
    public static final String ADMIN_PASSWORD = "admin";

    // ── File Paths ──────────────────────────────────────────────────────
    /** Data file for serialized product catalog. */
    public static final String PRODUCTS_DATA_FILE = "productosjc.dat";

    /** Data file for serialized customer registry. */
    public static final String CUSTOMERS_DATA_FILE = "clientesjc.dat";

    /** Data file for serialized sales history. */
    public static final String SALES_DATA_FILE = "ventasjc.dat";

    /** Directory that stores product images. */
    public static final String IMAGES_DIR = "images/";

    /** Directory that stores generated invoice text files. */
    public static final String INVOICES_DIR = "invoices";

    /** Application logo file path. */
    public static final String LOGO_PATH = IMAGES_DIR + "logo.jpg";

    // ── Product Categories ──────────────────────────────────────────────
    /** Available product categories used in search filters and product forms. */
    public static final String[] PRODUCT_CATEGORIES = {
        "Components",
        "Computers",
        "Mobile & Telephony",
        "TV, Audio & Photo",
        "Consoles & Video Games"
    };

    // ── Sort Options ────────────────────────────────────────────────────
    /** Sort options presented to the customer when browsing products. */
    public static final String[] SORT_OPTIONS = {
        "By Relevance",
        "Highest Price",
        "Lowest Price"
    };

    /** Sort option key: highest rated first. */
    public static final String SORT_BY_RELEVANCE = "By Relevance";

    /** Sort option key: most expensive first. */
    public static final String SORT_BY_PRICE_DESC = "Highest Price";

    /** Sort option key: cheapest first. */
    public static final String SORT_BY_PRICE_ASC = "Lowest Price";

    // ── Shopping ────────────────────────────────────────────────────────
    /** Fixed shipping cost added to every purchase (in euros). */
    public static final double SHIPPING_COST = 5.0;

    // ── Date Formats ────────────────────────────────────────────────────
    /** Short date format pattern used across invoices and display fields. */
    public static final String SHORT_DATE_PATTERN = "dd/MM/yyyy";

    /** Date format pattern used for credit card expiry display. */
    public static final String CARD_DATE_PATTERN = "yyyy/MM/dd";
}
