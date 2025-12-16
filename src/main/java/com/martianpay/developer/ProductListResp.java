package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProductListResp {
    @SerializedName("products")
    private List<Product> products;

    @SerializedName("total")
    private Long total;

    /**
     * Current page number, starting from 0 (zero-indexed).
     * The first page is page 0, second page is page 1, etc.
     */
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    public ProductListResp() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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
