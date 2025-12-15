package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class SettlementAbstractInfo {
    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("currency")
    private String currency;

    @SerializedName("amount")
    private BigDecimal amount;

    @SerializedName("frozen_amount")
    private BigDecimal frozenAmount;

    @SerializedName("tx_fee")
    private BigDecimal txFee;

    @SerializedName("tax_fee")
    private BigDecimal taxFee;

    @SerializedName("net_amount")
    private BigDecimal netAmount;

    @SerializedName("gas_currency")
    private String gasCurrency;

    @SerializedName("gas_amount")
    private BigDecimal gasAmount;

    @SerializedName("gas_exchange_to_usd")
    private BigDecimal gasExchangeToUsd;

    @SerializedName("exchange_rate_to_pi")
    private BigDecimal exchangeRateToPi;

    @SerializedName("exchange_rate_to_usd")
    private BigDecimal exchangeRateToUsd;

    @SerializedName("expected_amount")
    private BigDecimal expectedAmount;

    @SerializedName("settle_warnings")
    private String settleWarnings;

    public SettlementAbstractInfo() {
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public BigDecimal getTxFee() {
        return txFee;
    }

    public void setTxFee(BigDecimal txFee) {
        this.txFee = txFee;
    }

    public BigDecimal getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(BigDecimal taxFee) {
        this.taxFee = taxFee;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public String getGasCurrency() {
        return gasCurrency;
    }

    public void setGasCurrency(String gasCurrency) {
        this.gasCurrency = gasCurrency;
    }

    public BigDecimal getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(BigDecimal gasAmount) {
        this.gasAmount = gasAmount;
    }

    public BigDecimal getGasExchangeToUsd() {
        return gasExchangeToUsd;
    }

    public void setGasExchangeToUsd(BigDecimal gasExchangeToUsd) {
        this.gasExchangeToUsd = gasExchangeToUsd;
    }

    public BigDecimal getExchangeRateToPi() {
        return exchangeRateToPi;
    }

    public void setExchangeRateToPi(BigDecimal exchangeRateToPi) {
        this.exchangeRateToPi = exchangeRateToPi;
    }

    public BigDecimal getExchangeRateToUsd() {
        return exchangeRateToUsd;
    }

    public void setExchangeRateToUsd(BigDecimal exchangeRateToUsd) {
        this.exchangeRateToUsd = exchangeRateToUsd;
    }

    public BigDecimal getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(BigDecimal expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public String getSettleWarnings() {
        return settleWarnings;
    }

    public void setSettleWarnings(String settleWarnings) {
        this.settleWarnings = settleWarnings;
    }
}
