package com.martianpay.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Represents a payment intent in the MartianPay system.
 * Payment intents track the lifecycle of a payment from creation to completion.
 */
public class PaymentIntent {
    public static final String OBJECT_TYPE = "payment_intent";

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("amount")
    private AssetAmount amount;

    @SerializedName("payment_details")
    private PaymentDetails paymentDetails;

    @SerializedName("canceled_at")
    private Long canceledAt;

    @SerializedName("cancellation_reason")
    private String cancellationReason;

    @SerializedName("client_secret")
    private String clientSecret;

    @SerializedName("created")
    private Long created;

    @SerializedName("updated")
    private Long updated;

    @SerializedName("currency")
    private String currency;

    @SerializedName("customer")
    private Customer customer;

    @SerializedName("description")
    private String description;

    @SerializedName("livemode")
    private Boolean livemode;

    @SerializedName("metadata")
    private Map<String, Object> metadata;

    @SerializedName("payment_link_details")
    private PaymentLinkDetails paymentLinkDetails;

    @SerializedName("merchant_order_id")
    private String merchantOrderId;

    @SerializedName("charges")
    private List<Charge> charges;

    @SerializedName("receipt_email")
    private String receiptEmail;

    @SerializedName("status")
    private String status;

    @SerializedName("payment_intent_status")
    private PaymentIntentStatus paymentIntentStatus;

    @SerializedName("complete_on_first_payment")
    private Boolean completeOnFirstPayment;

    @SerializedName("permanent_deposit")
    private Boolean permanentDeposit;

    @SerializedName("permanent_deposit_asset_id")
    private String permanentDepositAssetId;

    @SerializedName("expired_at")
    private Long expiredAt;

    @SerializedName("unfreeze_withdraws")
    private List<UnfreezeWithdraw> unfreezeWithdraws;

    @SerializedName("invoice")
    private String invoice;

    @SerializedName("invoice_details")
    private Object invoiceDetails;

    @SerializedName("subscription")
    private String subscription;

    @SerializedName("subscription_details")
    private Object subscriptionDetails;

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

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Long getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Long canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public PaymentLinkDetails getPaymentLinkDetails() {
        return paymentLinkDetails;
    }

    public void setPaymentLinkDetails(PaymentLinkDetails paymentLinkDetails) {
        this.paymentLinkDetails = paymentLinkDetails;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public String getReceiptEmail() {
        return receiptEmail;
    }

    public void setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PaymentIntentStatus getPaymentIntentStatus() {
        return paymentIntentStatus;
    }

    public void setPaymentIntentStatus(PaymentIntentStatus paymentIntentStatus) {
        this.paymentIntentStatus = paymentIntentStatus;
    }

    public Boolean getCompleteOnFirstPayment() {
        return completeOnFirstPayment;
    }

    public void setCompleteOnFirstPayment(Boolean completeOnFirstPayment) {
        this.completeOnFirstPayment = completeOnFirstPayment;
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

    public Long getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Long expiredAt) {
        this.expiredAt = expiredAt;
    }

    public List<UnfreezeWithdraw> getUnfreezeWithdraws() {
        return unfreezeWithdraws;
    }

    public void setUnfreezeWithdraws(List<UnfreezeWithdraw> unfreezeWithdraws) {
        this.unfreezeWithdraws = unfreezeWithdraws;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Object getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(Object invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public Object getSubscriptionDetails() {
        return subscriptionDetails;
    }

    public void setSubscriptionDetails(Object subscriptionDetails) {
        this.subscriptionDetails = subscriptionDetails;
    }

    /**
     * Payment intent status enumeration
     */
    public enum PaymentIntentStatus {
        @SerializedName("Created")
        CREATED,

        @SerializedName("Waiting")
        WAITING,

        @SerializedName("Partially Paid")
        PARTIALLY_PAID,

        @SerializedName("Paid")
        PAID,

        @SerializedName("Completed")
        COMPLETED,

        @SerializedName("Confirmed")
        CONFIRMED,

        @SerializedName("Frozen")
        FROZEN,

        @SerializedName("Unfrozen")
        UNFROZEN,

        @SerializedName("Cancelled")
        CANCELLED
    }

    /**
     * Payment intent cancellation reason enumeration
     */
    public enum CancellationReason {
        @SerializedName("abandoned")
        ABANDONED,

        @SerializedName("automatic")
        AUTOMATIC,

        @SerializedName("duplicate")
        DUPLICATE,

        @SerializedName("failed_invoice")
        FAILED_INVOICE,

        @SerializedName("fraudulent")
        FRAUDULENT,

        @SerializedName("requested_by_customer")
        REQUESTED_BY_CUSTOMER,

        @SerializedName("void_invoice")
        VOID_INVOICE
    }

    /**
     * Payment details containing settlement information and fees
     */
    public static class PaymentDetails {
        @SerializedName("amount_captured")
        private AssetAmount amountCaptured;

        @SerializedName("amount_refunded")
        private AssetAmount amountRefunded;

        @SerializedName("tx_fee")
        private AssetAmount txFee;

        @SerializedName("tax_fee")
        private AssetAmount taxFee;

        @SerializedName("frozen_amount")
        private AssetAmount frozenAmount;

        @SerializedName("net_amount")
        private AssetAmount netAmount;

        @SerializedName("gas_fee")
        private Map<String, AssetAmount> gasFee;

        @SerializedName("network_fee")
        private AssetAmount networkFee;

        public AssetAmount getAmountCaptured() {
            return amountCaptured;
        }

        public void setAmountCaptured(AssetAmount amountCaptured) {
            this.amountCaptured = amountCaptured;
        }

        public AssetAmount getAmountRefunded() {
            return amountRefunded;
        }

        public void setAmountRefunded(AssetAmount amountRefunded) {
            this.amountRefunded = amountRefunded;
        }

        public AssetAmount getTxFee() {
            return txFee;
        }

        public void setTxFee(AssetAmount txFee) {
            this.txFee = txFee;
        }

        public AssetAmount getTaxFee() {
            return taxFee;
        }

        public void setTaxFee(AssetAmount taxFee) {
            this.taxFee = taxFee;
        }

        public AssetAmount getFrozenAmount() {
            return frozenAmount;
        }

        public void setFrozenAmount(AssetAmount frozenAmount) {
            this.frozenAmount = frozenAmount;
        }

        public AssetAmount getNetAmount() {
            return netAmount;
        }

        public void setNetAmount(AssetAmount netAmount) {
            this.netAmount = netAmount;
        }

        public Map<String, AssetAmount> getGasFee() {
            return gasFee;
        }

        public void setGasFee(Map<String, AssetAmount> gasFee) {
            this.gasFee = gasFee;
        }

        public AssetAmount getNetworkFee() {
            return networkFee;
        }

        public void setNetworkFee(AssetAmount networkFee) {
            this.networkFee = networkFee;
        }
    }

    /**
     * Unfreeze withdrawal information
     */
    public static class UnfreezeWithdraw {
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

    /**
     * Payment link details
     */
    public static class PaymentLinkDetails {
        @SerializedName("merchant_id")
        private String merchantId;

        @SerializedName("merchant_name")
        private String merchantName;

        @SerializedName("public_key")
        private String publicKey;

        @SerializedName("payment_link")
        private Object paymentLink;

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getMerchantName() {
            return merchantName;
        }

        public void setMerchantName(String merchantName) {
            this.merchantName = merchantName;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public Object getPaymentLink() {
            return paymentLink;
        }

        public void setPaymentLink(Object paymentLink) {
            this.paymentLink = paymentLink;
        }
    }
}
