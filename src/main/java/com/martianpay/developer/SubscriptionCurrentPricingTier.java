package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * SubscriptionCurrentPricingTier represents the active pricing tier for a subscription.
 *
 * This model captures the current pricing details for an active subscription, including
 * which billing cycle the subscription is in, the pricing applied, and any discounts
 * from the selling plan. It provides a complete picture of what the customer is paying
 * for their current subscription period.
 *
 * Key features:
 * - Current cycle tracking
 * - Base price and final price calculation
 * - Discount application and percentage
 * - Billing cycle information
 * - Currency specification
 *
 * Use cases:
 * - Displaying current subscription costs to customers
 * - Showing next billing amount and date
 * - Calculating prorated charges for plan changes
 * - Generating invoices with accurate pricing
 * - Tracking subscription discount progression
 *
 * Example scenarios:
 * - Cycle 1: Base $99.99, 20% intro discount, Final $79.99
 * - Cycle 5: Base $99.99, 10% loyalty discount, Final $89.99
 * - Cycle 13+: Base $99.99, no discount, Final $99.99
 *
 * The pricing tier automatically progresses as the subscription renews,
 * applying the appropriate discounts based on the selling plan's pricing policy.
 */
public class SubscriptionCurrentPricingTier {
    /**
     * Current billing cycle number for the subscription.
     * Indicates which cycle the subscription is currently in.
     * Starts at 1 for the first billing period.
     * Example: 1 (first month), 5 (fifth month), 12 (yearly anniversary)
     * Used to determine which pricing tier applies.
     */
    @SerializedName("cycle_number")
    private Integer cycleNumber;

    /**
     * Base price before any discounts are applied.
     * The standard price for the product/variant in the subscription.
     * Format: String to preserve precision (e.g., "99.99")
     * This is the price customers would pay without a selling plan.
     */
    @SerializedName("base_price")
    private String basePrice;

    /**
     * Discount amount from the selling plan.
     * The amount deducted from the base price due to subscription benefits.
     * Format: String to preserve precision (e.g., "10.00" for $10 off)
     * Calculated based on the selling plan's pricing policy.
     */
    @SerializedName("selling_plan_discount")
    private String sellingPlanDiscount;

    /**
     * Final price after applying selling plan discounts.
     * The actual amount the customer will be charged for this cycle.
     * Formula: base_price - selling_plan_discount = final_price
     * Format: String to preserve precision (e.g., "89.99")
     */
    @SerializedName("final_price")
    private String finalPrice;

    /**
     * Three-letter ISO 4217 currency code.
     * The currency in which all prices are denominated.
     * Examples: "USD" (Currently only USD is supported for fiat), "USDT"
     * Must match the subscription's configured currency.
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Type of pricing policy applied for this tier.
     * Indicates how the discount is calculated and applied.
     * Examples: "PERCENTAGE", "FIXED_AMOUNT", "PRICE", "RECURRING", "FIXED"
     * Matches the policy type from the selling plan's pricing policy.
     */
    @SerializedName("policy_type")
    private String policyType;

    /**
     * Human-readable description of this billing cycle.
     * Explains when this pricing applies in customer-friendly language.
     * Examples:
     * - "First month" (cycle 1)
     * - "Months 2-6" (cycles 2-6)
     * - "After 12 months" (cycle 13+)
     * Useful for displaying in customer-facing interfaces.
     */
    @SerializedName("cycle_description")
    private String cycleDescription;

    /**
     * Discount percentage applied for this cycle.
     * The percentage off the base price (if applicable).
     * Format: String representation (e.g., "20" for 20% off, "10.5" for 10.5% off)
     * Null if the discount is a fixed amount rather than a percentage.
     */
    @SerializedName("discount_percentage")
    private String discountPercentage;

    /**
     * Billing cycle period type.
     * The unit of time for each billing cycle.
     * Values: "day", "week", "month", "year"
     * Example: "month" means customer is billed monthly
     */
    @SerializedName("billing_cycle")
    private String billingCycle;

    /**
     * Billing cycle interval multiplier.
     * How many periods between each billing.
     * Example: 1 with "month" = monthly, 3 with "month" = every 3 months
     * Combined with billingCycle to determine the full billing frequency.
     */
    @SerializedName("billing_cycle_interval")
    private Integer billingCycleInterval;

    /**
     * Default constructor for SubscriptionCurrentPricingTier.
     */
    public SubscriptionCurrentPricingTier() {
    }

    /**
     * Gets the current cycle number.
     * @return The billing cycle number
     */
    public Integer getCycleNumber() {
        return cycleNumber;
    }

    /**
     * Sets the current cycle number.
     * @param cycleNumber The billing cycle number
     */
    public void setCycleNumber(Integer cycleNumber) {
        this.cycleNumber = cycleNumber;
    }

    /**
     * Gets the base price.
     * @return The base price before discounts
     */
    public String getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     * @param basePrice The base price before discounts
     */
    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
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
     * Gets the final price after discounts.
     * @return The final billing price
     */
    public String getFinalPrice() {
        return finalPrice;
    }

    /**
     * Sets the final price after discounts.
     * @param finalPrice The final billing price
     */
    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
     * Gets the currency code.
     * @return The ISO 4217 currency code
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code.
     * @param currency The ISO 4217 currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the policy type.
     * @return The pricing policy type
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the policy type.
     * @param policyType The pricing policy type
     */
    public void setPolicyType(String policyType) {
        this.policyType = policyType;
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

    /**
     * Gets the discount percentage.
     * @return The discount percentage as a string
     */
    public String getDiscountPercentage() {
        return discountPercentage;
    }

    /**
     * Sets the discount percentage.
     * @param discountPercentage The discount percentage as a string
     */
    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    /**
     * Gets the billing cycle period.
     * @return The billing cycle unit (day, week, month, year)
     */
    public String getBillingCycle() {
        return billingCycle;
    }

    /**
     * Sets the billing cycle period.
     * @param billingCycle The billing cycle unit
     */
    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    /**
     * Gets the billing cycle interval.
     * @return The number of periods between billings
     */
    public Integer getBillingCycleInterval() {
        return billingCycleInterval;
    }

    /**
     * Sets the billing cycle interval.
     * @param billingCycleInterval The number of periods between billings
     */
    public void setBillingCycleInterval(Integer billingCycleInterval) {
        this.billingCycleInterval = billingCycleInterval;
    }
}
