package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * PayoutParams contains parameters for creating a payout
 */
public class PayoutParams {
    /**
     * SourceCoin is the source coin for the swap
     */
    @SerializedName("source_coin")
    private String sourceCoin;

    /**
     * SourceAmount is the source amount for the swap
     */
    @SerializedName("source_amount")
    private String sourceAmount;

    /**
     * QuoteIds is the list of quote IDs for the swap
     */
    @SerializedName("quote_ids")
    private List<String> quoteIds;

    /**
     * DestinationAssetId is the asset ID of the destination currency
     */
    @SerializedName("receive_asset_id")
    private String destinationAssetId;

    /**
     * DestinationAmount is the amount to be received
     */
    @SerializedName("receive_amount")
    private String destinationAmount;

    /**
     * DestinationAccountType is the type of the destination account (bank or wallet)
     */
    @SerializedName("receive_account_type")
    private String destinationAccountType;

    /**
     * DestinationAccountId is the ID of the destination account
     */
    @SerializedName("receive_account_id")
    private String destinationAccountId;

    /**
     * DestinationAddress is the optional address for receiving funds
     */
    @SerializedName("receive_address")
    private String destinationAddress;

    /**
     * ToMerchantId is the destination merchant ID for internal transfers
     */
    @SerializedName("to_merchant_id")
    private String toMerchantId;

    /**
     * InternalNote contains internal notes for record keeping
     */
    @SerializedName("internal_note")
    private String internalNote;

    /**
     * StatementDescriptor is the description that appears on the statement
     */
    @SerializedName("statement_descriptor")
    private String statementDescriptor;

    /**
     * ExternalId is the external reference ID
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Metadata contains additional metadata as key-value pairs
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
