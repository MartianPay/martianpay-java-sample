package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Event represents a webhook event sent to subscribed endpoints.
 *
 * Events are notifications sent by MartianPay when specific actions occur in your account.
 * These events enable real-time integration and automation by notifying your application
 * when important changes happen (e.g., payments received, invoices paid, refunds processed).
 *
 * Event delivery mechanism:
 * - Events are sent as HTTP POST requests to your registered webhook endpoints
 * - Each event includes a cryptographic signature for verification
 * - Failed deliveries are automatically retried with exponential backoff
 * - Events are delivered in near real-time after the triggering action
 *
 * Event structure:
 * - Unique event ID for idempotency and tracking
 * - Event type indicates what action triggered the event
 * - Data payload contains the relevant object (invoice, payment, etc.)
 * - Timestamp of when the event was created
 * - API version used to generate the event structure
 *
 * Event categories:
 * - Payment Intent events: payment_intent.created, payment_intent.succeeded, etc.
 * - Invoice events: invoice.created, invoice.paid, invoice.payment_failed, etc.
 * - Subscription events: subscription.created, subscription.updated, etc.
 * - Refund events: refund.created, refund.succeeded, etc.
 * - Payout events: payout.created, payout.succeeded, etc.
 * - Payroll events: payroll.approved, payroll.completed, etc.
 *
 * Webhook signature verification:
 * - All events include a Martian-Pay-Signature header
 * - Signature uses HMAC-SHA256 with your webhook secret
 * - Verify signatures to ensure events are from MartianPay
 * - Reject events with invalid or missing signatures
 *
 * Best practices:
 * - Always verify webhook signatures before processing
 * - Return 200 OK quickly and process events asynchronously
 * - Implement idempotency using the event ID
 * - Handle duplicate event deliveries gracefully
 * - Monitor pending_webhooks for delivery issues
 * - Keep webhook endpoints secure (HTTPS only)
 * - Log all received events for debugging and audit trails
 *
 * Error handling:
 * - Return 200 status code to acknowledge receipt
 * - Non-200 responses trigger automatic retries
 * - Events are retried up to 3 days with exponential backoff
 * - Check pending_webhooks to monitor undelivered events
 */
public class Event {
    /** EventObject is the type identifier for event objects */
    public static final String EVENT_OBJECT = "event";
    /** MartianPaySignature is the HTTP header name for webhook signatures */
    public static final String MARTIAN_PAY_SIGNATURE = "Martian-Pay-Signature";

    // Payment Intent events

    /** EVENT_TYPE_PAYMENT_INTENT_CREATED is sent when a new payment intent is created */
    public static final String EVENT_TYPE_PAYMENT_INTENT_CREATED = "payment_intent.created";
    /** EVENT_TYPE_PAYMENT_INTENT_SUCCEEDED is sent when a payment intent has been fully paid and completed successfully */
    public static final String EVENT_TYPE_PAYMENT_INTENT_SUCCEEDED = "payment_intent.succeeded";
    /** EVENT_TYPE_PAYMENT_INTENT_PAYMENT_FAILED is sent when a payment attempt for a payment intent fails */
    public static final String EVENT_TYPE_PAYMENT_INTENT_PAYMENT_FAILED = "payment_intent.payment_failed";
    /** EVENT_TYPE_PAYMENT_INTENT_PROCESSING is sent when a payment intent is being processed (e.g., waiting for blockchain confirmation) */
    public static final String EVENT_TYPE_PAYMENT_INTENT_PROCESSING = "payment_intent.processing";
    /** EVENT_TYPE_PAYMENT_INTENT_PARTIALLY_PAID is sent when a payment intent has received partial payment but is not yet fully paid */
    public static final String EVENT_TYPE_PAYMENT_INTENT_PARTIALLY_PAID = "payment_intent.partially_paid";
    /** EVENT_TYPE_PAYMENT_INTENT_CANCELED is sent when a payment intent is canceled */
    public static final String EVENT_TYPE_PAYMENT_INTENT_CANCELED = "payment_intent.canceled";

