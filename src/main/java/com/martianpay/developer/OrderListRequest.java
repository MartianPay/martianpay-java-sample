package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve a paginated list of orders with optional filtering.
 */
public class OrderListRequest extends Pagination {
    /**
     * Search term to filter orders across order number, customer name, and email.
     */
    @SerializedName("search")
    private String search;

    /**
     * Order status to filter by.
     */
    @SerializedName("status")
    private String status;

    /**
     * Default constructor for OrderListRequest.
     */
    public OrderListRequest() {
    }

    /**
     * Gets the search term for filtering orders.
     * @return The search term, or null if no search filter
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets the search term for filtering orders.
     * @param search The search term
     */
    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * Gets the status filter.
     * @return The order status to filter by, or null for all statuses
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status filter.
     * @param status The order status to filter by
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
