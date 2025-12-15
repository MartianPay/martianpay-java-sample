package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayoutSwapItem {
    @SerializedName("id")
    private String id;

    @SerializedName("quote_id")
    private String quoteId;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("payout_id")
    private String payoutId;

    @SerializedName("payout")
    private Payout payout;

    @SerializedName("from_asset_id")
    private String fromAssetId;

    @SerializedName("expected_from_amount")
    private String expectedFromAmount;

    @SerializedName("estimated_from_amount")
    private String estimatedFromAmount;

    @SerializedName("estimated_from_amount_usd")
    private String estimatedFromAmountUsd;

    @SerializedName("actual_from_amount")
    private String actualFromAmount;

    @SerializedName("network_fee")
    private String networkFee;

    @SerializedName("to_asset_id")
    private String toAssetId;

    @SerializedName("expected_to_amount")
    private String expectedToAmount;

    @SerializedName("estimated_to_amount")
    private String estimatedToAmount;

    @SerializedName("estimated_to_amount_min")
    private String estimatedToAmountMin;

    @SerializedName("estimated_to_amount_usd")
    private String estimatedToAmountUsd;

    @SerializedName("actual_to_amount")
    private String actualToAmount;

    @SerializedName("status")
    private String status;

    public PayoutSwapItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPayoutId() {
        return payoutId;
    }

    public void setPayoutId(String payoutId) {
        this.payoutId = payoutId;
    }

    public Payout getPayout() {
        return payout;
    }

    public void setPayout(Payout payout) {
        this.payout = payout;
    }

    public String getFromAssetId() {
        return fromAssetId;
    }

    public void setFromAssetId(String fromAssetId) {
        this.fromAssetId = fromAssetId;
    }

    public String getExpectedFromAmount() {
        return expectedFromAmount;
    }

    public void setExpectedFromAmount(String expectedFromAmount) {
        this.expectedFromAmount = expectedFromAmount;
    }

    public String getEstimatedFromAmount() {
        return estimatedFromAmount;
    }

    public void setEstimatedFromAmount(String estimatedFromAmount) {
        this.estimatedFromAmount = estimatedFromAmount;
    }

    public String getEstimatedFromAmountUsd() {
        return estimatedFromAmountUsd;
    }

    public void setEstimatedFromAmountUsd(String estimatedFromAmountUsd) {
        this.estimatedFromAmountUsd = estimatedFromAmountUsd;
    }

    public String getActualFromAmount() {
        return actualFromAmount;
    }

    public void setActualFromAmount(String actualFromAmount) {
        this.actualFromAmount = actualFromAmount;
    }

    public String getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(String networkFee) {
        this.networkFee = networkFee;
    }

    public String getToAssetId() {
        return toAssetId;
    }

    public void setToAssetId(String toAssetId) {
        this.toAssetId = toAssetId;
    }

    public String getExpectedToAmount() {
        return expectedToAmount;
    }

    public void setExpectedToAmount(String expectedToAmount) {
        this.expectedToAmount = expectedToAmount;
    }

    public String getEstimatedToAmount() {
        return estimatedToAmount;
    }

    public void setEstimatedToAmount(String estimatedToAmount) {
        this.estimatedToAmount = estimatedToAmount;
    }

    public String getEstimatedToAmountMin() {
        return estimatedToAmountMin;
    }

    public void setEstimatedToAmountMin(String estimatedToAmountMin) {
        this.estimatedToAmountMin = estimatedToAmountMin;
    }

    public String getEstimatedToAmountUsd() {
        return estimatedToAmountUsd;
    }

    public void setEstimatedToAmountUsd(String estimatedToAmountUsd) {
        this.estimatedToAmountUsd = estimatedToAmountUsd;
    }

    public String getActualToAmount() {
        return actualToAmount;
    }

    public void setActualToAmount(String actualToAmount) {
        this.actualToAmount = actualToAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
