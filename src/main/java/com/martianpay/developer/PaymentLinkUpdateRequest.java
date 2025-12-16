package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update an existing payment link.
 */
public class PaymentLinkUpdateRequest {
    /**
     * Whether the payment link is active and accessible.
     */
    @SerializedName("active")
    private Boolean active;

    // Getters and Setters
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
