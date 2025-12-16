package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to cancel a payment intent.
 */
public class PaymentIntentCancelRequest {
    /**
     * Reason for canceling the payment intent.
     */
    @SerializedName("reason")
    private String reason;

    public PaymentIntentCancelRequest() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
