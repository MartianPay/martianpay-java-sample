package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class PricingTier {
    @SerializedName("base_price")
    private String basePrice;

    @SerializedName("total_cycles")
    private Integer totalCycles;

    @SerializedName("subtotal_before_policy")
    private String subtotalBeforePolicy;

    @SerializedName("selling_plan_discount")
    private String sellingPlanDiscount;

    @SerializedName("subtotal_after_policy")
    private String subtotalAfterPolicy;

    @SerializedName("policy_type")
    private String policyType;

    @SerializedName("after_cycle")
    private Integer afterCycle;

    @SerializedName("cycle_description")
    private String cycleDescription;

    public PricingTier() {
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getTotalCycles() {
        return totalCycles;
    }

    public void setTotalCycles(Integer totalCycles) {
        this.totalCycles = totalCycles;
    }

    public String getSubtotalBeforePolicy() {
        return subtotalBeforePolicy;
    }

    public void setSubtotalBeforePolicy(String subtotalBeforePolicy) {
        this.subtotalBeforePolicy = subtotalBeforePolicy;
    }

    public String getSellingPlanDiscount() {
        return sellingPlanDiscount;
    }

    public void setSellingPlanDiscount(String sellingPlanDiscount) {
        this.sellingPlanDiscount = sellingPlanDiscount;
    }

    public String getSubtotalAfterPolicy() {
        return subtotalAfterPolicy;
    }

    public void setSubtotalAfterPolicy(String subtotalAfterPolicy) {
        this.subtotalAfterPolicy = subtotalAfterPolicy;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Integer getAfterCycle() {
        return afterCycle;
    }

    public void setAfterCycle(Integer afterCycle) {
        this.afterCycle = afterCycle;
    }

    public String getCycleDescription() {
        return cycleDescription;
    }

    public void setCycleDescription(String cycleDescription) {
        this.cycleDescription = cycleDescription;
    }
}
