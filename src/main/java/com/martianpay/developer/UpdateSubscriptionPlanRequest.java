package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * UpdateSubscriptionPlanRequest updates or previews a subscription plan change (upgrade/downgrade).
 * This request type is used by both update and preview endpoints.
 */
public class UpdateSubscriptionPlanRequest {

    /**
     * PrimaryVariant is the primary variant selection to update
     */
    @SerializedName("primary_variant")
    private SubscriptionItemUpdate primaryVariant;

    /**
     * Addons is the optional list of addon variant selections (reserved for future use)
     */
    @SerializedName("addons")
    private List<SubscriptionItemUpdate> addons;

    /**
     * ProrationBehavior controls how proration charges are handled during plan changes.
     *
     * Values:
     * - "always_invoice": Create an invoice immediately for the prorated amount. Customer is charged right away.
     * - "create_prorations": Defer the plan change to next billing cycle (used for deferred upgrades).
     * - "none": No proration calculation. Only valid for downgrades.
     *
     * Default behavior (when not specified):
     * - Upgrades: "always_invoice" (immediate charge with credit for unused time on old plan)
     * - Downgrades: "none" (no charge, change takes effect at period end)
     *
     * VALID COMBINATIONS (other combinations return error "invalid_proration_config"):
     *
     * For UPGRADES (3 valid combinations):
     * | proration_behavior | billing_cycle_anchor | Result                                          |
     * |-------------------|---------------------|--------------------------------------------------|
     * | always_invoice    | now                 | Immediate upgrade, charge now, reset cycle       |
     * | always_invoice    | unchanged           | Immediate upgrade, charge now, keep cycle        |
     * | create_prorations | unchanged           | Deferred upgrade, change at period end           |
     *
     * For DOWNGRADES (1 valid combination):
     * | proration_behavior | billing_cycle_anchor | Result                                          |
     * |-------------------|---------------------|--------------------------------------------------|
     * | none              | unchanged           | Deferred downgrade, change at period end         |
     *
     * INVALID COMBINATIONS (return error):
     * - create_prorations + now: Would reset cycle without settling, customer credit lost
     * - none + now/unchanged (upgrade): Would give customer free upgrade
     * - any + now (downgrade): Downgrade cannot take effect immediately
     */
    @SerializedName("proration_behavior")
    private String prorationBehavior;

    /**
     * BillingCycleAnchor controls when the new billing cycle starts after a plan change.
     *
     * Values:
     * - "now": Reset billing cycle immediately. New period starts from the change time.
     * - "unchanged": Keep current billing cycle anchor.
     *
     * Default behavior (when not specified):
     * - Upgrades: "now" (billing cycle resets to start fresh)
     * - Downgrades: Must be "unchanged" (downgrades always take effect at period end)
     *
     * NOTE: For downgrades, only "unchanged" is valid. Using "now" will return an error.
     * See proration_behavior documentation for valid combinations.
     */
    @SerializedName("billing_cycle_anchor")
    private String billingCycleAnchor;

    /**
     * ProrationDate is a Unix timestamp (seconds) for custom proration calculation (backdating).
     * When provided, proration credits are calculated as if the plan change happened at this time instead of now.
     *
     * How it works:
     * - The remaining time on the old plan is calculated from proration_date to current_period_end
     * - Credit = (old_plan_price) × (remaining_time / total_period_time)
     * - This allows backdating: if a customer requested a change yesterday, you can use yesterday's timestamp
     *
     * Constraints:
     * - Must be within the current billing period (between current_period_start and current_period_end)
     * - If not specified, current time (now) is used for calculation
     *
     * Example: If period is Dec 1-31 and proration_date is Dec 15, customer gets credit for 16 remaining days.
     */
    @SerializedName("proration_date")
    private Long prorationDate;

    /**
     * Metadata is a set of key-value pairs for storing additional information (ignored in preview)
     */
    @SerializedName("metadata")
    private Map<String, Object> metadata;

    // Proration behavior constants

    /** Create invoice immediately with proration */
    public static final String PRORATION_ALWAYS_INVOICE = "always_invoice";
    /** Create proration items added to next invoice */
    public static final String PRORATION_CREATE_PRORATIONS = "create_prorations";
    /** Do not create any proration */
    public static final String PRORATION_NONE = "none";

    // Billing cycle anchor constants

    /** Reset billing cycle to current time */
    public static final String BILLING_ANCHOR_NOW = "now";
    /** Keep existing billing cycle date */
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
