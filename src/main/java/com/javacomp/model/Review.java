package com.javacomp.model;

import com.javacomp.util.Constants;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A customer review for a product, consisting of a numeric rating and a text comment.
 *
 * <p>The review date is automatically set to the current date upon creation.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final DateTimeFormatter SHORT_DATE =
            DateTimeFormatter.ofPattern(Constants.SHORT_DATE_PATTERN);

    /** Numeric rating (typically 0–10). */
    private int rating;

    /** Free-text comment left by the customer. */
    private String comment;

    /** Date when the review was submitted. */
    private LocalDate reviewDate;

    /**
     * Creates a new review with today's date.
     *
     * @param rating  the numeric rating (0–10)
     * @param comment the review comment text
     */
    public Review(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = LocalDate.now();
    }

    /** @return the numeric rating */
    public int getRating() {
        return rating;
    }

    /** @param rating the new rating value */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /** @return the review comment text */
    public String getComment() {
        return comment;
    }

    /** @param comment the new comment text */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /** @return the date the review was submitted */
    public LocalDate getReviewDate() {
        return reviewDate;
    }

    /** @param reviewDate the new review date */
    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{rating=" + rating
                + ", comment=" + comment
                + ", reviewDate=" + reviewDate.format(SHORT_DATE) + '}';
    }
}
