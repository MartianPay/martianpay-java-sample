package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SubscriptionListResponse represents a paginated list of subscriptions
 */
public class SubscriptionListResponse {
    @SerializedName("data")
    private List<SubscriptionDetails> data;

    @SerializedName("total")
    private Long total;

    @SerializedName("offset")
    private Integer offset;

    @SerializedName("limit")
    private Integer limit;

    // Getters and Setters
    public List<SubscriptionDetails> getData() { return data; }
    public void setData(List<SubscriptionDetails> data) { this.data = data; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
}
