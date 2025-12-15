package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Settlement represents a settlement transaction
 */
public class Settlement {
    public static final String SETTLEMENT_OBJECT = "statement";

    /**
     * ID is the unique identifier for the settlement
     */
    @SerializedName("id")
    private String id;

    /**
     * Object is the type identifier, always "statement"
     */
    @SerializedName("object")
    private String object;

    /**
     * Type is the settlement type (e.g., "charge", "refund")
     */
    @SerializedName("type")
    private String type;

    /**
     * PaymentIntentID is the ID of the associated payment intent
     */
    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    /**
     * OriginalAmount is the original transaction amount before conversion
     */
    @SerializedName("original_amount")
    private String originalAmount;

    /**
     * OriginalCurrency is the currency of the original transaction
     */
    @SerializedName("original_currency")
    private String originalCurrency;

    /**
     * SettlementAmount is the amount after currency conversion
     */
    @SerializedName("settlement_amount")
    private String settlementAmount;

    /**
     * SettlementCurrency is the currency used for settlement
     */
    @SerializedName("settlement_currency")
    private String settlementCurrency;

    /**
     * ExchangeRate is the exchange rate applied for currency conversion
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    /**
     * ChargeID is the ID of the associated charge (if applicable)
     */
    @SerializedName("charge_id")
    private String chargeId;

    /**
     * RefundID is the ID of the associated refund (if applicable)
     */
    @SerializedName("refund_id")
    private String refundId;

    /**
     * FrozenAmount is the amount frozen due to AML or risk checks
     */
    @SerializedName("frozen_amount")
    private String frozenAmount;

    /**
     * GasFee is the blockchain gas fee paid for the transaction
     */
    @SerializedName("gas_fee")
    private String gasFee;

    /**
     * GasFeeCurrency is the currency used for gas fee payment
     */
    @SerializedName("gas_fee_currency")
    private String gasFeeCurrency;

    /**
     * GasFeeExchangeRate is the exchange rate for gas fee conversion
     */
    @SerializedName("gas_fee_exchange_rate")
    private String gasFeeExchangeRate;

    /**
     * TxFee is the transaction processing fee
     */
    @SerializedName("tx_fee")
    private String txFee;

    /**
     * TaxFee is the tax amount charged on the transaction
     */
    @SerializedName("tax_fee")
    private String taxFee;

    /**
     * NetAmount is the net settlement amount after all fees and deductions
     */
    @SerializedName("net_amount")
    private String netAmount;

    /**
     * Status is the current status of the settlement
     */
    @SerializedName("status")
    private String status;

    /**
     * TxHashes is the list of blockchain transaction hashes
     */
    @SerializedName("tx_hashes")
    private List<String> txHashes;

    /**
     * Customer is the customer identifier for this settlement
     */
    @SerializedName("customer")
    private String customer;

    /**
     * TxTime is the Unix timestamp of the transaction
     */
    @SerializedName("tx_time")
    private Long txTime;

    public Settlement() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(String settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(String settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
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

    public String getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(String frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getGasFee() {
        return gasFee;
    }

    public void setGasFee(String gasFee) {
        this.gasFee = gasFee;
    }

    public String getGasFeeCurrency() {
        return gasFeeCurrency;
    }

    public void setGasFeeCurrency(String gasFeeCurrency) {
        this.gasFeeCurrency = gasFeeCurrency;
    }

    public String getGasFeeExchangeRate() {
        return gasFeeExchangeRate;
    }

    public void setGasFeeExchangeRate(String gasFeeExchangeRate) {
        this.gasFeeExchangeRate = gasFeeExchangeRate;
    }

    public String getTxFee() {
        return txFee;
    }

    public void setTxFee(String txFee) {
        this.txFee = txFee;
    }

    public String getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(String taxFee) {
        this.taxFee = taxFee;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getTxHashes() {
        return txHashes;
    }

    public void setTxHashes(List<String> txHashes) {
        this.txHashes = txHashes;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getTxTime() {
        return txTime;
    }

    public void setTxTime(Long txTime) {
        this.txTime = txTime;
    }
}
