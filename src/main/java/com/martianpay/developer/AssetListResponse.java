package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * AssetListResponse contains the list of assets enabled for the merchant
 */
public class AssetListResponse {
    /**
     * Assets is the list of cryptocurrency and fiat assets available to the merchant
     */
    @SerializedName("assets")
    private List<Asset> assets;

    // Getters and Setters
    public List<Asset> getAssets() { return assets; }
    public void setAssets(List<Asset> assets) { this.assets = assets; }
}
