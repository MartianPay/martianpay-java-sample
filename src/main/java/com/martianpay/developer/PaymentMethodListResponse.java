package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PaymentMethodListResponse represents the response for listing payment methods
 */
public class PaymentMethodListResponse {
    @SerializedName("payment_methods")
    private List<PaymentMethodCard> paymentMethods;

    // Getters and Setters
    public List<PaymentMethodCard> getPaymentMethods() { return paymentMethods; }
    public void setPaymentMethods(List<PaymentMethodCard> paymentMethods) { this.paymentMethods = paymentMethods; }
}
