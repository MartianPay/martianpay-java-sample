package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PayoutListResp {
    @SerializedName("payouts")
    private List<Payout> payouts;

    @SerializedName("total")
    private Integer total;

    /**
     * Current page number, starting from 0 (zero-indexed).
     * The first page is page 0, second page is page 1, etc.
     */
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    public PayoutListResp() {
    }

    public List<Payout> getPayouts() {
        return payouts;
    }

    public void setPayouts(List<Payout> payouts) {
        this.payouts = payouts;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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
}
