package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * Request to create a new product.
 */
public class ProductCreateRequest {
    /**
     * Custom ID for the product.
     */
    @SerializedName("id")
    private String id;

    /**
     * Name of the product displayed to customers.
     */
    @SerializedName("name")
    private String name;

    /**
     * Base price of the product.
     */
    @SerializedName("price")
    private AssetAmount price;

    /**
     * Fixed price of the product.
     */
    @SerializedName("fixed_price")
    private AssetAmount fixedPrice;

    /**
     * Description of the product.
     */
    @SerializedName("description")
    private String description;

    /**
     * Tax code for automated tax calculation.
     */
    @SerializedName("tax_code")
    private String taxCode;

    /**
     * Custom key-value pairs for additional data.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Default currency code for displaying prices. Currently only USD is supported.
     */
    @SerializedName("default_currency")
    private String defaultCurrency;

    /**
     * Ordered list of media IDs for product display.
     */
    @SerializedName("media_order")
    private List<String> mediaOrder;

    /**
     * Whether to collect shipping address during checkout.
     */
    @SerializedName("collect_shipping_address")
    private Boolean collectShippingAddress;

    /**
     * Whether to collect tax address for tax calculation.
     */
    @SerializedName("collect_tax_address")
    private Boolean collectTaxAddress;

    /**
     * Whether this product requires a selling plan to be selected.
     */
    @SerializedName("requires_selling_plan")
    private Boolean requiresSellingPlan;

    /**
     * List of product options.
     */
    @SerializedName("options")
    private List<ProductOption> options;

    /**
     * List of product variants.
     */
    @SerializedName("variants")
    private List<ProductVariant> variants;

    /**
     * Whether the product is active and available for purchase.
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * List of selling plan group IDs associated with this product.
     */
    @SerializedName("selling_plan_group_ids")
    private List<String> sellingPlanGroupIDs;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

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
}
