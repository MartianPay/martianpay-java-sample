package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ListMerchantInvoicesRequest {
    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("subscription_id")
    private String subscriptionId;

    @SerializedName("status")
    private String status;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    public ListMerchantInvoicesRequest() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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
