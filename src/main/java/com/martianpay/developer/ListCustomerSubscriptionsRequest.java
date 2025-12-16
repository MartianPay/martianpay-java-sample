package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ListCustomerSubscriptionsRequest represents parameters for listing subscriptions belonging to a specific customer.
 *
 * This request class enables customers to query their own subscription history and manage active subscriptions.
 * It provides filtering by subscription status and pagination support for handling large result sets.
 *
 * Typical use cases:
 * - Customer viewing their active subscriptions in account portal
 * - Filtering subscriptions by status (active, cancelled, past_due)
 * - Implementing paginated subscription lists in customer UI
 * - Displaying subscription management interface
 * - Exporting subscription data for customer records
 *
 * Subscription statuses:
 * - active: Subscription is current and billing normally
 * - past_due: Payment failed, in grace period
 * - cancelled: Subscription cancelled, no future billing
 * - incomplete: Initial payment not completed
 * - trialing: In trial period, not yet billed
 *
 * Pagination:
 * - offset: Number of records to skip (for page calculation)
 * - limit: Maximum number of records to return per page
 * - Use offset = (page_number - 1) * limit for page-based navigation
 */
public class ListCustomerSubscriptionsRequest {
    /**
     * Filter subscriptions by status.
     * Possible values: "active", "past_due", "cancelled", "incomplete", "trialing"
     * Allows customers to view only active subscriptions, cancelled ones, etc.
     */
    @SerializedName("status")
    private String status;

    /**
     * Number of records to skip before returning results.
     * Used for pagination. For page-based navigation: offset = (page - 1) * limit
     * Defaults to 0 if not provided.
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * Maximum number of records to return in a single request.
     * Used for pagination. Typical values: 10, 20, 50, 100
     * Server may enforce a maximum limit to prevent excessive data transfer.
     */
    @SerializedName("limit")
    private Integer limit;

    public ListCustomerSubscriptionsRequest() {
    }

    /**
     * Gets the status filter.
     * @return The subscription status, or null if not filtering by status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status filter.
     * @param status The subscription status
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
