package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * PaymentDetails contains detailed payment information including amounts and fees
 */
public class PaymentDetails {
    /**
     * AmountCaptured is the amount that has been captured from the customer
     */
    @SerializedName("amount_captured")
    private AssetAmount amountCaptured;

    /**
     * AmountRefunded is the amount that has been refunded to the customer
     */
    @SerializedName("amount_refunded")
    private AssetAmount amountRefunded;

    /**
     * TxFee is the transaction fee charged by the payment processor
     */
    @SerializedName("tx_fee")
    private AssetAmount txFee;

    /**
     * TaxFee is the tax amount charged on the transaction
     */
    @SerializedName("tax_fee")
    private AssetAmount taxFee;

    /**
     * FrozenAmount is the amount frozen due to AML or risk checks
     */
    @SerializedName("frozen_amount")
    private AssetAmount frozenAmount;

    /**
     * NetAmount is the net amount after deducting all fees
     */
    @SerializedName("net_amount")
    private AssetAmount netAmount;

    /**
     * GasFee is the map of gas fees by asset ID for blockchain transactions
     */
    @SerializedName("gas_fee")
    private Map<String, AssetAmount> gasFee;

    /**
     * NetworkFee is the network fee charged for blockchain transactions
     */
    @SerializedName("network_fee")
    private AssetAmount networkFee;

    public PaymentDetails() {
    }

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
