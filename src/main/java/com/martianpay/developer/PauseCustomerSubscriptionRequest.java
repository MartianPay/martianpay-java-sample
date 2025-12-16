package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to temporarily pause a customer's subscription.
 */
public class PauseCustomerSubscriptionRequest {
    /**
     * The unique identifier of the subscription to pause.
     */
    private String subscriptionId;

    /**
     * Defines how to handle billing during pause.
     */
    @SerializedName("behavior")
    private String behavior;

    /**
     * Unix timestamp (in seconds) when the subscription should automatically resume.
     */
    @SerializedName("resumes_at")
    private Long resumesAt;

    public PauseCustomerSubscriptionRequest() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public Long getResumesAt() {
        return resumesAt;
    }

    public void setResumesAt(Long resumesAt) {
        this.resumesAt = resumesAt;
    }
}
