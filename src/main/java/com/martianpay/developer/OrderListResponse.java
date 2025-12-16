package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Paginated list of orders with pagination metadata.
 */
public class OrderListResponse {
    /** List of orders in the current page. */
    @SerializedName("orders")
    private List<OrderListItem> orders;

    /** Total number of orders matching the query. */
    @SerializedName("total")
    private Integer total;

    /** Current page number (zero-indexed). */
    @SerializedName("page")
    private Integer page;

    /** Number of items per page. */
    @SerializedName("page_size")
    private Integer pageSize;

    public OrderListResponse() {
    }

    // Getters and Setters
    public List<OrderListItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderListItem> orders) {
        this.orders = orders;
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
