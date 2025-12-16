package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Calculated subscription price with discounts and billing cycle details.
 */
public class CalculatePriceResponse {
    /** Base price per billing cycle before discounts. */
    @SerializedName("base_price")
    private String basePrice;

    /** Total number of billing cycles (null or 0 for unlimited). */
    @SerializedName("total_cycles")
    private Integer totalCycles;

    /** Subtotal before discounts. */
    @SerializedName("subtotal_before_policy")
    private String subtotalBeforePolicy;

    /** Discount amount applied by the selling plan. */
    @SerializedName("selling_plan_discount")
    private String sellingPlanDiscount;

    /** Final subtotal after discounts. */
    @SerializedName("subtotal_after_policy")
    private String subtotalAfterPolicy;

    /** Currency code. Currently only USD is supported. */
    @SerializedName("currency")
    private String currency;

    /** Billing cycle frequency (e.g., "monthly", "yearly"). */
    @SerializedName("billing_cycle")
    private String billingCycle;

    /** Trial period duration in days (0 or null for no trial). */
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
