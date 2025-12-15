package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class Withdraw {
    @SerializedName("id")
    private String id;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("payout_id")
    private String payoutId;

    @SerializedName("asset_id")
    private String assetId;

    @SerializedName("decimals")
    private Integer decimals;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("tx_fee")
    private BigDecimal txFee;

    @SerializedName("network_fee")
    private BigDecimal networkFee;

    @SerializedName("estimated_receive_amount")
    private BigDecimal estimatedReceiveAmount;

    @SerializedName("estimated_receive_amount_min")
    private BigDecimal estimatedReceiveAmountMin;

    @SerializedName("status")
    private String status;

    @SerializedName("sub_status")
    private String subStatus;

    @SerializedName("address")
    private String address;

    @SerializedName("type")
    private String type;

    @SerializedName("original_frozen_tx_id")
    private String originalFrozenTxId;

    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("version")
    private Long version;

    public Withdraw() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTxFee() {
        return txFee;
    }

    public void setTxFee(BigDecimal txFee) {
        this.txFee = txFee;
    }

    public BigDecimal getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(BigDecimal networkFee) {
        this.networkFee = networkFee;
    }

    public BigDecimal getEstimatedReceiveAmount() {
        return estimatedReceiveAmount;
    }

    public void setEstimatedReceiveAmount(BigDecimal estimatedReceiveAmount) {
        this.estimatedReceiveAmount = estimatedReceiveAmount;
    }

    public BigDecimal getEstimatedReceiveAmountMin() {
        return estimatedReceiveAmountMin;
    }

    public void setEstimatedReceiveAmountMin(BigDecimal estimatedReceiveAmountMin) {
        this.estimatedReceiveAmountMin = estimatedReceiveAmountMin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginalFrozenTxId() {
        return originalFrozenTxId;
    }

    public void setOriginalFrozenTxId(String originalFrozenTxId) {
        this.originalFrozenTxId = originalFrozenTxId;
    }

    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
