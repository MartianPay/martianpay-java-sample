package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * SellingPlanGroupWithPlans represents a Selling Plan Group with associated Plans
 */
public class SellingPlanGroupWithPlans {
    /**
     * ID is the unique identifier for the selling plan group
     */
    @SerializedName("id")
    private String id;

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
     * Options is the list of option names
     */
    @SerializedName("options")
    private List<String> options;

    /**
     * Status is the current status of the selling plan group
     */
    @SerializedName("status")
    private String status;

    /**
     * SellingPlans is the list of associated selling plans
     */
    @SerializedName("selling_plans")
    private List<SellingPlan> sellingPlans;

    public SellingPlanGroupWithPlans() {
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SellingPlan> getSellingPlans() {
        return sellingPlans;
    }

    public void setSellingPlans(List<SellingPlan> sellingPlans) {
        this.sellingPlans = sellingPlans;
    }
}
