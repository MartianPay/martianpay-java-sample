package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentIntentListRequest {
    @SerializedName("page")
    private Integer page;

    @SerializedName("page_size")
    private Integer pageSize;

    @SerializedName("customer")
    private String customer;

    @SerializedName("customer_email")
    private String customerEmail;

    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    @SerializedName("permanent_deposit")
    private Boolean permanentDeposit;

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
