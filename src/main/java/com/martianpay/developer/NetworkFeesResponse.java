package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * NetworkFeesResponse contains network fee information for all supported networks
 */
public class NetworkFeesResponse {
    /**
     * NetworkFees is a map of network names to their fee information
     */
    @SerializedName("network_fees")
    private Map<String, NetworkFee> networkFees;

    // Getters and Setters
    public Map<String, NetworkFee> getNetworkFees() { return networkFees; }
    public void setNetworkFees(Map<String, NetworkFee> networkFees) { this.networkFees = networkFees; }
}
