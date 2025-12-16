package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * OrderTaxRegion represents the tax jurisdiction for an order.
 *
 * This model identifies the geographic region used to determine applicable tax
 * rates and regulations for an order. Tax regions are typically based on the
 * shipping destination and are crucial for accurate tax calculation and compliance.
 *
 * Key features:
 * - Country-level tax jurisdiction
 * - State/province-level tax jurisdiction
 * - Simple two-field structure for tax determination
 *
 * Use cases:
 * - Calculating sales tax, VAT, or GST for orders
 * - Determining tax compliance requirements
 * - Generating tax reports by jurisdiction
 * - Validating tax rates during checkout
 * - Supporting multi-jurisdiction tax scenarios
 *
 * Examples:
 * - US order: country="US", state="CA" (California sales tax applies)
 * - Canadian order: country="CA", state="ON" (Ontario HST applies)
 * - UK order: country="GB", state=null (UK VAT applies)
 * - EU order: country="DE", state=null (German VAT applies)
 *
 * Note: The level of detail required varies by country. Some countries only
 * need country-level information, while others (like the US) require state-level
 * detail for accurate tax calculation.
 */
public class OrderTaxRegion {
    /**
     * Country code or name for the tax jurisdiction.
     * Identifies the primary tax authority for this order.
     * Typically uses ISO 3166-1 alpha-2 country codes.
     * Examples: "US", "CA", "GB", "DE", "AU"
     * This field is usually required for tax calculation.
     */
    @SerializedName("country")
    private String country;

    /**
     * State, province, or region code for the tax jurisdiction.
     * Provides additional geographic precision for tax calculation.
     * Required in countries with state/province-level taxation (e.g., US, Canada).
     * May be null or empty for countries with only national-level taxation.
     * Examples: "CA" (California), "NY" (New York), "ON" (Ontario)
     */
    @SerializedName("state")
    private String state;

    /**
     * Default constructor for OrderTaxRegion.
     */
    public OrderTaxRegion() {
    }

    /**
     * Gets the country code for the tax jurisdiction.
     * @return The country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code for the tax jurisdiction.
     * @param country The country code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the state or province code for the tax jurisdiction.
     * @return The state code, or null for country-level taxation
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state or province code for the tax jurisdiction.
     * @param state The state code
     */
    public void setState(String state) {
        this.state = state;
    }
}
