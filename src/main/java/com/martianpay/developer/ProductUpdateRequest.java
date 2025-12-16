package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Request to update an existing product. All fields are optional.
 */
public class ProductUpdateRequest {
    /**
     * Updated name of the product.
     */
    @SerializedName("name")
    private String name;

    /**
     * Updated base price of the product.
     */
    @SerializedName("price")
    private AssetAmount price;

    /**
     * Updated fixed price of the product.
     */
    @SerializedName("fixed_price")
    private AssetAmount fixedPrice;

    /**
     * Updated product description.
     */
    @SerializedName("description")
    private String description;

    /**
     * Updated tax code for automated tax calculation.
     */
    @SerializedName("tax_code")
    private String taxCode;

    /**
     * Updated metadata key-value pairs.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Updated default currency code. Currently only USD is supported.
     */
    @SerializedName("default_currency")
    private String defaultCurrency;

    /**
     * Updated ordered list of media IDs.
     */
    @SerializedName("media_order")
    private List<String> mediaOrder;

    /**
     * Updated shipping address collection setting.
     */
    @SerializedName("collect_shipping_address")
    private Boolean collectShippingAddress;

    /**
     * Updated tax address collection setting.
     */
    @SerializedName("collect_tax_address")
    private Boolean collectTaxAddress;

    /**
     * Updated selling plan requirement.
     */
    @SerializedName("requires_selling_plan")
    private Boolean requiresSellingPlan;

    /**
     * Updated list of product options.
     */
    @SerializedName("options")
    private List<ProductOption> options;

    /**
     * Updated list of product variants.
     */
    @SerializedName("variants")
    private List<ProductVariant> variants;

    /**
     * Updated active status.
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * Updated list of selling plan group IDs.
     */
    @SerializedName("selling_plan_group_ids")
    private List<String> sellingPlanGroupIDs;

    /**
     * Version number for optimistic locking.
     */
    @SerializedName("version")
    private Long version;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public AssetAmount getPrice() { return price; }
    public void setPrice(AssetAmount price) { this.price = price; }

    public AssetAmount getFixedPrice() { return fixedPrice; }
    public void setFixedPrice(AssetAmount fixedPrice) { this.fixedPrice = fixedPrice; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getTaxCode() { return taxCode; }
    public void setTaxCode(String taxCode) { this.taxCode = taxCode; }

    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    public String getDefaultCurrency() { return defaultCurrency; }
    public void setDefaultCurrency(String defaultCurrency) { this.defaultCurrency = defaultCurrency; }

    public List<String> getMediaOrder() { return mediaOrder; }
    public void setMediaOrder(List<String> mediaOrder) { this.mediaOrder = mediaOrder; }

    public Boolean getCollectShippingAddress() { return collectShippingAddress; }
    public void setCollectShippingAddress(Boolean collectShippingAddress) { this.collectShippingAddress = collectShippingAddress; }

    public Boolean getCollectTaxAddress() { return collectTaxAddress; }
    public void setCollectTaxAddress(Boolean collectTaxAddress) { this.collectTaxAddress = collectTaxAddress; }

    public Boolean getRequiresSellingPlan() { return requiresSellingPlan; }
    public void setRequiresSellingPlan(Boolean requiresSellingPlan) { this.requiresSellingPlan = requiresSellingPlan; }

    public List<ProductOption> getOptions() { return options; }
    public void setOptions(List<ProductOption> options) { this.options = options; }

    public List<ProductVariant> getVariants() { return variants; }
    public void setVariants(List<ProductVariant> variants) { this.variants = variants; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public List<String> getSellingPlanGroupIDs() { return sellingPlanGroupIDs; }
    public void setSellingPlanGroupIDs(List<String> sellingPlanGroupIDs) { this.sellingPlanGroupIDs = sellingPlanGroupIDs; }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}
