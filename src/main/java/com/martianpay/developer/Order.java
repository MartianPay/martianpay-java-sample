package com.martianpay.developer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

/**
 * Order represents a complete order in the MartianPay system.
 *
 * An order is created when a customer successfully completes a payment through a payment link
 * or invoice. It contains all the details about the purchased items, customer information,
 * payment status, and fulfillment information.
 *
 * Order lifecycle:
 * 1. Created - Order has been created from a completed payment
 * 2. Processing - Order is being processed for fulfillment
 * 3. Completed - Order has been successfully fulfilled
 * 4. Cancelled - Order was cancelled before fulfillment
 * 5. Refunded - Order payment was refunded (fully or partially)
 *
 * An order typically includes:
 * - Customer and billing information
 * - List of purchased items with quantities and prices
 * - Payment method and transaction details
 * - Shipping/delivery information (if applicable)
 * - Tax calculations and applied discounts
 * - Order status and fulfillment tracking
 *
 * Key features:
 * - Automatic order creation from successful payments
 * - Support for digital and physical products
 * - Tax calculation and compliance
 * - Discount code application
 * - Subscription order handling
 * - Order history and tracking
 */
public class Order {
    /**
     * Object type constant for Order resource.
     * Always "order" for this resource type.
     */
    public static final String ORDER_OBJECT = "order";

    /**
     * Status constant indicating the order is pending.
     * The order has been created but is awaiting payment confirmation.
     */
    public static final String STATUS_PENDING = "Pending";

    /**
     * Status constant indicating the order has been paid.
     * Payment has been confirmed and the order is ready for processing.
     */
    public static final String STATUS_PAID = "Paid";

    /**
     * Status constant indicating the order is being shipped.
     * The order is currently in transit to the customer.
     */
    public static final String STATUS_SHIPPING = "Shipping";

    /**
     * Status constant indicating the order has been completed.
     * The order has been successfully fulfilled and delivered.
     */
    public static final String STATUS_COMPLETED = "Completed";

    /**
     * Status constant indicating the order has been refunded.
     * Payment has been returned to the customer.
     */
    public static final String STATUS_REFUNDED = "Refunded";

    /**
     * Status constant indicating the order has been canceled.
     * The order was canceled before fulfillment.
     */
    public static final String STATUS_CANCELED = "Canceled";

    /**
     * Unique order identifier.
     * Format: "ord_" followed by random characters
     * Example: "ord_abc123xyz"
     */
    @SerializedName("id")
    private String id;

    /**
     * Object type, always "order" for this resource.
     */
    @SerializedName("object")
    private String object;

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
     * ID of the customer who placed the order.
     * References the Customer object.
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * Customer information for this order.
     * Contains customer identity and contact details needed for order processing.
     */
    @SerializedName("customer")
    private OrderCustomer customer;

    /**
     * Shipping address where the order items will be delivered.
     * Contains complete address information for fulfillment and shipping.
     * Optional for digital products.
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
     * Subtotal amount before taxes and discounts.
     * Sum of all line item amounts (in smallest currency unit, e.g., cents).
     */
    @SerializedName("amount")
    private Long amount;

    /**
     * Total discount amount applied to the order.
     * Includes coupon codes and promotional discounts (in smallest currency unit).
     */
    @SerializedName("discount_amount")
    private Long discountAmount;

    /**
     * Total tax amount charged on the order.
     * Calculated based on tax region and applicable rates (in smallest currency unit).
     */
    @SerializedName("tax_amount")
    private Long taxAmount;

    /**
     * Total amount for the entire order including all items, taxes, and fees.
     * This is the final amount charged to the customer.
     * Includes the currency and amount details.
     */
    @SerializedName("total_amount")
    private AssetAmount totalAmount;

    /**
     * Three-letter ISO currency code.
     * Example: "USD" (Currently only USD is supported for fiat)
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Current status of the order.
     * Use the STATUS_* constants for consistency.
     * Possible values: "Pending", "Paid", "Shipping", "Completed", "Refunded", "Canceled"
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
     * Associated payment intent ID used to collect payment for this order.
     * References the PaymentIntent object.
     * Format: "pi_" followed by random characters
     */
    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    /**
     * Associated subscription ID if this order is part of a recurring subscription.
     * References the Subscription object.
     * Format: "sub_" followed by random characters
     */
    @SerializedName("subscription_id")
    private String subscriptionId;

    /**
     * Associated invoice ID if this order was created from an invoice.
     * References the Invoice object.
     * Format: "in_" followed by random characters
     */
    @SerializedName("invoice_id")
    private String invoiceId;

    /**
     * Unix timestamp (in seconds) when this order was created.
     */
    @SerializedName("created")
    private Long created;

    /**
     * Unix timestamp (in seconds) when this order was created.
     * Alternative field name for consistency with other objects.
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
     * Set of key-value pairs for storing additional information about the order.
     * Useful for storing application-specific data, order notes, or integration data.
     * Maximum of 50 keys with values up to 500 characters each.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Default constructor for Order.
     */
    public Order() {
    }

    /**
     * Gets the unique order identifier.
     * @return The order ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique order identifier.
     * @param id The order ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type, always "order".
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type.
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
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
     * Gets the customer ID who placed the order.
     * @return The customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID who placed the order.
     * @param customerId The customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
     * Gets the subtotal amount before taxes and discounts.
     * @return The subtotal amount in smallest currency unit
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Sets the subtotal amount before taxes and discounts.
     * @param amount The subtotal amount in smallest currency unit
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * Gets the total discount amount applied.
     * @return The discount amount in smallest currency unit
     */
    public Long getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets the total discount amount applied.
     * @param discountAmount The discount amount in smallest currency unit
     */
    public void setDiscountAmount(Long discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * Gets the total tax amount charged.
     * @return The tax amount in smallest currency unit
     */
    public Long getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the total tax amount charged.
     * @param taxAmount The tax amount in smallest currency unit
     */
    public void setTaxAmount(Long taxAmount) {
        this.taxAmount = taxAmount;
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
     * Gets the currency code for this order.
     * @return The three-letter ISO currency code
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code for this order.
     * @param currency The three-letter ISO currency code
     */
    public void setCurrency(String currency) {
        this.currency = currency;
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
     * Gets the associated payment intent ID.
     * @return The payment intent ID
     */
    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    /**
     * Sets the associated payment intent ID.
     * @param paymentIntentId The payment intent ID
     */
    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    /**
     * Gets the associated subscription ID.
     * @return The subscription ID
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the associated subscription ID.
     * @param subscriptionId The subscription ID
     */
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the associated invoice ID.
     * @return The invoice ID
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets the associated invoice ID.
     * @param invoiceId The invoice ID
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * Gets the timestamp when this order was created.
     * @return The creation timestamp in seconds
     */
    public Long getCreated() {
        return created;
    }

    /**
     * Sets the timestamp when this order was created.
     * @param created The creation timestamp in seconds
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * Gets the timestamp when this order was created (alternative field).
     * @return The creation timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp when this order was created (alternative field).
     * @param createdAt The creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the timestamp when this order was last updated.
     * @return The update timestamp in seconds
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the timestamp when this order was last updated.
     * @param updatedAt The update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets the metadata key-value pairs for this order.
     * @return The metadata map
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata key-value pairs for this order.
     * @param metadata The metadata map
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }
}
