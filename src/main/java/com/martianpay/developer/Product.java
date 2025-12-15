package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Product represents a product in the catalog
 */
public class Product {
    /**
     * ID is the unique identifier for the product
     */
    @SerializedName("id")
    private String id;

    /**
     * Name is the name of the product
     */
    @SerializedName("name")
    private String name;

    /**
     * Price is the legacy price field for simple products
     */
    @SerializedName("price")
    private AssetAmount price;

    /**
     * FixedPrice is the explicit price for simple products
     */
    @SerializedName("fixed_price")
    private AssetAmount fixedPrice;

    /**
     * Description is the detailed description of the product
     */
    @SerializedName("description")
    private String description;

    /**
     * TaxCode is the tax classification code for the product
     */
    @SerializedName("tax_code")
    private String taxCode;

    /**
     * Metadata contains additional custom data for the product
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * DefaultCurrency is the base currency for the product/variants
     */
    @SerializedName("default_currency")
    private String defaultCurrency;

    /**
     * MediaOrder contains ordered media asset IDs at product level
     */
    @SerializedName("media_order")
    private List<String> mediaOrder;

    /**
     * CollectShippingAddress indicates whether to collect shipping address during checkout
     */
    @SerializedName("collect_shipping_address")
    private Boolean collectShippingAddress;

    /**
     * CollectTaxAddress indicates whether to collect billing/tax address during checkout
     */
    @SerializedName("collect_tax_address")
    private Boolean collectTaxAddress;

    /**
     * RequiresSellingPlan indicates if subscription is required (true=subscription only, false=one-time or subscription)
     */
    @SerializedName("requires_selling_plan")
    private Boolean requiresSellingPlan;

    /**
     * Options contains variant option definitions
     */
    @SerializedName("options")
    private List<ProductOption> options;

    /**
     * Variants contains variant combinations
     */
    @SerializedName("variants")
    private List<ProductVariant> variants;

    /**
     * Active indicates if the product is currently available
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * UpdatedAt is the Unix timestamp when the product was last updated
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * CreatedAt is the Unix timestamp when the product was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Version is the catalog version associated with this product
     */
    @SerializedName("version")
    private Long version;

    /**
     * Includes contains included media assets with signed URLs
     */
    @SerializedName("includes")
    private PaymentLinkIncludes includes;

    /**
     * SellingPlanGroupIDs contains product-level selling plan group associations
     */
    @SerializedName("selling_plan_group_ids")
    private List<String> sellingPlanGroupIds;

    /**
     * SellingPlanGroups contains expanded selling plan groups with plans (use expand=selling_plans query param)
     */
    @SerializedName("selling_plan_groups")
    private List<SellingPlanGroupWithPlans> sellingPlanGroups;

    public Product() {
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

    public AssetAmount getPrice() {
        return price;
    }

    public void setPrice(AssetAmount price) {
        this.price = price;
    }

    public AssetAmount getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(AssetAmount fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public List<String> getMediaOrder() {
        return mediaOrder;
    }

    public void setMediaOrder(List<String> mediaOrder) {
        this.mediaOrder = mediaOrder;
    }

    public Boolean getCollectShippingAddress() {
        return collectShippingAddress;
    }

    public void setCollectShippingAddress(Boolean collectShippingAddress) {
        this.collectShippingAddress = collectShippingAddress;
    }

    public Boolean getCollectTaxAddress() {
        return collectTaxAddress;
    }

    public void setCollectTaxAddress(Boolean collectTaxAddress) {
        this.collectTaxAddress = collectTaxAddress;
    }

    public Boolean getRequiresSellingPlan() {
        return requiresSellingPlan;
    }

    public void setRequiresSellingPlan(Boolean requiresSellingPlan) {
        this.requiresSellingPlan = requiresSellingPlan;
    }

    public List<ProductOption> getOptions() {
        return options;
    }

    public void setOptions(List<ProductOption> options) {
        this.options = options;
    }

    public List<ProductVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<ProductVariant> variants) {
        this.variants = variants;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public PaymentLinkIncludes getIncludes() {
        return includes;
    }

    public void setIncludes(PaymentLinkIncludes includes) {
        this.includes = includes;
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
}
