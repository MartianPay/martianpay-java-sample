package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * TransactionDetails represents detailed information about a blockchain transaction
 */
public class TransactionDetails {
    /**
     * TxId is the unique transaction identifier
     */
    @SerializedName("tx_id")
    private String txId;

    /**
     * SourceAddress is the sender's blockchain address
     */
    @SerializedName("source_address")
    private String sourceAddress;

    /**
     * DestinationAddress is the recipient's blockchain address
     */
    @SerializedName("destination_address")
    private String destinationAddress;

    /**
     * TxHash is the blockchain transaction hash
     */
    @SerializedName("tx_hash")
    private String txHash;

    /**
     * Amount is the transaction amount
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Decimals is the number of decimal places for the asset
     */
    @SerializedName("decimals")
    private Integer decimals;

    /**
     * AssetId is the asset identifier for the token
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * Token is the token name (e.g., USDT, BTC, ETH)
     */
    @SerializedName("token")
    private String token;

    /**
     * Network is the blockchain network type (e.g., TRC20, ERC20)
     */
    @SerializedName("network")
    private String network;

    /**
     * Type is the transaction type (0: deposit, 1: refund)
     */
    @SerializedName("type")
    private String type;

    /**
     * CreatedAt is the Unix timestamp when the transaction was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Status is the current transaction status
     */
    @SerializedName("status")
    private String status;

    /**
     * AmlStatus is the AML check status ('', 'approved', 'rejected')
     */
    @SerializedName("aml_status")
    private String amlStatus;

    /**
     * AmlInfo contains AML check details
     */
    @SerializedName("aml_info")
    private String amlInfo;

    /**
     * ChargeId is the ID of the associated charge
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * RefundId is the ID of the associated refund (only valid for type==1)
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * FeeInfo contains details of the transaction's fee
     */
    @SerializedName("fee_info")
    private String feeInfo;

    /**
     * FeeCurrency is the asset type used to pay the fee (ETH for ERC-20 tokens, BTC for Omni, etc.)
     */
    @SerializedName("fee_currency")
    private String feeCurrency;

    public TransactionDetails() {
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

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

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getAmlInfo() {
        return amlInfo;
    }

    public void setAmlInfo(String amlInfo) {
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

    public String getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(String feeInfo) {
        this.feeInfo = feeInfo;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }
}
