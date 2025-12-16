package com.martianpay.developer;

/**
 * Request to retrieve address verification status.
 */
public class PayrollGetAddressVerificationRequest {
    /**
     * Verification code identifying the verification process.
     */
    private String verificationCode;

    public PayrollGetAddressVerificationRequest() {
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
