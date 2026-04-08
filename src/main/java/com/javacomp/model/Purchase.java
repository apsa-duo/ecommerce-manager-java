package com.javacomp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a completed or in-progress purchase order.
 *
 * <p>Holds the shopping cart contents (list of {@link PurchaseItem}s),
 * the customer who placed the order, and the purchase date.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;

    private double totalAmount;
    private int itemCount;
    private List<PurchaseItem> cartItems;
    private Customer customer;
    private LocalDate purchaseDate;

    /**
     * Constructs a purchase with the given details.
     *
     * @param totalAmount the total price including shipping
     * @param itemCount   the total number of individual items
     * @param customer    the customer placing the order
     * @param cartItems   the list of products and quantities
     * @param purchaseDate the date of the purchase
     */
    public Purchase(double totalAmount, int itemCount, Customer customer,
                    List<PurchaseItem> cartItems, LocalDate purchaseDate) {
        this.totalAmount = totalAmount;
        this.itemCount = itemCount;
        this.customer = customer;
        this.cartItems = (cartItems != null) ? cartItems : new ArrayList<>();
        this.purchaseDate = purchaseDate;
    }

    /**
     * Recalculates the total item count from the cart contents.
     *
     * <p>Iterates all cart items and sums their quantities.
     * Called after adding or removing items.</p>
     */
    public void recalculateItemCount() {
        int count = 0;
        for (PurchaseItem item : cartItems) {
            count += item.getQuantity();
        }
        this.itemCount = count;
    }

    /**
     * Recalculates the total purchase amount from the cart contents.
     *
     * <p>Sums (price × quantity) for every item in the cart.</p>
     */
    public void recalculateTotalAmount() {
        double total = 0;
        for (PurchaseItem item : cartItems) {
            total += item.getSubtotal();
        }
        this.totalAmount = total;
    }

    // ── Getters and Setters ─────────────────────────────────────────────

    /** @return the total purchase amount */
    public double getTotalAmount() {
        return totalAmount;
    }

    /** @param totalAmount the new total amount */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /** @return the total number of items */
    public int getItemCount() {
        return itemCount;
    }

    /** @param itemCount the new item count */
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /** @return the list of cart items */
    public List<PurchaseItem> getCartItems() {
        return cartItems;
    }

    /** @param cartItems the new cart item list */
    public void setCartItems(List<PurchaseItem> cartItems) {
        this.cartItems = cartItems;
    }

    /** @return the customer who placed this order */
    public Customer getCustomer() {
        return customer;
    }

    /** @param customer the new customer */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /** @return the purchase date */
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    /** @param purchaseDate the new purchase date */
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Purchase{totalAmount=" + totalAmount
                + ", itemCount=" + itemCount
                + ", cartItems=" + cartItems
                + ", customer=" + customer
                + ", purchaseDate=" + purchaseDate + '}';
    }
}
