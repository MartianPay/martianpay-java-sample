package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentCancelRequest {
    @SerializedName("reason")
    private String reason;

    public PaymentIntentCancelRequest() {
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
