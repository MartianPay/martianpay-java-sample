package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to verify ownership of a merchant blockchain address.
 * Merchant must send the specified verification amount to complete the process.
 */
public class MerchantAddressVerifyRequest {
    /**
     * Exact amount sent from the merchant's address for verification.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Gets the verification amount.
     * @return The amount sent for verification
     */
    public String getAmount() { return amount; }

    /**
     * Sets the verification amount.
     * @param amount The exact amount sent from the address for verification
     */
    public void setAmount(String amount) { this.amount = amount; }
}
