package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SellingPlanPricing {
    @SerializedName("selling_plan_id")
    private String sellingPlanId;

    @SerializedName("selling_plan_name")
    private String sellingPlanName;

    @SerializedName("billing_cycle")
    private String billingCycle;

    @SerializedName("currency")
    private String currency;

    @SerializedName("trial_period_days")
    private Integer trialPeriodDays;

    @SerializedName("pricing_tiers")
    private List<PricingTier> pricingTiers;

    public SellingPlanPricing() {
    }

    public String getSellingPlanId() {
        return sellingPlanId;
    }

    public void setSellingPlanId(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
    }

    public String getSellingPlanName() {
        return sellingPlanName;
    }

    public void setSellingPlanName(String sellingPlanName) {
        this.sellingPlanName = sellingPlanName;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTrialPeriodDays() {
        return trialPeriodDays;
    }

    public void setTrialPeriodDays(Integer trialPeriodDays) {
        this.trialPeriodDays = trialPeriodDays;
    }

    public List<PricingTier> getPricingTiers() {
        return pricingTiers;
    }

    public void setPricingTiers(List<PricingTier> pricingTiers) {
        this.pricingTiers = pricingTiers;
    }
}
