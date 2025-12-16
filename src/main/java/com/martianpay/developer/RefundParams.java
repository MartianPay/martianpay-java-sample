package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Parameters for creating a refund to return funds to customers for previously successful payments.
 * Supports full or partial refunds with customizable metadata and reason codes.
 */
public class RefundParams {
    /**
     * The amount to refund in the smallest currency unit (e.g., cents for fiat, smallest token unit for crypto).
     * Must not exceed the remaining refundable amount.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Key-value pairs for storing additional information about the refund.
     * Useful for tracking RMA numbers, support tickets, and audit trails.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * The ID of the payment intent to refund (e.g., "pi_abc123xyz").
     * Payment must be successful and have refundable amount remaining.
     */
    @SerializedName("payment_intent_id")
    private String paymentIntent;

    /**
     * Reason code for the refund (e.g., "duplicate", "fraudulent", "requested_by_customer").
     * Helps categorize and analyze refund patterns for reporting and analytics.
     */
    @SerializedName("reason")
    private String reason;

    /**
     * Human-readable description explaining the refund reason to staff and customers.
     * Should include relevant order details and any special circumstances.
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
