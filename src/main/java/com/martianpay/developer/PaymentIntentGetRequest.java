package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve a specific payment intent.
 */
public class PaymentIntentGetRequest {
    /**
     * Unique key identifier of the payment intent.
     */
    @SerializedName("key")
    private String key;

    /**
     * Payment link ID associated with this payment intent.
     */
    @SerializedName("payment_link_id")
    private String paymentLinkId;

    /**
     * Client secret for secure payment intent access.
     */
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
