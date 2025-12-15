package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * MerchantAddressListResponse represents paginated merchant address list
 */
public class MerchantAddressListResponse {
    /**
     * MerchantAddresses is the list of merchant addresses in the current page
     */
    @SerializedName("merchant_addresses")
    private List<MerchantAddress> merchantAddresses;

    /**
     * Total is the total number of merchant addresses matching the query
     */
    @SerializedName("total")
    private Long total;

    /**
     * Page is the current page number (zero-indexed)
     */
    @SerializedName("page")
    private Integer page;

    /**
     * PageSize is the number of items per page
     */
    @SerializedName("page_size")
    private Integer pageSize;

    // Getters and Setters
    public List<MerchantAddress> getMerchantAddresses() { return merchantAddresses; }
    public void setMerchantAddresses(List<MerchantAddress> merchantAddresses) { this.merchantAddresses = merchantAddresses; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
