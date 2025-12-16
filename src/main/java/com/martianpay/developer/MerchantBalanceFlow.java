package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * MerchantBalanceFlow represents a single balance change record for a merchant account.
 *
 * Balance flows track all movements of funds in a merchant's account, providing a complete
 * audit trail of every transaction that affects the merchant's balance. Each flow record
 * captures the before and after states of all balance categories, enabling precise
 * reconciliation and financial reporting.
 *
 * Balance categories:
 * - Available: Funds ready for immediate payout or withdrawal
 * - Pending: Funds that are being processed (awaiting confirmation, settlement, etc.)
 * - Locked: Funds temporarily held (dispute, investigation, rolling reserve, etc.)
 * - Frozen: Funds frozen due to AML concerns or policy violations
 *
 * Flow types:
 * - "in": Money flowing into the merchant account (payments received)
 * - "out": Money flowing out of the merchant account (payouts, refunds, fees)
 *
 * Business types:
 * - "charge": Customer payment received
 * - "refund": Refund issued to customer
 * - "payout": Merchant withdrawal to bank/wallet
 * - "fee": Platform or processing fee charged
 * - "adjustment": Manual balance adjustment
 * - "chargeback": Disputed transaction reversal
 * - "freeze": Funds frozen by compliance
 * - "unfreeze": Previously frozen funds released
 *
 * Use cases:
 * - Complete transaction history and audit trail
 * - Balance reconciliation and accounting
 * - Financial reporting and analytics
 * - Dispute and chargeback tracking
 * - Compliance and regulatory reporting
 * - Understanding balance state changes over time
 *
 * Balance state tracking:
 * Each flow record captures the complete balance state before and after the transaction,
 * allowing you to:
 * - Verify balance integrity at any point in time
 * - Trace how a specific transaction affected each balance category
 * - Detect and investigate balance discrepancies
 * - Reconstruct historical balance states
 * - Generate accurate financial statements
 *
 * Example scenarios:
 * 1. Customer payment: flow_type="in", business_type="charge", increases available balance
 * 2. Merchant payout: flow_type="out", business_type="payout", decreases available balance
 * 3. Refund to customer: flow_type="out", business_type="refund", decreases available balance
 * 4. Funds frozen: flow_type="out" from available, "in" to frozen
 * 5. Chargeback: flow_type="out", business_type="chargeback", may affect multiple categories
 */
public class MerchantBalanceFlow {
    /**
     * Unix timestamp (in seconds) when this balance flow record was created.
     * Represents the exact moment the balance change occurred.
     * Used for chronological ordering and time-based analysis.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * ID of the merchant whose balance was affected.
     * Links this flow record to a specific merchant account.
     * Format: merch_[random_id] or similar prefix
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * Currency of the balance change.
     * Can be fiat currency (USD) or cryptocurrency (BTC, ETH, USDT, etc.).
     *
     * Examples:
     * - Fiat: "USD" (Currently only USD is supported for fiat)
     * - Crypto: "BTC", "ETH", "USDT", "USDC"
     *
     * Balance flows are tracked separately for each currency.
     * Merchants have independent balance states per currency.
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Type of business operation that caused this balance change.
     *
     * Common values:
     * - "charge": Customer payment received (flow_type="in")
     * - "refund": Refund issued to customer (flow_type="out")
     * - "payout": Merchant withdrawal to bank or wallet (flow_type="out")
     * - "fee": Platform or processing fee charged (flow_type="out")
     * - "adjustment": Manual balance adjustment by admin
     * - "chargeback": Disputed transaction reversal (flow_type="out")
     * - "freeze": Funds moved to frozen status
     * - "unfreeze": Previously frozen funds released
     * - "settlement": Batch settlement of pending funds
     *
     * Used to categorize and analyze different types of balance movements.
     */
    @SerializedName("business_type")
    private String businessType;

    /**
     * Direction of the balance flow.
     *
     * Values:
     * - "in": Money flowing into the merchant account (credit)
     * - "out": Money flowing out of the merchant account (debit)
     *
     * Combined with business_type provides complete context:
     * - "in" + "charge": Payment received from customer
     * - "out" + "refund": Refund sent to customer
     * - "out" + "payout": Withdrawal to merchant's bank/wallet
     * - "out" + "fee": Fee charged by platform
     */
    @SerializedName("flow_type")
    private String flowType;

    /**
     * ID of the transaction that caused this balance change.
     * Links to the original business object (charge, refund, payout, etc.).
     *
     * Format depends on business_type:
     * - charge_[id] for charges
     * - refund_[id] for refunds
     * - payout_[id] for payouts
     * - adj_[id] for adjustments
     *
     * Use this ID to retrieve full details of the related transaction.
     * Essential for reconciliation and dispute investigation.
     */
    @SerializedName("related_id")
    private String relatedId;

    /**
     * Available balance before this transaction.
     * Funds that were ready for immediate payout or withdrawal.
     * Represented as BigDecimal to maintain precision for financial calculations.
     */
    @SerializedName("before_available_balance")
    private BigDecimal beforeAvailableBalance;

    /**
     * Pending balance before this transaction.
     * Funds that were in processing state (awaiting confirmation, settlement).
     * These funds are not yet available for payout but are expected to be released.
     */
    @SerializedName("before_pending_balance")
    private BigDecimal beforePendingBalance;

    /**
     * Locked balance before this transaction.
     * Funds that were temporarily held for disputes, investigations, or rolling reserves.
     * These funds are restricted from payout until the lock is released.
     */
    @SerializedName("before_locked_balance")
    private BigDecimal beforeLockedBalance;

    /**
     * Frozen balance before this transaction.
     * Funds that were frozen due to AML concerns, policy violations, or legal holds.
     * These funds cannot be accessed until compliance issues are resolved.
     */
    @SerializedName("before_frozen_balance")
    private BigDecimal beforeFrozenBalance;

    /**
     * Available balance after this transaction.
     * Compare with before_available_balance to calculate the change.
     * Example: after - before = +100.00 means 100 added to available balance.
     */
    @SerializedName("after_available_balance")
    private BigDecimal afterAvailableBalance;

    /**
     * Pending balance after this transaction.
     * Compare with before_pending_balance to see how pending funds changed.
     * Pending funds typically move to available once confirmed/settled.
     */
    @SerializedName("after_pending_balance")
    private BigDecimal afterPendingBalance;

    /**
     * Locked balance after this transaction.
     * Compare with before_locked_balance to track locked fund changes.
     * Funds may be locked due to disputes or automatically released after resolution.
     */
    @SerializedName("after_locked_balance")
    private BigDecimal afterLockedBalance;

    /**
     * Frozen balance after this transaction.
     * Compare with before_frozen_balance to track frozen fund changes.
     * Funds remain frozen until compliance reviews are completed.
     */
    @SerializedName("after_frozen_balance")
    private BigDecimal afterFrozenBalance;

    /**
     * Additional notes or description for this balance flow.
     * Provides human-readable context about the transaction.
     *
     * May include:
     * - Reason for adjustment or fee
     * - Related order or invoice information
     * - Administrative notes
     * - Compliance case references
     * - Custom merchant identifiers
     *
     * Useful for:
     * - Understanding unusual transactions
     * - Internal record keeping
     * - Customer service inquiries
     * - Audit trail documentation
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
