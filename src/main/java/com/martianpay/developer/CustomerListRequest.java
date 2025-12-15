package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CustomerListRequest contains parameters for listing customers
 */
public class CustomerListRequest {
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("email")
    private String email;

    // Getters and Setters
    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
