package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * InvoiceLineItemDetails represents a single line item within an invoice.
 *
 * Line items are the individual products, services, or charges that make up an invoice.
 * Each line item contains details about what was purchased, how much, and the pricing.
 * Line items are essential for itemized billing, providing transparency to customers
 * and enabling detailed financial reporting.
 *
 * Line item components:
 * - Product information: Links to the product and variant being billed
 * - Quantity: Number of units being billed
 * - Pricing: Unit price and total amount for this line item
 * - Period: Billing period for subscription-based charges
 * - Metadata: Custom attributes for integration and tracking
 *
 * Use cases:
 * - Display itemized invoice breakdown to customers
 * - Calculate invoice totals and subtotals
 * - Track what products/services were billed in each period
 * - Support proration for subscription changes
 * - Enable detailed revenue reporting by product
 * - Provide audit trail for billing disputes
 *
 * Pricing calculation:
 * - amount = unit_amount * quantity
 * - Amounts stored as strings to maintain decimal precision
 * - Currency matches the parent invoice currency
 */
public class InvoiceLineItemDetails {
    /**
     * Human-readable description of this line item.
     * Typically includes the product name and any relevant details.
     * Example: "Pro Plan - Monthly Subscription"
     */
    @SerializedName("description")
    private String description;

    /**
     * ID of the product associated with this line item.
     * Links to the product catalog for detailed product information.
     */
    @SerializedName("product_id")
    private String productId;

    /**
     * ID of the product variant for this line item.
     * Used when products have multiple variants (sizes, tiers, etc.).
     * Null for products without variants.
     */
    @SerializedName("variant_id")
    private String variantId;

    /**
     * Quantity of units being billed.
     * For most items this is a simple count.
     * For metered billing, this could be usage units (API calls, GB transferred, etc.).
     */
    @SerializedName("quantity")
    private Integer quantity;

    /**
     * Price per unit for this line item.
     * Stored as a string to maintain decimal precision.
     * Total line item amount = unit_amount * quantity
     */
    @SerializedName("unit_amount")
    private String unitAmount;

    /**
     * Total amount for this line item.
     * Calculated as unit_amount * quantity.
     * Stored as a string to maintain decimal precision.
     */
    @SerializedName("amount")
    private String amount;

    /**
     * Three-letter ISO currency code for this line item.
     * Should match the parent invoice currency.
     * Example: "USD" (Currently only USD is supported for fiat)
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Unix timestamp (in seconds) marking the start of the billing period.
     * Used for subscription billing to indicate the period this charge covers.
     * Null for one-time charges.
     */
    @SerializedName("period_start")
    private Long periodStart;

    /**
     * Unix timestamp (in seconds) marking the end of the billing period.
     * Used for subscription billing to indicate the period this charge covers.
     * Null for one-time charges.
     */
    @SerializedName("period_end")
    private Long periodEnd;

    /**
     * Custom metadata associated with this line item.
     * Key-value pairs for storing additional information or integration data.
     * Can be used for tracking, categorization, or custom business logic.
     */
    @SerializedName("metadata")
    private Map<String, Object> metadata;

    /**
     * Display name of the product.
     * Denormalized for convenience when displaying line items.
     * Avoids the need to join with product catalog for display.
     */
    @SerializedName("product_name")
    private String productName;

    /**
     * Display title of the product variant.
     * Denormalized for convenience when displaying line items.
     * Null for products without variants.
     */
    @SerializedName("variant_title")
    private String variantTitle;

    public InvoiceLineItemDetails() {
    }

    /**
     * Gets the human-readable description of this line item.
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the human-readable description of this line item.
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the ID of the product associated with this line item.
     * @return The product ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product associated with this line item.
     * @param productId The product ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets the ID of the product variant for this line item.
     * @return The variant ID, or null for products without variants
     */
    public String getVariantId() {
        return variantId;
    }

    /**
     * Sets the ID of the product variant for this line item.
     * @param variantId The variant ID
     */
    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    /**
     * Gets the quantity of units being billed.
     * @return The quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of units being billed.
     * @param quantity The quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price per unit for this line item.
     * @return The unit amount as a string
     */
    public String getUnitAmount() {
        return unitAmount;
    }

    /**
     * Sets the price per unit for this line item.
     * @param unitAmount The unit amount as a string
     */
    public void setUnitAmount(String unitAmount) {
        this.unitAmount = unitAmount;
    }

    /**
     * Gets the total amount for this line item.
     * @return The amount as a string
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the total amount for this line item.
     * @param amount The amount as a string
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the three-letter ISO currency code.
     * @return The currency code
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the three-letter ISO currency code.
     * @param currency The currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the Unix timestamp marking the start of the billing period.
     * @return The period start timestamp in seconds, or null for one-time charges
     */
    public Long getPeriodStart() {
        return periodStart;
    }

    /**
     * Sets the Unix timestamp marking the start of the billing period.
     * @param periodStart The period start timestamp in seconds
     */
    public void setPeriodStart(Long periodStart) {
        this.periodStart = periodStart;
    }

    /**
     * Gets the Unix timestamp marking the end of the billing period.
     * @return The period end timestamp in seconds, or null for one-time charges
     */
    public Long getPeriodEnd() {
        return periodEnd;
    }

    /**
     * Sets the Unix timestamp marking the end of the billing period.
     * @param periodEnd The period end timestamp in seconds
     */
    public void setPeriodEnd(Long periodEnd) {
        this.periodEnd = periodEnd;
    }

    /**
     * Gets the custom metadata associated with this line item.
     * @return The metadata map
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Sets the custom metadata associated with this line item.
     * @param metadata The metadata map
     */
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the display name of the product.
     * @return The product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the display name of the product.
     * @param productName The product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the display title of the product variant.
     * @return The variant title, or null for products without variants
     */
    public String getVariantTitle() {
        return variantTitle;
    }

    /**
     * Sets the display title of the product variant.
     * @param variantTitle The variant title
     */
    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }
}
