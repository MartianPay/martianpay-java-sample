package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanPricing represents the pricing information for a selling plan.
 *
 * This class encapsulates the complete pricing structure for a subscription plan,
 * including the billing cycle, currency, trial period, and tiered pricing details.
 * It provides a comprehensive view of how much customers will be charged over time.
 *
 * Use cases:
 * - Displaying pricing details to customers during checkout
 * - Calculating total costs for different billing cycles
 * - Showing price breakdowns with volume-based or time-based discounts
 * - Comparing pricing across different selling plans
 *
 * Example: A "Pro Annual" plan might have:
 * - Billing cycle: "yearly"
 * - Currency: "USD"
 * - Trial period: 14 days
 * - Pricing tiers: First year $299, subsequent years $349
 *
 * The pricing tiers allow for complex pricing models where the price changes
 * based on the billing cycle number or other criteria.
 */
public class SellingPlanPricing {
    /**
     * Unique identifier of the selling plan this pricing belongs to.
     * Links this pricing information back to a specific SellingPlan.
     * Format: plan_[random_id]
     */
    @SerializedName("selling_plan_id")
    private String sellingPlanId;

    /**
     * Display name of the selling plan for easy identification.
     * Example: "Premium Monthly", "Enterprise Annual"
     */
    @SerializedName("selling_plan_name")
    private String sellingPlanName;

    /**
     * The billing cycle interval for this plan.
     * Describes how often the customer is billed.
     * Example: "monthly", "yearly", "every 3 months"
     */
    @SerializedName("billing_cycle")
    private String billingCycle;

    /**
     * Three-letter ISO 4217 currency code for the pricing.
     * Example: "USD" (Currently only USD is supported for fiat)
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Number of days in the trial period before billing begins.
     * 0 or null indicates no trial period.
     * Customers can use the service for free during this period.
     */
    @SerializedName("trial_period_days")
    private Integer trialPeriodDays;

    /**
     * List of pricing tiers defining the cost structure over time.
     * Each tier specifies the price for a particular billing cycle or range.
     * Tiers enable progressive pricing where costs change after certain periods
     * (e.g., introductory pricing, loyalty discounts, or price increases).
     * Example: Tier 1 = First 3 months at $9.99, Tier 2 = Months 4+ at $14.99
     */
    @SerializedName("pricing_tiers")
    private List<PricingTier> pricingTiers;

    public SellingPlanPricing() {
    }

    /**
     * Gets the selling plan ID this pricing belongs to.
     * @return The selling plan ID
     */
    public String getSellingPlanId() {
        return sellingPlanId;
    }

    /**
     * Sets the selling plan ID this pricing belongs to.
     * @param sellingPlanId The selling plan ID
     */
    public void setSellingPlanId(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
    }

    /**
     * Gets the selling plan name for display purposes.
     * @return The selling plan name
     */
    public String getSellingPlanName() {
        return sellingPlanName;
    }

    /**
     * Sets the selling plan name for display purposes.
     * @param sellingPlanName The selling plan name
     */
    public void setSellingPlanName(String sellingPlanName) {
        this.sellingPlanName = sellingPlanName;
    }

    /**
     * Gets the billing cycle interval.
     * @return The billing cycle description
     */
    public String getBillingCycle() {
        return billingCycle;
    }

    /**
     * Sets the billing cycle interval.
     * @param billingCycle The billing cycle description
     */
    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    /**
     * Gets the currency code for pricing.
     * @return The ISO 4217 currency code
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code for pricing.
     * @param currency The ISO 4217 currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the trial period duration in days.
     * @return The trial period days, or 0/null for no trial
     */
    public Integer getTrialPeriodDays() {
        return trialPeriodDays;
    }

    /**
     * Sets the trial period duration in days.
     * @param trialPeriodDays The trial period days, or 0/null for no trial
     */
    public void setTrialPeriodDays(Integer trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }

    /**
     * Gets the list of pricing tiers.
     * @return List of pricing tier objects
     */
    public List<PricingTier> getPricingTiers() {
        return pricingTiers;
    }

    /**
     * Sets the list of pricing tiers.
     * @param pricingTiers List of pricing tier objects
     */
    public void setPricingTiers(List<PricingTier> pricingTiers) {
        this.pricingTiers = pricingTiers;
    }
}
