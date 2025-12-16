package com.martianpay.developer;

/**
 * Request to resume a merchant-paused subscription.
 */
public class ResumeMerchantSubscriptionRequest {
    /**
     * Unique identifier of the paused subscription to resume.
     */
    private String subscriptionId;

    public ResumeMerchantSubscriptionRequest() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
