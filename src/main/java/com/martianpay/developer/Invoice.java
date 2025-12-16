package com.martianpay.developer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

/**
 * Invoice represents a billing invoice in the MartianPay system.
 *
 * An invoice is a detailed billing document that lists products/services, quantities, prices,
 * taxes, and payment terms. Invoices can be sent to customers for payment and tracked through
 * their lifecycle from draft to paid or voided.
 *
 * Invoice types:
 * - One-time invoices: Created manually or automatically for specific transactions
 * - Recurring invoices: Generated automatically from active subscriptions
 * - Proforma invoices: Preliminary invoices sent before goods/services delivery
 *
 * Invoice lifecycle:
 * 1. Draft - Invoice created but not yet finalized
 * 2. Open - Invoice finalized and sent to customer, awaiting payment
 * 3. Paid - Customer has successfully paid the invoice
 * 4. Void - Invoice cancelled and will not be collected
 * 5. Uncollectible - Invoice deemed uncollectible after collection attempts
 *
 * Key features:
 * - Automatic invoice generation for subscriptions
 * - Support for multiple line items with custom pricing
 * - Tax calculation and compliance
 * - Multi-currency support
 * - Payment reminder automation
 * - Partial payment tracking
 * - Custom branding and templating
 * - PDF generation for download/email
 *
 * Payment collection:
 * - Can be paid via crypto or fiat payment methods
 * - Supports payment intents for collection
 * - Automatic retry logic for failed payments
 * - Grace period configuration for past-due invoices
 */
public class Invoice {
    /**
     * Unique identifier for the invoice.
     * Format: inv_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Object type identifier, always "invoice".
     * Used for type identification in polymorphic API responses.
     */
    @SerializedName("object")
    private String object;

    /**
     * ID of the merchant who owns this invoice.
     * Links the invoice to the merchant account for billing and reporting.
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * ID of the customer being invoiced.
     * Links to the customer record for billing information and history.
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * ID of the subscription that generated this invoice.
     * Null for one-time/manual invoices.
     * Used to track recurring billing cycles and subscription history.
     */
    @SerializedName("subscription_id")
    private String subscriptionId;

    /**
     * ID of the payment intent used to collect payment for this invoice.
     * Links the invoice to the payment flow for tracking collection status.
     */
    @SerializedName("payment_intent_id")
    private String paymentIntentId;

    /**
     * Current status of the invoice.
     * Possible values: "draft", "open", "paid", "void", "uncollectible"
     */
    @SerializedName("status")
    private String status;

    /**
     * Reason why this invoice was created.
     * Values: "subscription_cycle", "subscription_create", "subscription_update", "manual"
     * Helps identify the source and purpose of the invoice.
     */
    @SerializedName("billing_reason")
    private String billingReason;

    /**
     * List of line items included in this invoice.
     * Each line item represents a product/service with quantity and pricing.
     */
    @SerializedName("lines")
    private List<InvoiceLineItemDetails> lines;

    /**
     * Sum of all line item amounts before discounts and taxes.
     * Stored as a string to maintain decimal precision.
     */
    @SerializedName("subtotal")
    private String subtotal;

    /**
     * Total discount amount applied to this invoice.
     * Stored as a string to maintain decimal precision.
     * Reduces the final amount due.
     */
    @SerializedName("discount_amount")
    private String discountAmount;

    /**
     * Total tax amount charged on this invoice.
     * Stored as a string to maintain decimal precision.
     * Calculated based on line items and tax rules.
     */
    @SerializedName("tax_amount")
    private String taxAmount;

    /**
     * Total amount to be collected for this invoice.
     * Calculated as: subtotal - discount_amount + tax_amount
     * Stored as a string to maintain decimal precision.
     */
    @SerializedName("total_amount")
    private String totalAmount;

    /**
     * Amount already paid towards this invoice.
     * Stored as a string to maintain decimal precision.
     * Supports partial payments.
     */
    @SerializedName("amount_paid")
    private String amountPaid;

    /**
     * Amount still due for this invoice.
     * Calculated as: total_amount - amount_paid
     * Stored as a string to maintain decimal precision.
     */
    @SerializedName("amount_remaining")
    private String amountRemaining;

    /**
     * Three-letter ISO currency code for the invoice amount.
     * Example: "USD" (Currently only USD is supported for fiat)
     */
    @SerializedName("currency")
    private String currency;

    /**
     * Unix timestamp (in seconds) when payment is due.
     * After this date, the invoice is considered overdue.
     */
    @SerializedName("due_date")
    private Long dueDate;

