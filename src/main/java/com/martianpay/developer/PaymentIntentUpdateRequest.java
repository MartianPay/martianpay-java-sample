package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentIntentUpdateRequest confirms payment intent with payment method
 */
public class PaymentIntentUpdateRequest {
    /**
     * PaymentMethodType is the type of payment method being used
     */
    @SerializedName("payment_method_type")
    private String paymentMethodType;

    /**
     * PaymentMethodData contains the payment method confirmation options
     */
    @SerializedName("payment_method_options")
    private PaymentMethodConfirmOptions paymentMethodData;

    /**
     * SaveCustomer indicates whether to save the customer information for future use
     */
    @SerializedName("save_customer")
    private Boolean saveCustomer;

    public PaymentIntentUpdateRequest() {
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
