package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list products with optional filtering.
 */
public class ProductListRequest {
    /**
     * Page number for pagination (zero-indexed).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of products to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter by active status.
     */
    @SerializedName("active")
    private Boolean active;

    // Getters and Setters
    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
