package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayrollAddressVerificationRequest {
    @SerializedName("token")
    private String verificationCode;

    @SerializedName("amount")
    private String amount;

    public PayrollAddressVerificationRequest() {
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
