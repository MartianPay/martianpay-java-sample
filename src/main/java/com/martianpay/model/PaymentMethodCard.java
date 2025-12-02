package com.martianpay.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a saved payment method card.
 */
public class PaymentMethodCard {
    @SerializedName("id")
    private String id;

    @SerializedName("provider")
    private String provider;

    @SerializedName("type")
    private String type;

    @SerializedName("last4")
    private String last4;

    @SerializedName("brand")
    private String brand;

    @SerializedName("exp_month")
    private Long expMonth;

    @SerializedName("exp_year")
    private Long expYear;

    @SerializedName("funding")
    private String funding;

    @SerializedName("country")
    private String country;

    @SerializedName("fingerprint")
    private String fingerprint;

    // Getters and Setters
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
