package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class VariantSelectionRequest {
    @SerializedName("variant_id")
    private String variantId;

    @SerializedName("quantity")
    private Integer quantity;

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
