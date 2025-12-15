package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanResponse represents a selling plan in a response
 */
public class SellingPlanResponse {
    /**
     * ID is the unique identifier for the selling plan
     */
    @SerializedName("id")
    private String id;

    /**
     * SellingPlanGroupID is the ID of the selling plan group this plan belongs to
     */
    @SerializedName("selling_plan_group_id")
    private String sellingPlanGroupID;

    /**
     * MerchantID is the merchant ID who owns this plan
     */
    @SerializedName("merchant_id")
    private String merchantID;

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
    private BillingPolicyConfig billingPolicy;

    /**
     * PricingPolicy is the pricing policy configuration
     */
    @SerializedName("pricing_policy")
    private List<PricingPolicyItem> pricingPolicy;

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

    /**
     * Status is the current status ("active" | "disabled")
     */
    @SerializedName("status")
    private String status;

    /**
     * CreatedAt is the Unix timestamp when created (seconds)
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * UpdatedAt is the Unix timestamp when last updated (seconds)
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSellingPlanGroupID() { return sellingPlanGroupID; }
    public void setSellingPlanGroupID(String sellingPlanGroupID) { this.sellingPlanGroupID = sellingPlanGroupID; }

    public String getMerchantID() { return merchantID; }
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getBillingPolicyType() { return billingPolicyType; }
    public void setBillingPolicyType(String billingPolicyType) { this.billingPolicyType = billingPolicyType; }

    public BillingPolicyConfig getBillingPolicy() { return billingPolicy; }
    public void setBillingPolicy(BillingPolicyConfig billingPolicy) { this.billingPolicy = billingPolicy; }

    public List<PricingPolicyItem> getPricingPolicy() { return pricingPolicy; }
    public void setPricingPolicy(List<PricingPolicyItem> pricingPolicy) { this.pricingPolicy = pricingPolicy; }

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

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }
}
