package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class UnfreezeWithdraw {
    @SerializedName("id")
    private String id;

    @SerializedName("payout_id")
    private String payoutId;

    @SerializedName("asset_id")
    private String assetId;

    @SerializedName("amount")
    private AssetAmount amount;

    @SerializedName("network_fee")
    private AssetAmount networkFee;

    @SerializedName("status")
    private String status;

    @SerializedName("address")
    private String address;

    @SerializedName("type")
    private String type;

    @SerializedName("description")
    private String description;

    @SerializedName("original_frozen_tx_id")
    private String originalFrozenTxId;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    public UnfreezeWithdraw() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public AssetAmount getAmount() {
        return amount;
    }

    public void setAmount(AssetAmount amount) {
        this.amount = amount;
    }

    public AssetAmount getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(AssetAmount networkFee) {
        this.networkFee = networkFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginalFrozenTxId() {
        return originalFrozenTxId;
    }

    public void setOriginalFrozenTxId(String originalFrozenTxId) {
        this.originalFrozenTxId = originalFrozenTxId;
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
}
