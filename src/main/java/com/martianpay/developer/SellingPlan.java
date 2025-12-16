package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlan represents a subscription or recurring billing plan for products or services.
 *
 * A selling plan defines how customers are billed for recurring purchases, including:
 * - Billing frequency (daily, weekly, monthly, yearly)
 * - Billing type (recurring or prepaid)
 * - Pricing adjustments (percentage discounts, fixed amounts, or custom pricing)
 * - Trial periods before billing begins
 * - Plan validity dates and priority ordering
 *
 * Use cases:
 * - Monthly subscription boxes with 10% discount
 * - Annual service plans billed yearly
 * - Prepaid plans where customer pays upfront for multiple billing cycles
 * - Time-limited promotional plans with specific validity periods
 * - Multi-tier pricing based on billing cycle count
 *
 * Example: A "Premium Monthly" plan might bill customers every month at a 15% discount
 * from the regular price, with a 7-day free trial period.
 */
public class SellingPlan {
    /**
     * Status constant for an active selling plan that can be used for new subscriptions.
     */
    public static final String STATUS_ACTIVE = "active";

    /**
     * Status constant for a disabled selling plan that cannot be used for new subscriptions.
     */
    public static final String STATUS_DISABLED = "disabled";

    /**
     * Billing policy type for recurring billing where customers are charged at regular intervals.
     */
    public static final String BILLING_POLICY_TYPE_RECURRING = "RECURRING";

    /**
     * Billing policy type for prepaid billing where customers pay upfront for multiple cycles.
     */
    public static final String BILLING_POLICY_TYPE_PREPAID = "PREPAID";

    /**
     * Policy type for fixed pricing that doesn't change over time.
     */
    public static final String POLICY_TYPE_FIXED = "FIXED";

    /**
     * Policy type for recurring pricing with multiple pricing tiers.
     */
    public static final String POLICY_TYPE_RECURRING = "RECURRING";

    /**
     * Adjustment type for percentage-based discounts (e.g., 15% off).
     */
    public static final String ADJUSTMENT_TYPE_PERCENTAGE = "PERCENTAGE";

    /**
     * Adjustment type for fixed amount discounts (e.g., $10 off).
     */
    public static final String ADJUSTMENT_TYPE_FIXED_AMOUNT = "FIXED_AMOUNT";

    /**
     * Adjustment type for custom price override (e.g., set price to $49.99).
     */
    public static final String ADJUSTMENT_TYPE_PRICE = "PRICE";

    /**
     * Billing interval for daily billing cycles.
     */
    public static final String BILLING_INTERVAL_DAY = "day";

    /**
     * Billing interval for weekly billing cycles.
     */
    public static final String BILLING_INTERVAL_WEEK = "week";

    /**
     * Billing interval for monthly billing cycles.
     */
    public static final String BILLING_INTERVAL_MONTH = "month";

    /**
     * Billing interval for yearly billing cycles.
     */
    public static final String BILLING_INTERVAL_YEAR = "year";

    /**
     * Unique identifier for this selling plan.
     * Format: plan_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Display name for the selling plan shown to customers.
     * Example: "Premium Monthly", "Annual Subscription"
     */
    @SerializedName("name")
    private String name;

    /**
     * Detailed description of the selling plan explaining its features and benefits.
     * Displayed to customers during plan selection.
     */
    @SerializedName("description")
    private String description;

    /**
     * The type of billing policy for this plan.
     * Values: "RECURRING" for regular interval billing, "PREPAID" for upfront payment.
     */
    @SerializedName("billing_policy_type")
    private String billingPolicyType;

    /**
     * Configuration object containing billing cycle details including:
     * - Billing interval (day, week, month, year)
     * - Interval count (e.g., bill every 2 months)
     * - Minimum and maximum billing cycles
     */
    @SerializedName("billing_policy")
    private BillingPolicyConfig billingPolicy;

    /**
     * List of pricing policies defining price adjustments for different billing cycles.
     * Each policy can specify percentage discounts, fixed amounts, or custom pricing
     * that applies after a certain number of billing cycles.
     * Example: First 3 months at 20% off, then 10% off thereafter.
     */
    @SerializedName("pricing_policy")
    private List<PricingPolicyItem> pricingPolicy;

    /**
     * Number of days in the trial period before billing begins.
     * Stored as string to support flexible formatting.
     * Example: "7" for a 7-day free trial, "0" or null for no trial.
     */
    @SerializedName("trial_period_days")
    private String trialPeriodDays;

