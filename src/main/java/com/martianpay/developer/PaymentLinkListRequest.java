package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list payment links with optional filtering.
 */
public class PaymentLinkListRequest {
    /**
     * Page number for pagination (zero-indexed).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of payment links to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter by active status.
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * Filter by product ID.
     */
    @SerializedName("product")
    private String product;

    // Getters and Setters
    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
}
