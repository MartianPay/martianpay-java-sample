package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Request to update an existing selling plan group.
 */
public class UpdateSellingPlanGroupRequest {
    /**
     * Name of the selling plan group.
     */
    @SerializedName("name")
    private String name;

    /**
     * Description of the selling plan group.
     */
    @SerializedName("description")
    private String description;

    /**
     * List of option names for the selling plan group.
     */
    @SerializedName("options")
    private List<String> options;

    /**
     * Current status ("active" or "disabled").
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
