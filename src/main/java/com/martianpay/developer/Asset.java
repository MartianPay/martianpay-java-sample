package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Asset represents a cryptocurrency or fiat asset supported by the platform
 */
public class Asset {
    /**
     * Id is the unique identifier of the asset (e.g., "USDC_ETH", "USD")
     */
    @SerializedName("id")
    private String id;

    /**
     * DisplayName is the human-readable name of the asset (e.g., "USD Coin on Ethereum")
     */
    @SerializedName("display_name")
    private String displayName;

    /**
     * Coin is the base currency code (e.g., "USDC", "BTC", "USD")
     */
    @SerializedName("coin")
    private String coin;

    /**
     * IsFiat indicates whether this is a fiat currency (true) or cryptocurrency (false)
     */
    @SerializedName("is_fiat")
    private Boolean isFiat;

    /**
     * Decimals is the number of decimal places for this asset
     */
    @SerializedName("decimals")
    private Integer decimals;

    /**
     * Payable indicates whether this asset can be used for payments
     */
    @SerializedName("payable")
    private Boolean payable;

    // Crypto asset params (embedded fields from Go)
    /**
     * Network is the blockchain network name (e.g., "Ethereum", "Polygon", "Solana")
     */
    @SerializedName("network")
    private String network;

    /**
     * IsMainnet indicates if this is a mainnet (true) or testnet (false) asset
     */
    @SerializedName("is_mainnet")
    private Boolean isMainnet;

    /**
     * ContractAddress is the smart contract address for token assets (empty for native coins)
     */
    @SerializedName("contract_address")
    private String contractAddress;

    /**
     * AddressUrlTemplate is the URL template for viewing an address on a block explorer
     */
    @SerializedName("address_url_template")
    private String addressUrlTemplate;

    /**
     * TxUrlTemplate is the URL template for viewing a transaction on a block explorer
     */
    @SerializedName("tx_url_template")
    private String txUrlTemplate;

    /**
     * Token is the token symbol (e.g., "USDC", "USDT")
     */
    @SerializedName("token")
    private String token;

    /**
     * ChainId is the blockchain chain ID for EVM-compatible networks
     */
    @SerializedName("chain_id")
    private Long chainId;

    // Fiat asset params (embedded fields from Go)
    /**
     * Symbol is the currency symbol (e.g., "$", "€", "£")
     */
    @SerializedName("symbol")
    private String symbol;

    /**
     * Provider is the payment provider for this fiat currency (e.g., "Stripe", "PayPal")
     */
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
