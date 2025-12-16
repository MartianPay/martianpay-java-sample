package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Parameters for creating or updating basic merchant account information.
 */
public class MerchantParams {
    /**
     * Display name for the merchant business.
     */
    @SerializedName("name")
    private String name;

    /**
     * Country code (ISO 3166-1 alpha-2, e.g., "US", "GB", "CA").
     */
    @SerializedName("country")
    private String country;

    /**
     * Timezone identifier (IANA format, e.g., "America/New_York", "Europe/London").
     */
    @SerializedName("timezone")
    private String timezone;

    public MerchantParams() {
    }

    /**
     * Gets the display name for the merchant business.
     * @return The merchant name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the display name for the merchant business.
     * @param name The merchant name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the country code where the merchant operates.
     * @return The ISO 3166-1 alpha-2 country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country code where the merchant operates.
     * @param country The ISO 3166-1 alpha-2 country code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the timezone identifier for the merchant's location.
     * @return The IANA timezone identifier
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the timezone identifier for the merchant's location.
     * @param timezone The IANA timezone identifier
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
