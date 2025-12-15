package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayoutSwapPreviewRequest {
    @SerializedName("from_asset_id")
    private String fromAssetId;

    @SerializedName("from_amount")
    private String fromAmount;

    @SerializedName("quote_id")
    private String quoteId;

    @SerializedName("to_asset_id")
    private String toAssetId;

    @SerializedName("to_amount")
    private String toAmount;

    public PayoutSwapPreviewRequest() {
    }

    public String getFromAssetId() {
        return fromAssetId;
    }

    public void setFromAssetId(String fromAssetId) {
        this.fromAssetId = fromAssetId;
    }

    public String getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(String fromAmount) {
        this.fromAmount = fromAmount;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public String getToAssetId() {
        return toAssetId;
    }

    public void setToAssetId(String toAssetId) {
        this.toAssetId = toAssetId;
    }

    public String getToAmount() {
        return toAmount;
    }

    public void setToAmount(String toAmount) {
        this.toAmount = toAmount;
    }
}
