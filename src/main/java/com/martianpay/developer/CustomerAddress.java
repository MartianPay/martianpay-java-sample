package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CustomerAddress represents a customer's address information
 */
public class CustomerAddress {
    /**
     * Country is the two-letter country code (ISO 3166-1 alpha-2)
     */
    @SerializedName("country")
    private String country;

    /**
     * State is the state, province, or region
     */
    @SerializedName("state")
    private String state;

    /**
     * City is the city or town
     */
    @SerializedName("city")
    private String city;

    /**
     * PostalCode is the postal or ZIP code
     */
    @SerializedName("postal_code")
    private String postalCode;

    /**
     * Line1 is the first line of the address (street address)
     */
    @SerializedName("line1")
    private String line1;

    /**
     * Line2 is the second line of the address (apartment, suite, etc.)
     */
    @SerializedName("line2")
    private String line2;

    public CustomerAddress() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
}
