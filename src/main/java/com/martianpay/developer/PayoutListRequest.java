package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayoutListRequest {
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("status")
    private String status;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("start_time")
    private Long startTime;

    @SerializedName("end_time")
    private Long endTime;

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
