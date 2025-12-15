package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class MerchantParams {
    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("timezone")
    private String timezone;

    public MerchantParams() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
