package com.martianpay.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Represents a refund in the MartianPay system.
 * Refunds allow merchants to return funds to customers.
 */
public class Refund {
    public static final String OBJECT_TYPE = "refund";

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("amount")
    private AssetAmount amount;

    @SerializedName("network_fee")
    private AssetAmount networkFee;

    @SerializedName("net_amount")
    private AssetAmount netAmount;

    @SerializedName("created")
    private Long created;

    @SerializedName("description")
    private String description;

    @SerializedName("transactions")
    private List<TransactionDetails> transactions;

    @SerializedName("failure_reason")
    private String failureReason;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    @SerializedName("charge")
    private String charge;

    @SerializedName("payment_intent")
    private String paymentIntent;

    @SerializedName("refund_address")
    private String refundAddress;

    @SerializedName("reason")
    private String reason;

    @SerializedName("status")
    private String status;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
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

    public AssetAmount getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(AssetAmount netAmount) {
        this.netAmount = netAmount;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TransactionDetails> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDetails> transactions) {
        this.transactions = transactions;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getPaymentIntent() {
        return paymentIntent;
    }

    public void setPaymentIntent(String paymentIntent) {
        this.paymentIntent = paymentIntent;
    }

    public String getRefundAddress() {
        return refundAddress;
    }

    public void setRefundAddress(String refundAddress) {
        this.refundAddress = refundAddress;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Transaction details for blockchain transactions
     */
    public static class TransactionDetails {
        @SerializedName("tx_id")
        private String txId;

        @SerializedName("source_address")
        private String sourceAddress;

        @SerializedName("destination_address")
        private String destinationAddress;

        @SerializedName("tx_hash")
        private String txHash;

        @SerializedName("amount")
        private String amount;

        @SerializedName("decimals")
        private Integer decimals;

        @SerializedName("asset_id")
        private String assetId;

        @SerializedName("token")
        private String token;

        @SerializedName("network")
        private String network;

        @SerializedName("type")
        private String type;

        @SerializedName("created_at")
        private Long createdAt;

        @SerializedName("status")
        private String status;

        @SerializedName("aml_status")
        private String amlStatus;

        @SerializedName("aml_info")
        private String amlInfo;

        @SerializedName("charge_id")
        private String chargeId;

        @SerializedName("refund_id")
        private String refundId;

        @SerializedName("fee_info")
        private String feeInfo;

        @SerializedName("fee_currency")
        private String feeCurrency;

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
}
