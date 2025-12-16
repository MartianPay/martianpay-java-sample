package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to cancel a customer's subscription.
 * Supports immediate or end-of-period cancellation with optional reason tracking.
 */
public class CancelCustomerSubscriptionRequest {
    /**
     * Unique identifier of the subscription to cancel.
     */
    private String subscriptionId;

    /**
     * Whether to cancel at end of current billing period. True retains access until period ends.
     */
    @SerializedName("cancel_at_period_end")
    private Boolean cancelAtPeriodEnd;

    /**
     * Optional reason for cancellation.
     */
    @SerializedName("cancel_reason")
    private String cancelReason;

    /**
     * Default constructor for CancelCustomerSubscriptionRequest.
     */
    public CancelCustomerSubscriptionRequest() {
    }

    /**
     * Gets the subscription ID to cancel.
     * @return The subscription ID
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the subscription ID to cancel.
     * @param subscriptionId The subscription ID
     */
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets whether to cancel at the end of the current billing period.
     * @return True to cancel at period end, false for immediate cancellation
     */
    public Boolean getCancelAtPeriodEnd() {
        return cancelAtPeriodEnd;
    }

    /**
     * Sets whether to cancel at the end of the current billing period.
     * @param cancelAtPeriodEnd True to cancel at period end, false for immediate cancellation
     */
    public void setCancelAtPeriodEnd(Boolean cancelAtPeriodEnd) {
        this.cancelAtPeriodEnd = cancelAtPeriodEnd;
    }

    /**
     * Gets the cancellation reason.
     * @return The reason for cancellation, or null if not provided
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * Sets the cancellation reason.
     * @param cancelReason The reason for cancellation
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
