package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * CreateSellingPlanGroupRequest represents a request to create a new selling plan group
 */
public class CreateSellingPlanGroupRequest {
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
     * Options is the list of option names for the selling plan group (e.g., ["Size", "Color"])
     */
    @SerializedName("options")
    private List<String> options;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getOptions() { return options; }
    public void setOptions(List<String> options) { this.options = options; }
}
