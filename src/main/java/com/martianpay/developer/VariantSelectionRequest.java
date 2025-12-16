package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to select a product variant with quantity and subscription options.
 */
public class VariantSelectionRequest {
    /**
     * Unique identifier of the product variant to select.
     */
    @SerializedName("variant_id")
    private String variantId;

    /**
     * Quantity of this variant to purchase.
     */
    @SerializedName("quantity")
    private Integer quantity;

    /**
     * Selling plan (subscription) ID to apply to this variant.
     */
    @SerializedName("selling_plan_id")
    private String sellingPlanId;

    public VariantSelectionRequest() {
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSellingPlanId() {
        return sellingPlanId;
    }

    public void setSellingPlanId(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
    }
}
