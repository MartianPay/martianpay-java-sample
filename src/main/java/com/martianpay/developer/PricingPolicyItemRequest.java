package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PricingPolicyItemRequest represents a single pricing policy item in a request
 */
public class PricingPolicyItemRequest {
    /** PolicyType is the policy type ("FIXED" | "RECURRING", FIXED=first cycle, RECURRING=subsequent cycles) */
    @SerializedName("policy_type")
    private String policyType;

    /** AdjustmentType is the adjustment type ("PERCENTAGE" | "FIXED_AMOUNT" | "PRICE") */
    @SerializedName("adjustment_type")
    private String adjustmentType;

    /** AdjustmentValue is the discount value as string (e.g., "10.5") */
    @SerializedName("adjustment_value")
    private String adjustmentValue;

    /** AfterCycle is only for RECURRING type (as string) */
    @SerializedName("after_cycle")
    private String afterCycle;

    // Getters and Setters
    public String getPolicyType() { return policyType; }
    public void setPolicyType(String policyType) { this.policyType = policyType; }

    public String getAdjustmentType() { return adjustmentType; }
    public void setAdjustmentType(String adjustmentType) { this.adjustmentType = adjustmentType; }

    public String getAdjustmentValue() { return adjustmentValue; }
    public void setAdjustmentValue(String adjustmentValue) { this.adjustmentValue = adjustmentValue; }

    public String getAfterCycle() { return afterCycle; }
    public void setAfterCycle(String afterCycle) { this.afterCycle = afterCycle; }
}
