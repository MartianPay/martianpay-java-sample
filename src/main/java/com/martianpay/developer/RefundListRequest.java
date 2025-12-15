package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class RefundListRequest extends Pagination {
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
