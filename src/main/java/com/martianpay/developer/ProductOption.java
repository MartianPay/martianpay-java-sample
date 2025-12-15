package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * ProductOption represents a product option (e.g., Color, Size)
 */
public class ProductOption {
    /**
     * Name is the option name (e.g., "Color")
     */
    @SerializedName("name")
    private String name;

    /**
     * SortOrder is the optional order for display
     */
    @SerializedName("sort_order")
    private Integer sortOrder;

    /**
     * Values is the list of allowed values for this option
     */
    @SerializedName("values")
    private List<ProductOptionValue> values;

    /**
     * Metadata contains optional metadata
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    public ProductOption() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public List<ProductOptionValue> getValues() {
        return values;
    }

    public void setValues(List<ProductOptionValue> values) {
        this.values = values;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
