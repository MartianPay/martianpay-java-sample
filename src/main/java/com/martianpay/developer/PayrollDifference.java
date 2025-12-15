package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayrollDifference {
    @SerializedName("name")
    private PayrollDifferenceField name;

    @SerializedName("email")
    private PayrollDifferenceField email;

    @SerializedName("phone")
    private PayrollDifferenceField phone;

    @SerializedName("amount")
    private PayrollDifferenceField amount;

    @SerializedName("coin")
    private PayrollDifferenceField coin;

    @SerializedName("network")
    private PayrollDifferenceField network;

    @SerializedName("address")
    private PayrollDifferenceField address;

    public PayrollDifference() {
    }

    public PayrollDifferenceField getName() {
        return name;
    }

    public void setName(PayrollDifferenceField name) {
        this.name = name;
    }

    public PayrollDifferenceField getEmail() {
        return email;
    }

    public void setEmail(PayrollDifferenceField email) {
        this.email = email;
    }

    public PayrollDifferenceField getPhone() {
        return phone;
    }

    public void setPhone(PayrollDifferenceField phone) {
        this.phone = phone;
    }

    public PayrollDifferenceField getAmount() {
        return amount;
    }

    public void setAmount(PayrollDifferenceField amount) {
        this.amount = amount;
    }

    public PayrollDifferenceField getCoin() {
        return coin;
    }

    public void setCoin(PayrollDifferenceField coin) {
        this.coin = coin;
    }

    public PayrollDifferenceField getNetwork() {
        return network;
    }

    public void setNetwork(PayrollDifferenceField network) {
        this.network = network;
    }

    public PayrollDifferenceField getAddress() {
        return address;
    }

    public void setAddress(PayrollDifferenceField address) {
        this.address = address;
    }
}
