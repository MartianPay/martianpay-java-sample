package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PaymentLinkVariant represents a variant available in a payment link
 */
public class PaymentLinkVariant {
    @SerializedName("variant_id")
    private String variantID;

    @SerializedName("variant")
    private ProductVariant variant;

    @SerializedName("quantity")
    private Integer quantity;

    @SerializedName("min_quantity")
    private Integer minQuantity;

    @SerializedName("max_quantity")
    private Integer maxQuantity;

    @SerializedName("is_primary")
    private Boolean isPrimary;

    // Getters and Setters
    public String getVariantID() { return variantID; }
    public void setVariantID(String variantID) { this.variantID = variantID; }

    public ProductVariant getVariant() { return variant; }
    public void setVariant(ProductVariant variant) { this.variant = variant; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Integer getMinQuantity() { return minQuantity; }
    public void setMinQuantity(Integer minQuantity) { this.minQuantity = minQuantity; }

    public Integer getMaxQuantity() { return maxQuantity; }
    public void setMaxQuantity(Integer maxQuantity) { this.maxQuantity = maxQuantity; }

    public Boolean getIsPrimary() { return isPrimary; }
    public void setIsPrimary(Boolean isPrimary) { this.isPrimary = isPrimary; }
}
