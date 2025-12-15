package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class OrderListRequest extends Pagination {
    @SerializedName("search")
    private String search;

    @SerializedName("status")
    private String status;

    public OrderListRequest() {
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