    // Refund events

    /** EVENT_TYPE_REFUND_CREATED is sent when a new refund is created */
    public static final String EVENT_TYPE_REFUND_CREATED = "refund.created";
    /** EVENT_TYPE_REFUND_SUCCEEDED is sent when a refund has been successfully processed and funds returned to customer */
    public static final String EVENT_TYPE_REFUND_SUCCEEDED = "refund.succeeded";
    /** EVENT_TYPE_REFUND_UPDATED is sent when a refund's details are updated */
    public static final String EVENT_TYPE_REFUND_UPDATED = "refund.updated";
    /** EVENT_TYPE_REFUND_FAILED is sent when a refund attempt fails */
    public static final String EVENT_TYPE_REFUND_FAILED = "refund.failed";

    // Payout events

    /** EVENT_TYPE_PAYOUT_CREATED is sent when a new payout is created */
    public static final String EVENT_TYPE_PAYOUT_CREATED = "payout.created";
    /** EVENT_TYPE_PAYOUT_SUCCEEDED is sent when a payout has been successfully transferred to the recipient */
    public static final String EVENT_TYPE_PAYOUT_SUCCEEDED = "payout.succeeded";
    /** EVENT_TYPE_PAYOUT_UPDATED is sent when a payout's details are updated */
    public static final String EVENT_TYPE_PAYOUT_UPDATED = "payout.updated";
    /** EVENT_TYPE_PAYOUT_FAILED is sent when a payout attempt fails */
    public static final String EVENT_TYPE_PAYOUT_FAILED = "payout.failed";

    // Payroll events

    /** EVENT_TYPE_PAYROLL_CREATED is sent when a new payroll batch is created */
    public static final String EVENT_TYPE_PAYROLL_CREATED = "payroll.created";
    /** EVENT_TYPE_PAYROLL_APPROVED is sent when a payroll batch has been approved for execution */
    public static final String EVENT_TYPE_PAYROLL_APPROVED = "payroll.approved";
    /** EVENT_TYPE_PAYROLL_REJECTED is sent when a payroll batch approval is rejected */
    public static final String EVENT_TYPE_PAYROLL_REJECTED = "payroll.rejected";
    /** EVENT_TYPE_PAYROLL_CANCELED is sent when a payroll batch is canceled */
    public static final String EVENT_TYPE_PAYROLL_CANCELED = "payroll.canceled";
    /** EVENT_TYPE_PAYROLL_EXECUTING is sent when a payroll batch execution has started */
    public static final String EVENT_TYPE_PAYROLL_EXECUTING = "payroll.executing";
    /** EVENT_TYPE_PAYROLL_COMPLETED is sent when all items in a payroll batch have been processed successfully */
    public static final String EVENT_TYPE_PAYROLL_COMPLETED = "payroll.completed";
    /** EVENT_TYPE_PAYROLL_FAILED is sent when a payroll batch execution fails */
    public static final String EVENT_TYPE_PAYROLL_FAILED = "payroll.failed";

    // Payroll item events

    /** EVENT_TYPE_PAYROLL_ITEM_PROCESSING is sent when an individual payroll item is being processed */
    public static final String EVENT_TYPE_PAYROLL_ITEM_PROCESSING = "payroll_item.processing";
    /** EVENT_TYPE_PAYROLL_ITEM_SUCCEEDED is sent when an individual payroll item has been successfully paid */
    public static final String EVENT_TYPE_PAYROLL_ITEM_SUCCEEDED = "payroll_item.succeeded";
    /** EVENT_TYPE_PAYROLL_ITEM_FAILED is sent when an individual payroll item payment fails */
    public static final String EVENT_TYPE_PAYROLL_ITEM_FAILED = "payroll_item.failed";
    /** EVENT_TYPE_PAYROLL_ITEM_ADDRESS_VERIFICATION is sent when address verification email has been sent to the recipient */
    public static final String EVENT_TYPE_PAYROLL_ITEM_ADDRESS_VERIFICATION = "payroll_item.address_verification_sent";
    /** EVENT_TYPE_PAYROLL_ITEM_ADDRESS_VERIFIED is sent when the recipient has verified their wallet address */
    public static final String EVENT_TYPE_PAYROLL_ITEM_ADDRESS_VERIFIED = "payroll_item.address_verified";

