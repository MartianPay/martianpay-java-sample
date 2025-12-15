package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanGroupResponse represents a selling plan group in a response
 */
public class SellingPlanGroupResponse {
    /**
     * ID is the unique identifier for the selling plan group
     */
    @SerializedName("id")
    private String id;

    /**
     * MerchantID is the merchant ID who owns this group
     */
    @SerializedName("merchant_id")
    private String merchantID;

    /**
     * Name is the name of the selling plan group
     */
    @SerializedName("name")
    private String name;

    /**
     * Description is the description of the selling plan group
     */
    @SerializedName("description")
    private String description;

    /**
     * Options is the list of option names for the selling plan group
     */
    @SerializedName("options")
    private List<String> options;

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

    /**
     * SellingPlans is the list of associated selling plans (included if requested)
     */
    @SerializedName("selling_plans")
    private List<SellingPlanResponse> sellingPlans;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMerchantID() { return merchantID; }
    public void setMerchantID(String merchantID) { this.merchantID = merchantID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public List<SellingPlanResponse> getSellingPlans() { return sellingPlans; }
    public void setSellingPlans(List<SellingPlanResponse> sellingPlans) { this.sellingPlans = sellingPlans; }
}
