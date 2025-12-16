package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a cryptocurrency or fiat currency asset.
 * Fiat assets use ISO currency code (e.g., "USD"). Currently only USD is supported.
 * Crypto assets use format {TOKEN}_{NETWORK} (e.g., "USDC_ETH", "BTC_BTC").
 */
public class Asset {
    /** Unique identifier (e.g., "USD" for fiat, "USDC_ETH" for crypto). */
    @SerializedName("id")
    private String id;

    /** Human-readable display name (e.g., "United States Dollar", "Bitcoin"). */
    @SerializedName("display_name")
    private String displayName;

    /** Base currency or token code (e.g., "USD", "USDC", "BTC"). */
    @SerializedName("coin")
    private String coin;

    /** True if fiat currency, false if cryptocurrency. */
    @SerializedName("is_fiat")
    private Boolean isFiat;

    /** Number of decimal places (e.g., 2 for USD, 6 for USDC, 8 for BTC). */
    @SerializedName("decimals")
    private Integer decimals;

    /** True if this asset can be used for payments. */
    @SerializedName("payable")
    private Boolean payable;

    // Cryptocurrency-specific fields (null for fiat)

    /** Blockchain network name (e.g., "Ethereum", "Polygon", "Bitcoin"). */
    @SerializedName("network")
    private String network;

    /** True if mainnet, false if testnet. */
    @SerializedName("is_mainnet")
    private Boolean isMainnet;

    /** Smart contract address (empty for native coins like BTC, ETH). */
    @SerializedName("contract_address")
    private String contractAddress;

    /** URL template for viewing addresses in block explorer. */
    @SerializedName("address_url_template")
    private String addressUrlTemplate;

    /** URL template for viewing transactions in block explorer. */
    @SerializedName("tx_url_template")
    private String txUrlTemplate;

    /** Token symbol (e.g., "USDC", "BTC", "ETH"). */
    @SerializedName("token")
    private String token;

    /** Chain ID for EVM-compatible networks (e.g., 1 for Ethereum, 137 for Polygon). */
    @SerializedName("chain_id")
    private Long chainId;

    // Fiat-specific fields (null for crypto)

    /** Currency symbol (e.g., "$", "€", "£"). */
    @SerializedName("symbol")
    private String symbol;

    /** Payment provider (e.g., "Stripe", "PayPal"). */
    @SerializedName("provider")
    private String provider;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public String getCoin() { return coin; }
    public void setCoin(String coin) { this.coin = coin; }

    public Boolean getIsFiat() { return isFiat; }
    public void setIsFiat(Boolean isFiat) { this.isFiat = isFiat; }

    // Java bean convention for boolean getters
    public boolean isFiat() { return isFiat != null && isFiat; }

    public Integer getDecimals() { return decimals; }
    public void setDecimals(Integer decimals) { this.decimals = decimals; }

    public Boolean getPayable() { return payable; }
    public void setPayable(Boolean payable) { this.payable = payable; }

    // Java bean convention for boolean getters
    public boolean isPayable() { return payable != null && payable; }

    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public Boolean getIsMainnet() { return isMainnet; }
    public void setIsMainnet(Boolean isMainnet) { this.isMainnet = isMainnet; }

    public String getContractAddress() { return contractAddress; }
    public void setContractAddress(String contractAddress) { this.contractAddress = contractAddress; }

    public String getAddressUrlTemplate() { return addressUrlTemplate; }
    public void setAddressUrlTemplate(String addressUrlTemplate) { this.addressUrlTemplate = addressUrlTemplate; }

    public String getTxUrlTemplate() { return txUrlTemplate; }
    public void setTxUrlTemplate(String txUrlTemplate) { this.txUrlTemplate = txUrlTemplate; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getChainId() { return chainId; }
    public void setChainId(Long chainId) { this.chainId = chainId; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    // Convenience method to get crypto asset params as an object
    public CryptoAssetParams getCryptoAssetParams() {
        if (isFiat()) {
            return null;
        }
        CryptoAssetParams params = new CryptoAssetParams();
        params.network = network;
        params.isMainnet = isMainnet;
        params.contractAddress = contractAddress;
        params.addressUrlTemplate = addressUrlTemplate;
        params.txUrlTemplate = txUrlTemplate;
        params.token = token;
        params.chainId = chainId;
        return params;
    }

    // Convenience method to get fiat asset params as an object
    public FiatAssetParams getFiatAssetParams() {
        if (!isFiat()) {
            return null;
        }
        FiatAssetParams params = new FiatAssetParams();
        params.setSymbol(symbol);
        params.setProvider(provider);
        return params;
    }
}
