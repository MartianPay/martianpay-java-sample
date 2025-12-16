package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/**
 * SettlementAbstractInfo provides a summary of settlement financial information.
 *
 * This class encapsulates the key financial details of a settlement transaction,
 * including amounts, fees, exchange rates, and any warnings or discrepancies.
 * It's used to give a quick overview of the settlement's financial status without
 * needing all the detailed transaction information.
 *
 * Use cases:
 * - Displaying settlement summaries in dashboards
 * - Calculating net amounts quickly without full settlement details
 * - Comparing expected vs actual settlement amounts
 * - Identifying settlements with warnings or discrepancies
 * - Auditing fee structures and currency conversions
 *
 * Example scenario:
 * A merchant receives a payment of 100 USDC:
 * - Amount: 100 USDC
 * - Tx Fee: 2 USDC
 * - Tax Fee: 3 USDC
 * - Gas Fee: 0.5 USDC
 * - Net Amount: 94.5 USDC
 * - Exchange rate to USD: 0.998
 * - Expected vs actual check for reconciliation
 */
public class SettlementAbstractInfo {
    /**
     * Unix timestamp (in seconds) when this settlement was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Currency code for the settlement amounts.
     * Three-letter ISO 4217 code (e.g., "USD", "USDT", "ETH").
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Total settlement amount before any deductions.
     * The gross amount that will be processed for settlement.
     */
    @SerializedName("amount")
    private BigDecimal amount;

    /**
     * Amount that has been frozen due to AML or risk checks.
     * This amount is held back from settlement until compliance review completes.
     */
    @SerializedName("frozen_amount")
    private BigDecimal frozenAmount;

    /**
     * Transaction processing fee charged by the platform.
     * Deducted from the settlement amount.
     */
    @SerializedName("tx_fee")
    private BigDecimal txFee;

    /**
     * Tax amount applicable to the transaction.
     * Includes VAT, sales tax, or other applicable taxes based on jurisdiction.
     */
    @SerializedName("tax_fee")
    private BigDecimal taxFee;

    /**
     * Net amount after all fees and deductions.
     * Formula: amount - frozen_amount - tx_fee - tax_fee - gas_amount
     * This is the final amount the merchant receives.
     */
    @SerializedName("net_amount")
    private BigDecimal netAmount;

    /**
     * Currency code for the blockchain gas fee.
     * Often the native token of the blockchain (e.g., "ETH" for Ethereum).
     */
    @SerializedName("gas_currency")
    private String gasCurrency;

    /**
     * Amount of gas fee paid for the blockchain transaction.
     * The cost to execute the transaction on the blockchain network.
     */
    @SerializedName("gas_amount")
    private BigDecimal gasAmount;

    /**
     * Exchange rate from gas currency to USD.
     * Used to calculate the USD equivalent of gas fees for reporting.
     */
    @SerializedName("gas_exchange_to_usd")
    private BigDecimal gasExchangeToUsd;

    /**
     * Exchange rate from the settlement currency to Pi Network currency.
     * Null if Pi conversion is not applicable for this settlement.
     */
    @SerializedName("exchange_rate_to_pi")
    private BigDecimal exchangeRateToPi;

    /**
     * Exchange rate from the settlement currency to USD.
     * Used for standardized reporting and accounting in USD.
     */
    @SerializedName("exchange_rate_to_usd")
    private BigDecimal exchangeRateToUsd;

    /**
     * Expected settlement amount based on the original transaction.
     * Used for reconciliation to detect discrepancies between expected and actual amounts.
     */
    @SerializedName("expected_amount")
    private BigDecimal expectedAmount;

    /**
     * Warning messages or notes about the settlement.
     * May include information about discrepancies, delayed processing,
     * compliance holds, or other issues requiring attention.
     * Null or empty if no warnings exist.
     */
    @SerializedName("settle_warnings")
    private String settleWarnings;

    public SettlementAbstractInfo() {
    }

