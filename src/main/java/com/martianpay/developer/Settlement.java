package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Settlement represents a settlement transaction for processing payments and refunds.
 *
 * A settlement is the process of transferring funds from a payment transaction to a merchant's
 * account after deducting fees, taxes, and handling currency conversions. This class tracks
 * the complete lifecycle of funds from the original transaction through to final settlement.
 *
 * Key features:
 * - Currency conversion tracking with exchange rates
 * - Blockchain transaction details including gas fees
 * - Fee breakdown (transaction fees, tax fees, gas fees)
 * - Frozen amount handling for AML/risk management
 * - Net amount calculation after all deductions
 *
 * Use cases:
 * - Tracking payment settlements for merchant payouts
 * - Processing refund settlements
 * - Calculating net amounts after fees and conversions
 * - Auditing blockchain transactions and associated costs
 * - Managing frozen funds due to compliance checks
 *
 * Example flow:
 * 1. Customer pays $100 USDT for a product
 * 2. System converts to merchant's settlement currency (e.g., $95 after conversion)
 * 3. Deducts transaction fee ($2), tax ($3), gas fee ($0.50)
 * 4. Net settlement to merchant: $89.50
 * 5. Tracks blockchain transaction hash for transparency
 */
public class Settlement {
    /**
     * Object type identifier constant for settlement objects.
     * Always set to "statement" to identify this as a settlement statement.
     */
    public static final String SETTLEMENT_OBJECT = "statement";

    /**
     * Unique identifier for this settlement transaction.
     * Format: settlement_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Object type identifier, always set to "statement" for settlements.
     * Used for type checking and API response parsing.
     */
    @SerializedName("object")
    private String object;

    /**
     * Type of settlement transaction.
     * Values: "charge" (payment settlement), "refund" (refund settlement).
     * Determines the direction and nature of fund flow.
     */
    @SerializedName("type")
    private String type;

    /**
     * ID of the payment intent associated with this settlement.
     * Links the settlement back to the original payment request.
     * Format: pi_[random_id]
     */
    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    /**
     * Original transaction amount before any currency conversion.
     * Stored as string to preserve precision for financial calculations.
     * Example: "100.50" (represents the exact amount the customer paid)
     */
    @SerializedName("original_amount")
    private String originalAmount;

    /**
     * Currency of the original transaction (what the customer paid in).
     * Three-letter ISO 4217 currency code.
     * Example: "USDT", "ETH", "USD"
     */
    @SerializedName("original_currency")
    private String originalCurrency;

    /**
     * Amount after conversion to the settlement currency.
     * This is the amount in the merchant's preferred currency after exchange.
     * Stored as string to maintain precision.
     */
    @SerializedName("settlement_amount")
    private String settlementAmount;

    /**
     * Currency used for final settlement to the merchant.
     * The merchant's preferred or configured settlement currency.
     * Example: "USD" (Currently only USD is supported for fiat), "USDT"
     */
    @SerializedName("settlement_currency")
    private String settlementCurrency;

    /**
     * Exchange rate applied when converting from original to settlement currency.
     * Formula: settlement_amount = original_amount * exchange_rate
     * Stored as string to preserve precise rate information.
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    /**
     * ID of the charge associated with this settlement (for charge-type settlements).
     * Null for refund settlements. Links to the charge object.
     * Format: ch_[random_id]
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * ID of the refund associated with this settlement (for refund-type settlements).
     * Null for charge settlements. Links to the refund object.
     * Format: re_[random_id]
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * Amount frozen due to AML (Anti-Money Laundering) or risk management checks.
     * This amount is held and not included in the net settlement until cleared.
     * Stored as string for precision.
     */
    @SerializedName("frozen_amount")
    private String frozenAmount;

    /**
     * Blockchain gas fee paid for processing the on-chain transaction.
     * Covers the cost of executing the transaction on the blockchain network.
     * Deducted from the settlement amount.
     */
    @SerializedName("gas_fee")
    private String gasFee;

    /**
     * Currency in which the gas fee was paid.
     * Often the native blockchain token (e.g., "ETH" for Ethereum).
     */
    @SerializedName("gas_fee_currency")
    private String gasFeeCurrency;

    /**
     * Exchange rate for converting gas fee to settlement currency.
     * Used to calculate the gas fee impact on net settlement amount.
     */
    @SerializedName("gas_fee_exchange_rate")
    private String gasFeeExchangeRate;

    /**
     * Transaction processing fee charged by the payment platform.
     * Platform's service fee for facilitating the payment.
     * Deducted from the settlement amount before payout.
     */
    @SerializedName("tx_fee")
    private String txFee;

    /**
     * Tax amount charged on the transaction.
     * Applicable taxes (VAT, sales tax, etc.) based on jurisdiction.
     * Deducted from the settlement amount.
     */
    @SerializedName("tax_fee")
    private String taxFee;

    /**
     * Net settlement amount after all fees and deductions.
     * Formula: settlement_amount - frozen_amount - gas_fee - tx_fee - tax_fee
     * This is the final amount the merchant receives.
     */
    @SerializedName("net_amount")
    private String netAmount;

    /**
     * Current status of the settlement.
     * Example values: "pending", "completed", "failed", "frozen"
     * Indicates the settlement processing state.
     */
    @SerializedName("status")
    private String status;

    /**
     * List of blockchain transaction hashes for this settlement.
     * Provides on-chain verification and traceability.
     * Can have multiple hashes for complex multi-step settlements.
     */
    @SerializedName("tx_hashes")
    private List<String> txHashes;

    /**
     * Customer identifier associated with this settlement.
     * Links the settlement to the customer who made the payment.
     * Format: cus_[random_id]
     */
    @SerializedName("customer")
    private String customer;

