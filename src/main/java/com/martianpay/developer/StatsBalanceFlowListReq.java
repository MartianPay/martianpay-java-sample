package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class StatsBalanceFlowListReq {
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("currency")
    private String currency;

    public StatsBalanceFlowListReq() {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
