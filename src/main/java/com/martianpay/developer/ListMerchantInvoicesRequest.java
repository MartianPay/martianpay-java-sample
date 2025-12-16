package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ListMerchantInvoicesRequest represents parameters for listing invoices belonging to a merchant.
 *
 * This request class is used by merchants to query and filter their invoice collections.
 * It provides comprehensive filtering capabilities including customer, subscription, status,
 * and external ID filters, along with pagination support for efficient data retrieval.
 *
 * Typical use cases:
 * - Merchant viewing all invoices in their dashboard
 * - Filtering invoices by customer to view billing history
 * - Finding invoices by subscription for recurring billing analysis
 * - Filtering by status to track outstanding payments
 * - Looking up invoices by external_id for integration sync
 * - Implementing paginated invoice tables
 * - Exporting invoice data for accounting and reporting
 *
 * Filter combinations:
 * - All filters can be used independently or in combination
 * - Multiple filters are combined with AND logic
 * - Example: customer_id + status returns invoices for that customer with that status
 *
 * Pagination:
 * - offset: Number of records to skip (for page calculation)
 * - limit: Maximum number of records to return per page
 * - Use offset = (page_number - 1) * limit for page-based navigation
 */
public class ListMerchantInvoicesRequest {
    /**
     * Filter invoices by customer ID.
     * When provided, only returns invoices for the specified customer.
     * Useful for viewing a customer's complete billing history.
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * Filter invoices by subscription ID.
     * When provided, only returns invoices associated with this subscription.
     * Useful for analyzing recurring billing patterns and subscription revenue.
     */
    @SerializedName("subscription_id")
    private String subscriptionId;

    /**
     * Filter invoices by status.
     * Possible values: "draft", "open", "paid", "void", "uncollectible"
     * Useful for tracking outstanding payments (open) or completed transactions (paid).
     */
    @SerializedName("status")
    private String status;

    /**
     * Filter invoices by external ID.
     * Used to find invoices that were synced from an external system.
     * Enables bidirectional sync with external accounting or ERP systems.
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

    public ListMerchantInvoicesRequest() {
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
