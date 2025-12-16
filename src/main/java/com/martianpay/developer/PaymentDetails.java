package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Payment settlement information including amounts, fees, and refunds.
 * Net = Captured - Refunded - Tx Fee - Tax Fee - Frozen - Network Fee - Gas Fees.
 */
public class PaymentDetails {
    /** Total amount captured from customer (before deductions). */
    @SerializedName("amount_captured")
    private AssetAmount amountCaptured;

    /** Total amount refunded to customer. */
    @SerializedName("amount_refunded")
    private AssetAmount amountRefunded;

    /** Transaction processing fee. */
    @SerializedName("tx_fee")
    private AssetAmount txFee;

    /** Tax amount collected (sales tax, VAT, GST). */
    @SerializedName("tax_fee")
    private AssetAmount taxFee;

    /** Amount frozen due to AML or compliance review. */
    @SerializedName("frozen_amount")
    private AssetAmount frozenAmount;

    /** Net amount available to merchant after all deductions. */
    @SerializedName("net_amount")
    private AssetAmount netAmount;

    /** Map of gas fees by asset ID for blockchain transactions. */
    @SerializedName("gas_fee")
    private Map<String, AssetAmount> gasFee;

    /** Fixed network fee for blockchain transactions. */
    @SerializedName("network_fee")
    private AssetAmount networkFee;

    public PaymentDetails() {
    }

    // Getters and Setters
    public AssetAmount getAmountCaptured() { return amountCaptured; }
    public void setAmountCaptured(AssetAmount amountCaptured) { this.amountCaptured = amountCaptured; }

    public AssetAmount getAmountRefunded() { return amountRefunded; }
    public void setAmountRefunded(AssetAmount amountRefunded) { this.amountRefunded = amountRefunded; }

    public AssetAmount getTxFee() { return txFee; }
    public void setTxFee(AssetAmount txFee) { this.txFee = txFee; }

    public AssetAmount getTaxFee() { return taxFee; }
    public void setTaxFee(AssetAmount taxFee) { this.taxFee = taxFee; }

    public AssetAmount getFrozenAmount() { return frozenAmount; }
    public void setFrozenAmount(AssetAmount frozenAmount) { this.frozenAmount = frozenAmount; }

    public AssetAmount getNetAmount() { return netAmount; }
    public void setNetAmount(AssetAmount netAmount) { this.netAmount = netAmount; }

    public Map<String, AssetAmount> getGasFee() { return gasFee; }
    public void setGasFee(Map<String, AssetAmount> gasFee) { this.gasFee = gasFee; }

    public AssetAmount getNetworkFee() { return networkFee; }
    public void setNetworkFee(AssetAmount networkFee) { this.networkFee = networkFee; }
}
