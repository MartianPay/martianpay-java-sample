package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentLinkUpdateRequest {
    @SerializedName("key")
    private String key;

    @SerializedName("payment_link_id")
    private String paymentLinkId;

    @SerializedName("client_secret")
    private String clientSecret;

    @SerializedName("payment_method_type")
    private String paymentMethodType;

    @SerializedName("payment_method_options")
    private PaymentMethodConfirmOptions paymentMethodData;

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
