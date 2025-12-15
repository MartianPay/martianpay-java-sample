package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * PaymentLinkCreateRequest creates a new payment link
 */
public class PaymentLinkCreateRequest {
    @SerializedName("product_id")
    private String productID;

    @SerializedName("default_variant_id")
    private String defaultVariantID;

    @SerializedName("primary_variant_ids")
    private List<String> primaryVariantIDs;

    @SerializedName("addon_variants")
    private List<PaymentLinkAddonVariantRequest> addonVariants;

    @SerializedName("variant_config")
    private Map<String, Object> variantConfig;

    // Getters and Setters
    public String getProductID() { return productID; }
    public void setProductID(String productID) { this.productID = productID; }

    public String getDefaultVariantID() { return defaultVariantID; }
    public void setDefaultVariantID(String defaultVariantID) { this.defaultVariantID = defaultVariantID; }

    public List<String> getPrimaryVariantIDs() { return primaryVariantIDs; }
    public void setPrimaryVariantIDs(List<String> primaryVariantIDs) { this.primaryVariantIDs = primaryVariantIDs; }

    public List<PaymentLinkAddonVariantRequest> getAddonVariants() { return addonVariants; }
    public void setAddonVariants(List<PaymentLinkAddonVariantRequest> addonVariants) { this.addonVariants = addonVariants; }

    public Map<String, Object> getVariantConfig() { return variantConfig; }
    public void setVariantConfig(Map<String, Object> variantConfig) { this.variantConfig = variantConfig; }
}

/**
 * PaymentLinkAddonVariantRequest represents addon variant configuration
 */
class PaymentLinkAddonVariantRequest {
    @SerializedName("variant_id")
    private String variantID;

    @SerializedName("min_quantity")
    private Integer minQuantity;

    @SerializedName("max_quantity")
    private Integer maxQuantity;

    // Getters and Setters
    public String getVariantID() { return variantID; }
    public void setVariantID(String variantID) { this.variantID = variantID; }

    public Integer getMinQuantity() { return minQuantity; }
    public void setMinQuantity(Integer minQuantity) { this.minQuantity = minQuantity; }

    public Integer getMaxQuantity() { return maxQuantity; }
    public void setMaxQuantity(Integer maxQuantity) { this.maxQuantity = maxQuantity; }
}
