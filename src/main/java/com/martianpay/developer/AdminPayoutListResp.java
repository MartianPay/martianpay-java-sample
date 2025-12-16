package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * AdminPayoutListResp represents a paginated response for administrative payout listings.
 *
 * This response is returned when administrators query the payout list through the admin API.
 * It provides a paginated view of all payouts in the system with filtering and sorting capabilities.
 *
 * Typical use cases:
 * - Admin dashboard displaying all merchant payouts
 * - Financial reporting and reconciliation
 * - Monitoring payout status across multiple merchants
 * - Audit and compliance reviews
 * - Bulk payout management operations
 *
 * Pagination:
 * - Supports page-based navigation through large payout lists
 * - Configurable page size for optimal performance
 * - Total count provided for calculating total pages
 * - Zero-indexed page numbers (first page is 0)
 *
 * Example usage:
 * Request page 0 with 20 items per page:
 * - page: 0, page_size: 20
 * - Returns: payouts[0-19], total: 150
 * - Calculate total pages: ceil(150 / 20) = 8 pages
 */
public class AdminPayoutListResp {
    /**
     * List of payout records for the current page.
     * Contains detailed information about each payout including:
     * - Payout ID and status
     * - Source and destination information
     * - Amount and currency details
     * - Timestamps and metadata
     */
    @SerializedName("payouts")
    private List<Payout> payouts;

    /**
     * Total number of payouts matching the query across all pages.
     * Used to calculate the total number of pages available.
     * Example: If total=150 and page_size=20, there are 8 pages total.
     */
    @SerializedName("total")
    private Integer total;

    /**
     * Current page number, starting from 0 (zero-indexed).
     * The first page is page 0, second page is page 1, etc.
     * Used for pagination navigation.
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of payout records per page.
     * Determines how many records are returned in the payouts list.
     * Typical values: 10, 20, 50, 100
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Constructs a new empty AdminPayoutListResp.
     */
    public AdminPayoutListResp() {
    }

    /**
     * Gets the list of payouts for the current page.
     * @return List of payout records
     */
    public List<Payout> getPayouts() {
        return payouts;
    }

    /**
     * Sets the list of payouts for the current page.
     * @param payouts List of payout records
     */
    public void setPayouts(List<Payout> payouts) {
        this.payouts = payouts;
    }

    /**
     * Gets the total number of payouts across all pages.
     * @return Total count of payouts
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the total number of payouts across all pages.
     * @param total Total count of payouts
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Gets the current page number (zero-indexed).
     * @return Current page number
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the current page number (zero-indexed).
     * @param page Current page number
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets the number of items per page.
     * @return Page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the number of items per page.
     * @param pageSize Page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
