package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * RefundListResponse represents the response containing a paginated list of refunds
 */
public class RefundListResponse {
    /**
     * Refunds is the list of refunds in the current page
     */
    @SerializedName("refunds")
    private List<Refund> refunds;

    /**
     * Total is the total number of refunds matching the query
     */
    @SerializedName("total")
    private Long total;

    /**
     * Current page number, starting from 0 (zero-indexed).
     * The first page is page 0, second page is page 1, etc.
     */
    @SerializedName("page")
    private Integer page;

    /**
     * PageSize is the number of items per page
     */
    @SerializedName("page_size")
    private Integer pageSize;

    // Getters and Setters
    public List<Refund> getRefunds() { return refunds; }
    public void setRefunds(List<Refund> refunds) { this.refunds = refunds; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
