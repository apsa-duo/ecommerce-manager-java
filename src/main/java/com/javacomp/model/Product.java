package com.javacomp.model;

import com.javacomp.util.Constants;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a product available in the store catalog.
 *
 * <p>Each product has a title, description, category, price, stock level,
 * an associated image filename, and a list of customer {@link Review}s.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter SHORT_DATE =
            DateTimeFormatter.ofPattern(Constants.SHORT_DATE_PATTERN);

    private String title;
    private String description;
    private String category;
    private double price;
    private String imageName;
    private int stock;
    private LocalDate entryDate;
    private List<Review> reviews;

    /**
     * Full constructor including existing reviews.
     *
     * @param title       the product title (also used as the unique key)
     * @param description a brief description of the product's features
     * @param category    the product category (must match one of {@link Constants#PRODUCT_CATEGORIES})
     * @param price       the unit price in euros
     * @param imageName   the filename of the product image (relative to {@code images/})
     * @param stock       the current stock quantity
     * @param entryDate   the date the product was added to the catalog
     * @param reviews     existing customer reviews
     */
    public Product(String title, String description, String category, double price,
                   String imageName, int stock, LocalDate entryDate, List<Review> reviews) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imageName = imageName;
        this.stock = stock;
        this.entryDate = entryDate;
        this.reviews = (reviews != null) ? reviews : new ArrayList<>();
    }

    /**
     * Constructor for a new product with no reviews yet.
     *
     * @param title       the product title
     * @param description a brief description
     * @param category    the product category
     * @param price       the unit price
     * @param imageName   the image filename
     * @param stock       the initial stock quantity
     * @param entryDate   the catalog entry date
     */
    public Product(String title, String description, String category, double price,
                   String imageName, int stock, LocalDate entryDate) {
        this(title, description, category, price, imageName, stock, entryDate, new ArrayList<>());
    }

    /**
     * Minimal constructor used for search/display purposes.
     *
     * @param title       the product title
     * @param description a brief description
     */
    public Product(String title, String description) {
        this.title = title;
        this.description = description;
        this.reviews = new ArrayList<>();
    }

    /**
     * Calculates the average rating from all reviews.
     *
     * @return the mean rating, or 0.0 if no reviews exist
     */
    public double getAverageRating() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (Review review : reviews) {
            total += review.getRating();
        }
        return (double) total / reviews.size();
    }

    // ── Getters and Setters ─────────────────────────────────────────────

    /** @return the product title */
    public String getTitle() {
        return title;
    }

    /** @param title the new product title */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return the product description */
    public String getDescription() {
        return description;
    }

    /** @param description the new description */
    public void setDescription(String description) {
        this.description = description;
    }

    /** @return the product category */
    public String getCategory() {
        return category;
    }

    /** @param category the new category */
    public void setCategory(String category) {
        this.category = category;
    }

    /** @return the unit price in euros */
    public double getPrice() {
        return price;
    }

    /** @param price the new price */
    public void setPrice(double price) {
        this.price = price;
    }

    /** @return the image filename */
    public String getImageName() {
        return imageName;
    }

    /** @param imageName the new image filename */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /** @return the current stock quantity */
    public int getStock() {
        return stock;
    }

    /** @param stock the new stock quantity */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /** @return the date this product was added to the catalog */
    public LocalDate getEntryDate() {
        return entryDate;
    }

    /** @param entryDate the new entry date */
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    /** @return the list of customer reviews */
    public List<Review> getReviews() {
        return reviews;
    }

    /** @param reviews the new list of reviews */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Product{title=" + title
                + ", description=" + description
                + ", category=" + category
                + ", price=" + price
                + ", imageName=" + imageName
                + ", stock=" + stock
                + ", entryDate=" + entryDate.format(SHORT_DATE)
                + ", reviews=" + reviews + '}';
    }
}
