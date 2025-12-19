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
     * <p>
     * Values:
     * <ul>
     *   <li>"always_invoice": Create an invoice immediately for the prorated amount. Customer is charged right away.</li>
     *   <li>"create_prorations": Create proration line items but defer to the next billing cycle (no immediate charge).</li>
     *   <li>"none": No proration calculation. Customer keeps access until period end, new plan starts next cycle.</li>
     * </ul>
     * <p>
     * Default behavior (when not specified):
     * <ul>
     *   <li>Upgrades: "always_invoice" (immediate charge with credit for unused time on old plan)</li>
     *   <li>Downgrades: "none" (no charge, change takes effect at period end)</li>
     * </ul>
     * <p>
     * Scenario Examples:
     * <pre>
     * | Scenario          | proration_behavior | billing_cycle_anchor | Immediate Charge | Credit | Billing Date Changes |
     * |-------------------|-------------------|---------------------|------------------|--------|---------------------|
     * | Immediate Upgrade | always_invoice    | now                 | Yes              | Yes    | Yes (reset to now)  |
     * | Deferred Upgrade  | create_prorations | unchanged           | No               | Yes    | No (keeps date)     |
     * | Downgrade         | none              | (ignored)           | No               | No     | No (period end)     |
     * </pre>
     */
    @SerializedName("proration_behavior")
    private String prorationBehavior;

    /**
     * BillingCycleAnchor controls when the new billing cycle starts after a plan change.
     * <p>
     * Values:
     * <ul>
     *   <li>"now": Reset billing cycle immediately. New period starts from the change time.</li>
     *   <li>"unchanged": Keep current billing cycle anchor. Change takes effect at next period end.</li>
     * </ul>
     * <p>
     * Default behavior (when not specified):
     * <ul>
     *   <li>Upgrades: "now" (billing cycle resets to start fresh)</li>
     *   <li>Downgrades: Always treated as "unchanged" (this parameter is IGNORED for downgrades)</li>
     * </ul>
     * <p>
     * Combined with proration_behavior, this determines upgrade behavior:
     * <ul>
     *   <li>Immediate upgrade: proration_behavior=always_invoice + billing_cycle_anchor=now</li>
     *   <li>Deferred upgrade: proration_behavior=create_prorations + billing_cycle_anchor=unchanged</li>
     * </ul>
     * <p>
     * NOTE: For downgrades, billing_cycle_anchor is always treated as "unchanged" regardless of the value provided.
     * Downgrades always take effect at the current period end.
     */
    @SerializedName("billing_cycle_anchor")
    private String billingCycleAnchor;

    /**
     * ProrationDate is a Unix timestamp (seconds) for custom proration calculation (backdating).
     * When provided, proration credits are calculated as if the plan change happened at this time instead of now.
     * <p>
     * How it works:
     * <ul>
     *   <li>The remaining time on the old plan is calculated from proration_date to current_period_end</li>
     *   <li>Credit = (old_plan_price) × (remaining_time / total_period_time)</li>
     *   <li>This allows backdating: if a customer requested a change yesterday, you can use yesterday's timestamp</li>
     * </ul>
     * <p>
     * Constraints:
     * <ul>
     *   <li>Must be within the current billing period (between current_period_start and current_period_end)</li>
     *   <li>If not specified, current time (now) is used for calculation</li>
     * </ul>
     * <p>
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
