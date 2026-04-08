package com.javacomp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a shipping/billing address for a customer.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String street;
    private int streetNumber;
    private int postalCode;
    private String city;

    /**
     * Constructs a complete mailing address.
     *
     * @param street       the street name
     * @param streetNumber the house/building number
     * @param postalCode   the postal/ZIP code
     * @param city         the city name
     */
    public Address(String street, int streetNumber, int postalCode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    /** @return the street name */
    public String getStreet() {
        return street;
    }

    /** @param street the new street name */
    public void setStreet(String street) {
        this.street = street;
    }

    /** @return the house/building number */
    public int getStreetNumber() {
        return streetNumber;
    }

    /** @param streetNumber the new house/building number */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /** @return the postal/ZIP code */
    public int getPostalCode() {
        return postalCode;
    }

    /** @param postalCode the new postal/ZIP code */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /** @return the city name */
    public String getCity() {
        return city;
    }

    /** @param city the new city name */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{street=" + street
                + ", streetNumber=" + streetNumber
                + ", postalCode=" + postalCode
                + ", city=" + city + '}';
    }
}
