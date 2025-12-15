package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayerMaxDropinOrderResponse {
    @SerializedName("success")
    private Boolean success;

    @SerializedName("charge_id")
    private String chargeId;

    @SerializedName("payment_intent")
    private PaymentIntent paymentIntent;

    public PayerMaxDropinOrderResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public PaymentIntent getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(PaymentIntent paymentIntent) {
        this.paymentIntent = paymentIntent;
    }
}
