package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Transaction represents a blockchain transaction
 */
public class Transaction {
    /**
     * SourceAddress is the address sending the funds
     */
    @SerializedName("source_address")
    private String sourceAddress;

    /**
     * DestinationAddress is the address receiving the funds
     */
    @SerializedName("destination_address")
    private String destinationAddress;

    /**
     * TxHash is the transaction hash on the blockchain
     */
    @SerializedName("tx_hash")
    private String txHash;

    /**
     * Amount is the transaction amount
     */
    @SerializedName("amount")
    private String amount;

    /**
     * AssetId is the unique identifier of the asset (maps to token symbol and network)
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * Type indicates the transaction type (0: deposit, 1: refund)
     */
    @SerializedName("type")
    private Integer type;

    /**
     * CreatedAt is the Unix timestamp when the transaction was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Status is the transaction status ("submitted", "failed", "completed", "confirmed")
     * Transaction is successful when status is "confirmed" and AmlStatus is "approved"
     */
    @SerializedName("status")
    private String status;

    /**
     * AmlStatus is the AML screening status ('', 'approved', 'rejected')
     */
    @SerializedName("aml_status")
    private String amlStatus;

    /**
     * AmlInfo contains detailed AML screening information
     */
    @SerializedName("aml_info")
    private AmlInfo amlInfo;

    /**
     * ChargeId is the unique identifier of the associated charge
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * RefundId is the unique identifier of the associated refund (only valid when Type==1)
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * FeeInfo contains detailed fee information for the transaction
     */
    @SerializedName("fee_info")
    private FeeInfo feeInfo;

    /**
     * FeeCurrency is the asset used to pay the transaction fee (e.g., ETH for ERC-20 tokens)
     */
    @SerializedName("fee_currency")
    private String feeCurrency;

    public Transaction() {
    }

    // Getters and Setters
    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAmlStatus() {
        return amlStatus;
    }

    public void setAmlStatus(String amlStatus) {
        this.amlStatus = amlStatus;
    }

    public AmlInfo getAmlInfo() {
        return amlInfo;
    }

    public void setAmlInfo(AmlInfo amlInfo) {
        this.amlInfo = amlInfo;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public FeeInfo getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(FeeInfo feeInfo) {
        this.feeInfo = feeInfo;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }
}
