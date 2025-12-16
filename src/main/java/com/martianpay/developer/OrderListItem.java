package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * OrderListItem represents a summary of an order in a list view.
 *
 * This model provides essential order information optimized for displaying multiple
 * orders in list or grid views. It contains the same structure as OrderDetail but
 * is used in list contexts where many orders need to be displayed efficiently.
 *
 * Key features:
 * - Complete order summary information
 * - Predefined status constants for consistency
 * - Customer and shipping details
 * - Order items and totals
 *
 * Use cases:
 * - Displaying orders in dashboards and management interfaces
 * - Showing order history to customers
 * - Filtering and searching through orders
 * - Generating order reports and exports
 *
 * Order status workflow:
 * Pending → Paid → Shipping → (Completed) or potentially Refunded/Canceled
 */
public class OrderListItem {
    /**
     * Status constant indicating the order is pending payment.
     * The order has been created but payment has not been confirmed.
     */
    public static final String STATUS_PENDING = "Pending";

    /**
     * Status constant indicating the order has been paid.
     * Payment has been confirmed and the order is ready for fulfillment.
     */
    public static final String STATUS_PAID = "Paid";

    /**
     * Status constant indicating the order is being shipped.
     * The order is in transit to the customer.
     */
    public static final String STATUS_SHIPPING = "Shipping";

    /**
     * Status constant indicating the order has been refunded.
     * Payment has been returned to the customer.
     */
    public static final String STATUS_REFUNDED = "Refunded";

    /**
     * Status constant indicating the order has been canceled.
     * The order was canceled before completion.
     */
    public static final String STATUS_CANCELED = "Canceled";

    /**
     * Unique order number for this order.
     * Example: "ORD-20240101-ABCD1234"
     */
    @SerializedName("order_number")
    private String orderNumber;

    /**
     * External identifier from an integrated system.
     * Links this order to external e-commerce platforms or ERP systems.
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Customer information for this order.
     * Contains customer identity and contact details.
     */
    @SerializedName("customer")
    private OrderCustomer customer;

    /**
     * Shipping address for this order.
     * Destination where the order items will be delivered.
     */
    @SerializedName("shipping_address")
    private OrderShippingAddress shippingAddress;

    /**
     * Tax region information for this order.
     * Determines applicable tax rates based on destination.
     */
    @SerializedName("tax_region")
    private OrderTaxRegion taxRegion;

    /**
     * List of items in this order.
     * Contains product details, quantities, and pricing for each item.
     */
    @SerializedName("items")
    private List<OrderItem> items;

    /**
     * Total amount for the entire order.
     * Includes all items, taxes, and fees with currency information.
     */
    @SerializedName("total_amount")
    private AssetAmount totalAmount;

    /**
     * Current status of the order.
     * Use the STATUS_* constants for consistency.
     * Possible values: "Pending", "Paid", "Shipping", "Refunded", "Canceled"
     */
    @SerializedName("status")
    private String status;

    /**
     * Payment method used for this order.
     * Examples: "credit_card", "crypto", "bank_transfer"
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
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Default constructor for OrderListItem.
     */
    public OrderListItem() {
    }

    /**
     * Gets the order number.
     * @return The order number
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the order number.
     * @param orderNumber The order number
     */
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets the external system identifier.
     * @return The external ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the external system identifier.
     * @param externalId The external ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Gets the customer information.
     * @return The customer details
     */
    public OrderCustomer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer information.
     * @param customer The customer details
     */
    public void setCustomer(OrderCustomer customer) {
        this.customer = customer;
    }

    /**
     * Gets the shipping address.
     * @return The shipping address
     */
    public OrderShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the shipping address.
     * @param shippingAddress The shipping address
     */
    public void setShippingAddress(OrderShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets the tax region information.
     * @return The tax region details
     */
    public OrderTaxRegion getTaxRegion() {
        return taxRegion;
    }

    /**
     * Sets the tax region information.
     * @param taxRegion The tax region details
     */
    public void setTaxRegion(OrderTaxRegion taxRegion) {
        this.taxRegion = taxRegion;
    }

    /**
     * Gets the list of order items.
     * @return List of order items
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Sets the list of order items.
     * @param items List of order items
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Gets the total order amount.
     * @return The total amount
     */
    public AssetAmount getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total order amount.
     * @param totalAmount The total amount
     */
    public void setTotalAmount(AssetAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the order status.
     * @return The order status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the order status.
     * @param status The order status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the payment method.
     * @return The payment method identifier
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method.
     * @param paymentMethod The payment method identifier
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the creation timestamp.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last update timestamp.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last update timestamp.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
