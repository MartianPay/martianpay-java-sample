package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SubscriptionListResponse represents a paginated list of subscriptions.
 *
 * This response contains a page of subscription records along with pagination metadata.
 * It enables efficient retrieval and display of subscription collections by breaking
 * them into manageable pages. Each subscription includes complete details about the
 * recurring payment arrangement, including status, billing cycle, and customer information.
 *
 * Response structure:
 * - data: Array of subscription records for the current page
 * - total: Total count of subscriptions matching the query (across all pages)
 * - offset: Current offset position in the result set
 * - limit: Maximum number of records per page
 *
 * Pagination calculations:
 * - Current page size: data.length
 * - Total pages: Math.ceil(total / limit)
 * - Has more pages: (offset + limit) < total
 * - Next page offset: offset + limit
 * - Previous page offset: offset - limit
 *
 * Use cases:
 * - Display paginated subscription lists in merchant dashboards
 * - Show customer's active subscriptions
 * - Implement infinite scroll or pagination controls in UI
 * - Export subscription data in batches for reporting
 * - Track recurring revenue and subscription metrics
 * - Monitor subscription lifecycle and churn analysis
 */
public class SubscriptionListResponse {
    /**
     * List of subscription details for the current page.
     * Each entry contains complete subscription information including billing details.
     */
    @SerializedName("data")
    private List<SubscriptionDetails> data;

    /**
     * Total number of subscriptions matching the query across all pages.
     * Used to calculate total page count and display result summaries.
     */
    @SerializedName("total")
    private Long total;

    /**
     * Number of records skipped before this page.
     * Determines the starting position in the result set.
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * Maximum number of records returned per page.
     * Used for pagination calculations and UI display.
     */
    @SerializedName("limit")
    private Integer limit;

    // Getters and Setters
    public List<SubscriptionDetails> getData() { return data; }
    public void setData(List<SubscriptionDetails> data) { this.data = data; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
