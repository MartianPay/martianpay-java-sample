package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * MerchantAddressVerifyRequest verifies a merchant address
 */
public class MerchantAddressVerifyRequest {
    @SerializedName("amount")
    private String amount;

    // Getters and Setters
    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }
}
