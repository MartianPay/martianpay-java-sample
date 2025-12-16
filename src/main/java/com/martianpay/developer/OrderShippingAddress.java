package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * OrderShippingAddress represents the destination address for order delivery.
 *
 * This model contains the complete shipping address information needed for order
 * fulfillment and delivery. It captures all necessary address components to ensure
 * accurate delivery of physical goods.
 *
 * Key features:
 * - Complete address breakdown (country, state, city, postal code)
 * - Two address lines for detailed location information
 * - Support for international addresses
 *
 * Use cases:
 * - Providing delivery information to shipping carriers
 * - Calculating shipping costs based on destination
 * - Determining tax rates based on shipping location
 * - Printing shipping labels and packing slips
 * - Validating address information
 *
 * Address format typically follows:
 * Line 1: Street address, building number
 * Line 2: Apartment, suite, unit number (optional)
 * City, State/Province, Postal Code
 * Country
 */
public class OrderShippingAddress {
    /**
     * Country code or name for the shipping destination.
     * Typically uses ISO 3166-1 alpha-2 country codes for consistency.
     * Examples: "US" (United States), "GB" (United Kingdom), "CA" (Canada)
     * May also contain full country names: "United States", "Canada"
     */
    @SerializedName("country")
    private String country;

    /**
     * State, province, or region within the country.
     * For US addresses, typically the two-letter state code.
     * For other countries, may be province, region, or prefecture.
     * Examples: "CA" (California), "NY" (New York), "Ontario", "Queensland"
     */
    @SerializedName("state")
    private String state;

    /**
     * City or locality name.
     * The municipality where the address is located.
     * Examples: "San Francisco", "New York", "London", "Tokyo"
     */
    @SerializedName("city")
    private String city;

    /**
     * Postal code or ZIP code.
     * Format varies by country (e.g., "94102", "SW1A 1AA", "100-0001").
     * Used for delivery routing and tax calculation.
     * Examples: "94102" (US), "SW1A 1AA" (UK), "M5H 2N2" (Canada)
     */
    @SerializedName("postal_code")
    private String postalCode;

    /**
     * First line of the street address.
     * Typically contains the street number and street name.
     * Examples: "123 Main Street", "456 Oak Avenue Apt 2B"
     */
    @SerializedName("line1")
    private String line1;

    /**
     * Second line of the street address (optional).
     * Used for apartment numbers, suite numbers, building names, or other
     * supplementary address information.
     * Examples: "Apartment 5B", "Suite 200", "Building C", "Floor 3"
     * May be null or empty if not needed.
     */
    @SerializedName("line2")
    private String line2;

    /**
     * Default constructor for OrderShippingAddress.
     */
    public OrderShippingAddress() {
    }

    /**
     * Gets the country code or name.
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code or name.
     * @param country The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the state, province, or region.
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state, province, or region.
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the city or locality name.
     * @return The city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city or locality name.
     * @param city The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the postal code or ZIP code.
     * @return The postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code or ZIP code.
     * @param postalCode The postal code
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the first line of the street address.
     * @return The first address line
     */
    public String getLine1() {
        return line1;
    }

    /**
     * Sets the first line of the street address.
     * @param line1 The first address line
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     * Gets the second line of the street address.
     * @return The second address line, or null if not provided
     */
    public String getLine2() {
        return line2;
    }

    /**
     * Sets the second line of the street address.
     * @param line2 The second address line
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }
}
