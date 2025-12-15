package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayrollValidation {
    @SerializedName("name_valid")
    private Boolean nameValid;

    @SerializedName("email_valid")
    private Boolean emailValid;

    @SerializedName("phone_valid")
    private Boolean phoneValid;

    @SerializedName("amount_valid")
    private Boolean amountValid;

    @SerializedName("coin_valid")
    private Boolean coinValid;

    @SerializedName("network_valid")
    private Boolean networkValid;

    @SerializedName("address_valid")
    private Boolean addressValid;

    @SerializedName("payment_method_valid")
    private Boolean paymentMethodValid;

    @SerializedName("balance_enough")
    private Boolean balanceEnough;

    public PayrollValidation() {
    }

    public boolean isWalletInfoValid() {
        return Boolean.TRUE.equals(amountValid) &&
               Boolean.TRUE.equals(coinValid) &&
               Boolean.TRUE.equals(networkValid) &&
               Boolean.TRUE.equals(addressValid) &&
               Boolean.TRUE.equals(paymentMethodValid);
    }

    public Boolean getNameValid() {
        return nameValid;
    }

    public void setNameValid(Boolean nameValid) {
        this.nameValid = nameValid;
    }

    public Boolean getEmailValid() {
        return emailValid;
    }

    public void setEmailValid(Boolean emailValid) {
        this.emailValid = emailValid;
    }

    public Boolean getPhoneValid() {
        return phoneValid;
    }

    public void setPhoneValid(Boolean phoneValid) {
        this.phoneValid = phoneValid;
    }

    public Boolean getAmountValid() {
        return amountValid;
    }

    public void setAmountValid(Boolean amountValid) {
        this.amountValid = amountValid;
    }

    public Boolean getCoinValid() {
        return coinValid;
    }

    public void setCoinValid(Boolean coinValid) {
        this.coinValid = coinValid;
    }

    public Boolean getNetworkValid() {
        return networkValid;
    }

    public void setNetworkValid(Boolean networkValid) {
        this.networkValid = networkValid;
    }

    public Boolean getAddressValid() {
        return addressValid;
    }

    public void setAddressValid(Boolean addressValid) {
        this.addressValid = addressValid;
    }

    public Boolean getPaymentMethodValid() {
        return paymentMethodValid;
    }

    public void setPaymentMethodValid(Boolean paymentMethodValid) {
        this.paymentMethodValid = paymentMethodValid;
    }

    public Boolean getBalanceEnough() {
        return balanceEnough;
    }

    public void setBalanceEnough(Boolean balanceEnough) {
        this.balanceEnough = balanceEnough;
    }
}
