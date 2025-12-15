package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ListPayoutsResponse represents paginated payout list
 */
public class ListPayoutsResponse {
    /**
     * Payouts is the list of payouts in the current page
     */
    @SerializedName("payouts")
    private List<Payout> payouts;

    /**
     * Total is the total number of payouts matching the query
     */
    @SerializedName("total")
    private Integer total;

    /**
     * Page is the current page number (zero-indexed)
     */
    @SerializedName("page")
    private Integer page;

    /**
     * PageSize is the number of items per page
     */
    @SerializedName("page_size")
    private Integer pageSize;

    // Getters and Setters
    public List<Payout> getPayouts() { return payouts; }
    public void setPayouts(List<Payout> payouts) { this.payouts = payouts; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
