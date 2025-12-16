package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list subscriptions with optional filtering.
 */
public class SubscriptionListRequest {
    /**
     * Filter by customer ID.
     */
    @SerializedName("customer_id")
    private String customerID;

    /**
     * Filter by subscription status.
     */
    @SerializedName("status")
    private String status;

    /**
     * Filter by external ID.
     */
    @SerializedName("external_id")
    private String externalID;

    /**
     * Number of records to skip (offset for pagination).
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * Maximum number of subscriptions to return.
     */
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
