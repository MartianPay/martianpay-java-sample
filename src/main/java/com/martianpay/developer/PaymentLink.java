package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * PaymentLink represents a shareable payment link for purchasing products.
 *
 * Payment links enable merchants to sell products without needing a full e-commerce website.
 * They provide a simple, hosted checkout page that can be shared via URL, embedded in emails,
 * or posted on social media. Customers can view product details, select variants, and complete
 * payment all on the hosted page.
 *
 * Key features:
 * - No-code product selling solution
 * - Hosted checkout page with product display
 * - Support for product variants and options (size, color, etc.)
 * - Optional add-on products
 * - Dynamic pricing based on variant selection
 * - Multiple cryptocurrency and fiat payment methods
 * - Mobile-responsive design
 * - Shareable via URL
 *
 * Product variant system:
 * - Primary Variants: Main product options customer must choose (e.g., T-shirt size/color)
 * - Addon Variants: Optional extras customer can add (e.g., gift wrapping, extended warranty)
 * - Price Range: Shows min-max price across all primary variants
 * - Variant Config: UI settings like default selections and display order
 *
 * Use cases:
 * - Selling products on social media without a website
 * - Quick product sales for small businesses
 * - Event ticket sales
 * - Digital product distribution
 * - Donation collection
 * - Pre-orders and crowdfunding
 * - One-time promotional offers
 * - Email marketing campaigns
 *
 * Typical workflow:
 * 1. Merchant creates a product in the system
 * 2. Merchant generates a payment link for the product
 * 3. System creates hosted checkout page with unique URL
 * 4. Merchant shares the URL with potential customers
 * 5. Customer clicks link and views product details
 * 6. Customer selects variants and adds to cart
 * 7. Customer completes payment on hosted page
 * 8. System creates PaymentIntent and processes payment
 * 9. Customer receives confirmation and merchant gets paid
 *
 * Advantages:
 * - Fast setup (minutes instead of days)
 * - No website hosting required
 * - No technical skills needed
 * - Built-in payment processing
 * - Automatic inventory management
 * - Mobile-optimized checkout
 * - Secure payment handling
 * - Analytics and reporting included
 */
public class PaymentLink {
    /**
     * Unique identifier for the payment link.
     * Format: pl_[random_id] or similar prefix
     * Used to reference this link in analytics and reports.
     */
    @SerializedName("id")
    private String id;

    /**
     * Legacy flattened product list for backward compatibility.
     * Contains simplified product information.
     *
     * Deprecated in favor of the structured product and variants fields.
     * Maintained for API compatibility with older integrations.
     */
    @SerializedName("product_items")
    private List<ProductItem> productItems;

    /**
     * The product associated with this payment link.
     * Contains full product information including name, description, and media.
     *
     * Product details are displayed on the hosted checkout page:
     * - Product name as page title
     * - Description for product details
     * - Media gallery for product images/videos
     * - Metadata for additional information
     *
     * See Product class for complete structure.
     */
    @SerializedName("product")
    private Product product;

    /**
     * List of primary product variants the buyer must choose from.
     * These are the main options for the product (e.g., size, color).
     *
     * Characteristics:
     * - Customer must select one primary variant to purchase
     * - Each variant has its own price and inventory
     * - Variants can have multiple options (e.g., "Large Blue", "Small Red")
     * - Cannot checkout without selecting a primary variant
     *
     * Examples:
     * - T-shirt: Small/Medium/Large in Red/Blue/Green
     * - Subscription: Monthly/Annual plans
     * - Service: Basic/Pro/Enterprise tiers
     *
     * See PaymentLinkVariant for variant structure.
     */
    @SerializedName("primary_variants")
    private List<PaymentLinkVariant> primaryVariants;

    /**
     * List of optional add-on variants the buyer can add.
     * These are supplementary products or services.
     *
     * Characteristics:
     * - Optional: customer can add 0 or more addons
     * - Each addon has independent pricing
     * - Added to base product price in cart
     * - Can have quantity selection
     *
     * Examples:
     * - Gift wrapping (+$5)
     * - Extended warranty (+$29)
     * - Expedited shipping (+$15)
     * - Accessory bundle (+$39)
     *
     * See PaymentLinkVariant for addon structure.
     */
    @SerializedName("addon_variants")
    private List<PaymentLinkVariant> addonVariants;

    /**
     * UI configuration and default selection metadata for variants.
     * Controls how variants are displayed and which options are pre-selected.
     *
     * May include:
     * - default_variant_id: Which variant is selected by default
     * - display_style: How to show variants (dropdown, buttons, grid)
     * - show_sold_out: Whether to display out-of-stock variants
     * - addon_display: How to present addon options
     * - quantity_enabled: Whether customers can buy multiple units
     *
     * Flexible map structure allows for UI customization without schema changes.
     */
    @SerializedName("variant_config")
    private Map<String, Object> variantConfig;

    /**
     * Price range across all primary variants.
     * Shows the minimum and maximum prices available.
     *
     * Displayed as:
     * - Single variant: "$29.99"
     * - Multiple variants with same price: "$29.99"
     * - Multiple variants with different prices: "$19.99 - $49.99"
     *
     * Helps customers understand pricing before selecting variants.
     * Updated automatically when variant prices change.
     *
     * See PaymentLinkPriceRange for structure.
     */
    @SerializedName("price_range")
    private PaymentLinkPriceRange priceRange;

    /**
     * Computed total price for the product.
     * Legacy field maintained for backward compatibility.
     *
     * For single-variant products: The fixed price
     * For multi-variant products: May show the default or minimum price
     *
     * Deprecated in favor of price_range for multi-variant products.
     * Actual price is calculated based on customer's variant selection.
     */
    @SerializedName("total_price")
    private AssetAmount totalPrice;

    /**
     * Indicates if the payment link is currently active and accepting orders.
     *
     * When true:
     * - Link URL is accessible and functional
     * - Customers can complete purchases
     * - Link appears in merchant's active links list
     *
     * When false:
     * - Link URL may show "inactive" message
     * - Customers cannot complete purchases
     * - Useful for temporarily disabling sales
     * - Link can be reactivated later
     *
     * Merchants can deactivate links for:
     * - Sold out products
     * - Ended promotions
     * - Seasonal products
     * - Product updates or changes
     */
    @SerializedName("active")
    private Boolean active;

    /**
     * Unix timestamp (in seconds) when the link was last updated.
     * Updates when any link property changes (variants, pricing, status, etc.).
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Unix timestamp (in seconds) when the link was first created.
     * Records the initial creation time of this payment link.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * The public URL to access the hosted payment page.
     * Merchants share this URL with customers.
     *
     * Format: https://pay.merchantdomain.com/links/[link_id]
     *
     * Features:
     * - Shareable on social media, email, SMS
     * - Can be shortened for easier sharing
     * - Mobile-responsive hosted page
     * - Secure HTTPS connection
     * - Can include tracking parameters
     *
     * The URL remains constant even if product details change.
     */
    @SerializedName("url")
    private String url;

    /**
     * Included shared resources for the payment link.
     * Contains media files, documents, and other assets.
     *
     * Typically includes:
     * - Product images in various sizes
     * - Product videos
     * - Variant-specific media
     * - Downloadable files for digital products
     *
     * Optimized for:
     * - Fast loading on hosted page
     * - Responsive image display
     * - CDN delivery
     * - Different screen sizes
     *
     * See PaymentLinkIncludes for structure.
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
