package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentLinkPriceRange represents the price range for a payment link
 */
public class PaymentLinkPriceRange {
    @SerializedName("min")
    private AssetAmount min;

    @SerializedName("max")
    private AssetAmount max;

    // Getters and Setters
    public AssetAmount getMin() { return min; }
    public void setMin(AssetAmount min) { this.min = min; }

    public AssetAmount getMax() { return max; }
    public void setMax(AssetAmount max) { this.max = max; }
}
