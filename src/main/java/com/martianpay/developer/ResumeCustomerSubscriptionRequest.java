package com.martianpay.developer;

/**
 * Request to resume a paused customer subscription.
 */
public class ResumeCustomerSubscriptionRequest {
    /**
     * Unique identifier of the paused subscription to resume.
     */
    private String subscriptionId;

    public ResumeCustomerSubscriptionRequest() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
