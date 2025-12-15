package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentInvoiceCreateResponse {
    @SerializedName("payment_intent")
    private PaymentIntent paymentIntent;

    public PaymentIntentInvoiceCreateResponse() {
    }

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
    }
}
