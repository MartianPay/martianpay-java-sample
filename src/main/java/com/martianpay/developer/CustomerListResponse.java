package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * CustomerListResponse contains paginated customer list
 */
public class CustomerListResponse {
    /**
     * Customers is the list of customers in the current page
     */
    @SerializedName("customers")
    private List<Customer> customers;

    /**
     * Total is the total number of customers matching the query
     */
    @SerializedName("total")
    private Integer total;

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
    public List<Customer> getCustomers() { return customers; }
    public void setCustomers(List<Customer> customers) { this.customers = customers; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
