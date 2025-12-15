package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentMethodCard represents a credit or debit card payment method
 */
public class PaymentMethodCard {
    /**
     * ID is the unique identifier for this card
     */
    @SerializedName("id")
    private String id;

    /**
     * Provider is the payment provider (e.g., "stripe", "payermax")
     */
    @SerializedName("provider")
    private String provider;

    /**
     * Type is the card type (e.g., "credit", "debit")
     */
    @SerializedName("type")
    private String type;

    /**
     * Last4 is the last 4 digits of the card number
     */
    @SerializedName("last4")
    private String last4;

    /**
     * Brand is the card brand (e.g., "visa", "mastercard", "amex")
     */
    @SerializedName("brand")
    private String brand;

    /**
     * ExpMonth is the expiration month (1-12)
     */
    @SerializedName("exp_month")
    private Long expMonth;

    /**
     * ExpYear is the expiration year (4 digits)
     */
    @SerializedName("exp_year")
    private Long expYear;

    /**
     * Funding is the funding type (e.g., "credit", "debit", "prepaid")
     */
    @SerializedName("funding")
    private String funding;

    /**
     * Country is the two-letter country code where the card was issued
     */
    @SerializedName("country")
    private String country;

    /**
     * Fingerprint is a unique identifier for this card to detect duplicates
     */
    @SerializedName("fingerprint")
    private String fingerprint;

    public PaymentMethodCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(Long expMonth) {
        this.expMonth = expMonth;
    }

    public Long getExpYear() {
        return expYear;
    }

    public void setExpYear(Long expYear) {
        this.expYear = expYear;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
