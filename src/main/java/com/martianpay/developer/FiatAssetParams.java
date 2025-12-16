package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Configuration parameters for fiat currency assets.
 * Currently only USD is supported.
 */
public class FiatAssetParams {
    /**
     * Currency symbol (e.g., "USD"). Currently only USD is supported.
     */
    @SerializedName("symbol")
    private String symbol;

    /**
     * Payment provider for this fiat currency (e.g., "stripe", "bank_transfer").
     */
    @SerializedName("provider")
    private String provider;

    /**
     * Creates a new FiatAssetParams instance.
     */
    public FiatAssetParams() {
    }

    /**
     * Gets the currency symbol for this fiat asset.
     * @return The currency symbol (e.g., "USD")
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the currency symbol for this fiat asset.
     * @param symbol The currency symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the payment provider for this fiat currency.
     * @return The provider identifier
     */
    public String getProvider() {
        return provider;
    }

    /**
     * Sets the payment provider for this fiat currency.
     * @param provider The provider identifier
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }
}
