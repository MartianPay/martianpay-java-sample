package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to update an existing selling plan.
 */
public class UpdateSellingPlanRequest {
    /**
     * Name of the selling plan.
     */
    @SerializedName("name")
    private String name;

    /**
     * Description of the selling plan.
     */
    @SerializedName("description")
    private String description;

    /**
     * Billing policy type ("RECURRING" or "PREPAID").
     */
    @SerializedName("billing_policy_type")
    private String billingPolicyType;

    /**
     * Billing policy configuration.
     */
    @SerializedName("billing_policy")
    private BillingPolicyRequest billingPolicy;

    /**
     * Pricing policy configuration.
     */
    @SerializedName("pricing_policy")
    private List<PricingPolicyItemRequest> pricingPolicy;

    /**
     * Trial period in days.
     */
    @SerializedName("trial_period_days")
    private String trialPeriodDays;

    /**
     * Unix timestamp when the plan becomes valid (seconds).
     */
    @SerializedName("valid_from")
    private Long validFrom;

    /**
     * Unix timestamp when the plan expires (seconds).
     */
    @SerializedName("valid_until")
    private Long validUntil;

    /**
     * Priority of this plan.
     */
    @SerializedName("priority")
    private String priority;

    /**
     * Current status ("active" or "disabled").
     */
    @SerializedName("status")
    private String status;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBillingPolicyType() { return billingPolicyType; }
    public void setBillingPolicyType(String billingPolicyType) { this.billingPolicyType = billingPolicyType; }

    public BillingPolicyRequest getBillingPolicy() { return billingPolicy; }
    public void setBillingPolicy(BillingPolicyRequest billingPolicy) { this.billingPolicy = billingPolicy; }

    public List<PricingPolicyItemRequest> getPricingPolicy() { return pricingPolicy; }
    public void setPricingPolicy(List<PricingPolicyItemRequest> pricingPolicy) { this.pricingPolicy = pricingPolicy; }

    public String getTrialPeriodDays() { return trialPeriodDays; }
    public void setTrialPeriodDays(String trialPeriodDays) { this.trialPeriodDays = trialPeriodDays; }

    public Long getValidFrom() { return validFrom; }
    public void setValidFrom(Long validFrom) { this.validFrom = validFrom; }

    public Long getValidUntil() { return validUntil; }
    public void setValidUntil(Long validUntil) { this.validUntil = validUntil; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
