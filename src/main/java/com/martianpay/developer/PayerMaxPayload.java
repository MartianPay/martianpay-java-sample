package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PayerMaxPayload {
    @SerializedName("cashier_url")
    private String cashierUrl;

    @SerializedName("status")
    private String status;

    @SerializedName("session_key")
    private String sessionKey;

    @SerializedName("client_key")
    private String clientKey;

    public PayerMaxPayload() {
    }

    public String getCashierUrl() {
        return cashierUrl;
    }

    public void setCashierUrl(String cashierUrl) {
        this.cashierUrl = cashierUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getClientKey() {
        return clientKey;
    }

    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }
}
