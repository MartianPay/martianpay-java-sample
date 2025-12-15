package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CalculatePriceResponse represents the calculated subscription price for a variant
 */
public class CalculatePriceResponse {
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

    @SerializedName("currency")
    private String currency;

    @SerializedName("billing_cycle")
    private String billingCycle;

    @SerializedName("trial_period_days")
    private Integer trialPeriodDays;

    // Getters and Setters
    public String getBasePrice() { return basePrice; }
    public void setBasePrice(String basePrice) { this.basePrice = basePrice; }

    public Integer getTotalCycles() { return totalCycles; }
    public void setTotalCycles(Integer totalCycles) { this.totalCycles = totalCycles; }

    public String getSubtotalBeforePolicy() { return subtotalBeforePolicy; }
    public void setSubtotalBeforePolicy(String subtotalBeforePolicy) { this.subtotalBeforePolicy = subtotalBeforePolicy; }

    public String getSellingPlanDiscount() { return sellingPlanDiscount; }
    public void setSellingPlanDiscount(String sellingPlanDiscount) { this.sellingPlanDiscount = sellingPlanDiscount; }

    public String getSubtotalAfterPolicy() { return subtotalAfterPolicy; }
    public void setSubtotalAfterPolicy(String subtotalAfterPolicy) { this.subtotalAfterPolicy = subtotalAfterPolicy; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getBillingCycle() { return billingCycle; }
    public void setBillingCycle(String billingCycle) { this.billingCycle = billingCycle; }

    public Integer getTrialPeriodDays() { return trialPeriodDays; }
    public void setTrialPeriodDays(Integer trialPeriodDays) { this.trialPeriodDays = trialPeriodDays; }
}
