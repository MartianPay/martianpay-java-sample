package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ListMerchantSubscriptionsRequest represents parameters for listing subscriptions belonging to a merchant.
 *
 * This request class enables merchants to query and filter their subscription collections across all customers.
 * It provides comprehensive filtering capabilities including customer, status, and external ID filters,
 * along with pagination support for efficient data retrieval.
 *
 * Typical use cases:
 * - Merchant viewing all active subscriptions in their dashboard
 * - Filtering subscriptions by customer for account management
 * - Monitoring subscription health (active, past_due, cancelled)
 * - Finding subscriptions by external_id for integration sync
 * - Generating subscription reports and analytics
 * - Tracking churn and renewal rates
 * - Managing subscription lifecycle across customer base
 *
 * Subscription statuses:
 * - active: Subscription is current and billing normally
 * - past_due: Payment failed, in grace period
 * - cancelled: Subscription cancelled, no future billing
 * - incomplete: Initial payment not completed
 * - trialing: In trial period, not yet billed
 *
 * Filter combinations:
 * - All filters can be used independently or in combination
 * - Multiple filters are combined with AND logic
 * - Example: customer_id + status = "active" returns active subscriptions for that customer
 *
 * Pagination:
 * - offset: Number of records to skip (for page calculation)
 * - limit: Maximum number of records to return per page
 * - Use offset = (page_number - 1) * limit for page-based navigation
 */
public class ListMerchantSubscriptionsRequest {
    /**
     * Filter subscriptions by customer ID.
     * When provided, only returns subscriptions for the specified customer.
     * Useful for viewing a customer's complete subscription portfolio.
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * Filter subscriptions by status.
     * Possible values: "active", "past_due", "cancelled", "incomplete", "trialing"
     * Useful for monitoring subscription health and identifying issues.
     */
    @SerializedName("status")
    private String status;

    /**
     * Filter subscriptions by external ID.
     * Used to find subscriptions that were synced from an external system.
     * Enables bidirectional sync with external CRM or billing systems.
     */
    @SerializedName("external_id")
    private String externalId;

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

    public ListMerchantSubscriptionsRequest() {
    }

    /**
     * Gets the customer ID filter.
     * @return The customer ID, or null if not filtering by customer
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID filter.
     * @param customerId The customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * Gets the external ID filter.
     * @return The external ID, or null if not filtering by external ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the external ID filter.
     * @param externalId The external ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
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
