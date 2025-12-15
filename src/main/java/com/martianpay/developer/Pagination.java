package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Pagination contains pagination parameters for list requests
 */
public class Pagination {
    /**
     * Page is the page number to retrieve (zero-indexed, default is 0)
     */
    @SerializedName("page")
    private Integer page;

    /**
     * PageSize is the number of items per page (default is 10, max is 50)
     */
    @SerializedName("page_size")
    private Integer pageSize;

    public Pagination() {
        this.page = 0;
        this.pageSize = 10;
    }

    public void setDefault() {
        if (this.page == null || this.page < 0) {
            this.page = 0;
        }

        if (this.pageSize == null || this.pageSize == 0) {
            this.pageSize = 10;
        }
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
