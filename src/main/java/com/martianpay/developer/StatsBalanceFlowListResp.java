package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * StatsBalanceFlowListResp represents the response for a balance flow statistics list request.
 *
 * This response model contains paginated balance flow data for a merchant account,
 * including all transactions that affect the account balance such as payments received,
 * refunds issued, fees charged, and settlement transfers.
 *
 * Key features:
 * - List of balance flow records for the requested page
 * - Pagination metadata (page, page size, total count)
 * - Support for filtering by currency
 * - Complete transaction history tracking
 *
 * Use cases:
 * - Displaying transaction history in merchant dashboards
 * - Generating financial reports and reconciliation
 * - Implementing pagination controls in UI
 * - Calculating account balance changes over time
 * - Auditing and compliance reporting
 *
 * The response includes pagination information that helps clients:
 * - Navigate through large datasets
 * - Calculate total number of pages
 * - Implement "load more" or "infinite scroll" features
 * - Display progress indicators
 */
public class StatsBalanceFlowListResp {
    /**
     * List of balance flow records for the current page.
     * Each record represents a single transaction or balance change event.
     * Empty list if no records match the query criteria.
     * Order: Typically sorted by transaction timestamp (newest first).
     */
    @SerializedName("balance_flows")
    private List<MerchantBalanceFlow> balanceFlows;

    /**
     * Current page number, starting from 0 (zero-indexed).
     * The first page is page 0, second page is page 1, etc.
     * Indicates which page of results this response contains.
     * Matches the page number from the request.
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of items per page.
     * Indicates how many records were requested per page.
     * The actual number of items in balanceFlows may be less
     * if this is the last page or if fewer results are available.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Total number of balance flow records matching the query.
     * Use this to calculate total pages: Math.ceil(total / pageSize)
     * Useful for displaying pagination controls and progress.
     */
    @SerializedName("total")
    private Integer total;

    /**
     * Default constructor for StatsBalanceFlowListResp.
     */
    public StatsBalanceFlowListResp() {
    }

    /**
     * Gets the list of balance flow records.
     * @return List of balance flows for the current page
     */
    public List<MerchantBalanceFlow> getBalanceFlows() {
        return balanceFlows;
    }

    /**
     * Sets the list of balance flow records.
     * @param balanceFlows List of balance flows
     */
    public void setBalanceFlows(List<MerchantBalanceFlow> balanceFlows) {
        this.balanceFlows = balanceFlows;
    }

    /**
     * Gets the current page number.
     * @return The page number (zero-indexed)
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the current page number.
     * @param page The page number (zero-indexed)
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets the page size.
     * @return The number of items per page
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page size.
     * @param pageSize The number of items per page
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the total count of all matching records.
     * @return The total number of balance flows matching the query
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * Sets the total count of all matching records.
     * @param total The total number of balance flows
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
