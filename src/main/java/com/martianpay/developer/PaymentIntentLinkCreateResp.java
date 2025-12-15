package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentIntentLinkCreateResp represents payment link creation response
 */
public class PaymentIntentLinkCreateResp {
    @SerializedName("payment_intent")
    private PaymentIntent paymentIntent;

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
    }
}