    /**
     * Unix timestamp (in seconds) when this selling plan becomes valid and can be used.
     * Plans cannot be subscribed to before this date.
     * Null means valid immediately.
     */
    @SerializedName("valid_from")
    private Long validFrom;

    /**
     * Unix timestamp (in seconds) when this selling plan expires and can no longer be used.
     * Existing subscriptions continue but new subscriptions cannot be created.
     * Null means no expiration date.
     */
    @SerializedName("valid_until")
    private Long validUntil;

    /**
     * Priority value for plan ordering when multiple plans are displayed.
     * Lower values appear first. Stored as string for flexible formatting.
     * Example: "1", "10", "100"
     */
    @SerializedName("priority")
    private String priority;

    /**
     * Current status of the selling plan.
     * Values: "active" (can be used), "disabled" (cannot be used for new subscriptions).
     */
    @SerializedName("status")
    private String status;

    /**
     * Unix timestamp (in seconds) when this selling plan was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when this selling plan was last updated.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Version number for optimistic locking and concurrent update control.
     * Incremented with each update to prevent conflicting modifications.
     */
    @SerializedName("version")
    private Long version;

    public SellingPlan() {
    }

    /**
     * Gets the unique identifier for this selling plan.
     * @return The selling plan ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this selling plan.
     * @param id The selling plan ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the display name for the selling plan.
     * @return The plan name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the display name for the selling plan.
     * @param name The plan name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the detailed description of the selling plan.
     * @return The plan description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the detailed description of the selling plan.
     * @param description The plan description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the billing policy type.
     * @return The billing policy type (RECURRING or PREPAID)
     */
    public String getBillingPolicyType() {
        return billingPolicyType;
    }

    /**
     * Sets the billing policy type.
     * @param billingPolicyType The billing policy type (RECURRING or PREPAID)
     */
    public void setBillingPolicyType(String billingPolicyType) {
        this.billingPolicyType = billingPolicyType;
    }

    /**
     * Gets the billing policy configuration.
     * @return The billing policy configuration object
     */
    public BillingPolicyConfig getBillingPolicy() {
        return billingPolicy;
    }

    /**
     * Sets the billing policy configuration.
     * @param billingPolicy The billing policy configuration object
     */
    public void setBillingPolicy(BillingPolicyConfig billingPolicy) {
        this.billingPolicy = billingPolicy;
    }

    /**
     * Gets the list of pricing policies.
     * @return List of pricing policy items
     */
    public List<PricingPolicyItem> getPricingPolicy() {
        return pricingPolicy;
    }

    /**
     * Sets the list of pricing policies.
     * @param pricingPolicy List of pricing policy items
     */
    public void setPricingPolicy(List<PricingPolicyItem> pricingPolicy) {
        this.pricingPolicy = pricingPolicy;
    }

    /**
     * Gets the trial period duration in days.
     * @return The trial period days as a string
     */
    public String getTrialPeriodDays() {
        return trialPeriodDays;
    }

    /**
     * Sets the trial period duration in days.
     * @param trialPeriodDays The trial period days as a string
     */
    public void setTrialPeriodDays(String trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }

    /**
     * Gets the Unix timestamp when this plan becomes valid.
     * @return The valid from timestamp in seconds, or null for immediate validity
     */
    public Long getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the Unix timestamp when this plan becomes valid.
     * @param validFrom The valid from timestamp in seconds, or null for immediate validity
     */
    public void setValidFrom(Long validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * Gets the Unix timestamp when this plan expires.
     * @return The valid until timestamp in seconds, or null for no expiration
     */
    public Long getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the Unix timestamp when this plan expires.
     * @param validUntil The valid until timestamp in seconds, or null for no expiration
     */
    public void setValidUntil(Long validUntil) {
        this.validUntil = validUntil;
    }

    /**
     * Gets the priority value for plan ordering.
     * @return The priority value as a string
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the priority value for plan ordering.
     * @param priority The priority value as a string
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * Gets the current status of the selling plan.
     * @return The status (active or disabled)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the selling plan.
     * @param status The status (active or disabled)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the Unix timestamp when this plan was created.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Unix timestamp when this plan was created.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the Unix timestamp when this plan was last updated.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the Unix timestamp when this plan was last updated.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets the version number for optimistic locking.
     * @return The version number
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version number for optimistic locking.
     * @param version The version number
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}
