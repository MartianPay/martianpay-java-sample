package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayrollGetAddressVerificationResponse {
    @SerializedName("coin")
    private String coin;

    @SerializedName("network")
    private String network;

    @SerializedName("address")
    private String address;

    @SerializedName("amount_start_decimal")
    private String amountStartDecimal;

    @SerializedName("amount_end_decimal")
    private String amountEndDecimal;

    public PayrollGetAddressVerificationResponse() {
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmountStartDecimal() {
        return amountStartDecimal;
    }

    public void setAmountStartDecimal(String amountStartDecimal) {
        this.amountStartDecimal = amountStartDecimal;
    }

    public String getAmountEndDecimal() {
        return amountEndDecimal;
    }

    public void setAmountEndDecimal(String amountEndDecimal) {
        this.amountEndDecimal = amountEndDecimal;
    }
}
