package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * ProductVariant represents a specific variant of a product
 */
public class ProductVariant {
    /**
     * ID is the unique identifier for the variant
     */
    @SerializedName("id")
    private String id;

    /**
     * OptionValues contains the selected option value per option name
     */
    @SerializedName("option_values")
    private Map<String, String> optionValues;

    /**
     * Price is the variant price
     */
    @SerializedName("price")
    private AssetAmount price;

    /**
     * MediaOrder contains ordered media asset IDs for the variant
     */
    @SerializedName("media_order")
    private List<String> mediaOrder;

    /**
     * InventoryQuantity is the optional inventory quantity
     */
    @SerializedName("inventory_quantity")
    private Integer inventoryQuantity;

    /**
     * Active indicates if the variant is active/available
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * Version is the catalog version that produced this variant
     */
    @SerializedName("version")
    private Long version;

    /**
     * SellingPlanGroupIDs contains variant-level selling plan group associations
     */
    @SerializedName("selling_plan_group_ids")
    private List<String> sellingPlanGroupIds;

    /**
     * SellingPlanGroups contains expanded selling plan groups with plans (only populated when variant has override)
     */
    @SerializedName("selling_plan_groups")
    private List<SellingPlanGroupWithPlans> sellingPlanGroups;

    /**
     * SellingPlanPricing contains pre-calculated subscription pricing per selling plan
     */
    @SerializedName("selling_plan_pricing")
    private List<SellingPlanPricing> sellingPlanPricing;

    public ProductVariant() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getOptionValues() {
        return optionValues;
    }

    public void setOptionValues(Map<String, String> optionValues) {
        this.optionValues = optionValues;
    }

    public AssetAmount getPrice() {
        return price;
    }

    public void setPrice(AssetAmount price) {
        this.price = price;
    }

    public List<String> getMediaOrder() {
        return mediaOrder;
    }

    public void setMediaOrder(List<String> mediaOrder) {
        this.mediaOrder = mediaOrder;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<String> getSellingPlanGroupIds() {
        return sellingPlanGroupIds;
    }

    public void setSellingPlanGroupIds(List<String> sellingPlanGroupIds) {
        this.sellingPlanGroupIds = sellingPlanGroupIds;
    }

    public List<SellingPlanGroupWithPlans> getSellingPlanGroups() {
        return sellingPlanGroups;
    }

    public void setSellingPlanGroups(List<SellingPlanGroupWithPlans> sellingPlanGroups) {
        this.sellingPlanGroups = sellingPlanGroups;
    }

    public List<SellingPlanPricing> getSellingPlanPricing() {
        return sellingPlanPricing;
    }

    public void setSellingPlanPricing(List<SellingPlanPricing> sellingPlanPricing) {
        this.sellingPlanPricing = sellingPlanPricing;
    }
}
