package com.martianpay.developer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

/**
 * Subscription represents a recurring payment subscription in the MartianPay system.
 *
 * A subscription enables merchants to charge customers on a recurring basis for products or services.
 * Subscriptions can be configured with various billing intervals (e.g., daily, weekly, monthly, yearly)
 * and can include trial periods, setup fees, and discount codes.
 *
 * Key features:
 * - Automatic recurring billing based on selling plan configuration
 * - Support for multiple payment methods (crypto, fiat cards)
 * - Flexible billing cycles and pricing tiers
 * - Automatic retry logic for failed payments
 * - Pause and resume capabilities
 * - Proration support for mid-cycle changes
 *
 * Lifecycle states:
 * - Active: Subscription is currently active and billing normally
 * - Paused: Subscription is temporarily paused, no billing occurs
 * - Cancelled: Subscription has been cancelled and will not renew
 * - Expired: Subscription period has ended
 * - Incomplete: Initial payment has not been completed
 */
public class Subscription {
    /**
     * Unique identifier for the subscription object.
     * Format: sub_[random_id]
     * This ID is used for all API operations involving this subscription.
     */
    @SerializedName("id")
    private String id;

    /**
     * String representing the object type. Always "subscription" for subscription objects.
     * Used for type identification in API responses.
     */
    @SerializedName("object")
    private String object;

    /**
     * The merchant ID that owns this subscription.
     * Format: mer_[random_id]
     * Links the subscription to the merchant account.
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * The ID of the customer who owns this subscription.
     * Format: cus_[random_id]
     * Links the subscription to the customer account who will be charged.
     */
    @SerializedName("customer_id")
    private String customerId;

    /**
     * The ID of the selling plan defining the billing terms for this subscription.
     * Format: plan_[random_id]
     * The selling plan defines billing frequency, pricing tiers, and discounts.
     */
    @SerializedName("selling_plan_id")
    private String sellingPlanId;

    /**
     * The ID of the product being subscribed to.
     * Format: prod_[random_id]
     * Links to the product catalog entry.
     */
    @SerializedName("product_id")
    private String productId;

    /**
     * The ID of the specific product variant being subscribed to.
     * Format: variant_[random_id]
     * Specifies the exact configuration (size, color, etc.) if the product has variants.
     */
    @SerializedName("variant_id")
    private String variantId;

    /**
     * Current status of the subscription.
     * Possible values:
     * - "active": Subscription is currently active and billing
     * - "paused": Subscription is temporarily paused
     * - "canceled": Subscription has been cancelled
     * - "incomplete": Initial payment has not completed
     * - "expired": Subscription period has ended
     */
    @SerializedName("status")
    private String status;

    /**
     * How payments are collected for this subscription.
     * Possible values:
     * - "charge_automatically": Payments are automatically charged using the default payment method
     * - "send_invoice": Invoices are sent to the customer for manual payment
     */
    @SerializedName("collection_method")
    private String collectionMethod;

    /**
     * Timestamp that determines when billing cycles start for this subscription.
     * Unix timestamp in seconds.
     * This anchor point is used to calculate all future billing dates.
     * For example, if set to the 1st of the month, all cycles start on the 1st.
     */
    @SerializedName("billing_cycle_anchor")
    private Long billingCycleAnchor;

    /**
     * Start of the current billing period.
     * Unix timestamp in seconds.
     * Indicates when the current billing cycle began.
     */
    @SerializedName("current_period_start")
    private Long currentPeriodStart;

    /**
     * End of the current billing period.
     * Unix timestamp in seconds.
     * The subscription will automatically renew at this time unless cancelled.
     */
    @SerializedName("current_period_end")
    private Long currentPeriodEnd;

    /**
     * Start of the trial period, if one exists.
     * Unix timestamp in seconds.
     * Null if no trial period was configured.
     * During the trial, customers can use the service without being charged.
     */
    @SerializedName("trial_start")
    private Long trialStart;

    /**
     * End of the trial period, if one exists.
     * Unix timestamp in seconds.
     * Null if no trial period was configured.
     * Regular billing begins after this time.
     */
    @SerializedName("trial_end")
    private Long trialEnd;

    /**
     * Timestamp when the subscription was cancelled.
     * Unix timestamp in seconds.
     * Null if the subscription has not been cancelled.
     * Note: A cancelled subscription may still be active until the end of the current period.
     */
    @SerializedName("canceled_at")
    private Long canceledAt;

