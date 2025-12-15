package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * FeeInfo contains fee information for a blockchain transaction
 */
public class FeeInfo {
    /**
     * NetworkFee is the fee paid to the blockchain network
     */
    @SerializedName("network_fee")
    private String networkFee;

    /**
     * ServiceFee is the total fee deducted by the platform (serviceFee = amount - netAmount)
     */
    @SerializedName("service_fee")
    private String serviceFee;

    public FeeInfo() {
    }

    // Getters and Setters
    public String getNetworkFee() {
        return networkFee;
    }

    public void setNetworkFee(String networkFee) {
        this.networkFee = networkFee;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }
}