    // Subscription events

    /** EVENT_TYPE_SUBSCRIPTION_CREATED is sent when a new subscription is created */
    public static final String EVENT_TYPE_SUBSCRIPTION_CREATED = "subscription.created";
    /** EVENT_TYPE_SUBSCRIPTION_UPDATED is sent when a subscription's details are updated (e.g., plan, quantity, billing cycle) */
    public static final String EVENT_TYPE_SUBSCRIPTION_UPDATED = "subscription.updated";
    /** EVENT_TYPE_SUBSCRIPTION_DELETED is sent when a subscription is deleted or permanently canceled */
    public static final String EVENT_TYPE_SUBSCRIPTION_DELETED = "subscription.deleted";
    /** EVENT_TYPE_SUBSCRIPTION_PAUSED is sent when a subscription is temporarily paused */
    public static final String EVENT_TYPE_SUBSCRIPTION_PAUSED = "subscription.paused";
    /** EVENT_TYPE_SUBSCRIPTION_RESUMED is sent when a paused subscription is resumed */
    public static final String EVENT_TYPE_SUBSCRIPTION_RESUMED = "subscription.resumed";
    /** EVENT_TYPE_SUBSCRIPTION_TRIAL_WILL is sent when a subscription's trial period is about to end (typically 3 days before) */
    public static final String EVENT_TYPE_SUBSCRIPTION_TRIAL_WILL = "subscription.trial_will_end";

    // Invoice events

    /** EVENT_TYPE_INVOICE_CREATED is sent when a new invoice is created (draft state) */
    public static final String EVENT_TYPE_INVOICE_CREATED = "invoice.created";
    /** EVENT_TYPE_INVOICE_FINALIZED is sent when an invoice is finalized and ready for payment */
    public static final String EVENT_TYPE_INVOICE_FINALIZED = "invoice.finalized";
    /** EVENT_TYPE_INVOICE_PAID is sent when an invoice has been fully paid */
    public static final String EVENT_TYPE_INVOICE_PAID = "invoice.paid";
    /** EVENT_TYPE_INVOICE_PAYMENT_SUCCEEDED is sent when a payment attempt for an invoice succeeds */
    public static final String EVENT_TYPE_INVOICE_PAYMENT_SUCCEEDED = "invoice.payment_succeeded";
    /** EVENT_TYPE_INVOICE_PAYMENT_FAILED is sent when a payment attempt for an invoice fails */
    public static final String EVENT_TYPE_INVOICE_PAYMENT_FAILED = "invoice.payment_failed";
    /** EVENT_TYPE_INVOICE_PAYMENT_ACTION_REQUIRED is sent when an invoice payment requires additional action from the customer */
    public static final String EVENT_TYPE_INVOICE_PAYMENT_ACTION_REQUIRED = "invoice.payment_action_required";
    /** EVENT_TYPE_INVOICE_UPCOMING is sent when an upcoming invoice will be generated soon (for subscriptions) */
    public static final String EVENT_TYPE_INVOICE_UPCOMING = "invoice.upcoming";
    /** EVENT_TYPE_INVOICE_UPDATED is sent when an invoice's details are updated */
    public static final String EVENT_TYPE_INVOICE_UPDATED = "invoice.updated";
    /** EVENT_TYPE_INVOICE_VOIDED is sent when an invoice is voided and can no longer be paid */
    public static final String EVENT_TYPE_INVOICE_VOIDED = "invoice.voided";

    /** DefaultTolerance indicates that signatures older than this will be rejected */
    public static final long DEFAULT_TOLERANCE_SECONDS = 3000000000L;
    /** SigningVersion represents the version of the signature we currently use */
    public static final String SIGNING_VERSION = "v1";

