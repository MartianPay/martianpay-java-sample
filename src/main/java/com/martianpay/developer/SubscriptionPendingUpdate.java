package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * SubscriptionPendingUpdate represents a scheduled subscription change (e.g., downgrade at period end)
 */
public class SubscriptionPendingUpdate {
    @SerializedName("target_selling_plan_id")
    private String targetSellingPlanId;

    @SerializedName("target_selling_plan_name")
    private String targetSellingPlanName;

    @SerializedName("target_variant_id")
    private String targetVariantId;

    @SerializedName("target_variant_title")
    private String targetVariantTitle;

    @SerializedName("target_variant_price")
    private String targetVariantPrice;

    @SerializedName("target_variant_option_values")
    private Map<String, String> targetVariantOptionValues;

    @SerializedName("next_charge_amount")
    private String nextChargeAmount;

    @SerializedName("change_type")
    private String changeType;

    @SerializedName("effective_date")
    private Long effectiveDate;

    @SerializedName("proration_behavior")
    private String prorationBehavior;

    @SerializedName("billing_cycle_anchor")
    private String billingCycleAnchor;

    @SerializedName("proration_date")
    private Long prorationDate;

    @SerializedName("metadata")
    private Map<String, Object> metadata;

    @SerializedName("scheduled_at")
    private Long scheduledAt;

    public SubscriptionPendingUpdate() {
    }

    public String getTargetSellingPlanId() {
        return targetSellingPlanId;
    }

    public void setTargetSellingPlanId(String targetSellingPlanId) {
        this.targetSellingPlanId = targetSellingPlanId;
    }

    public String getTargetSellingPlanName() {
        return targetSellingPlanName;
    }

    public void setTargetSellingPlanName(String targetSellingPlanName) {
        this.targetSellingPlanName = targetSellingPlanName;
    }

    public String getTargetVariantId() {
        return targetVariantId;
    }

    public void setTargetVariantId(String targetVariantId) {
        this.targetVariantId = targetVariantId;
    }

    public String getTargetVariantTitle() {
        return targetVariantTitle;
    }

    public void setTargetVariantTitle(String targetVariantTitle) {
        this.targetVariantTitle = targetVariantTitle;
    }

    public String getTargetVariantPrice() {
        return targetVariantPrice;
    }

    public void setTargetVariantPrice(String targetVariantPrice) {
        this.targetVariantPrice = targetVariantPrice;
    }

    public Map<String, String> getTargetVariantOptionValues() {
        return targetVariantOptionValues;
    }

    public void setTargetVariantOptionValues(Map<String, String> targetVariantOptionValues) {
        this.targetVariantOptionValues = targetVariantOptionValues;
    }

    public String getNextChargeAmount() {
        return nextChargeAmount;
    }

    public void setNextChargeAmount(String nextChargeAmount) {
        this.nextChargeAmount = nextChargeAmount;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Long getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Long effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getProrationBehavior() {
        return prorationBehavior;
    }

    public void setProrationBehavior(String prorationBehavior) {
        this.prorationBehavior = prorationBehavior;
    }

    public String getBillingCycleAnchor() {
        return billingCycleAnchor;
    }

    public void setBillingCycleAnchor(String billingCycleAnchor) {
        this.billingCycleAnchor = billingCycleAnchor;
    }

    public Long getProrationDate() {
        return prorationDate;
    }

    public void setProrationDate(Long prorationDate) {
        this.prorationDate = prorationDate;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public Long getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Long scheduledAt) {
        this.scheduledAt = scheduledAt;
    }
}
