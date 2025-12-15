package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * ProductOptionValue represents a single value for a product option
 */
public class ProductOptionValue {
    /**
     * Value is the option value label
     */
    @SerializedName("value")
    private String value;

    /**
     * SortOrder is the optional order for display
     */
    @SerializedName("sort_order")
    private Integer sortOrder;

    /**
     * Swatch is the optional swatch metadata
     */
    @SerializedName("swatch")
    private ProductOptionSwatch swatch;

    /**
     * Metadata contains additional metadata
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    public ProductOptionValue() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public ProductOptionSwatch getSwatch() {
        return swatch;
    }

    public void setSwatch(ProductOptionSwatch swatch) {
        this.swatch = swatch;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
