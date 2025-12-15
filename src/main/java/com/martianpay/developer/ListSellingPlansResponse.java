package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ListSellingPlansResponse represents a paginated list of selling plans
 */
public class ListSellingPlansResponse {
    /**
     * Data is the list of selling plans in the current page
     */
    @SerializedName("data")
    private List<SellingPlanResponse> data;

    /**
     * Total is the total number of selling plans matching the query
     */
    @SerializedName("total")
    private Long total;

    /**
     * Offset is the starting position in the result set
     */
    @SerializedName("offset")
    private Integer offset;

    /**
     * Limit is the maximum number of items to return
     */
    @SerializedName("limit")
    private Integer limit;

    // Getters and Setters
    public List<SellingPlanResponse> getData() { return data; }
    public void setData(List<SellingPlanResponse> data) { this.data = data; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