    /**
     * Whether the subscription will be cancelled at the end of the current billing period.
     * If true, the subscription remains active until current_period_end, then terminates.
     * If false, the subscription continues to renew automatically.
     */
    @SerializedName("cancel_at_period_end")
    private Boolean cancelAtPeriodEnd;

    /**
     * Reason provided when the subscription was cancelled.
     * Free-form text field that can be used for tracking cancellation reasons.
     * Useful for customer retention analysis.
     */
    @SerializedName("cancel_reason")
    private String cancelReason;

    /**
     * Behavior when a subscription is paused.
     * Possible values:
     * - "keep_as_draft": Keep invoices as drafts and don't attempt to collect payment
     * - "mark_uncollectible": Mark invoices as uncollectible
     * - "void": Void any generated invoices
     */
    @SerializedName("pause_collection_behavior")
    private String pauseCollectionBehavior;

    /**
     * Timestamp when the subscription was paused.
     * Unix timestamp in seconds.
     * Null if the subscription has never been paused or is currently active.
     */
    @SerializedName("paused_at")
    private Long pausedAt;

    /**
     * Timestamp when a paused subscription will automatically resume.
     * Unix timestamp in seconds.
     * Null if no automatic resume is scheduled.
     * When this time is reached, billing will resume automatically.
     */
    @SerializedName("resumes_at")
    private Long resumesAt;

    /**
     * The ID of the most recent invoice generated for this subscription.
     * Format: inv_[random_id]
     * Links to the latest invoice object for payment tracking.
     */
    @SerializedName("latest_invoice_id")
    private String latestInvoiceId;

    /**
     * The ID of the default payment method used for this subscription.
     * Format: pm_[random_id]
     * This payment method is charged for each billing cycle.
     */
    @SerializedName("default_payment_method_id")
    private String defaultPaymentMethodId;

    /**
     * The type of payment provider for the default payment method.
     * Possible values:
     * - "crypto": Cryptocurrency payment
     * - "stripe": Stripe payment processing
     * - "payermax": PayerMax payment processing
     * Indicates which payment system processes the recurring charges.
     */
    @SerializedName("default_provider_type")
    private String defaultProviderType;

    /**
     * The specific type of payment method being used.
     * Possible values:
     * - "card": Credit or debit card
     * - "crypto": Cryptocurrency wallet
     * - "bank_account": Bank account (ACH/SEPA)
     * Provides more specific information about the payment method.
     */
    @SerializedName("default_payment_method_type")
    private String defaultPaymentMethodType;

    /**
     * Set of key-value pairs for storing additional information about the subscription.
     * Can be used to store custom data such as user preferences, internal IDs, or integration data.
     * All metadata keys and values must be strings.
     * Maximum 50 keys, with key names up to 40 characters and values up to 500 characters.
     */
    @SerializedName("metadata")
    private Map<String, Object> metadata;

    /**
     * External identifier for this subscription from an external system.
     * Useful for linking MartianPay subscriptions to records in your own database
     * or third-party systems (e.g., Shopify subscription ID, internal order ID).
     */
    @SerializedName("external_id")
    private String externalId;

    /**
     * Timestamp when the subscription was created.
     * Unix timestamp in seconds.
     * Immutable value set at subscription creation time.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Timestamp when the subscription was last updated.
     * Unix timestamp in seconds.
     * Updated whenever any subscription field is modified.
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * Whether a payment is required to activate this subscription.
     * If true, the customer needs to complete a payment before the subscription becomes active.
     * Common for subscriptions with no trial period or when initial payment failed.
     */
    @SerializedName("payment_required")
    private Boolean paymentRequired;

    /**
     * URL where the customer can complete payment for this subscription.
     * Only present when payment_required is true.
     * Send customers to this URL to complete the initial payment and activate the subscription.
     */
    @SerializedName("payment_url")
    private String paymentUrl;

    /**
     * Timestamp when the payment URL expires.
     * Unix timestamp in seconds.
     * After this time, a new payment URL must be generated.
     * Null if no payment is required or no expiration is set.
     */
    @SerializedName("payment_expires_at")
    private Long paymentExpiresAt;

    /**
     * Number of hours that have elapsed since the subscription was created.
     * Floating point value for precision.
     * Useful for tracking subscription age and time-based business logic.
     */
    @SerializedName("hours_since_creation")
    private Double hoursSinceCreation;

