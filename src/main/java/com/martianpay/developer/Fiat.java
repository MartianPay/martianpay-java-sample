package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Fiat represents fiat currency payment options
 */
public class Fiat {
    /**
     * Amount is the amount to be paid in fiat currency
     */
    @SerializedName("amount")
    private String amount;

    /**
     * AssetId is the unique identifier for the fiat currency asset
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * Currency is the ISO 4217 currency code (e.g., "USD", "EUR")
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Decimals is the number of decimal places for this currency
     */
    @SerializedName("decimals")
    private Integer decimals;

    /**
     * ExchangeRate is the exchange rate applied for currency conversion
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    public Fiat() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public String getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(String exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
