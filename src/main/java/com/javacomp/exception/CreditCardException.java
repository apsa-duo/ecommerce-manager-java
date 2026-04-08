package com.javacomp.exception;

/**
 * Thrown when credit card validation fails (wrong digit count or expired card).
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class CreditCardException extends Exception {

    /** Error message: the card number does not have 16 digits. */
    public static final String INVALID_DIGIT_COUNT =
            "Invalid credit card number. Please enter exactly 16 digits.";

    /** Error message: the card has expired. */
    public static final String CARD_EXPIRED =
            "This credit card has expired. Please update your payment information.";

    /**
     * Creates a CreditCardException with a default message.
     */
    public CreditCardException() {
        super("A credit card error has occurred.");
    }

    /**
     * Creates a CreditCardException with a specific message.
     *
     * @param message the error detail message
     */
    public CreditCardException(String message) {
        super(message);
    }
}