    /**
     * The current billing cycle number.
     * Integer value starting at 1 for the first billing cycle.
     * Increments by 1 each time the subscription renews.
     * Useful for tracking subscription tenure and cycle-based pricing tiers.
     */
    @SerializedName("current_cycle_number")
    private Integer currentCycleNumber;

    /**
     * Pricing tier information for the current billing cycle.
     * Contains the actual pricing being applied in the current period,
     * including base price, discounts, final price, and billing frequency.
     * Null if pricing tier information is not available.
     */
    @SerializedName("current_pricing_tier")
    private SubscriptionCurrentPricingTier currentPricingTier;

    /**
     * Pricing tier information for the upcoming billing cycle.
     * Shows what pricing will be applied when the current period ends.
     * Useful for displaying future charges to customers.
     * May differ from current pricing if using progressive pricing models.
     * Null if no upcoming cycle is scheduled or pricing tier information is unavailable.
     */
    @SerializedName("upcoming_pricing_tier")
    private SubscriptionCurrentPricingTier upcomingPricingTier;

    /**
     * The amount that will be charged at the next billing cycle.
     * String representation of the decimal amount.
     * Example: "29.99"
     * Uses the currency specified in the selling plan.
     */
    @SerializedName("next_charge_amount")
    private String nextChargeAmount;

    /**
     * Human-readable display version of the next charge amount.
     * Includes currency symbol and formatting.
     * Example: "$29.99 USD"
     * Ready to display to end users without additional formatting.
     */
    @SerializedName("next_charge_amount_display")
    private String nextChargeAmountDisplay;

    /**
     * Complete pricing information from the selling plan.
     * Contains billing cycle, currency, trial period, and all pricing tiers.
     * Provides full context of how pricing changes over the subscription lifetime.
     */
    @SerializedName("selling_plan_pricing")
    private SellingPlanPricing sellingPlanPricing;

    /**
     * Display name of the merchant.
     * The business name shown to customers.
     * Denormalized field for convenience - source of truth is the Merchant object.
     */
    @SerializedName("merchant_name")
    private String merchantName;

    /**
     * Email address of the customer who owns this subscription.
     * Denormalized field for convenience - source of truth is the Customer object.
     */
    @SerializedName("customer_email")
    private String customerEmail;

    /**
     * Full name of the customer who owns this subscription.
     * Denormalized field for convenience - source of truth is the Customer object.
     */
    @SerializedName("customer_name")
    private String customerName;

    /**
     * Name of the product being subscribed to.
     * Denormalized field for convenience - source of truth is the Product object.
     */
    @SerializedName("product_name")
    private String productName;

    /**
     * Description of the product being subscribed to.
     * Denormalized field for convenience - source of truth is the Product object.
     */
    @SerializedName("product_description")
    private String productDescription;

    /**
     * URL of the primary product image.
     * Denormalized field for convenience - source of truth is the Product object.
     * Can be used to display product imagery in subscription management interfaces.
     */
    @SerializedName("product_image_url")
    private String productImageUrl;

    /**
     * Title of the specific product variant.
     * Example: "Large / Blue" or "Enterprise Plan"
     * Denormalized field for convenience - source of truth is the ProductVariant object.
     */
    @SerializedName("variant_title")
    private String variantTitle;

    /**
     * Map of option names to option values for the product variant.
     * Example: {"Size": "Large", "Color": "Blue"}
     * Denormalized field for convenience - source of truth is the ProductVariant object.
     */
    @SerializedName("variant_option_values")
    private Map<String, String> variantOptionValues;

    /**
     * Base price of the product variant before any subscription discounts.
     * String representation of the decimal amount.
     * Example: "39.99"
     * Denormalized field for convenience - source of truth is the ProductVariant object.
     */
    @SerializedName("variant_price")
    private String variantPrice;

    /**
     * Display name of the selling plan.
     * Example: "Monthly Pro Plan", "Annual Subscription"
     * Denormalized field for convenience - source of truth is the SellingPlan object.
     */
    @SerializedName("selling_plan_name")
    private String sellingPlanName;

    /**
     * Description of the selling plan explaining the billing terms and benefits.
     * Denormalized field for convenience - source of truth is the SellingPlan object.
     */
    @SerializedName("selling_plan_description")
    private String sellingPlanDescription;

