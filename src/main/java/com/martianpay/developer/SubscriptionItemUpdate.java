package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * SubscriptionItemUpdate represents a subscription item update for plan changes
 */
public class SubscriptionItemUpdate {
    @SerializedName("id")
    private String id;

    @SerializedName("selling_plan_id")
    private String sellingPlanId;

    @SerializedName("variant_id")
    private String variantId;

    @SerializedName("quantity")
    private Integer quantity;

    public SubscriptionItemUpdate() {
    }

    public SubscriptionItemUpdate(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellingPlanId() {
        return sellingPlanId;
    }

    public void setSellingPlanId(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
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
}
