package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * PricingTier represents a tier in a subscription or recurring payment pricing model.
 *
 * This model defines pricing information for a specific phase or tier in a subscription
 * plan, typically used with selling plans that have multiple pricing stages. It captures
 * base pricing, cycle information, discounts, and policy details for a pricing tier.
 *
 * Key features:
 * - Base price and cycle information
 * - Before and after policy subtotals
 * - Selling plan discounts
 * - Cycle descriptions for customer display
 * - Policy type identification
 *
 * Use cases:
 * - Implementing tiered subscription pricing
 * - Defining introductory pricing periods
 * - Calculating pricing for different subscription phases
 * - Displaying pricing breakdowns to customers
 * - Managing discounts that apply after certain cycles
 *
 * Example scenarios:
 * - Tier 1: First 3 months at $10/month (introductory rate)
 * - Tier 2: Months 4-12 at $15/month (regular rate)
 * - Tier 3: After 12 months at $12/month (loyalty rate)
 */
public class PricingTier {
    /**
     * Base price for this pricing tier.
     * The starting price before any discounts or policies are applied.
     * Format: String representation of the monetary amount (e.g., "10.00", "99.99")
     */
    @SerializedName("base_price")
    private String basePrice;

    /**
     * Total number of billing cycles for this tier.
     * Specifies how many billing periods this pricing tier applies to.
     * Example: 3 means this price applies for 3 billing cycles
     * Use null or 0 for unlimited/ongoing tiers
     */
    @SerializedName("total_cycles")
    private Integer totalCycles;

    /**
     * Subtotal before policy discounts are applied.
     * The price after base calculations but before selling plan discounts.
     * Format: String representation of the monetary amount
     * Useful for showing customers the pre-discount price
     */
    @SerializedName("subtotal_before_policy")
    private String subtotalBeforePolicy;

    /**
     * Discount amount from the selling plan.
     * The amount deducted due to subscription/selling plan discounts.
     * Format: String representation of the monetary amount
     * Example: "5.00" for a $5 discount, "10%" for percentage-based discounts
     */
    @SerializedName("selling_plan_discount")
    private String sellingPlanDiscount;

    /**
     * Subtotal after policy discounts are applied.
     * The final price for this tier after all discounts.
     * Format: String representation of the monetary amount
     * This is the amount the customer will actually pay per cycle
     */
    @SerializedName("subtotal_after_policy")
    private String subtotalAfterPolicy;

    /**
     * Type of pricing policy applied.
     * Identifies what kind of discount or adjustment is being applied.
     * Examples: "percentage", "fixed_amount", "tiered", "volume"
     * Used to determine how the discount is calculated and displayed
     */
    @SerializedName("policy_type")
    private String policyType;

    /**
     * The cycle number after which this tier becomes active.
     * Indicates when this pricing tier starts applying.
     * Example: 3 means this tier applies after the 3rd cycle (starting from cycle 4)
     * Use 0 for tiers that apply from the beginning
     */
    @SerializedName("after_cycle")
    private Integer afterCycle;

    /**
     * Human-readable description of the billing cycle for this tier.
     * Explains to customers when and how this pricing applies.
     * Examples:
     * - "First 3 months"
     * - "Months 4-12"
     * - "After 12 months"
     * - "Every month thereafter"
     */
    @SerializedName("cycle_description")
    private String cycleDescription;

    /**
     * Default constructor for PricingTier.
     */
    public PricingTier() {
    }

    /**
     * Gets the base price for this tier.
     * @return The base price
     */
    public String getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price for this tier.
     * @param basePrice The base price
     */
    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets the total number of cycles for this tier.
     * @return The total cycles
     */
    public Integer getTotalCycles() {
        return totalCycles;
    }

    /**
     * Sets the total number of cycles for this tier.
     * @param totalCycles The total cycles
     */
    public void setTotalCycles(Integer totalCycles) {
        this.totalCycles = totalCycles;
    }

    /**
     * Gets the subtotal before policy discounts.
     * @return The subtotal before policy
     */
    public String getSubtotalBeforePolicy() {
        return subtotalBeforePolicy;
    }

    /**
     * Sets the subtotal before policy discounts.
     * @param subtotalBeforePolicy The subtotal before policy
     */
    public void setSubtotalBeforePolicy(String subtotalBeforePolicy) {
        this.subtotalBeforePolicy = subtotalBeforePolicy;
    }

    /**
     * Gets the selling plan discount amount.
     * @return The discount amount
     */
    public String getSellingPlanDiscount() {
        return sellingPlanDiscount;
    }

    /**
     * Sets the selling plan discount amount.
     * @param sellingPlanDiscount The discount amount
     */
    public void setSellingPlanDiscount(String sellingPlanDiscount) {
        this.sellingPlanDiscount = sellingPlanDiscount;
    }

    /**
     * Gets the subtotal after policy discounts.
     * @return The final subtotal
     */
    public String getSubtotalAfterPolicy() {
        return subtotalAfterPolicy;
    }

    /**
     * Sets the subtotal after policy discounts.
     * @param subtotalAfterPolicy The final subtotal
     */
    public void setSubtotalAfterPolicy(String subtotalAfterPolicy) {
        this.subtotalAfterPolicy = subtotalAfterPolicy;
    }

    /**
     * Gets the policy type.
     * @return The policy type
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the policy type.
     * @param policyType The policy type
     */
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    /**
     * Gets the cycle number after which this tier applies.
     * @return The starting cycle number
     */
    public Integer getAfterCycle() {
        return afterCycle;
    }

    /**
     * Sets the cycle number after which this tier applies.
     * @param afterCycle The starting cycle number
     */
    public void setAfterCycle(Integer afterCycle) {
        this.afterCycle = afterCycle;
    }

    /**
     * Gets the cycle description.
     * @return The human-readable cycle description
     */
    public String getCycleDescription() {
        return cycleDescription;
    }

    /**
     * Sets the cycle description.
     * @param cycleDescription The human-readable cycle description
     */
    public void setCycleDescription(String cycleDescription) {
        this.cycleDescription = cycleDescription;
    }
}
