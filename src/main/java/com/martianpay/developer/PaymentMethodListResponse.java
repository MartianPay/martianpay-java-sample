package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * List of saved payment methods for a customer.
 */
public class PaymentMethodListResponse {
    /** List of saved payment methods. */
    @SerializedName("payment_methods")
    private List<PaymentMethodCard> paymentMethods;

    // Getters and Setters
    public List<PaymentMethodCard> getPaymentMethods() { return paymentMethods; }
    public void setPaymentMethods(List<PaymentMethodCard> paymentMethods) { this.paymentMethods = paymentMethods; }
}
