package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Single pricing policy item in a request.
 */
public class PricingPolicyItemRequest {
    /** Policy type ("FIXED" or "RECURRING"). */
    @SerializedName("policy_type")
    private String policyType;

    /** Adjustment type ("PERCENTAGE", "FIXED_AMOUNT", or "PRICE"). */
    @SerializedName("adjustment_type")
    private String adjustmentType;

    /** Discount value as string. */
    @SerializedName("adjustment_value")
    private String adjustmentValue;

    /** After cycle (for RECURRING type only). */
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
