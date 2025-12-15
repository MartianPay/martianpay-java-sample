package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class CryptoOption {
    @SerializedName("asset_id")
    private String assetId;

    public CryptoOption() {
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
}