    /**
     * Unix timestamp (in seconds) when the invoice was paid.
     * Null if the invoice has not been paid yet.
     */
    @SerializedName("paid_at")
    private Long paidAt;

    /**
     * Unix timestamp (in seconds) when the invoice was voided.
     * Null if the invoice has not been voided.
     * Voided invoices will not be collected.
     */
    @SerializedName("voided_at")
    private Long voidedAt;

    /**
     * Unix timestamp (in seconds) when the invoice was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when the invoice was last updated.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Number of payment attempts made for this invoice.
     * Incremented each time a payment is attempted.
     * Used for retry logic and to track collection difficulty.
     */
    @SerializedName("attempt_count")
    private Integer attemptCount;

    /**
     * Custom metadata associated with this invoice.
     * Key-value pairs for storing additional information or integration data.
     */
    @SerializedName("metadata")
    private Map<String, Object> metadata;

    /**
     * External identifier from an external system.
     * Used for integration with external accounting or ERP systems.
     * Enables bidirectional synchronization and reference tracking.
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Version number for optimistic locking.
     * Incremented on each update to prevent concurrent modification conflicts.
     */
    @SerializedName("version")
    private Long version;

    /**
     * Display name of the merchant.
     * Denormalized for convenience when displaying invoice details.
     */
    @SerializedName("merchant_name")
    private String merchantName;

    /**
     * Public API key of the merchant.
     * Used for identifying the merchant in public contexts.
     */
    @SerializedName("public_key")
    private String publicKey;

    /**
     * Email address of the customer.
     * Denormalized for convenience when sending invoice notifications.
     */
    @SerializedName("customer_email")
    private String customerEmail;

    /**
     * Display name of the customer.
     * Denormalized for convenience when displaying invoice details.
     */
    @SerializedName("customer_name")
    private String customerName;

    /**
     * Name of the subscription product.
     * Denormalized for convenience when displaying subscription-based invoices.
     * Null for non-subscription invoices.
     */
    @SerializedName("subscription_product_name")
    private String subscriptionProductName;

    /**
     * Variant title of the subscription product.
     * Denormalized for convenience when displaying subscription-based invoices.
     * Null for non-subscription invoices or products without variants.
     */
    @SerializedName("subscription_product_variant")
    private String subscriptionProductVariant;

    /**
     * Default constructor.
     */
    public Invoice() {
    }

    /**
     * Gets the unique identifier for the invoice.
     * @return The invoice ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the invoice.
     * @param id The invoice ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type identifier.
     * @return The object type, always "invoice"
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type identifier.
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the ID of the merchant who owns this invoice.
     * @return The merchant ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the ID of the merchant who owns this invoice.
     * @param merchantId The merchant ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Gets the ID of the customer being invoiced.
     * @return The customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the ID of the customer being invoiced.
     * @param customerId The customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the ID of the subscription that generated this invoice.
     * @return The subscription ID, or null for one-time invoices
     */
    public String getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * Sets the ID of the subscription that generated this invoice.
     * @param subscriptionId The subscription ID
     */
    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    /**
     * Gets the ID of the payment intent used to collect payment.
     * @return The payment intent ID
     */
    public String getPaymentIntentId() {
        return paymentIntentId;
    }

    /**
     * Sets the ID of the payment intent used to collect payment.
     * @param paymentIntentId The payment intent ID
     */
    public void setPaymentIntentId(String paymentIntentId) {
        this.paymentIntentId = paymentIntentId;
    }

    /**
     * Gets the current status of the invoice.
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the invoice.
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the reason why this invoice was created.
     * @return The billing reason
     */
    public String getBillingReason() {
        return billingReason;
    }

    /**
     * Sets the reason why this invoice was created.
     * @param billingReason The billing reason
     */
    public void setBillingReason(String billingReason) {
        this.billingReason = billingReason;
    }

    /**
     * Gets the list of line items included in this invoice.
     * @return The list of line items
     */
    public List<InvoiceLineItemDetails> getLines() {
        return lines;
    }

    /**
     * Sets the list of line items included in this invoice.
     * @param lines The list of line items
     */
    public void setLines(List<InvoiceLineItemDetails> lines) {
        this.lines = lines;
    }

    /**
     * Gets the sum of all line item amounts before discounts and taxes.
     * @return The subtotal as a string
     */
    public String getSubtotal() {
        return subtotal;
    }

