package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentLinkDetails contains detailed payment link information including merchant info
 */
public class PaymentLinkDetails {
    /**
     * MerchantID is the ID of the merchant who created the payment link
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * MerchantName is the name of the merchant
     */
    @SerializedName("merchant_name")
    private String merchantName;

    /**
     * PublicKey is the public API key for this merchant
     */
    @SerializedName("public_key")
    private String publicKey;

    /**
     * PaymentLink contains the details of the payment link
     */
    @SerializedName("payment_link")
    private PaymentLink paymentLink;

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public PaymentLink getPaymentLink() {
        return paymentLink;
    }

    public void setPaymentLink(PaymentLink paymentLink) {
        this.paymentLink = paymentLink;
    }
}
