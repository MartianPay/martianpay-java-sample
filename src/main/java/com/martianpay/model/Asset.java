package com.martianpay.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a cryptocurrency or fiat asset in the MartianPay system.
 */
public class Asset {
    @SerializedName("id")
    private String id;

    @SerializedName("display_name")
    private String displayName;

    @SerializedName("coin")
    private String coin;

    @SerializedName("is_fiat")
    private Boolean isFiat;

    @SerializedName("decimals")
    private Integer decimals;

    @SerializedName("payable")
    private Boolean payable;

    @SerializedName("network")
    private String network;

    @SerializedName("is_mainnet")
    private Boolean isMainnet;

    @SerializedName("contract_address")
    private String contractAddress;

    @SerializedName("address_url_template")
    private String addressUrlTemplate;

    @SerializedName("tx_url_template")
    private String txUrlTemplate;

    @SerializedName("token")
    private String token;

    @SerializedName("chain_id")
    private Long chainId;

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("provider")
    private String provider;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Boolean getIsFiat() {
        return isFiat;
    }

    public void setIsFiat(Boolean isFiat) {
        this.isFiat = isFiat;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public Boolean getPayable() {
        return payable;
    }

    public void setPayable(Boolean payable) {
        this.payable = payable;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Boolean getIsMainnet() {
        return isMainnet;
    }

    public void setIsMainnet(Boolean isMainnet) {
        this.isMainnet = isMainnet;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getAddressUrlTemplate() {
        return addressUrlTemplate;
    }

    public void setAddressUrlTemplate(String addressUrlTemplate) {
        this.addressUrlTemplate = addressUrlTemplate;
    }

    public String getTxUrlTemplate() {
        return txUrlTemplate;
    }

    public void setTxUrlTemplate(String txUrlTemplate) {
        this.txUrlTemplate = txUrlTemplate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
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

    // Helper methods
    public boolean isFiat() {
        return Boolean.TRUE.equals(isFiat);
    }

    public boolean isPayable() {
        return Boolean.TRUE.equals(payable);
    }

    /**
     * Get crypto asset params (for non-fiat assets)
     */
    public CryptoAssetParams getCryptoAssetParams() {
        if (isFiat()) {
            return null;
        }
        CryptoAssetParams params = new CryptoAssetParams();
        params.network = this.network;
        params.isMainnet = this.isMainnet;
        params.contractAddress = this.contractAddress;
        params.addressUrlTemplate = this.addressUrlTemplate;
        params.txUrlTemplate = this.txUrlTemplate;
        params.token = this.token;
        params.chainId = this.chainId;
        return params;
    }

    /**
     * Crypto asset parameters
     */
    public static class CryptoAssetParams {
        public String network;
        public Boolean isMainnet;
        public String contractAddress;
        public String addressUrlTemplate;
        public String txUrlTemplate;
        public String token;
        public Long chainId;
    }
}
