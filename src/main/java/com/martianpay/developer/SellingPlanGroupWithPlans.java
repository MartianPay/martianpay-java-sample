package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanGroupWithPlans represents a selling plan group with its associated selling plans.
 *
 * This class combines a selling plan group with the full details of all plans within that group.
 * Unlike SellingPlanGroupResponse which may optionally include plans, this class always contains
 * the complete plan information as SellingPlan objects (not just SellingPlanResponse).
 *
 * Use cases:
 * - Retrieving a complete view of a plan group with all plan details for display
 * - Building subscription selection interfaces with full pricing information
 * - Exporting or syncing plan configurations to external systems
 * - Creating plan comparison tables showing all available options
 *
 * Example: A "Membership Plans" group containing:
 * - Basic Monthly: $9.99/month with limited features
 * - Pro Monthly: $29.99/month with full features
 * - Enterprise Annual: $299/year with custom support
 *
 * The group metadata (name, description, status) plus complete plan details
 * are all included in a single object for convenience.
 */
public class SellingPlanGroupWithPlans {
    /**
     * Unique identifier for this selling plan group.
     * Format: spg_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Display name of the selling plan group shown to customers.
     * Example: "Subscription Options", "Membership Tiers"
     */
    @SerializedName("name")
    private String name;

    /**
     * Detailed description explaining what this group of plans offers.
     * Helps customers understand the purpose and benefits of the plans in this group.
     */
    @SerializedName("description")
    private String description;

    /**
     * List of option names used to categorize and label the plans.
     * These options help organize how plans are displayed and filtered.
     * Example: ["Duration", "Billing Frequency", "Feature Level"]
     */
    @SerializedName("options")
    private List<String> options;

    /**
     * Current status of the selling plan group.
     * Values: "active" (visible and available), "disabled" (hidden from customers).
     */
    @SerializedName("status")
    private String status;

    /**
     * Complete list of selling plans within this group.
     * Contains full SellingPlan objects with all configuration details including
     * billing policies, pricing policies, trial periods, and validity dates.
     * Never null - will be an empty list if no plans exist.
     */
    @SerializedName("selling_plans")
    private List<SellingPlan> sellingPlans;

    public SellingPlanGroupWithPlans() {
    }

    /**
     * Gets the unique identifier for this selling plan group.
     * @return The selling plan group ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this selling plan group.
     * @param id The selling plan group ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the display name of the selling plan group.
     * @return The group name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the display name of the selling plan group.
     * @param name The group name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the detailed description of the selling plan group.
     * @return The group description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the detailed description of the selling plan group.
     * @param description The group description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of option names for categorizing plans.
     * @return List of option names
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * Sets the list of option names for categorizing plans.
     * @param options List of option names
     */
    public void setOptions(List<String> options) {
        this.options = options;
    }

    /**
     * Gets the current status of the selling plan group.
     * @return The status (active or disabled)
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the selling plan group.
     * @param status The status (active or disabled)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the list of selling plans in this group.
     * @return List of complete selling plan objects
     */
    public List<SellingPlan> getSellingPlans() {
        return sellingPlans;
    }

    /**
     * Sets the list of selling plans in this group.
     * @param sellingPlans List of complete selling plan objects
     */
    public void setSellingPlans(List<SellingPlan> sellingPlans) {
        this.sellingPlans = sellingPlans;
    }
}
