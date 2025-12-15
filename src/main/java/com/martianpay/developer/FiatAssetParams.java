package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * FiatAssetParams contains parameters for fiat currency assets
 */
public class FiatAssetParams {
    @SerializedName("symbol")
    private String symbol;

    @SerializedName("provider")
    private String provider;

    public FiatAssetParams() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
