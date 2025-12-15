package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentLinkListRequest lists payment links with filters
 */
public class PaymentLinkListRequest {
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("active")
    private Boolean active;

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
