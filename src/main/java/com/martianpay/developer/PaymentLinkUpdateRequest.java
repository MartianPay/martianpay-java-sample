package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentLinkUpdateRequest updates a payment link
 */
public class PaymentLinkUpdateRequest {
    @SerializedName("active")
    private Boolean active;

    // Getters and Setters
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
