package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * UpdateSubscriptionPlanRequest updates or previews a subscription plan change (upgrade/downgrade)
 * This request type is used by both update and preview endpoints
 */
public class UpdateSubscriptionPlanRequest {
    @SerializedName("primary_variant")
    private SubscriptionItemUpdate primaryVariant;

    @SerializedName("addons")
    private List<SubscriptionItemUpdate> addons;

    @SerializedName("proration_behavior")
    private String prorationBehavior;

    @SerializedName("billing_cycle_anchor")
    private String billingCycleAnchor;

    @SerializedName("proration_date")
    private Long prorationDate;

    @SerializedName("metadata")
    private Map<String, Object> metadata;

    // Proration behavior constants
    public static final String PRORATION_ALWAYS_INVOICE = "always_invoice";
    public static final String PRORATION_CREATE_PRORATIONS = "create_prorations";
    public static final String PRORATION_NONE = "none";

    // Billing cycle anchor constants
    public static final String BILLING_ANCHOR_NOW = "now";
    public static final String BILLING_ANCHOR_UNCHANGED = "unchanged";

    public UpdateSubscriptionPlanRequest() {
    }

    public SubscriptionItemUpdate getPrimaryVariant() {
        return primaryVariant;
    }

    public void setPrimaryVariant(SubscriptionItemUpdate primaryVariant) {
        this.primaryVariant = primaryVariant;
    }

    public List<SubscriptionItemUpdate> getAddons() {
        return addons;
    }

    public void setAddons(List<SubscriptionItemUpdate> addons) {
        this.addons = addons;
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
}
