package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve a filtered and paginated list of payouts.
 * Supports filtering by status, time range, merchant ID, and external ID with pagination.
 */
public class ListPayoutsRequest {
    /**
     * Page number for pagination, starting from 0 (zero-indexed). Default: 0 if not specified.
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of payouts to return per page. Default: 20 if not specified.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter payouts by status. Valid values: pending, processing, completed, failed, canceled. Null returns all statuses.
     */
    @SerializedName("status")
    private String status;

    /**
     * Filter payouts by merchant ID. Null returns payouts for authenticated merchant.
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * Start of time range filter in Unix timestamp (seconds). Filters payouts created on or after this timestamp. Null means no start limit.
     */
    @SerializedName("start_time")
    private Long startTime;

    /**
     * End of time range filter in Unix timestamp (seconds). Filters payouts created before or on this timestamp. Null means no end limit.
     */
    @SerializedName("end_time")
    private Long endTime;

    /**
     * Filter payouts by external ID. Exact case-sensitive match. Null means no external ID filtering.
     */
    @SerializedName("external_id")
    private String externalID;

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
     * @return The number of payouts per page, or null if not set
     */
    public Integer getPageSize() { return pageSize; }

    /**
     * Sets the page size.
     * @param pageSize The number of payouts per page
     */
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    /**
     * Gets the status filter.
     * @return The payout status to filter by, or null for all statuses
     */
    public String getStatus() { return status; }

    /**
     * Sets the status filter.
     * @param status The payout status to filter by
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Gets the merchant ID filter.
     * @return The merchant ID, or null for authenticated merchant
     */
    public String getMerchantID() { return merchantID; }

    /**
     * Sets the merchant ID filter.
     * @param merchantID The merchant ID
     */
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    /**
     * Gets the start time filter.
     * @return The start timestamp in seconds, or null for no start limit
     */
    public Long getStartTime() { return startTime; }

    /**
     * Sets the start time filter.
     * @param startTime The start timestamp in seconds
     */
    public void setStartTime(Long startTime) { this.startTime = startTime; }

    /**
     * Gets the end time filter.
     * @return The end timestamp in seconds, or null for no end limit
     */
    public Long getEndTime() { return endTime; }

    /**
     * Sets the end time filter.
     * @param endTime The end timestamp in seconds
     */
    public void setEndTime(Long endTime) { this.endTime = endTime; }

    /**
     * Gets the external ID filter.
     * @return The external ID, or null for no external ID filtering
     */
    public String getExternalID() { return externalID; }

    /**
     * Sets the external ID filter.
     * @param externalID The external ID
     */
    public void setExternalID(String externalID) { this.externalID = externalID; }
}
