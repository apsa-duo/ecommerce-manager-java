package com.javacomp.model;

import java.io.Serializable;

/**
 * A business customer identified by a tax ID (CIF) and a company website.
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public class BusinessCustomer extends Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Spanish tax identification number (Código de Identificación Fiscal). */
    private String cif;

    /** Company website URL. */
    private String website;

    /**
     * Constructs a business customer with CIF and website.
     *
     * @param cif         the tax ID
     * @param website     the company website URL
     * @param name        the company/contact name
     * @param email       the login email
     * @param password    the login password
     * @param address     the business address
     * @param creditCard  the payment credit card
     * @param phoneNumber the contact phone number
     */
    public BusinessCustomer(String cif, String website, String name, String email,
                            String password, Address address, CreditCard creditCard,
                            int phoneNumber) {
        super(name, email, password, address, creditCard, phoneNumber);
        this.cif = cif;
        this.website = website;
    }

    /** @return the tax ID (CIF) */
    public String getCif() {
        return cif;
    }

    /** @param cif the new tax ID */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /** @return the company website URL */
    public String getWebsite() {
        return website;
    }

    /** @param website the new website URL */
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return super.toString() + "BusinessCustomer{cif=" + cif + ", website=" + website + '}';
    }
}
