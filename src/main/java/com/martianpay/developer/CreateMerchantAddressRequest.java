package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CreateMerchantAddressRequest creates a new merchant address
 */
public class CreateMerchantAddressRequest {
    @SerializedName("network")
    private String network;

    @SerializedName("address")
    private String address;

    // Getters and Setters
    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