    /**
     * Sets the sum of all line item amounts before discounts and taxes.
     * @param subtotal The subtotal as a string
     */
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Gets the total discount amount applied to this invoice.
     * @return The discount amount as a string
     */
    public String getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets the total discount amount applied to this invoice.
     * @param discountAmount The discount amount as a string
     */
    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    /**
     * Gets the total tax amount charged on this invoice.
     * @return The tax amount as a string
     */
    public String getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the total tax amount charged on this invoice.
     * @param taxAmount The tax amount as a string
     */
    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * Gets the total amount to be collected for this invoice.
     * @return The total amount as a string
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount to be collected for this invoice.
     * @param totalAmount The total amount as a string
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Gets the amount already paid towards this invoice.
     * @return The amount paid as a string
     */
    public String getAmountPaid() {
        return amountPaid;
    }

    /**
     * Sets the amount already paid towards this invoice.
     * @param amountPaid The amount paid as a string
     */
    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Gets the amount still due for this invoice.
     * @return The amount remaining as a string
     */
    public String getAmountRemaining() {
        return amountRemaining;
    }

    /**
     * Sets the amount still due for this invoice.
     * @param amountRemaining The amount remaining as a string
     */
    public void setAmountRemaining(String amountRemaining) {
        this.amountRemaining = amountRemaining;
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
     * Gets the Unix timestamp when payment is due.
     * @return The due date timestamp in seconds
     */
    public Long getDueDate() {
        return dueDate;
    }

    /**
     * Sets the Unix timestamp when payment is due.
     * @param dueDate The due date timestamp in seconds
     */
    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the Unix timestamp when the invoice was paid.
     * @return The paid timestamp in seconds, or null if not paid
     */
    public Long getPaidAt() {
        return paidAt;
    }

    /**
     * Sets the Unix timestamp when the invoice was paid.
     * @param paidAt The paid timestamp in seconds
     */
    public void setPaidAt(Long paidAt) {
        this.paidAt = paidAt;
    }

    /**
     * Gets the Unix timestamp when the invoice was voided.
     * @return The voided timestamp in seconds, or null if not voided
     */
    public Long getVoidedAt() {
        return voidedAt;
    }

    /**
     * Sets the Unix timestamp when the invoice was voided.
     * @param voidedAt The voided timestamp in seconds
     */
    public void setVoidedAt(Long voidedAt) {
        this.voidedAt = voidedAt;
    }

    /**
     * Gets the Unix timestamp when the invoice was created.
     * @return The creation timestamp in seconds
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the Unix timestamp when the invoice was created.
     * @param createdAt The creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the Unix timestamp when the invoice was last updated.
     * @return The update timestamp in seconds
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the Unix timestamp when the invoice was last updated.
     * @param updatedAt The update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets the number of payment attempts made for this invoice.
     * @return The attempt count
     */
    public Integer getAttemptCount() {
        return attemptCount;
    }

    /**
     * Sets the number of payment attempts made for this invoice.
     * @param attemptCount The attempt count
     */
    public void setAttemptCount(Integer attemptCount) {
        this.attemptCount = attemptCount;
    }

    /**
     * Gets the custom metadata associated with this invoice.
     * @return The metadata map
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Sets the custom metadata associated with this invoice.
     * @param metadata The metadata map
     */
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the external identifier from an external system.
     * @return The external ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the external identifier from an external system.
     * @param externalId The external ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Gets the version number for optimistic locking.
     * @return The version number
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version number for optimistic locking.
     * @param version The version number
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Gets the display name of the merchant.
     * @return The merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the display name of the merchant.
     * @param merchantName The merchant name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * Gets the public API key of the merchant.
     * @return The public key
     */
    public String getPublicKey() {
        return publicKey;
    }

    /**
     * Sets the public API key of the merchant.
     * @param publicKey The public key
     */
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    /**
     * Gets the email address of the customer.
     * @return The customer email
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the email address of the customer.
     * @param customerEmail The customer email
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Gets the display name of the customer.
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the display name of the customer.
     * @param customerName The customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the name of the subscription product.
     * @return The product name, or null for non-subscription invoices
     */
    public String getSubscriptionProductName() {
        return subscriptionProductName;
    }

    /**
     * Sets the name of the subscription product.
     * @param subscriptionProductName The product name
     */
    public void setSubscriptionProductName(String subscriptionProductName) {
        this.subscriptionProductName = subscriptionProductName;
    }

    /**
     * Gets the variant title of the subscription product.
     * @return The variant title, or null if not applicable
     */
    public String getSubscriptionProductVariant() {
        return subscriptionProductVariant;
    }

    /**
     * Sets the variant title of the subscription product.
     * @param subscriptionProductVariant The variant title
     */
    public void setSubscriptionProductVariant(String subscriptionProductVariant) {
        this.subscriptionProductVariant = subscriptionProductVariant;
    }
}
