package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list refunds with optional filtering.
 */
public class RefundListRequest extends Pagination {
    /**
     * Filter by payment intent ID.
     */
    @SerializedName("payment_intent")
    private String paymentIntent;

    public RefundListRequest() {
    }

    public String getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(String paymentIntent) {
        this.paymentIntent = paymentIntent;
    }
}
