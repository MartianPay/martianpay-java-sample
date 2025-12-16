package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * List of assets enabled for the merchant.
 */
public class AssetsListResponse {
    /** List of cryptocurrency and fiat assets. Currently only USD is supported. */
    @SerializedName("assets")
    private List<Asset> assets;

    // Getters and Setters
    public List<Asset> getAssets() { return assets; }
    public void setAssets(List<Asset> assets) { this.assets = assets; }
}
