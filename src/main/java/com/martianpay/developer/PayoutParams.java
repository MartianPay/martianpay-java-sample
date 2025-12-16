package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Parameters for creating a payout.
 */
public class PayoutParams {
    /**
     * Source cryptocurrency or currency code (e.g., "USDT", "BTC", "USD"). Currently only USD is supported for fiat.
     */
    @SerializedName("source_coin")
    private String sourceCoin;

    /**
     * Amount to pay out in smallest unit of source currency.
     */
    @SerializedName("source_amount")
    private String sourceAmount;

    /**
     * List of quote IDs for currency conversion swaps.
     */
    @SerializedName("quote_ids")
    private List<String> quoteIds;

    /**
     * Destination currency asset ID (e.g., "usd", "usdt", "btc"). Currently only USD is supported for fiat.
     */
    @SerializedName("receive_asset_id")
    private String destinationAssetId;

    /**
     * Amount to be received in destination currency.
     */
    @SerializedName("receive_amount")
    private String destinationAmount;

    /**
     * Destination account type ("bank", "wallet", or "merchant").
     */
    @SerializedName("receive_account_type")
    private String destinationAccountType;

    /**
     * ID of saved destination account.
     */
    @SerializedName("receive_account_id")
    private String destinationAccountId;

    /**
     * Direct address for receiving funds (alternative to account ID).
     */
    @SerializedName("receive_address")
    private String destinationAddress;

    /**
     * Destination merchant ID for internal platform transfers.
     */
    @SerializedName("to_merchant_id")
    private String toMerchantId;

    /**
     * Internal notes for record keeping (not visible to recipient).
     */
    @SerializedName("internal_note")
    private String internalNote;

    /**
     * Description appearing on recipient's statement.
     */
    @SerializedName("statement_descriptor")
    private String statementDescriptor;

    /**
     * External reference ID from your system.
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Key-value pairs for custom tracking.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    public PayoutParams() {
    }

    public String getSourceCoin() {
        return sourceCoin;
    }

    public void setSourceCoin(String sourceCoin) {
        this.sourceCoin = sourceCoin;
    }

    public String getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(String sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public List<String> getQuoteIds() {
        return quoteIds;
    }

    public void setQuoteIds(List<String> quoteIds) {
        this.quoteIds = quoteIds;
    }

    public String getDestinationAssetId() {
        return destinationAssetId;
    }

    public void setDestinationAssetId(String destinationAssetId) {
        this.destinationAssetId = destinationAssetId;
    }

    public String getDestinationAmount() {
        return destinationAmount;
    }

    public void setDestinationAmount(String destinationAmount) {
        this.destinationAmount = destinationAmount;
    }

    public String getDestinationAccountType() {
        return destinationAccountType;
    }

    public void setDestinationAccountType(String destinationAccountType) {
        this.destinationAccountType = destinationAccountType;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getToMerchantId() {
        return toMerchantId;
    }

    public void setToMerchantId(String toMerchantId) {
        this.toMerchantId = toMerchantId;
    }

    public String getInternalNote() {
        return internalNote;
    }

    public void setInternalNote(String internalNote) {
        this.internalNote = internalNote;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
