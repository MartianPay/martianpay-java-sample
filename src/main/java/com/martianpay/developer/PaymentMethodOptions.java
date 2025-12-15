package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentMethodOptions {
    @SerializedName("crypto")
    private Crypto crypto;

    @SerializedName("fiat")
    private Fiat fiat;

    public PaymentMethodOptions() {
    }

    public Crypto getCrypto() {
        return crypto;
    }

    public void setCrypto(Crypto crypto) {
        this.crypto = crypto;
    }

    public Fiat getFiat() {
        return fiat;
    }

    public void setFiat(Fiat fiat) {
        this.fiat = fiat;
    }
}
