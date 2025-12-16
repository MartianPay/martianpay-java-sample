package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/**
 * OrderItem represents a single line item within an order.
 *
 * This model contains detailed information about a product purchased as part of an order,
 * including product identification, variant selection, quantity, pricing, and associated
 * media. It links to both lightweight product information and full product objects.
 *
 * Key features:
 * - Product and variant identification
 * - Quantity and pricing details (unit price and total)
 * - Selected product options (e.g., size, color)
 * - Media display order for the item
 * - Full product and variant objects for detailed information
 *
 * Use cases:
 * - Displaying order items in order summaries
 * - Calculating order totals and subtotals
 * - Processing order fulfillment
 * - Tracking inventory for ordered products
 * - Generating invoices and receipts
 *
 * Example:
 * An order item might represent "2x Large Red T-Shirt" with unit price $20.00
 * and total $40.00, along with product images and full product details.
 */
public class OrderItem {
    /**
     * Unique identifier for the product.
     * Links this order item to a specific product in the catalog.
     * Format: Typically prod_[random_id]
     */
    @SerializedName("product_id")
    private String productId;

    /**
     * Name of the product as displayed to customers.
     * This is the product title shown in the order summary.
     * Example: "Premium Cotton T-Shirt", "Wireless Headphones"
     */
    @SerializedName("product_name")
    private String productName;

    /**
     * Description of the product.
     * Provides detailed information about the product for order documentation.
     * May be displayed in invoices and order confirmations.
     */
    @SerializedName("product_description")
    private String productDescription;

    /**
     * Unique identifier for the specific product variant.
     * Identifies the exact SKU/variant purchased (e.g., size, color combination).
     * Format: Typically var_[random_id]
     */
    @SerializedName("variant_id")
    private String variantId;

    /**
     * Map of option names to selected values for this item.
     * Captures the specific variant choices made by the customer.
     * Key: Option name (e.g., "Size", "Color")
     * Value: Selected value (e.g., "Large", "Red")
     * Example: {"Size": "Large", "Color": "Red"}
     */
    @SerializedName("option_values")
    private Map<String, String> optionValues;

    /**
     * Quantity of this product ordered.
     * The number of units of this product/variant in the order.
     * Must be a positive integer.
     */
    @SerializedName("quantity")
    private Integer quantity;

    /**
     * Price per unit of this product.
     * The cost for a single unit including currency information.
     * Used to calculate the total: unit_price * quantity = total
     */
    @SerializedName("unit_price")
    private AssetAmount unitPrice;

    /**
     * Total price for this line item.
     * Calculated as unit_price * quantity, may include item-level discounts.
     * Includes currency information.
     */
    @SerializedName("total")
    private AssetAmount total;

    /**
     * Ordered list of media URLs for this product.
     * Specifies the display order of product images/videos for this item.
     * Each string is typically a URL or media ID.
     * Example: ["https://cdn.example.com/img1.jpg", "https://cdn.example.com/img2.jpg"]
     */
    @SerializedName("media_order")
    private List<String> mediaOrder;

    /**
     * Complete product object with all product details.
     * Provides access to full product information including options, media, and metadata.
     * May be null if only basic product information is included.
     */
    @SerializedName("product")
    private Product product;

    /**
     * Complete product variant object with variant-specific details.
     * Provides access to full variant information including SKU, inventory, and pricing.
     * May be null if only basic variant information is included.
     */
    @SerializedName("variant")
    private ProductVariant variant;

    /**
     * Default constructor for OrderItem.
     */
    public OrderItem() {
    }

    /**
     * Gets the unique identifier for the product.
     * @return The product ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the unique identifier for the product.
     * @param productId The product ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets the name of the product.
     * @return The product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product.
     * @param productName The product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the description of the product.
     * @return The product description
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the description of the product.
     * @param productDescription The product description
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Gets the unique identifier for the product variant.
     * @return The variant ID
     */
    public String getVariantId() {
        return variantId;
    }

    /**
     * Sets the unique identifier for the product variant.
     * @param variantId The variant ID
     */
    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    /**
     * Gets the map of selected option values.
     * @return Map of option names to selected values
     */
    public Map<String, String> getOptionValues() {
        return optionValues;
    }

    /**
     * Sets the map of selected option values.
     * @param optionValues Map of option names to selected values
     */
    public void setOptionValues(Map<String, String> optionValues) {
        this.optionValues = optionValues;
    }

    /**
     * Gets the quantity of this product ordered.
     * @return The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this product ordered.
     * @param quantity The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price per unit of this product.
     * @return The unit price
     */
    public AssetAmount getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the price per unit of this product.
     * @param unitPrice The unit price
     */
    public void setUnitPrice(AssetAmount unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the total price for this line item.
     * @return The total price
     */
    public AssetAmount getTotal() {
        return total;
    }

    /**
     * Sets the total price for this line item.
     * @param total The total price
     */
    public void setTotal(AssetAmount total) {
        this.total = total;
    }

    /**
     * Gets the ordered list of media URLs for this product.
     * @return List of media URLs or IDs
     */
    public List<String> getMediaOrder() {
        return mediaOrder;
    }

    /**
     * Sets the ordered list of media URLs for this product.
     * @param mediaOrder List of media URLs or IDs
     */
    public void setMediaOrder(List<String> mediaOrder) {
        this.mediaOrder = mediaOrder;
    }

    /**
     * Gets the complete product object.
     * @return The product details, or null if not included
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the complete product object.
     * @param product The product details
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the complete product variant object.
     * @return The variant details, or null if not included
     */
    public ProductVariant getVariant() {
        return variant;
    }

    /**
     * Sets the complete product variant object.
     * @param variant The variant details
     */
    public void setVariant(ProductVariant variant) {
        this.variant = variant;
    }
}
