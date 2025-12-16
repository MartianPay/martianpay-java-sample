package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Paginated list of subscriptions with offset-based pagination.
 */
public class ListSubscriptionsResponse {
    /** List of subscriptions in the current page. */
    @SerializedName("data")
    private List<SubscriptionDetails> data;

    /** Total number of subscriptions matching the query. */
    @SerializedName("total")
    private Long total;

    /** Pagination offset. */
    @SerializedName("offset")
    private Integer offset;

    /** Maximum records per page. */
    @SerializedName("limit")
    private Integer limit;

    public ListSubscriptionsResponse() {
    }

    // Getters and Setters
    public List<SubscriptionDetails> getData() {
        return data;
    }

    public void setData(List<SubscriptionDetails> data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
