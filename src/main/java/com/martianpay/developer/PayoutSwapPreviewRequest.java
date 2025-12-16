package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to preview an asset swap for payout.
 */
public class PayoutSwapPreviewRequest {
    /**
     * Source asset/cryptocurrency ID to swap from.
     */
    @SerializedName("from_asset_id")
    private String fromAssetId;

    /**
     * Amount of source asset to swap.
     */
    @SerializedName("from_amount")
    private String fromAmount;

    /**
     * Quote ID from a previous swap quote.
     */
    @SerializedName("quote_id")
    private String quoteId;

    /**
     * Target asset/cryptocurrency ID to swap to.
     */
    @SerializedName("to_asset_id")
    private String toAssetId;

    /**
     * Desired amount of target asset to receive.
     */
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
