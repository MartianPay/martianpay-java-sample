package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * CreatePayoutRequest creates a new payout
 */
public class CreatePayoutRequest {
    @SerializedName("source_coin")
    private String sourceCoin;

    @SerializedName("source_amount")
    private String sourceAmount;

    @SerializedName("quote_ids")
    private List<String> quoteIds;

    @SerializedName("receive_asset_id")
    private String destinationAssetId;

    @SerializedName("receive_amount")
    private String destinationAmount;

    @SerializedName("receive_account_type")
    private String destinationAccountType;

    @SerializedName("receive_account_id")
    private String destinationAccountId;

    @SerializedName("receive_address")
    private String destinationAddress;

    @SerializedName("to_merchant_id")
    private String toMerchantId;

    @SerializedName("internal_note")
    private String internalNote;

    @SerializedName("statement_descriptor")
    private String statementDescriptor;

    @SerializedName("external_id")
    private String externalId;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    // Getters and Setters
    public String getSourceCoin() { return sourceCoin; }
    public void setSourceCoin(String sourceCoin) { this.sourceCoin = sourceCoin; }

    public String getSourceAmount() { return sourceAmount; }
    public void setSourceAmount(String sourceAmount) { this.sourceAmount = sourceAmount; }

    public List<String> getQuoteIds() { return quoteIds; }
    public void setQuoteIds(List<String> quoteIds) { this.quoteIds = quoteIds; }

    public String getDestinationAssetId() { return destinationAssetId; }
    public void setDestinationAssetId(String destinationAssetId) { this.destinationAssetId = destinationAssetId; }

    public String getDestinationAmount() { return destinationAmount; }
    public void setDestinationAmount(String destinationAmount) { this.destinationAmount = destinationAmount; }

    public String getDestinationAccountType() { return destinationAccountType; }
    public void setDestinationAccountType(String destinationAccountType) { this.destinationAccountType = destinationAccountType; }

    public String getDestinationAccountId() { return destinationAccountId; }
    public void setDestinationAccountId(String destinationAccountId) { this.destinationAccountId = destinationAccountId; }

    public String getDestinationAddress() { return destinationAddress; }
    public void setDestinationAddress(String destinationAddress) { this.destinationAddress = destinationAddress; }

    public String getToMerchantId() { return toMerchantId; }
    public void setToMerchantId(String toMerchantId) { this.toMerchantId = toMerchantId; }

    public String getInternalNote() { return internalNote; }
    public void setInternalNote(String internalNote) { this.internalNote = internalNote; }

    public String getStatementDescriptor() { return statementDescriptor; }
    public void setStatementDescriptor(String statementDescriptor) { this.statementDescriptor = statementDescriptor; }

    public String getExternalId() { return externalId; }
    public void setExternalId(String externalId) { this.externalId = externalId; }

    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }
}
