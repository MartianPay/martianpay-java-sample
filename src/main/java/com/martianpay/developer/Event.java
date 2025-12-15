package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Event represents a webhook event sent to subscribed endpoints
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

    /** ID is the unique identifier for the event */
    @SerializedName("id")
    private String id;

    /** Object is the type identifier, always "event" */
    @SerializedName("object")
    private String object;

    /** APIVersion is the API version used for this event */
    @SerializedName("api_version")
    private String apiVersion;

    /** Created is the Unix timestamp when the event was created */
    @SerializedName("created")
    private Long created;

    /** Data contains the event payload */
    @SerializedName("data")
    private EventData data;

    /** Livemode indicates whether this event was created in live mode or test mode */
    @SerializedName("livemode")
    private Boolean livemode;

    /** PendingWebhooks is the number of webhooks that haven't been successfully delivered */
    @SerializedName("pending_webhooks")
    private Long pendingWebhooks;

    /** Type is the event type (e.g., "invoice.created" or "charge.refunded") */
    @SerializedName("type")
    private String type;

    public Event() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public EventData getData() {
        return data;
    }

    public void setData(EventData data) {
        this.data = data;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Long getPendingWebhooks() {
        return pendingWebhooks;
    }

    public void setPendingWebhooks(Long pendingWebhooks) {
        this.pendingWebhooks = pendingWebhooks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
