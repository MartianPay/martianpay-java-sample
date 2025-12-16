package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Pagination parameters for list requests with zero-indexed page numbering.
 * Defaults: page=0, pageSize=10. Maximum pageSize: 50.
 */
public class Pagination {
    /**
     * Page number starting from 0 (zero-indexed). Default: 0, Minimum: 0.
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of items per page. Default: 10, Maximum: 50, Minimum: 1.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Default constructor initializes with page=0, pageSize=10.
     */
    public Pagination() {
        this.page = 0;
        this.pageSize = 10;
    }

    /**
     * Sets default values for null or invalid parameters. Resets page to 0 if null or negative, pageSize to 10 if null or zero.
     */
    public void setDefault() {
        if (this.page == null || this.page < 0) {
            this.page = 0;
        }

        if (this.pageSize == null || this.pageSize == 0) {
            this.pageSize = 10;
        }
    }

    /**
     * Gets the page number to retrieve.
     * @return The page number (zero-indexed)
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the page number to retrieve.
     * @param page The page number (zero-indexed, must be >= 0)
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets the number of items per page.
     * @return The page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the number of items per page.
     * @param pageSize The page size (maximum 50)
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
