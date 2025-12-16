package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to list payment intents with optional filtering.
 */
public class PaymentIntentListRequest {
    /**
     * Page number for pagination (zero-indexed).
     */
    @SerializedName("page")
    private Integer page;

    /**
     * Number of payment intents to return per page.
     */
    @SerializedName("page_size")
    private Integer pageSize;

    /**
     * Filter by customer ID.
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Filter by customer email address.
     */
    @SerializedName("customer_email")
    private String customerEmail;

    /**
     * Filter by merchant order ID.
     */
    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    /**
     * Filter by permanent deposit status.
     */
    @SerializedName("permanent_deposit")
    private Boolean permanentDeposit;

    /**
     * Filter by permanent deposit asset ID.
     */
    @SerializedName("permanent_deposit_asset_id")
    private String permanentDepositAssetId;

    public PaymentIntentListRequest() {
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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public Boolean getPermanentDeposit() {
        return permanentDeposit;
    }

    public void setPermanentDeposit(Boolean permanentDeposit) {
        this.permanentDeposit = permanentDeposit;
    }

    public String getPermanentDepositAssetId() {
        return permanentDepositAssetId;
    }

    public void setPermanentDepositAssetId(String permanentDepositAssetId) {
        this.permanentDepositAssetId = permanentDepositAssetId;
    }
}
