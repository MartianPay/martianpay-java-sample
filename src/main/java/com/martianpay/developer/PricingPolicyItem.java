package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Pricing policy rule for subscription billing cycles defining when and how discounts or price overrides apply.
 * Policy types: FIXED (first cycle only), RECURRING (subsequent cycles). Adjustment types: PERCENTAGE, FIXED_AMOUNT, PRICE.
 */
public class PricingPolicyItem {
    /**
     * Policy type: FIXED (first cycle only) or RECURRING (subsequent cycles).
     */
    @SerializedName("policy_type")
    private String policyType;

    /**
     * Adjustment type: PERCENTAGE (discount %), FIXED_AMOUNT (discount amount), or PRICE (override price).
     */
    @SerializedName("adjustment_type")
    private String adjustmentType;

    /**
     * Discount or price value as string. Format depends on adjustmentType: percentage value, currency amount, or new price.
     */
    @SerializedName("adjustment_value")
    private String adjustmentValue;

    /**
     * Cycle number after which this RECURRING policy becomes active. Only applicable for RECURRING policies, ignored for FIXED.
     */
    @SerializedName("after_cycle")
    private String afterCycle;

    /**
     * Default constructor for PricingPolicyItem.
     */
    public PricingPolicyItem() {
    }

    /**
     * Gets the policy type.
     * @return The policy type ("FIXED" or "RECURRING")
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the policy type.
     * @param policyType The policy type ("FIXED" or "RECURRING")
     */
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    /**
     * Gets the adjustment type.
     * @return The adjustment type ("PERCENTAGE", "FIXED_AMOUNT", or "PRICE")
     */
    public String getAdjustmentType() {
        return adjustmentType;
    }

    /**
     * Sets the adjustment type.
     * @param adjustmentType The adjustment type
     */
    public void setAdjustmentType(String adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    /**
     * Gets the adjustment value.
     * @return The discount or price value as a string
     */
    public String getAdjustmentValue() {
        return adjustmentValue;
    }

    /**
     * Sets the adjustment value.
     * @param adjustmentValue The discount or price value as a string
     */
    public void setAdjustmentValue(String adjustmentValue) {
        this.adjustmentValue = adjustmentValue;
    }

    /**
     * Gets the cycle number after which this recurring policy applies.
     * @return The after-cycle value, or null for FIXED policies
     */
    public String getAfterCycle() {
        return afterCycle;
    }

    /**
     * Sets the cycle number after which this recurring policy applies.
     * @param afterCycle The after-cycle value (only for RECURRING policies)
     */
    public void setAfterCycle(String afterCycle) {
        this.afterCycle = afterCycle;
    }
}
