package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ListSellingPlanGroupsResponse represents a paginated list of selling plan groups
 */
public class ListSellingPlanGroupsResponse {
    /**
     * Data is the list of selling plan groups in the current page
     */
    @SerializedName("data")
    private List<SellingPlanGroupResponse> data;

    /**
     * Total is the total number of selling plan groups matching the query
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
    public List<SellingPlanGroupResponse> getData() { return data; }
    public void setData(List<SellingPlanGroupResponse> data) { this.data = data; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
