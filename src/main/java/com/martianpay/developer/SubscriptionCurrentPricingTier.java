package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

public class SubscriptionCurrentPricingTier {
    @SerializedName("cycle_number")
    private Integer cycleNumber;

    @SerializedName("base_price")
    private String basePrice;

    @SerializedName("selling_plan_discount")
    private String sellingPlanDiscount;

    @SerializedName("final_price")
    private String finalPrice;

    @SerializedName("currency")
    private String currency;

    @SerializedName("policy_type")
    private String policyType;

    @SerializedName("cycle_description")
    private String cycleDescription;

    @SerializedName("discount_percentage")
    private String discountPercentage;

    @SerializedName("billing_cycle")
    private String billingCycle;

    @SerializedName("billing_cycle_interval")
    private Integer billingCycleInterval;

    public SubscriptionCurrentPricingTier() {
    }

    public Integer getCycleNumber() {
        return cycleNumber;
    }

    public void setCycleNumber(Integer cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getSellingPlanDiscount() {
        return sellingPlanDiscount;
    }

    public void setSellingPlanDiscount(String sellingPlanDiscount) {
        this.sellingPlanDiscount = sellingPlanDiscount;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getCycleDescription() {
        return cycleDescription;
    }

    public void setCycleDescription(String cycleDescription) {
        this.cycleDescription = cycleDescription;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public Integer getBillingCycleInterval() {
        return billingCycleInterval;
    }

    public void setBillingCycleInterval(Integer billingCycleInterval) {
        this.billingCycleInterval = billingCycleInterval;
    }
}
