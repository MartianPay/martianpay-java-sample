package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class UpdateCustomerSubscriptionPaymentMethodRequest {
    private String subscriptionId;

    @SerializedName("default_payment_method_id")
    private String defaultPaymentMethodId;

    public UpdateCustomerSubscriptionPaymentMethodRequest() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getDefaultPaymentMethodId() {
        return defaultPaymentMethodId;
    }

    public void setDefaultPaymentMethodId(String defaultPaymentMethodId) {
        this.defaultPaymentMethodId = defaultPaymentMethodId;
    }
}
