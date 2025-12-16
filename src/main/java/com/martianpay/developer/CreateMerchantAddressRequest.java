package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to register a new blockchain address for the merchant.
 * Address must be verified before it can be used for payments or withdrawals.
 */
public class CreateMerchantAddressRequest {
    /**
     * Blockchain network identifier (e.g., ETH, BTC, TRX).
     */
    @SerializedName("network")
    private String network;

    /**
     * Blockchain address to register. Must be valid for the specified network.
     */
    @SerializedName("address")
    private String address;

    /**
     * Gets the blockchain network identifier.
     * @return The network identifier (e.g., "ETH", "BTC", "TRX")
     */
    public String getNetwork() { return network; }

    /**
     * Sets the blockchain network identifier.
     * @param network The network identifier (e.g., "ETH", "BTC", "TRX")
     */
    public void setNetwork(String network) { this.network = network; }

    /**
     * Gets the blockchain address.
     * @return The blockchain address
     */
    public String getAddress() { return address; }

    /**
     * Sets the blockchain address.
     * @param address The blockchain address
     */
    public void setAddress(String address) { this.address = address; }
}
