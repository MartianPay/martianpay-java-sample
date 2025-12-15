package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * PaymentLink represents a payment link for purchasing products
 */
public class PaymentLink {
    /**
     * ID is the unique identifier for the payment link
     */
    @SerializedName("id")
    private String id;

    /**
     * ProductItems is the legacy flattened product list
     */
    @SerializedName("product_items")
    private List<ProductItem> productItems;

    /**
     * Product is the product associated with the payment link
     */
    @SerializedName("product")
    private Product product;

    /**
     * PrimaryVariants are primary variants selectable by the buyer
     */
    @SerializedName("primary_variants")
    private List<PaymentLinkVariant> primaryVariants;

    /**
     * AddonVariants are optional add-on variants
     */
    @SerializedName("addon_variants")
    private List<PaymentLinkVariant> addonVariants;

    /**
     * VariantConfig contains UI and default selection metadata
     */
    @SerializedName("variant_config")
    private Map<String, Object> variantConfig;

    /**
     * PriceRange is the price range across primary variants
     */
    @SerializedName("price_range")
    private PaymentLinkPriceRange priceRange;

    /**
     * TotalPrice is the computed total price (legacy behaviour)
     */
    @SerializedName("total_price")
    private AssetAmount totalPrice;

    /**
     * Active indicates if the payment link is currently active
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * UpdatedAt is the Unix timestamp when the link was last updated
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * CreatedAt is the Unix timestamp when the link was created
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * URL is the URL to access the payment link
     */
    @SerializedName("url")
    private String url;

    /**
     * Includes contains included shared resources (e.g., media)
     */
    @SerializedName("includes")
    private PaymentLinkIncludes includes;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<ProductItem> getProductItems() { return productItems; }
    public void setProductItems(List<ProductItem> productItems) { this.productItems = productItems; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public List<PaymentLinkVariant> getPrimaryVariants() { return primaryVariants; }
    public void setPrimaryVariants(List<PaymentLinkVariant> primaryVariants) { this.primaryVariants = primaryVariants; }

    public List<PaymentLinkVariant> getAddonVariants() { return addonVariants; }
    public void setAddonVariants(List<PaymentLinkVariant> addonVariants) { this.addonVariants = addonVariants; }

    public Map<String, Object> getVariantConfig() { return variantConfig; }
    public void setVariantConfig(Map<String, Object> variantConfig) { this.variantConfig = variantConfig; }

    public PaymentLinkPriceRange getPriceRange() { return priceRange; }
    public void setPriceRange(PaymentLinkPriceRange priceRange) { this.priceRange = priceRange; }

    public AssetAmount getTotalPrice() { return totalPrice; }
    public void setTotalPrice(AssetAmount totalPrice) { this.totalPrice = totalPrice; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public PaymentLinkIncludes getIncludes() { return includes; }
    public void setIncludes(PaymentLinkIncludes includes) { this.includes = includes; }
}
