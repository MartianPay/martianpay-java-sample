package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class FiatOption {
    @SerializedName("currency")
    private String currency;

    @SerializedName("payment_method_id")
    private String paymentMethodId;

    @SerializedName("save_payment_method")
    private Boolean savePaymentMethod;

    public FiatOption() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Boolean getSavePaymentMethod() {
        return savePaymentMethod;
    }

    public void setSavePaymentMethod(Boolean savePaymentMethod) {
        this.savePaymentMethod = savePaymentMethod;
    }
}
