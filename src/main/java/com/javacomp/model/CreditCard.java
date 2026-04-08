package com.javacomp.model;

import com.javacomp.util.Constants;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a credit card used for purchase payments.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class CreditCard implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter CARD_DATE_FORMAT =
            DateTimeFormatter.ofPattern(Constants.CARD_DATE_PATTERN);

    private String holderName;
    private long cardNumber;
    private LocalDate expirationDate;

    /**
     * Constructs a credit card with the given details.
     *
     * @param holderName     the name printed on the card
     * @param cardNumber     the 16-digit card number
     * @param expirationDate the card's expiration date
     */
    public CreditCard(String holderName, long cardNumber, LocalDate expirationDate) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    /** @return the cardholder's name */
    public String getHolderName() {
        return holderName;
    }

    /** @param holderName the new cardholder name */
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    /** @return the 16-digit card number */
    public long getCardNumber() {
        return cardNumber;
    }

    /** @param cardNumber the new card number */
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    /** @return the card's expiration date */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /** @param expirationDate the new expiration date */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Checks whether this card is still valid (not expired).
     *
     * @return {@code true} if today's date is on or before the expiration date
     */
    public boolean isValid() {
        LocalDate today = LocalDate.now();
        return today.isBefore(expirationDate) || today.isEqual(expirationDate);
    }

    @Override
    public String toString() {
        return "CreditCard{holderName=" + holderName
                + ", cardNumber=" + cardNumber
                + ", expirationDate=" + expirationDate.format(CARD_DATE_FORMAT) + '}';
    }
}
