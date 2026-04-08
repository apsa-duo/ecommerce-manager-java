package com.javacomp.model;

import java.io.Serializable;

/**
 * Base class representing an authenticated user of the application.
 *
 * <p>Stores the minimum credentials (email and password) required for
 * authentication. Extended by {@link Customer} with profile details.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** User's email address, also serves as the unique login identifier. */
    private String email;

    /** User's password (stored in plain text — see Future Roadmap for hashing plans). */
    private String password;

    /**
     * Constructs a new User with the given credentials.
     *
     * @param email    the email address used for login
     * @param password the password used for login
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /** @return the user's email address */
    public String getEmail() {
        return email;
    }

    /** @param email the new email address */
    public void setEmail(String email) {
        this.email = email;
    }

    /** @return the user's password */
    public String getPassword() {
        return password;
    }

    /** @param password the new password */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{email=" + email + ", password=" + password + '}';
    }
}
