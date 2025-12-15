package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PauseMerchantSubscriptionRequest {
    private String subscriptionId;

    @SerializedName("behavior")
    private String behavior;

    @SerializedName("resumes_at")
    private Long resumesAt;

    public PauseMerchantSubscriptionRequest() {
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
