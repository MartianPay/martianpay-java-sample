package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to update the payment method of a customer subscription.
 */
public class UpdateCustomerSubscriptionPaymentMethodRequest {
    /**
     * The unique identifier of the subscription to update.
     */
    private String subscriptionId;

    /**
     * ID of the new payment method to use for recurring payments.
     */
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
