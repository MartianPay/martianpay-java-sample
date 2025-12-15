package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentTaxRegion {
    @SerializedName("country")
    private String country;

    @SerializedName("state")
    private String state;

    public PaymentIntentTaxRegion() {
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
}
