package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CryptoAssetParams contains blockchain-specific parameters for cryptocurrency assets
 */
public class CryptoAssetParams {
    @SerializedName("network")
    public String network;

    @SerializedName("is_mainnet")
    public Boolean isMainnet;

    @SerializedName("contract_address")
    public String contractAddress;

    @SerializedName("address_url_template")
    public String addressUrlTemplate;

    @SerializedName("tx_url_template")
    public String txUrlTemplate;

    @SerializedName("token")
    public String token;

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