    /**
     * Brand of the payment method (e.g., "Visa", "Mastercard", "Bitcoin").
     * Null if no payment method is attached or brand information is unavailable.
     * Denormalized field for convenience - source of truth is the PaymentMethod object.
     */
    @SerializedName("payment_method_brand")
    private String paymentMethodBrand;

    /**
     * Last 4 digits of the payment method (card number, account number, wallet address).
     * Used for displaying masked payment method information.
     * Example: "4242" for a card ending in 4242
     * Null if no payment method is attached.
     * Denormalized field for convenience - source of truth is the PaymentMethod object.
     */
    @SerializedName("payment_method_last4")
    private String paymentMethodLast4;

    /**
     * Default constructor.
     * Creates a new Subscription instance with all fields initialized to null.
     */
    public Subscription() {
    }

    /**
     * Gets the unique identifier for this subscription.
     * @return The subscription ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this subscription.
     * @param id The subscription ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the object type identifier.
     * @return Always "subscription"
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the object type identifier.
     * @param object Should be "subscription"
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the merchant ID that owns this subscription.
     * @return The merchant ID
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the merchant ID that owns this subscription.
     * @param merchantId The merchant ID
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Gets the customer ID who owns this subscription.
     * @return The customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customer ID who owns this subscription.
     * @param customerId The customer ID
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the selling plan ID defining the billing terms.
     * @return The selling plan ID
     */
    public String getSellingPlanId() {
        return sellingPlanId;
    }

    /**
     * Sets the selling plan ID defining the billing terms.
     * @param sellingPlanId The selling plan ID
     */
    public void setSellingPlanId(String sellingPlanId) {
        this.sellingPlanId = sellingPlanId;
    }

    /**
     * Gets the product ID being subscribed to.
     * @return The product ID
     */
    public String getProductId() {
        return productId;
    }

    /**
     * Sets the product ID being subscribed to.
     * @param productId The product ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Gets the product variant ID being subscribed to.
     * @return The variant ID
     */
    public String getVariantId() {
        return variantId;
    }

    /**
     * Sets the product variant ID being subscribed to.
     * @param variantId The variant ID
     */
    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    /**
     * Gets the current status of the subscription.
     * @return The subscription status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the current status of the subscription.
     * @param status The subscription status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the payment collection method.
     * @return The collection method
     */
    public String getCollectionMethod() {
        return collectionMethod;
    }