    /**
     * Unique identifier for this event.
     * Format: evt_[random_id]
     * Use this ID for idempotency to prevent processing the same event twice.
     * Event IDs are immutable and globally unique across all events.
     */
    @SerializedName("id")
    private String id;

    /**
     * Type identifier for this object, always "event".
     * Used to distinguish event objects from other API resource types.
     */
    @SerializedName("object")
    private String object;

    /**
     * The API version used to render this event's data.
     * Events generated with different API versions may have different structures.
     * Format: YYYY-MM-DD (e.g., "2025-01-22")
     * This ensures you can process events according to the correct API schema.
     */
    @SerializedName("api_version")
    private String apiVersion;

    /**
     * Unix timestamp (in seconds) when this event was created.
     * Represents when the action occurred and the event was generated.
     * Used for ordering events and implementing time-based processing logic.
     */
    @SerializedName("created")
    private Long created;

    /**
     * The event payload containing the affected resource.
     * This contains the actual data object (invoice, payment_intent, etc.) that triggered the event.
     * The structure depends on the event type.
     * For *.updated events, also includes previous_attributes showing what changed.
     */
    @SerializedName("data")
    private EventData data;

    /**
     * Indicates whether this event occurred in live mode or test mode.
     * - true: Event occurred in production with real transactions
     * - false: Event occurred in test mode with test data
     * Always check this flag to avoid processing test events in production.
     */
    @SerializedName("livemode")
    private Boolean livemode;

    /**
     * Number of webhook deliveries that are still pending for this event.
     * A high number indicates delivery issues with your webhook endpoints.
     * Monitoring this helps identify webhook reliability problems.
     * Count decreases as webhooks are successfully delivered or retries are exhausted.
     */
    @SerializedName("pending_webhooks")
    private Long pendingWebhooks;

    /**
     * The specific event type that occurred.
     * Format: resource.action (e.g., "invoice.paid", "payment_intent.succeeded")
     * Use this to determine which event handler to invoke.
     * See EVENT_TYPE_* constants for all available event types.
     */
    @SerializedName("type")
    private String type;

    /**
     * Creates a new Event instance.
     */
    public Event() {
    }

    // Getters and Setters

    /**
     * Gets the unique identifier for this event.
     * @return The event ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this event.
     * @param id The event ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the type identifier for this object.
     * @return Always returns "event"
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets the type identifier for this object.
     * @param object The object type (should be "event")
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Gets the API version used to render this event.
     * @return The API version string in YYYY-MM-DD format
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Sets the API version used to render this event.
     * @param apiVersion The API version string
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Gets the Unix timestamp when this event was created.
     * @return The creation timestamp in seconds
     */
    public Long getCreated() {
        return created;
    }

    /**
     * Sets the Unix timestamp when this event was created.
     * @param created The creation timestamp in seconds
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * Gets the event data payload containing the affected resource.
     * @return The EventData object with the resource and any previous attributes
     */
    public EventData getData() {
        return data;
    }

    /**
     * Sets the event data payload.
     * @param data The EventData object containing the resource
     */
    public void setData(EventData data) {
        this.data = data;
    }

    /**
     * Gets whether this event occurred in live mode.
     * @return true if live mode, false if test mode
     */
    public Boolean getLivemode() {
        return livemode;
    }

    /**
     * Sets whether this event occurred in live mode.
     * @param livemode true if live mode, false if test mode
     */
    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    /**
     * Gets the number of pending webhook deliveries for this event.
     * @return The count of undelivered webhooks
     */
    public Long getPendingWebhooks() {
        return pendingWebhooks;
    }

    /**
     * Sets the number of pending webhook deliveries for this event.
     * @param pendingWebhooks The count of undelivered webhooks
     */
    public void setPendingWebhooks(Long pendingWebhooks) {
        this.pendingWebhooks = pendingWebhooks;
    }

    /**
     * Gets the specific event type that occurred.
     * @return The event type in resource.action format (e.g., "invoice.paid")
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the specific event type that occurred.
     * @param type The event type string
     */
    public void setType(String type) {
        this.type = type;
    }
}
