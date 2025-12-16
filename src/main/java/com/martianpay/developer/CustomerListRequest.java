package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve a paginated list of customers.
 * Supports email filtering and configurable page size.
 */
public class CustomerListRequest {
    /**
     * Page number for pagination (zero-indexed, starts from 0).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of customers to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter customers by email address (optional).
     */
    @SerializedName("email")
    private String email;

    /**
     * Gets the page number to retrieve.
     * @return The page number (zero-indexed, starts from 0), or null if not set
     */
    public Integer getPage() { return page; }

    /**
     * Sets the page number to retrieve.
     * @param page The page number (zero-indexed, starts from 0)
     */
    public void setPage(Integer page) { this.page = page; }

    /**
     * Gets the number of customers per page.
     * @return The page size, or null if not set
     */
    public Integer getPageSize() { return pageSize; }

    /**
     * Sets the number of customers per page.
     * @param pageSize The page size
     */
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    /**
     * Gets the email filter.
     * @return The email to filter by, or null for no filtering
     */
    public String getEmail() { return email; }

    /**
     * Sets the email filter.
     * @param email The email to filter by
     */
    public void setEmail(String email) { this.email = email; }
}
