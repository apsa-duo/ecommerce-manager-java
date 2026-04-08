package com.javacomp.exception;

/**
 * Thrown when a stock-related validation fails (out of stock or insufficient quantity).
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class StockException extends Exception {

    /** Error message: the product is completely out of stock. */
    public static final String OUT_OF_STOCK =
            "This product is out of stock.";

    /** Error message: the requested quantity exceeds available stock. */
    public static final String INSUFFICIENT_STOCK =
            "Insufficient stock. Please try a smaller quantity.";

    /**
     * Creates a StockException with a default message.
     */
    public StockException() {
        super("A stock quantity error has occurred.");
    }

    /**
     * Creates a StockException with a specific message.
     *
     * @param message the error detail message
     */
    public StockException(String message) {
        super(message);
    }
}
