package com.javacomp.model;

import java.io.Serializable;

/**
 * A single line item in a {@link Purchase}, linking a product to the ordered quantity.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class PurchaseItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The product being purchased. */
    private Product product;

    /** The quantity ordered. */
    private int quantity;

    /**
     * Constructs a purchase line item.
     *
     * @param product  the product being purchased
     * @param quantity the number of units ordered
     */
    public PurchaseItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Calculates the subtotal for this line item.
     *
     * @return price × quantity
     */
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    /** @return the product */
    public Product getProduct() {
        return product;
    }

    /** @param product the new product reference */
    public void setProduct(Product product) {
        this.product = product;
    }

    /** @return the ordered quantity */
    public int getQuantity() {
        return quantity;
    }

    /** @param quantity the new quantity */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PurchaseItem{product=" + product + ", quantity=" + quantity + "}";
    }
}