    /**
     * Unix timestamp (in seconds) when the transaction occurred.
     * Records the exact time the settlement was processed.
     */
    @SerializedName("tx_time")
    private Long txTime;

    public Settlement() {
    }

    /**
     * Gets the unique identifier for this settlement.
     * @return The settlement ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this settlement.
     * @param id The settlement ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type identifier.
     * @return The object type (always "statement")
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type identifier.
     * @param object The object type (should be "statement")
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the type of settlement transaction.
     * @return The settlement type (charge or refund)
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of settlement transaction.
     * @param type The settlement type (charge or refund)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the payment intent ID.
     * @return The payment intent ID
     */
    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    /**
     * Sets the payment intent ID.
     * @param paymentIntentId The payment intent ID
     */
    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    /**
     * Gets the original transaction amount.
     * @return The original amount as a string
     */
    public String getOriginalAmount() {
        return originalAmount;
    }

    /**
     * Sets the original transaction amount.
     * @param originalAmount The original amount as a string
     */
    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    /**
     * Gets the original transaction currency.
     * @return The original currency code
     */
    public String getOriginalCurrency() {
        return originalCurrency;
    }

    /**
     * Sets the original transaction currency.
     * @param originalCurrency The original currency code
     */
    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    /**
     * Gets the settlement amount after conversion.
     * @return The settlement amount as a string
     */
    public String getSettlementAmount() {
        return settlementAmount;
    }

    /**
     * Sets the settlement amount after conversion.
     * @param settlementAmount The settlement amount as a string
     */
    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    /**
     * Gets the settlement currency.
     * @return The settlement currency code
     */
    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    /**
     * Sets the settlement currency.
     * @param settlementCurrency The settlement currency code
     */
    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    /**
     * Gets the exchange rate used for conversion.
     * @return The exchange rate as a string
     */
    public String getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the exchange rate used for conversion.
     * @param exchangeRate The exchange rate as a string
     */
    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * Gets the charge ID for charge-type settlements.
     * @return The charge ID, or null for refund settlements
     */
    public String getChargeId() {
        return chargeId;
    }

    /**
     * Sets the charge ID for charge-type settlements.
     * @param chargeId The charge ID, or null for refund settlements
     */
    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    /**
     * Gets the refund ID for refund-type settlements.
     * @return The refund ID, or null for charge settlements
     */
    public String getRefundId() {
        return refundId;
    }

    /**
     * Sets the refund ID for refund-type settlements.
     * @param refundId The refund ID, or null for charge settlements
     */
    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    /**
     * Gets the frozen amount held for compliance checks.
     * @return The frozen amount as a string
     */
    public String getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * Sets the frozen amount held for compliance checks.
     * @param frozenAmount The frozen amount as a string
     */
    public void setFrozenAmount(String frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * Gets the blockchain gas fee.
     * @return The gas fee as a string
     */
    public String getGasFee() {
        return gasFee;
    }

    /**
     * Sets the blockchain gas fee.
     * @param gasFee The gas fee as a string
     */
    public void setGasFee(String gasFee) {
        this.gasFee = gasFee;
    }

    /**
     * Gets the currency in which gas fee was paid.
     * @return The gas fee currency code
     */
    public String getGasFeeCurrency() {
        return gasFeeCurrency;
    }

    /**
     * Sets the currency in which gas fee was paid.
     * @param gasFeeCurrency The gas fee currency code
     */
    public void setGasFeeCurrency(String gasFeeCurrency) {
        this.gasFeeCurrency = gasFeeCurrency;
    }

    /**
     * Gets the gas fee exchange rate.
     * @return The gas fee exchange rate as a string
     */
    public String getGasFeeExchangeRate() {
        return gasFeeExchangeRate;
    }

    /**
     * Sets the gas fee exchange rate.
     * @param gasFeeExchangeRate The gas fee exchange rate as a string
     */
    public void setGasFeeExchangeRate(String gasFeeExchangeRate) {
        this.gasFeeExchangeRate = gasFeeExchangeRate;
    }

    /**
     * Gets the transaction processing fee.
     * @return The transaction fee as a string
     */
    public String getTxFee() {
        return txFee;
    }

    /**
     * Sets the transaction processing fee.
     * @param txFee The transaction fee as a string
     */
    public void setTxFee(String txFee) {
        this.txFee = txFee;
    }

    /**
     * Gets the tax amount.
     * @return The tax fee as a string
     */
    public String getTaxFee() {
        return taxFee;
    }

    /**
     * Sets the tax amount.
     * @param taxFee The tax fee as a string
     */
    public void setTaxFee(String taxFee) {
        this.taxFee = taxFee;
    }

    /**
     * Gets the net settlement amount after all deductions.
     * @return The net amount as a string
     */
    public String getNetAmount() {
        return netAmount;
    }

    /**
     * Sets the net settlement amount after all deductions.
     * @param netAmount The net amount as a string
     */
    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    /**
     * Gets the current settlement status.
     * @return The settlement status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current settlement status.
     * @param status The settlement status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the list of blockchain transaction hashes.
     * @return List of transaction hashes
     */
    public List<String> getTxHashes() {
        return txHashes;
    }

    /**
     * Sets the list of blockchain transaction hashes.
     * @param txHashes List of transaction hashes
     */
    public void setTxHashes(List<String> txHashes) {
        this.txHashes = txHashes;
    }

    /**
     * Gets the customer identifier.
     * @return The customer ID
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Sets the customer identifier.
     * @param customer The customer ID
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * Gets the transaction timestamp.
     * @return Unix timestamp in seconds
     */
    public Long getTxTime() {
        return txTime;
    }

    /**
     * Sets the transaction timestamp.
     * @param txTime Unix timestamp in seconds
     */
    public void setTxTime(Long txTime) {
        this.txTime = txTime;
    }
}
