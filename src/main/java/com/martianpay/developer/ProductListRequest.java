package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ProductListRequest lists products with filters
 */
public class ProductListRequest {
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

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