    /**
     * Sets the payment collection method.
     * @param collectionMethod The collection method
     */
    public void setCollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
    }

    /**
     * Gets the billing cycle anchor timestamp.
     * @return The billing cycle anchor in Unix timestamp (seconds)
     */
    public Long getBillingCycleAnchor() {
        return billingCycleAnchor;
    }

    /**
     * Sets the billing cycle anchor timestamp.
     * @param billingCycleAnchor The billing cycle anchor in Unix timestamp (seconds)
     */
    public void setBillingCycleAnchor(Long billingCycleAnchor) {
        this.billingCycleAnchor = billingCycleAnchor;
    }

    /**
     * Gets the start of the current billing period.
     * @return The current period start in Unix timestamp (seconds)
     */
    public Long getCurrentPeriodStart() {
        return currentPeriodStart;
    }

    /**
     * Sets the start of the current billing period.
     * @param currentPeriodStart The current period start in Unix timestamp (seconds)
     */
    public void setCurrentPeriodStart(Long currentPeriodStart) {
        this.currentPeriodStart = currentPeriodStart;
    }

    /**
     * Gets the end of the current billing period.
     * @return The current period end in Unix timestamp (seconds)
     */
    public Long getCurrentPeriodEnd() {
        return currentPeriodEnd;
    }

    /**
     * Sets the end of the current billing period.
     * @param currentPeriodEnd The current period end in Unix timestamp (seconds)
     */
    public void setCurrentPeriodEnd(Long currentPeriodEnd) {
        this.currentPeriodEnd = currentPeriodEnd;
    }

    /**
     * Gets the start of the trial period.
     * @return The trial start in Unix timestamp (seconds), or null if no trial
     */
    public Long getTrialStart() {
        return trialStart;
    }

    /**
     * Sets the start of the trial period.
     * @param trialStart The trial start in Unix timestamp (seconds)
     */
    public void setTrialStart(Long trialStart) {
        this.trialStart = trialStart;
    }

    /**
     * Gets the end of the trial period.
     * @return The trial end in Unix timestamp (seconds), or null if no trial
     */
    public Long getTrialEnd() {
        return trialEnd;
    }

    /**
     * Sets the end of the trial period.
     * @param trialEnd The trial end in Unix timestamp (seconds)
     */
    public void setTrialEnd(Long trialEnd) {
        this.trialEnd = trialEnd;
    }

    /**
     * Gets the timestamp when the subscription was cancelled.
     * @return The cancellation timestamp in Unix seconds, or null if not cancelled
     */
    public Long getCanceledAt() {
        return canceledAt;
    }

    /**
     * Sets the timestamp when the subscription was cancelled.
     * @param canceledAt The cancellation timestamp in Unix seconds
     */
    public void setCanceledAt(Long canceledAt) {
        this.canceledAt = canceledAt;
    }

    /**
     * Gets whether the subscription will cancel at period end.
     * @return True if cancelling at period end, false otherwise
     */
    public Boolean getCancelAtPeriodEnd() {
        return cancelAtPeriodEnd;
    }

    /**
     * Sets whether the subscription will cancel at period end.
     * @param cancelAtPeriodEnd True to cancel at period end
     */
    public void setCancelAtPeriodEnd(Boolean cancelAtPeriodEnd) {
        this.cancelAtPeriodEnd = cancelAtPeriodEnd;
    }

    /**
     * Gets the reason for subscription cancellation.
     * @return The cancellation reason, or null if not cancelled
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * Sets the reason for subscription cancellation.
     * @param cancelReason The cancellation reason
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     * Gets the pause collection behavior.
     * @return The pause behavior
     */
    public String getPauseCollectionBehavior() {
        return pauseCollectionBehavior;
    }

    /**
     * Sets the pause collection behavior.
     * @param pauseCollectionBehavior The pause behavior
     */
    public void setPauseCollectionBehavior(String pauseCollectionBehavior) {
        this.pauseCollectionBehavior = pauseCollectionBehavior;
    }

    /**
     * Gets the timestamp when the subscription was paused.
     * @return The pause timestamp in Unix seconds, or null if not paused
     */
    public Long getPausedAt() {
        return pausedAt;
    }

    /**
     * Sets the timestamp when the subscription was paused.
     * @param pausedAt The pause timestamp in Unix seconds
     */
    public void setPausedAt(Long pausedAt) {
        this.pausedAt = pausedAt;
    }

    /**
     * Gets the timestamp when a paused subscription will resume.
     * @return The resume timestamp in Unix seconds, or null if no resume scheduled
     */
    public Long getResumesAt() {
        return resumesAt;
    }

    /**
     * Sets the timestamp when a paused subscription will resume.
     * @param resumesAt The resume timestamp in Unix seconds
     */
    public void setResumesAt(Long resumesAt) {
        this.resumesAt = resumesAt;
    }

    /**
     * Gets the ID of the latest invoice.
     * @return The latest invoice ID
     */
    public String getLatestInvoiceId() {
        return latestInvoiceId;
    }

    /**
     * Sets the ID of the latest invoice.
     * @param latestInvoiceId The latest invoice ID
     */
    public void setLatestInvoiceId(String latestInvoiceId) {
        this.latestInvoiceId = latestInvoiceId;
    }

    /**
     * Gets the default payment method ID.
     * @return The payment method ID
     */
    public String getDefaultPaymentMethodId() {
        return defaultPaymentMethodId;
    }

    /**
     * Sets the default payment method ID.
     * @param defaultPaymentMethodId The payment method ID
     */
    public void setDefaultPaymentMethodId(String defaultPaymentMethodId) {
        this.defaultPaymentMethodId = defaultPaymentMethodId;
    }

    /**
     * Gets the default payment provider type.
     * @return The provider type (e.g., "crypto", "stripe", "payermax")
     */
    public String getDefaultProviderType() {
        return defaultProviderType;
    }

    /**
     * Sets the default payment provider type.
     * @param defaultProviderType The provider type
     */
    public void setDefaultProviderType(String defaultProviderType) {
        this.defaultProviderType = defaultProviderType;
    }

    /**
     * Gets the default payment method type.
     * @return The payment method type (e.g., "card", "crypto", "bank_account")
     */
    public String getDefaultPaymentMethodType() {
        return defaultPaymentMethodType;
    }

    /**
     * Sets the default payment method type.
     * @param defaultPaymentMethodType The payment method type
     */
    public void setDefaultPaymentMethodType(String defaultPaymentMethodType) {
        this.defaultPaymentMethodType = defaultPaymentMethodType;
    }

    /**
     * Gets the metadata key-value pairs.
     * @return The metadata map
     */
    public Map<String, Object> getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata key-value pairs.
     * @param metadata The metadata map
     */
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    /**
     * Gets the external identifier.
     * @return The external ID
     */
    public String getExternalId() {
        return externalId;
    }

    /**
     * Sets the external identifier.
     * @param externalId The external ID
     */
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    /**
     * Gets the creation timestamp.
     * @return The creation time in Unix timestamp (seconds)
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp.
     * @param createdAt The creation time in Unix timestamp (seconds)
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the last update timestamp.
     * @return The update time in Unix timestamp (seconds)
     */
    public Long getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the last update timestamp.
     * @param updatedAt The update time in Unix timestamp (seconds)
     */
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets whether payment is required to activate the subscription.
     * @return True if payment is required, false otherwise
     */
    public Boolean getPaymentRequired() {
        return paymentRequired;
    }

    /**
     * Sets whether payment is required to activate the subscription.
     * @param paymentRequired True if payment is required
     */
    public void setPaymentRequired(Boolean paymentRequired) {
        this.paymentRequired = paymentRequired;
    }

    /**
     * Gets the payment URL for completing subscription payment.
     * @return The payment URL
     */
    public String getPaymentUrl() {
        return paymentUrl;
    }

    /**
     * Sets the payment URL for completing subscription payment.
     * @param paymentUrl The payment URL
     */
    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    /**
     * Gets the payment URL expiration timestamp.
     * @return The expiration time in Unix timestamp (seconds)
     */
    public Long getPaymentExpiresAt() {
        return paymentExpiresAt;
    }

    /**
     * Sets the payment URL expiration timestamp.
     * @param paymentExpiresAt The expiration time in Unix timestamp (seconds)
     */
    public void setPaymentExpiresAt(Long paymentExpiresAt) {
        this.paymentExpiresAt = paymentExpiresAt;
    }

    /**
     * Gets the hours elapsed since subscription creation.
     * @return The hours since creation
     */
    public Double getHoursSinceCreation() {
        return hoursSinceCreation;
    }

    /**
     * Sets the hours elapsed since subscription creation.
     * @param hoursSinceCreation The hours since creation
     */
    public void setHoursSinceCreation(Double hoursSinceCreation) {
        this.hoursSinceCreation = hoursSinceCreation;
    }

    /**
     * Gets the current billing cycle number.
     * @return The cycle number (1-based)
     */
    public Integer getCurrentCycleNumber() {
        return currentCycleNumber;
    }

    /**
     * Sets the current billing cycle number.
     * @param currentCycleNumber The cycle number
     */
    public void setCurrentCycleNumber(Integer currentCycleNumber) {
        this.currentCycleNumber = currentCycleNumber;
    }

    /**
     * Gets the current pricing tier information.
     * @return The current pricing tier
     */
    public SubscriptionCurrentPricingTier getCurrentPricingTier() {
        return currentPricingTier;
    }

    /**
     * Sets the current pricing tier information.
     * @param currentPricingTier The current pricing tier
     */
    public void setCurrentPricingTier(SubscriptionCurrentPricingTier currentPricingTier) {
        this.currentPricingTier = currentPricingTier;
    }

    /**
     * Gets the upcoming pricing tier information.
     * @return The upcoming pricing tier
     */
    public SubscriptionCurrentPricingTier getUpcomingPricingTier() {
        return upcomingPricingTier;
    }

    /**
     * Sets the upcoming pricing tier information.
     * @param upcomingPricingTier The upcoming pricing tier
     */
    public void setUpcomingPricingTier(SubscriptionCurrentPricingTier upcomingPricingTier) {
        this.upcomingPricingTier = upcomingPricingTier;
    }

    /**
     * Gets the next charge amount.
     * @return The next charge amount as a string
     */
    public String getNextChargeAmount() {
        return nextChargeAmount;
    }

    /**
     * Sets the next charge amount.
     * @param nextChargeAmount The next charge amount as a string
     */
    public void setNextChargeAmount(String nextChargeAmount) {
        this.nextChargeAmount = nextChargeAmount;
    }

    /**
     * Gets the human-readable next charge amount with currency.
     * @return The formatted next charge amount
     */
    public String getNextChargeAmountDisplay() {
        return nextChargeAmountDisplay;
    }

    /**
     * Sets the human-readable next charge amount with currency.
     * @param nextChargeAmountDisplay The formatted next charge amount
     */
    public void setNextChargeAmountDisplay(String nextChargeAmountDisplay) {
        this.nextChargeAmountDisplay = nextChargeAmountDisplay;
    }

    /**
     * Gets the complete selling plan pricing information.
     * @return The selling plan pricing
     */
    public SellingPlanPricing getSellingPlanPricing() {
        return sellingPlanPricing;
    }

    /**
     * Sets the complete selling plan pricing information.
     * @param sellingPlanPricing The selling plan pricing
     */
    public void setSellingPlanPricing(SellingPlanPricing sellingPlanPricing) {
        this.sellingPlanPricing = sellingPlanPricing;
    }

    /**
     * Gets the merchant name.
     * @return The merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * Sets the merchant name.
     * @param merchantName The merchant name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * Gets the customer email address.
     * @return The customer email
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the customer email address.
     * @param customerEmail The customer email
     */
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    /**
     * Gets the customer name.
     * @return The customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name.
     * @param customerName The customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the product name.
     * @return The product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the product name.
     * @param productName The product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets the product description.
     * @return The product description
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the product description.
     * @param productDescription The product description
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Gets the product image URL.
     * @return The product image URL
     */
    public String getProductImageUrl() {
        return productImageUrl;
    }

    /**
     * Sets the product image URL.
     * @param productImageUrl The product image URL
     */
    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    /**
     * Gets the variant title.
     * @return The variant title
     */
    public String getVariantTitle() {
        return variantTitle;
    }

    /**
     * Sets the variant title.
     * @param variantTitle The variant title
     */
    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    /**
     * Gets the variant option values.
     * @return The map of option names to values
     */
    public Map<String, String> getVariantOptionValues() {
        return variantOptionValues;
    }

    /**
     * Sets the variant option values.
     * @param variantOptionValues The map of option names to values
     */
    public void setVariantOptionValues(Map<String, String> variantOptionValues) {
        this.variantOptionValues = variantOptionValues;
    }

    /**
     * Gets the variant base price.
     * @return The variant price as a string
     */
    public String getVariantPrice() {
        return variantPrice;
    }

    /**
     * Sets the variant base price.
     * @param variantPrice The variant price as a string
     */
    public void setVariantPrice(String variantPrice) {
        this.variantPrice = variantPrice;
    }

    /**
     * Gets the selling plan name.
     * @return The selling plan name
     */
    public String getSellingPlanName() {
        return sellingPlanName;
    }

    /**
     * Sets the selling plan name.
     * @param sellingPlanName The selling plan name
     */
    public void setSellingPlanName(String sellingPlanName) {
        this.sellingPlanName = sellingPlanName;
    }

    /**
     * Gets the selling plan description.
     * @return The selling plan description
     */
    public String getSellingPlanDescription() {
        return sellingPlanDescription;
    }

    /**
     * Sets the selling plan description.
     * @param sellingPlanDescription The selling plan description
     */
    public void setSellingPlanDescription(String sellingPlanDescription) {
        this.sellingPlanDescription = sellingPlanDescription;
    }

    /**
     * Gets the payment method brand.
     * @return The payment method brand
     */
    public String getPaymentMethodBrand() {
        return paymentMethodBrand;
    }

    /**
     * Sets the payment method brand.
     * @param paymentMethodBrand The payment method brand
     */
    public void setPaymentMethodBrand(String paymentMethodBrand) {
        this.paymentMethodBrand = paymentMethodBrand;
    }

    /**
     * Gets the last 4 digits of the payment method.
     * @return The last 4 digits
     */
    public String getPaymentMethodLast4() {
        return paymentMethodLast4;
    }

    /**
     * Sets the last 4 digits of the payment method.
     * @param paymentMethodLast4 The last 4 digits
     */
    public void setPaymentMethodLast4(String paymentMethodLast4) {
        this.paymentMethodLast4 = paymentMethodLast4;
    }
}
