package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Crypto represents cryptocurrency payment options
 */
public class Crypto {
    /**
     * Amount is the amount to be paid in cryptocurrency
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Token is the token symbol (e.g., "USDT", "BTC", "ETH")
     */
    @SerializedName("token")
    private String token;

    /**
     * AssetId is the unique identifier for the cryptocurrency asset
     */
    @SerializedName("asset_id")
    private String assetId;

    /**
     * Network is the blockchain network (e.g., "TRC20", "ERC20")
     */
    @SerializedName("network")
    private String network;

    /**
     * Decimals is the number of decimal places for this asset
     */
    @SerializedName("decimals")
    private Integer decimals;

    /**
     * ExchangeRate is the exchange rate applied for currency conversion
     */
    @SerializedName("exchange_rate")
    private String exchangeRate;

    /**
     * DepositAddress is the blockchain address for receiving cryptocurrency payments
     */
    @SerializedName("deposit_address")
    private String depositAddress;

    public Crypto() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
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

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }
}
