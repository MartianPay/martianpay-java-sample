package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * MerchantAddressListRequest lists merchant addresses with filters
 */
public class MerchantAddressListRequest {
    @SerializedName("network")
    private String network;

    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    // Getters and Setters
    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
