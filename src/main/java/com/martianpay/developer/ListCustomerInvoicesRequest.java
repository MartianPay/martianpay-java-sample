package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ListCustomerInvoicesRequest {
    @SerializedName("subscription_id")
    private String subscriptionId;

    @SerializedName("status")
    private String status;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    public ListCustomerInvoicesRequest() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
