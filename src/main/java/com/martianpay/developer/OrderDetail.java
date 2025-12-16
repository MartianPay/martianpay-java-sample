package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * OrderDetail represents the complete details of a specific order.
 *
 * This model provides comprehensive information about an order including customer details,
 * shipping address, ordered items, payment information, and order status. It serves as
 * the central data structure for order management operations.
 *
 * Key use cases:
 * - Retrieving full order information for order management
 * - Displaying order details to customers and merchants
 * - Processing order fulfillment and shipping
 * - Tracking order status throughout its lifecycle
 * - Generating invoices and receipts
 * - Supporting customer service inquiries
 *
 * Order lifecycle:
 * 1. Order created with customer and items
 * 2. Payment processed and status updated
 * 3. Order fulfilled and shipped
 * 4. Completed or potentially refunded/canceled
 */
public class OrderDetail {
    /**
     * Unique order number for this order.
     * This is the human-readable identifier displayed to customers and merchants.
     * Format: Typically ORD-[timestamp]-[random] or merchant-specific format
     * Example: "ORD-20240101-ABCD1234"
     */
    @SerializedName("order_number")
    private String orderNumber;

    /**
     * External identifier from an integrated system or merchant's own system.
     * Used to link this order to records in external e-commerce platforms,
     * ERPs, or inventory management systems.
     * Example: Shopify order ID, WooCommerce order ID
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Customer information for this order.
     * Contains customer identity and contact details needed for order processing.
     */
    @SerializedName("customer")
    private OrderCustomer customer;

    /**
     * Shipping address where the order items will be delivered.
     * Contains complete address information for fulfillment and shipping.
     */
    @SerializedName("shipping_address")
    private OrderShippingAddress shippingAddress;

    /**
     * Tax region information for this order.
     * Determines applicable tax rates and regulations based on shipping destination.
     */
    @SerializedName("tax_region")
    private OrderTaxRegion taxRegion;

    /**
     * List of items included in this order.
     * Each item contains product details, quantity, pricing, and variant information.
     */
    @SerializedName("items")
    private List<OrderItem> items;

    /**
     * Total amount for the entire order including all items, taxes, and fees.
     * Includes the currency and amount details.
     */
    @SerializedName("total_amount")
    private AssetAmount totalAmount;

    /**
     * Current status of the order.
     * Common values: "Pending", "Paid", "Shipping", "Completed", "Refunded", "Canceled"
     * See OrderListItem constants for standard status values.
     */
    @SerializedName("status")
    private String status;

    /**
     * Payment method used for this order.
     * Identifies how the customer paid for the order.
     * Examples: "credit_card", "crypto", "bank_transfer", "paypal"
     */
    @SerializedName("payment_method")
    private String paymentMethod;

    /**
     * Unix timestamp (in seconds) when this order was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when this order was last updated.
     * Updates when status changes or order details are modified.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Default constructor for OrderDetail.
     */
    public OrderDetail() {
    }

    /**
     * Gets the unique order number for this order.
     * @return The order number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the unique order number for this order.
     * @param orderNumber The order number
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets the external identifier from an integrated system.
     * @return The external system ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the external identifier from an integrated system.
     * @param externalId The external system ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Gets the customer information for this order.
     * @return The customer details
     */
    public OrderCustomer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer information for this order.
     * @param customer The customer details
     */
    public void setCustomer(OrderCustomer customer) {
        this.customer = customer;
    }

    /**
     * Gets the shipping address for this order.
     * @return The shipping address
     */
    public OrderShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shipping address for this order.
     * @param shippingAddress The shipping address
     */
    public void setShippingAddress(OrderShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets the tax region information for this order.
     * @return The tax region details
     */
    public OrderTaxRegion getTaxRegion() {
        return taxRegion;
    }

    /**
     * Sets the tax region information for this order.
     * @param taxRegion The tax region details
     */
    public void setTaxRegion(OrderTaxRegion taxRegion) {
        this.taxRegion = taxRegion;
    }

    /**
     * Gets the list of items in this order.
     * @return List of order items
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Sets the list of items in this order.
     * @param items List of order items
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Gets the total amount for the entire order.
     * @return The total order amount
     */
    public AssetAmount getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount for the entire order.
     * @param totalAmount The total order amount
     */
    public void setTotalAmount(AssetAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the current status of the order.
     * @return The order status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the order.
     * @param status The order status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the payment method used for this order.
     * @return The payment method identifier
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method used for this order.
     * @param paymentMethod The payment method identifier
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the Unix timestamp when this order was created.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Unix timestamp when this order was created.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the Unix timestamp when this order was last updated.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the Unix timestamp when this order was last updated.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
