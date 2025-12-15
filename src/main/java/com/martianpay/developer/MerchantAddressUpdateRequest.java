package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * MerchantAddressUpdateRequest updates a merchant address
 */
public class MerchantAddressUpdateRequest {
    @SerializedName("alias")
    private String alias;

    // Getters and Setters
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}
