package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list payouts with optional filtering.
 */
public class PayoutListRequest {
    /**
     * Page number for pagination (zero-indexed).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of payouts to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter by payout status.
     */
    @SerializedName("status")
    private String status;

    /**
     * Filter by merchant ID.
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * Filter by start time (Unix timestamp in seconds).
     */
    @SerializedName("start_time")
    private Long startTime;

    /**
     * Filter by end time (Unix timestamp in seconds).
     */
    @SerializedName("end_time")
    private Long endTime;

    /**
     * Filter by external ID.
     */
    @SerializedName("external_id")
    private String externalId;

    public PayoutListRequest() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
