package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Blockchain-specific parameters for cryptocurrency assets.
 * Includes network information, contract addresses, and blockchain explorer URLs.
 */
public class CryptoAssetParams {
    /**
     * The blockchain network name (e.g., "ethereum", "polygon", "bitcoin").
     */
    @SerializedName("network")
    public String network;

    /**
     * Whether this is mainnet (true) or testnet (false).
     */
    @SerializedName("is_mainnet")
    public Boolean isMainnet;

    /**
     * Smart contract address for token-based assets (not needed for native coins).
     */
    @SerializedName("contract_address")
    public String contractAddress;

    /**
     * URL template for blockchain explorer address links (uses {address} placeholder).
     */
    @SerializedName("address_url_template")
    public String addressUrlTemplate;

    /**
     * URL template for blockchain explorer transaction links (uses {txHash} placeholder).
     */
    @SerializedName("tx_url_template")
    public String txUrlTemplate;

    /**
     * Token symbol or cryptocurrency ticker (e.g., "BTC", "ETH", "USDT").
     */
    @SerializedName("token")
    public String token;

    /**
     * Numeric chain ID for the blockchain network (for EVM-compatible chains).
     */
    @SerializedName("chain_id")
    public Long chainId;

    public CryptoAssetParams() {
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
}
