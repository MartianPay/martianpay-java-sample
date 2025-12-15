package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * MerchantAddressCreateRequest creates a new merchant address
 */
public class MerchantAddressCreateRequest {
    /**
     * Network is the blockchain network (e.g., "ETH", "BTC", "TRX")
     */
    @SerializedName("network")
    private String network;

    /**
     * Address is the blockchain address to be verified
     */
    @SerializedName("address")
    private String address;

    // Getters and Setters
    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
