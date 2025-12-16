package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list invoices for a customer.
 * Supports filtering by subscription and status, with pagination.
 */
public class ListCustomerInvoicesRequest {
    /**
     * Filter invoices by subscription ID (optional).
     */
    @SerializedName("subscription_id")
    private String subscriptionId;

    /**
     * Filter invoices by status (optional).
     */
    @SerializedName("status")
    private String status;

    /**
     * Number of records to skip for pagination.
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * Maximum number of records to return per request.
     */
    @SerializedName("limit")
    private Integer limit;

    public ListCustomerInvoicesRequest() {
    }

    /**
     * Gets the subscription ID filter.
     * @return The subscription ID, or null if not filtering by subscription
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the subscription ID filter.
     * @param subscriptionId The subscription ID
     */
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the status filter.
     * @return The invoice status, or null if not filtering by status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status filter.
     * @param status The invoice status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the pagination offset.
     * @return The offset value
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets the pagination offset.
     * @param offset The offset value
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Gets the pagination limit.
     * @return The limit value
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the pagination limit.
     * @param limit The limit value
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
