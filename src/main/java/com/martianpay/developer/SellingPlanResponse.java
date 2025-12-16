package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanResponse represents a selling plan returned in API responses.
 *
 * This class contains the complete details of a subscription/billing plan as returned
 * by the MartianPay API. It includes all configuration details needed to understand
 * how the plan works, including billing policies, pricing policies, trial periods,
 * validity dates, and current status.
 *
 * Use cases:
 * - Displaying available subscription options to customers
 * - Retrieving plan details after creation or update operations
 * - Showing plan information in admin interfaces
 * - Comparing multiple plans to help customers choose
 *
 * Example: A "Pro Monthly" plan response might show:
 * - Billing: Every 1 month, recurring
 * - Pricing: 15% discount from regular price
 * - Trial: 14 days free
 * - Status: Active
 * - Valid: From 2024-01-01 to 2024-12-31
 *
 * This response object includes both the merchant ID and selling plan group ID
 * to provide context about ownership and organization.
 */
public class SellingPlanResponse {
    /**
     * Unique identifier for this selling plan.
     * Format: plan_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * ID of the selling plan group this plan belongs to.
     * Groups related plans together for organization and display.
     * Format: spg_[random_id]
     */
    @SerializedName("selling_plan_group_id")
    private String sellingPlanGroupID;

    /**
     * ID of the merchant who owns this selling plan.
     * Used for multi-tenant access control and data isolation.
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * Display name of the selling plan shown to customers.
     * Example: "Premium Monthly", "Enterprise Annual"
     */
    @SerializedName("name")
    private String name;

    /**
     * Detailed description explaining the plan's features and benefits.
     * Helps customers understand what they're subscribing to.
     */
    @SerializedName("description")
    private String description;

    /**
     * Type of billing policy for this plan.
     * Values: "RECURRING" (regular interval billing), "PREPAID" (upfront payment for multiple cycles).
     */
    @SerializedName("billing_policy_type")
    private String billingPolicyType;

    /**
     * Configuration object defining the billing cycle details.
     * Includes billing interval, interval count, and min/max cycles.
     */
    @SerializedName("billing_policy")
    private BillingPolicyConfig billingPolicy;

    /**
     * List of pricing policies defining price adjustments over time.
     * Each policy can specify discounts or custom pricing for different billing cycles.
     */
    @SerializedName("pricing_policy")
    private List<PricingPolicyItem> pricingPolicy;

    /**
     * Number of days in the trial period before billing begins.
     * Stored as string for flexible formatting.
     * "0" or null indicates no trial period.
     */
    @SerializedName("trial_period_days")
    private String trialPeriodDays;

    /**
     * Unix timestamp (in seconds) when this plan becomes valid.
     * Customers cannot subscribe before this date.
     * Null means the plan is immediately valid.
     */
    @SerializedName("valid_from")
    private Long validFrom;

    /**
     * Unix timestamp (in seconds) when this plan expires.
     * No new subscriptions allowed after this date (existing continue).
     * Null means the plan never expires.
     */
    @SerializedName("valid_until")
    private Long validUntil;

    /**
     * Priority value for ordering plans when displayed to customers.
     * Lower values appear first. Stored as string for flexibility.
     * Example: "1", "10", "100"
     */
    @SerializedName("priority")
    private String priority;

    /**
     * Current status of the selling plan.
     * Values: "active" (available for new subscriptions), "disabled" (hidden from customers).
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
     * Gets the unique identifier for this selling plan.
     * @return The selling plan ID
     */
    public String getId() { return id; }

    /**
     * Sets the unique identifier for this selling plan.
     * @param id The selling plan ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets the ID of the selling plan group this plan belongs to.
     * @return The selling plan group ID
     */
    public String getSellingPlanGroupID() { return sellingPlanGroupID; }

    /**
     * Sets the ID of the selling plan group this plan belongs to.
     * @param sellingPlanGroupID The selling plan group ID
     */
    public void setSellingPlanGroupID(String sellingPlanGroupID) { this.sellingPlanGroupID = sellingPlanGroupID; }

