package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * CreateSellingPlanRequest represents a request to create a new selling plan
 */
public class CreateSellingPlanRequest {
    /**
     * SellingPlanGroupID is the ID of the selling plan group this plan belongs to
     */
    @SerializedName("selling_plan_group_id")
    private String sellingPlanGroupID;

    /**
     * Name is the name of the selling plan
     */
    @SerializedName("name")
    private String name;

    /**
     * Description is the description of the selling plan
     */
    @SerializedName("description")
    private String description;

    /**
     * BillingPolicyType is the billing policy type ("RECURRING" | "PREPAID")
     */
    @SerializedName("billing_policy_type")
    private String billingPolicyType;

    /**
     * BillingPolicy contains the billing policy configuration
     */
    @SerializedName("billing_policy")
    private BillingPolicyRequest billingPolicy;

    /**
     * PricingPolicy is the pricing policy (optional, following Shopify practice)
     */
    @SerializedName("pricing_policy")
    private List<PricingPolicyItemRequest> pricingPolicy;

    /**
     * TrialPeriodDays is the trial period in days (string format)
     */
    @SerializedName("trial_period_days")
    private String trialPeriodDays;

    /**
     * ValidFrom is the Unix timestamp when the plan becomes valid (seconds)
     */
    @SerializedName("valid_from")
    private Long validFrom;

    /**
     * ValidUntil is the Unix timestamp when the plan expires (seconds)
     */
    @SerializedName("valid_until")
    private Long validUntil;

    /**
     * Priority is the priority of this plan (string format)
     */
    @SerializedName("priority")
    private String priority;

    // Getters and Setters
    public String getSellingPlanGroupID() { return sellingPlanGroupID; }
    public void setSellingPlanGroupID(String sellingPlanGroupID) { this.sellingPlanGroupID = sellingPlanGroupID; }

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
}
