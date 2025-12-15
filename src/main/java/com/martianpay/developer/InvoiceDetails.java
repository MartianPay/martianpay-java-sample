package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

public class InvoiceDetails {
    @SerializedName("id")
    private String id;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("subscription_id")
    private String subscriptionId;

    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    @SerializedName("customer_id")
    private String customerId;

    @SerializedName("amount")
    private String amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("status")
    private String status;

    @SerializedName("billing_reason")
    private String billingReason;

    @SerializedName("attempt_count")
    private Integer attemptCount;

    @SerializedName("due_date")
    private Long dueDate;

    @SerializedName("paid_at")
    private Long paidAt;

    @SerializedName("voided_at")
    private Long voidedAt;

    @SerializedName("lines")
    private List<InvoiceLineItemDetails> lines;

    @SerializedName("metadata")
    private Map<String, Object> metadata;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("version")
    private Long version;

    @SerializedName("merchant_name")
    private String merchantName;

    @SerializedName("public_key")
    private String publicKey;

    @SerializedName("customer_email")
    private String customerEmail;

    @SerializedName("customer_name")
    private String customerName;

    @SerializedName("subscription_product_name")
    private String subscriptionProductName;

    @SerializedName("subscription_product_variant")
    private String subscriptionProductVariant;

    public InvoiceDetails() {
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

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBillingReason() {
        return billingReason;
    }

    public void setBillingReason(String billingReason) {
        this.billingReason = billingReason;
    }

    public Integer getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(Integer attemptCount) {
        this.attemptCount = attemptCount;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public Long getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Long paidAt) {
        this.paidAt = paidAt;
    }

    public Long getVoidedAt() {
        return voidedAt;
    }

    public void setVoidedAt(Long voidedAt) {
        this.voidedAt = voidedAt;
    }

    public List<InvoiceLineItemDetails> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLineItemDetails> lines) {
        this.lines = lines;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubscriptionProductName() {
        return subscriptionProductName;
    }

    public void setSubscriptionProductName(String subscriptionProductName) {
        this.subscriptionProductName = subscriptionProductName;
    }

    public String getSubscriptionProductVariant() {
        return subscriptionProductVariant;
    }

    public void setSubscriptionProductVariant(String subscriptionProductVariant) {
        this.subscriptionProductVariant = subscriptionProductVariant;
    }
}
