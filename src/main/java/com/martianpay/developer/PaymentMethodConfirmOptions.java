package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PaymentMethodConfirmOptions {
    @SerializedName("crypto")
    private CryptoOption crypto;

    @SerializedName("fiat")
    private FiatOption fiat;

    public PaymentMethodConfirmOptions() {
    }

    public CryptoOption getCrypto() {
        return crypto;
    }

    public void setCrypto(CryptoOption crypto) {
        this.crypto = crypto;
    }

    public FiatOption getFiat() {
        return fiat;
    }

    public void setFiat(FiatOption fiat) {
        this.fiat = fiat;
    }
}
