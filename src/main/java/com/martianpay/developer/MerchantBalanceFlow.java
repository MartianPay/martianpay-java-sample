package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * MerchantBalanceFlow represents a balance change record for a merchant
 */
public class MerchantBalanceFlow {
    /**
     * CreatedAt is the Unix timestamp when this balance flow was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * MerchantId is the ID of the merchant
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * Currency is the currency for this balance flow
     */
    @SerializedName("currency")
    private String currency;

    /**
     * BusinessType is the business operation type (e.g., "charge", "refund", "payout")
     */
    @SerializedName("business_type")
    private String businessType;

    /**
     * FlowType is the flow direction ("in" or "out")
     */
    @SerializedName("flow_type")
    private String flowType;

    /**
     * RelatedId is the ID of the related transaction (charge_id, refund_id, etc.)
     */
    @SerializedName("related_id")
    private String relatedId;

    /**
     * BeforeAvailableBalance is the available balance before this transaction
     */
    @SerializedName("before_available_balance")
    private BigDecimal beforeAvailableBalance;

    /**
     * BeforePendingBalance is the pending balance before this transaction
     */
    @SerializedName("before_pending_balance")
    private BigDecimal beforePendingBalance;

    /**
     * BeforeLockedBalance is the locked balance before this transaction
     */
    @SerializedName("before_locked_balance")
    private BigDecimal beforeLockedBalance;

    /**
     * BeforeFrozenBalance is the frozen balance before this transaction
     */
    @SerializedName("before_frozen_balance")
    private BigDecimal beforeFrozenBalance;

    /**
     * AfterAvailableBalance is the available balance after this transaction
     */
    @SerializedName("after_available_balance")
    private BigDecimal afterAvailableBalance;

    /**
     * AfterPendingBalance is the pending balance after this transaction
     */
    @SerializedName("after_pending_balance")
    private BigDecimal afterPendingBalance;

    /**
     * AfterLockedBalance is the locked balance after this transaction
     */
    @SerializedName("after_locked_balance")
    private BigDecimal afterLockedBalance;

    /**
     * AfterFrozenBalance is the frozen balance after this transaction
     */
    @SerializedName("after_frozen_balance")
    private BigDecimal afterFrozenBalance;

    /**
     * Remark contains additional notes or description for this balance flow
     */
    @SerializedName("remark")
    private String remark;

    public MerchantBalanceFlow() {
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType;
    }

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public BigDecimal getBeforeAvailableBalance() {
        return beforeAvailableBalance;
    }

    public void setBeforeAvailableBalance(BigDecimal beforeAvailableBalance) {
        this.beforeAvailableBalance = beforeAvailableBalance;
    }

    public BigDecimal getBeforePendingBalance() {
        return beforePendingBalance;
    }

    public void setBeforePendingBalance(BigDecimal beforePendingBalance) {
        this.beforePendingBalance = beforePendingBalance;
    }

    public BigDecimal getBeforeLockedBalance() {
        return beforeLockedBalance;
    }

    public void setBeforeLockedBalance(BigDecimal beforeLockedBalance) {
        this.beforeLockedBalance = beforeLockedBalance;
    }

    public BigDecimal getBeforeFrozenBalance() {
        return beforeFrozenBalance;
    }

    public void setBeforeFrozenBalance(BigDecimal beforeFrozenBalance) {
        this.beforeFrozenBalance = beforeFrozenBalance;
    }

    public BigDecimal getAfterAvailableBalance() {
        return afterAvailableBalance;
    }

    public void setAfterAvailableBalance(BigDecimal afterAvailableBalance) {
        this.afterAvailableBalance = afterAvailableBalance;
    }

    public BigDecimal getAfterPendingBalance() {
        return afterPendingBalance;
    }

    public void setAfterPendingBalance(BigDecimal afterPendingBalance) {
        this.afterPendingBalance = afterPendingBalance;
    }

    public BigDecimal getAfterLockedBalance() {
        return afterLockedBalance;
    }

    public void setAfterLockedBalance(BigDecimal afterLockedBalance) {
        this.afterLockedBalance = afterLockedBalance;
    }

    public BigDecimal getAfterFrozenBalance() {
        return afterFrozenBalance;
    }

    public void setAfterFrozenBalance(BigDecimal afterFrozenBalance) {
        this.afterFrozenBalance = afterFrozenBalance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
