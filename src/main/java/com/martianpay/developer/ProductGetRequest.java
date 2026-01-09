package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request parameters for retrieving a product.
 */
public class ProductGetRequest {
    /**
     * Specifies related resources to include in the response.
     * For example, "selling_plans" to include selling plan details.
     */
    @SerializedName("expand")
    private String expand;

    // Getters and Setters
    public String getExpand() { return expand; }
    public void setExpand(String expand) { this.expand = expand; }
}
