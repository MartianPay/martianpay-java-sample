package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class StripePayload {
    @SerializedName("client_secret")
    private String clientSecret;

    @SerializedName("public_key")
    private String publicKey;

    @SerializedName("status")
    private String status;

    @SerializedName("customer_id")
    private String customerId;

    public StripePayload() {
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
