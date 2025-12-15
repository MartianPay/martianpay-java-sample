package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PaymentLinkListResponse represents paginated payment link list
 */
public class PaymentLinkListResponse {
    /**
     * PaymentLinks is the list of payment links in the current page
     */
    @SerializedName("payment_links")
    private List<PaymentLink> paymentLinks;

    /**
     * Total is the total number of payment links matching the query
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
    public List<PaymentLink> getPaymentLinks() { return paymentLinks; }
    public void setPaymentLinks(List<PaymentLink> paymentLinks) { this.paymentLinks = paymentLinks; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
