package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PayrollDirectItem represents a single payroll recipient item
 */
public class PayrollDirectItem {
    /**
     * ExternalID is the external ID for the item
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Name is the recipient name
     */
    @SerializedName("name")
    private String name;

    /**
     * Email is the recipient email
     */
    @SerializedName("email")
    private String email;

    /**
     * Phone is the recipient phone number
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Amount is the payment amount
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Coin is the cryptocurrency to use for payment
     */
    @SerializedName("coin")
    private String coin;

    /**
     * Network is the blockchain network to use
     */
    @SerializedName("network")
    private String network;

    /**
     * Address is the recipient wallet address
     */
    @SerializedName("address")
    private String address;

    /**
     * PaymentMethod is the payment method ("normal" or "binance")
     */
    @SerializedName("payment_method")
    private String paymentMethod;

    public PayrollDirectItem() {
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
