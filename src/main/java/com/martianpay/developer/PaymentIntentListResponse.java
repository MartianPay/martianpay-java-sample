package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * PaymentIntentListResponse represents paginated payment intent list
 */
public class PaymentIntentListResponse {
    /**
     * PaymentIntents is the list of payment intents in the current page
     */
    @SerializedName("payment_intents")
    private List<PaymentIntent> paymentIntents;

    /**
     * Total is the total number of payment intents matching the query
     */
    @SerializedName("total")
    private Long total;

    /**
     * Current page number, starting from 0 (zero-indexed).
     * The first page is page 0, second page is page 1, etc.
     */
    @SerializedName("page")
    private Integer page;

    /**
     * PageSize is the number of items per page
     */
    @SerializedName("page_size")
    private Integer pageSize;

    // Getters and Setters
    public List<PaymentIntent> getPaymentIntents() { return paymentIntents; }
    public void setPaymentIntents(List<PaymentIntent> paymentIntents) { this.paymentIntents = paymentIntents; }

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
}
