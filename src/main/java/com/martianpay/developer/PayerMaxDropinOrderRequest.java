package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayerMaxDropinOrderRequest {
    @SerializedName("payment_link_id")
    private String paymentLinkId;

    @SerializedName("key")
    private String key;

    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    @SerializedName("charge_id")
    private String chargeId;

    @SerializedName("client_secret")
    private String clientSecret;

    @SerializedName("payment_token")
    private String paymentToken;

    public PayerMaxDropinOrderRequest() {
    }

    public String getPaymentLinkId() {
        return paymentLinkId;
    }

    public void setPaymentLinkId(String paymentLinkId) {
        this.paymentLinkId = paymentLinkId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }
}
