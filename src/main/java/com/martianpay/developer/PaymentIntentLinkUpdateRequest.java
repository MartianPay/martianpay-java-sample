package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update and confirm a payment intent from a payment link.
 */
public class PaymentIntentLinkUpdateRequest {
    /**
     * Unique key identifier of the payment intent to update.
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

    /**
     * Type of payment method being used.
     */
    @SerializedName("payment_method_type")
    private String paymentMethodType;

    /**
     * Payment method configuration and options.
     */
    @SerializedName("payment_method_options")
    private PaymentMethodConfirmOptions paymentMethodData;

    /**
     * Whether to save customer's payment information for future use.
     */
    @SerializedName("save_customer")
    private Boolean saveCustomer;

    public PaymentIntentLinkUpdateRequest() {
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

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public PaymentMethodConfirmOptions getPaymentMethodData() {
        return paymentMethodData;
    }

    public void setPaymentMethodData(PaymentMethodConfirmOptions paymentMethodData) {
        this.paymentMethodData = paymentMethodData;
    }

    public Boolean getSaveCustomer() {
        return saveCustomer;
    }

    public void setSaveCustomer(Boolean saveCustomer) {
        this.saveCustomer = saveCustomer;
    }
}
