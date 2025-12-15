package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentGetRequest {
    @SerializedName("key")
    private String key;

    @SerializedName("payment_link_id")
    private String paymentLinkId;

    @SerializedName("client_secret")
    private String clientSecret;

    public PaymentIntentGetRequest() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPaymentLinkId() {
        return paymentLinkId;
    }

    public void setPaymentLinkId(String paymentLinkId) {
        this.paymentLinkId = paymentLinkId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
