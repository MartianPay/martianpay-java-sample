package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * UpdateSellingPlanGroupRequest represents a request to update an existing selling plan group
 */
public class UpdateSellingPlanGroupRequest {
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

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
