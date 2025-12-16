package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update merchant's cryptocurrency address configuration.
 */
public class UpdateMerchantAddressRequest {
    /**
     * New alias (friendly name) for the merchant address.
     */
    @SerializedName("alias")
    private String alias;

    // Getters and Setters
    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
}