    /**
     * Gets the merchant ID who owns this plan.
     * @return The merchant ID
     */
    public String getMerchantID() { return merchantID; }

    /**
     * Sets the merchant ID who owns this plan.
     * @param merchantID The merchant ID
     */
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    /**
     * Gets the display name of the selling plan.
     * @return The plan name
     */
    public String getName() { return name; }

    /**
     * Sets the display name of the selling plan.
     * @param name The plan name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the detailed description of the plan.
     * @return The plan description
     */
    public String getDescription() { return description; }

    /**
     * Sets the detailed description of the plan.
     * @param description The plan description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the billing policy type.
     * @return The billing policy type (RECURRING or PREPAID)
     */
    public String getBillingPolicyType() { return billingPolicyType; }

    /**
     * Sets the billing policy type.
     * @param billingPolicyType The billing policy type (RECURRING or PREPAID)
     */
    public void setBillingPolicyType(String billingPolicyType) { this.billingPolicyType = billingPolicyType; }

    /**
     * Gets the billing policy configuration.
     * @return The billing policy configuration object
     */
    public BillingPolicyConfig getBillingPolicy() { return billingPolicy; }

    /**
     * Sets the billing policy configuration.
     * @param billingPolicy The billing policy configuration object
     */
    public void setBillingPolicy(BillingPolicyConfig billingPolicy) { this.billingPolicy = billingPolicy; }

    /**
     * Gets the list of pricing policies.
     * @return List of pricing policy items
     */
    public List<PricingPolicyItem> getPricingPolicy() { return pricingPolicy; }

    /**
     * Sets the list of pricing policies.
     * @param pricingPolicy List of pricing policy items
     */
    public void setPricingPolicy(List<PricingPolicyItem> pricingPolicy) { this.pricingPolicy = pricingPolicy; }

    /**
     * Gets the trial period duration in days.
     * @return The trial period days as a string
     */
    public String getTrialPeriodDays() { return trialPeriodDays; }

    /**
     * Sets the trial period duration in days.
     * @param trialPeriodDays The trial period days as a string
     */
    public void setTrialPeriodDays(String trialPeriodDays) { this.trialPeriodDays = trialPeriodDays; }

    /**
     * Gets the Unix timestamp when this plan becomes valid.
     * @return The valid from timestamp in seconds, or null for immediate validity
     */
    public Long getValidFrom() { return validFrom; }

    /**
     * Sets the Unix timestamp when this plan becomes valid.
     * @param validFrom The valid from timestamp in seconds, or null for immediate validity
     */
    public void setValidFrom(Long validFrom) { this.validFrom = validFrom; }

    /**
     * Gets the Unix timestamp when this plan expires.
     * @return The valid until timestamp in seconds, or null for no expiration
     */
    public Long getValidUntil() { return validUntil; }

    /**
     * Sets the Unix timestamp when this plan expires.
     * @param validUntil The valid until timestamp in seconds, or null for no expiration
     */
    public void setValidUntil(Long validUntil) { this.validUntil = validUntil; }

    /**
     * Gets the priority value for plan ordering.
     * @return The priority value as a string
     */
    public String getPriority() { return priority; }

    /**
     * Sets the priority value for plan ordering.
     * @param priority The priority value as a string
     */
    public void setPriority(String priority) { this.priority = priority; }

    /**
     * Gets the current status of the selling plan.
     * @return The status (active or disabled)
     */
    public String getStatus() { return status; }

    /**
     * Sets the current status of the selling plan.
     * @param status The status (active or disabled)
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Gets the Unix timestamp when this plan was created.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() { return createdAt; }

    /**
     * Sets the Unix timestamp when this plan was created.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    /**
     * Gets the Unix timestamp when this plan was last updated.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() { return updatedAt; }

    /**
     * Sets the Unix timestamp when this plan was last updated.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }
}
