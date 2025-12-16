package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request for listing paginated balance flow statistics for a merchant account.
 * Supports filtering by currency to track incoming and outgoing funds.
 */
public class StatsBalanceFlowListReq {
    /**
     * Page number for pagination, starting from 0 (zero-indexed).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of balance flow records to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Currency code to filter balance flows (e.g., "USDT", "ETH", "USD").
     * Leave null to retrieve flows for all currencies.
     */
    @SerializedName("currency")
    private String currency;

    public StatsBalanceFlowListReq() {
    }

    /**
     * @return The page number
     */
    public Integer getPage() {
        return page;
    }

    /**
     * @param page The page number
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * @return The page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize The page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return The currency code
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
