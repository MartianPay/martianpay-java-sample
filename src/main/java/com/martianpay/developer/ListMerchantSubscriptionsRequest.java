package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class ListMerchantSubscriptionsRequest {
    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("status")
    private String status;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    public ListMerchantSubscriptionsRequest() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