    /**
     * Gets the creation timestamp.
     * @return Unix timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * @param createdAt Unix timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the settlement currency code.
     * @return The currency code
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the settlement currency code.
     * @param currency The currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the gross settlement amount.
     * @return The amount before deductions
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the gross settlement amount.
     * @param amount The amount before deductions
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets the frozen amount.
     * @return The amount held for compliance checks
     */
    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * Sets the frozen amount.
     * @param frozenAmount The amount held for compliance checks
     */
    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * Gets the transaction processing fee.
     * @return The transaction fee
     */
    public BigDecimal getTxFee() {
        return txFee;
    }

    /**
     * Sets the transaction processing fee.
     * @param txFee The transaction fee
     */
    public void setTxFee(BigDecimal txFee) {
        this.txFee = txFee;
    }

    /**
     * Gets the tax amount.
     * @return The tax fee
     */
    public BigDecimal getTaxFee() {
        return taxFee;
    }

    /**
     * Sets the tax amount.
     * @param taxFee The tax fee
     */
    public void setTaxFee(BigDecimal taxFee) {
        this.taxFee = taxFee;
    }

    /**
     * Gets the net settlement amount after all deductions.
     * @return The net amount
     */
    public BigDecimal getNetAmount() {
        return netAmount;
    }

    /**
     * Sets the net settlement amount after all deductions.
     * @param netAmount The net amount
     */
    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    /**
     * Gets the gas currency code.
     * @return The gas currency code
     */
    public String getGasCurrency() {
        return gasCurrency;
    }

    /**
     * Sets the gas currency code.
     * @param gasCurrency The gas currency code
     */
    public void setGasCurrency(String gasCurrency) {
        this.gasCurrency = gasCurrency;
    }

    /**
     * Gets the gas fee amount.
     * @return The gas amount
     */
    public BigDecimal getGasAmount() {
        return gasAmount;
    }

    /**
     * Sets the gas fee amount.
     * @param gasAmount The gas amount
     */
    public void setGasAmount(BigDecimal gasAmount) {
        this.gasAmount = gasAmount;
    }

    /**
     * Gets the gas to USD exchange rate.
     * @return The exchange rate
     */
    public BigDecimal getGasExchangeToUsd() {
        return gasExchangeToUsd;
    }

    /**
     * Sets the gas to USD exchange rate.
     * @param gasExchangeToUsd The exchange rate
     */
    public void setGasExchangeToUsd(BigDecimal gasExchangeToUsd) {
        this.gasExchangeToUsd = gasExchangeToUsd;
    }

    /**
     * Gets the exchange rate to Pi currency.
     * @return The exchange rate to Pi, or null if not applicable
     */
    public BigDecimal getExchangeRateToPi() {
        return exchangeRateToPi;
    }

    /**
     * Sets the exchange rate to Pi currency.
     * @param exchangeRateToPi The exchange rate to Pi, or null if not applicable
     */
    public void setExchangeRateToPi(BigDecimal exchangeRateToPi) {
        this.exchangeRateToPi = exchangeRateToPi;
    }

    /**
     * Gets the exchange rate to USD.
     * @return The exchange rate to USD
     */
    public BigDecimal getExchangeRateToUsd() {
        return exchangeRateToUsd;
    }

    /**
     * Sets the exchange rate to USD.
     * @param exchangeRateToUsd The exchange rate to USD
     */
    public void setExchangeRateToUsd(BigDecimal exchangeRateToUsd) {
        this.exchangeRateToUsd = exchangeRateToUsd;
    }

    /**
     * Gets the expected settlement amount.
     * @return The expected amount for reconciliation
     */
    public BigDecimal getExpectedAmount() {
        return expectedAmount;
    }

    /**
     * Sets the expected settlement amount.
     * @param expectedAmount The expected amount for reconciliation
     */
    public void setExpectedAmount(BigDecimal expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    /**
     * Gets settlement warnings or notes.
     * @return Warning messages, or null if none
     */
    public String getSettleWarnings() {
        return settleWarnings;
    }

    /**
     * Sets settlement warnings or notes.
     * @param settleWarnings Warning messages, or null if none
     */
    public void setSettleWarnings(String settleWarnings) {
        this.settleWarnings = settleWarnings;
    }
}
