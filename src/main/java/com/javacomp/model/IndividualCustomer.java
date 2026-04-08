package com.javacomp.model;

import java.io.Serializable;

/**
 * A personal (non-business) customer identified by a national ID (DNI).
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class IndividualCustomer extends Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Spanish national identification number (Documento Nacional de Identidad). */
    private String dni;

    /**
     * Constructs an individual customer with a DNI.
     *
     * @param dni         the national ID number
     * @param name        the customer's name
     * @param email       the login email
     * @param password    the login password
     * @param address     the mailing address
     * @param creditCard  the credit card
     * @param phoneNumber the phone number
     */
    public IndividualCustomer(String dni, String name, String email, String password,
                              Address address, CreditCard creditCard, int phoneNumber) {
        super(name, email, password, address, creditCard, phoneNumber);
        this.dni = dni;
    }

    /** @return the national ID (DNI) */
    public String getDni() {
        return dni;
    }

    /** @param dni the new national ID */
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return super.toString() + "IndividualCustomer{dni=" + dni + '}';
    }
}
