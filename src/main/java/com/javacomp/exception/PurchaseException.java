package com.javacomp.exception;

/**
 * Thrown when a purchase operation fails (e.g., duplicate item in cart).
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class PurchaseException extends Exception {

    /** Error message: the product is not in the cart. */
    public static final String PRODUCT_NOT_IN_CART =
            "The product is not in the shopping cart.";

    /** Error message: the product has already been added to the cart. */
    public static final String PRODUCT_ALREADY_ADDED =
            "The product has already been added to the cart.";

    /**
     * Creates a PurchaseException with a default message.
     */
    public PurchaseException() {
        super("A purchase error has occurred.");
    }

    /**
     * Creates a PurchaseException with a specific message.
     *
     * @param message the error detail message
     */
    public PurchaseException(String message) {
        super(message);
    }
}
