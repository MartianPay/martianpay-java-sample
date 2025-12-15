package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Refund represents a refund transaction
 */
public class Refund {
    public static final String REFUND_OBJECT = "refund";

    /**
     * ID is the unique identifier for the refund
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type identifier, always "refund"
     */
    @SerializedName("object")
    private String object;

    /**
     * Amount is the amount refunded in the smallest currency unit
     */
    @SerializedName("amount")
    private AssetAmount amount;

    /**
     * NetworkFee is the network fee charged for processing the refund
     */
    @SerializedName("network_fee")
    private AssetAmount networkFee;

    /**
     * NetAmount is the net amount after deducting fees
     */
    @SerializedName("net_amount")
    private AssetAmount netAmount;

    /**
     * Created is the Unix timestamp when the refund was created
     */
    @SerializedName("created")
    private Long created;

    /**
     * Description is the description of the refund
     */
    @SerializedName("description")
    private String description;

    /**
     * Transactions is the list of blockchain transactions associated with the refund
     */
    @SerializedName("transactions")
    private List<TransactionDetails> transactions;

    /**
     * FailureReason is the reason for refund failure if applicable
     */
    @SerializedName("failure_reason")
    private String failureReason;

    /**
     * Metadata is additional metadata attached to the refund
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Charge is the ID of charge that's refunded
     */
    @SerializedName("charge")
    private String charge;

    /**
     * PaymentIntent is the ID of the payment intent
     */
    @SerializedName("payment_intent")
    private String paymentIntent;

    /**
     * RefundAddress is the address where funds are refunded to
     */
    @SerializedName("refund_address")
    private String refundAddress;

    /**
     * Reason is the reason for the refund
     */
    @SerializedName("reason")
    private String reason;

    /**
     * Status is the status of the refund (Pending, Success, Failed, Canceled)
     */
    @SerializedName("status")
    private String status;

    public Refund() {
    }

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
}
