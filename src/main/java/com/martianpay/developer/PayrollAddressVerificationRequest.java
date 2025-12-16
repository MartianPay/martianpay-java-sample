package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to verify a recipient's cryptocurrency address for payroll.
 */
public class PayrollAddressVerificationRequest {
    /**
     * Verification token received during the verification process.
     */
    @SerializedName("token")
    private String verificationCode;

    /**
     * Exact test amount sent to the address for verification.
     */
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
