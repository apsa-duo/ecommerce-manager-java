package com.javacomp.model;

import java.io.Serializable;

/**
 * Represents a registered customer who can browse products and make purchases.
 *
 * <p>Extends {@link User} with personal details (name, address, credit card,
 * phone). Serves as the base class for {@link IndividualCustomer} and
 * {@link BusinessCustomer}.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class Customer extends User {

    private static final long serialVersionUID = 1L;

    private String name;
    private Address address;
    private CreditCard creditCard;
    private int phoneNumber;

    /**
     * Constructs a customer with full profile details.
     *
     * @param name        the customer's display name
     * @param email       the email used for login
     * @param password    the password used for login
     * @param address     the customer's mailing address
     * @param creditCard  the customer's credit card
     * @param phoneNumber the customer's phone number
     */
    public Customer(String name, String email, String password,
                    Address address, CreditCard creditCard, int phoneNumber) {
        super(email, password);
        this.name = name;
        this.address = address;
        this.creditCard = creditCard;
        this.phoneNumber = phoneNumber;
    }

    /** @return the customer's display name */
    public String getName() {
        return name;
    }

    /** @param name the new display name */
    public void setName(String name) {
        this.name = name;
    }

    /** @return the customer's mailing address */
    public Address getAddress() {
        return address;
    }

    /** @param address the new mailing address */
    public void setAddress(Address address) {
        this.address = address;
    }

    /** @return the customer's credit card */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /** @param creditCard the new credit card */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /** @return the customer's phone number */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /** @param phoneNumber the new phone number */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Customer{name=" + name
                + ", address=" + address
                + ", creditCard=" + creditCard
                + ", phoneNumber=" + phoneNumber + '}';
    }
}
