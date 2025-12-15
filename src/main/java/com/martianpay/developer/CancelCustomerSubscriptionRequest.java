package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class CancelCustomerSubscriptionRequest {
    private String subscriptionId;

    @SerializedName("cancel_at_period_end")
    private Boolean cancelAtPeriodEnd;

    @SerializedName("cancel_reason")
    private String cancelReason;

    public CancelCustomerSubscriptionRequest() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Boolean getCancelAtPeriodEnd() {
        return cancelAtPeriodEnd;
    }

    public void setCancelAtPeriodEnd(Boolean cancelAtPeriodEnd) {
        this.cancelAtPeriodEnd = cancelAtPeriodEnd;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
