package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * RefundParams contains parameters for creating a refund
 */
public class RefundParams {
    /**
     * Amount is the amount to refund in the smallest currency unit
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Metadata is additional metadata to attach to the refund
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * PaymentIntent is the ID of payment intent to refund
     */
    @SerializedName("payment_intent_id")
    private String paymentIntent;

    /**
     * Reason is the reason for the refund
     */
    @SerializedName("reason")
    private String reason;

    /**
     * Description is the description of the refund
     */
    @SerializedName("description")
    private String description;

    public RefundParams() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(String paymentIntent) {
        this.paymentIntent = paymentIntent;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
