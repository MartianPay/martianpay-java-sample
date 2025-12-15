package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * SubscriptionListRequest lists subscriptions for merchant with filters
 */
public class SubscriptionListRequest {
    @SerializedName("customer_id")
    private String customerID;

    @SerializedName("status")
    private String status;

    @SerializedName("external_id")
    private String externalID;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    // Getters and Setters
    public String getCustomerID() { return customerID; }
    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getExternalID() { return externalID; }
    public void setExternalID(String externalID) { this.externalID = externalID; }

    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
