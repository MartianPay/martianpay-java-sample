package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanGroupResponse represents a selling plan group returned in API responses.
 *
 * A selling plan group is a collection of related subscription/billing plans that share
 * common characteristics. Groups help organize multiple plans and allow customers to
 * choose between different billing options (e.g., monthly vs. annual).
 *
 * Use cases:
 * - Organizing multiple subscription tiers (Basic, Pro, Enterprise)
 * - Grouping billing frequency options (Monthly, Quarterly, Yearly)
 * - Managing promotional plans separate from standard plans
 * - Creating product-specific subscription bundles
 *
 * Example: A "Premium Subscription" group might contain three plans:
 * - Premium Monthly (billed monthly at $29.99)
 * - Premium Quarterly (billed every 3 months at $79.99)
 * - Premium Annual (billed yearly at $299.99)
 *
 * The response optionally includes the associated selling plans if requested
 * via the API's include parameter.
 */
public class SellingPlanGroupResponse {
    /**
     * Unique identifier for this selling plan group.
     * Format: spg_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * ID of the merchant who owns this selling plan group.
     * Used for multi-tenant access control and filtering.
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * Display name of the selling plan group shown to customers.
     * Example: "Premium Subscription Options", "Basic Membership Plans"
     */
    @SerializedName("name")
    private String name;

    /**
     * Detailed description explaining the purpose and benefits of this plan group.
     * Helps customers understand the differences between plan groups.
     */
    @SerializedName("description")
    private String description;

    /**
     * List of option names that categorize or label the plans within this group.
     * Used for filtering and display organization.
     * Example: ["Billing Frequency", "Commitment Period"]
     */
    @SerializedName("options")
    private List<String> options;

    /**
     * Current status of the selling plan group.
     * Values: "active" (visible and usable), "disabled" (hidden from customers).
     */
    @SerializedName("status")
    private String status;

    /**
     * Unix timestamp (in seconds) when this selling plan group was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when this selling plan group was last updated.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * List of selling plans associated with this group.
     * Only populated when explicitly requested via API include parameters.
     * Null or empty if not requested or if no plans exist in the group.
     */
    @SerializedName("selling_plans")
    private List<SellingPlanResponse> sellingPlans;

    /**
     * Gets the unique identifier for this selling plan group.
     * @return The selling plan group ID
     */
    public String getId() { return id; }

    /**
     * Sets the unique identifier for this selling plan group.
     * @param id The selling plan group ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets the merchant ID who owns this group.
     * @return The merchant ID
     */
    public String getMerchantID() { return merchantID; }

    /**
     * Sets the merchant ID who owns this group.
     * @param merchantID The merchant ID
     */
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    /**
     * Gets the display name of the selling plan group.
     * @return The group name
     */
    public String getName() { return name; }

    /**
     * Sets the display name of the selling plan group.
     * @param name The group name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the detailed description of the selling plan group.
     * @return The group description
     */
    public String getDescription() { return description; }

    /**
     * Sets the detailed description of the selling plan group.
     * @param description The group description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the list of option names for categorizing plans.
     * @return List of option names
     */
    public List<String> getOptions() { return options; }

    /**
     * Sets the list of option names for categorizing plans.
     * @param options List of option names
     */
    public void setOptions(List<String> options) { this.options = options; }

    /**
     * Gets the current status of the selling plan group.
     * @return The status (active or disabled)
     */
    public String getStatus() { return status; }

    /**
     * Sets the current status of the selling plan group.
     * @param status The status (active or disabled)
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Gets the Unix timestamp when this group was created.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() { return createdAt; }

    /**
     * Sets the Unix timestamp when this group was created.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    /**
     * Gets the Unix timestamp when this group was last updated.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() { return updatedAt; }

    /**
     * Sets the Unix timestamp when this group was last updated.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Gets the list of selling plans in this group.
     * @return List of selling plan responses, or null if not included
     */
    public List<SellingPlanResponse> getSellingPlans() { return sellingPlans; }

    /**
     * Sets the list of selling plans in this group.
     * @param sellingPlans List of selling plan responses
     */
    public void setSellingPlans(List<SellingPlanResponse> sellingPlans) { this.sellingPlans = sellingPlans; }
}
