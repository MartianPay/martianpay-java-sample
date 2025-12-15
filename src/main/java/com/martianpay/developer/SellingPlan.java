package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SellingPlan {
    public static final String STATUS_ACTIVE = "active";
    public static final String STATUS_DISABLED = "disabled";

    public static final String BILLING_POLICY_TYPE_RECURRING = "RECURRING";
    public static final String BILLING_POLICY_TYPE_PREPAID = "PREPAID";

    public static final String POLICY_TYPE_FIXED = "FIXED";
    public static final String POLICY_TYPE_RECURRING = "RECURRING";

    public static final String ADJUSTMENT_TYPE_PERCENTAGE = "PERCENTAGE";
    public static final String ADJUSTMENT_TYPE_FIXED_AMOUNT = "FIXED_AMOUNT";
    public static final String ADJUSTMENT_TYPE_PRICE = "PRICE";

    public static final String BILLING_INTERVAL_DAY = "day";
    public static final String BILLING_INTERVAL_WEEK = "week";
    public static final String BILLING_INTERVAL_MONTH = "month";
    public static final String BILLING_INTERVAL_YEAR = "year";

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("billing_policy_type")
    private String billingPolicyType;

    @SerializedName("billing_policy")
    private BillingPolicyConfig billingPolicy;

    @SerializedName("pricing_policy")
    private List<PricingPolicyItem> pricingPolicy;

    @SerializedName("trial_period_days")
    private String trialPeriodDays;

    @SerializedName("valid_from")
    private Long validFrom;

    @SerializedName("valid_until")
    private Long validUntil;

    @SerializedName("priority")
    private String priority;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("version")
    private Long version;

    public SellingPlan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillingPolicyType() {
        return billingPolicyType;
    }

    public void setBillingPolicyType(String billingPolicyType) {
        this.billingPolicyType = billingPolicyType;
    }

    public BillingPolicyConfig getBillingPolicy() {
        return billingPolicy;
    }

    public void setBillingPolicy(BillingPolicyConfig billingPolicy) {
        this.billingPolicy = billingPolicy;
    }

    public List<PricingPolicyItem> getPricingPolicy() {
        return pricingPolicy;
    }

    public void setPricingPolicy(List<PricingPolicyItem> pricingPolicy) {
        this.pricingPolicy = pricingPolicy;
    }

    public String getTrialPeriodDays() {
        return trialPeriodDays;
    }

    public void setTrialPeriodDays(String trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }

    public Long getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Long validFrom) {
        this.validFrom = validFrom;
    }

    public Long getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Long validUntil) {
        this.validUntil = validUntil;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
