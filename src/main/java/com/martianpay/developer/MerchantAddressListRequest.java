package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve a paginated list of merchant blockchain addresses.
 * Supports network filtering.
 */
public class MerchantAddressListRequest {
    /**
     * Filter addresses by blockchain network (optional).
     */
    @SerializedName("network")
    private String network;

    /**
     * Page number for pagination (zero-indexed, starts from 0).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of addresses to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Gets the network filter.
     * @return The network to filter by, or null for all networks
     */
    public String getNetwork() { return network; }

    /**
     * Sets the network filter.
     * @param network The network to filter by (e.g., "ETH", "BTC")
     */
    public void setNetwork(String network) { this.network = network; }

    /**
     * Gets the page number.
     * @return The page number (zero-indexed, starts from 0), or null if not set
     */
    public Integer getPage() { return page; }

    /**
     * Sets the page number.
     * @param page The page number (zero-indexed, starts from 0)
     */
    public void setPage(Integer page) { this.page = page; }

    /**
     * Gets the page size.
     * @return The number of addresses per page, or null if not set
     */
    public Integer getPageSize() { return pageSize; }

    /**
     * Sets the page size.
     * @param pageSize The number of addresses per page
     */
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
