package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * EventData contains the data payload of a webhook event.
 *
 * This class encapsulates the actual resource that was affected by the event,
 * along with metadata about what changed. It serves as the container for the
 * event's meaningful data.
 *
 * Structure:
 * - object: The current state of the resource (invoice, payment_intent, etc.)
 * - previous_attributes: For *.updated events, shows what changed
 * - raw: The raw JSON string for custom parsing
 *
 * Object field:
 * - Contains the complete resource in its current state
 * - Structure depends on the event type (invoice, payment_intent, subscription, etc.)
 * - Represented as a Map for flexible handling of different resource types
 * - Can be deserialized to specific types based on event.type
 *
 * Previous attributes (for *.updated events):
 * - Only included in events with type ending in ".updated"
 * - Contains only the fields that changed
 * - Values represent the state BEFORE the update
 * - Compare with current object to see what changed
 * - Useful for audit trails and change detection
 *
 * Use cases:
 * - Extract the affected resource for processing
 * - Determine what changed in an update event
 * - Build audit logs showing before/after states
 * - Trigger different actions based on specific field changes
 * - Store complete event data for future reference
 *
 * Processing patterns:
 * - Check event.type to determine resource type
 * - Deserialize object Map to appropriate model class
 * - For *.updated events, compare previous_attributes with current object
 * - Use raw JSON when you need the original payload
 *
 * Example event types and their objects:
 * - invoice.paid: object contains the paid Invoice
 * - payment_intent.succeeded: object contains the successful PaymentIntent
 * - subscription.updated: object contains updated Subscription + previous_attributes
 * - refund.created: object contains the newly created Refund
 */
public class EventData {
    /**
     * The API resource object that was affected by this event.
     * This is a generic Map representation that can be deserialized to the specific
     * resource type based on the event type.
     *
     * Contains the current state of the resource:
     * - For creation events: The newly created resource
     * - For update events: The resource with all current values
     * - For deletion events: The resource in its final state before deletion
     * - For status change events: The resource with the new status
     *
     * The actual structure depends on the resource type:
     * - Invoice object for invoice.* events
     * - PaymentIntent object for payment_intent.* events
     * - Subscription object for subscription.* events
     * - Refund object for refund.* events
     * - etc.
     */
    private Map<String, Object> object;

    /**
     * For *.updated events, contains the names and previous values of attributes that changed.
     * Only included in events with type ending in ".updated".
     *
     * Structure:
     * - Keys: Names of fields that were modified
     * - Values: The values those fields had BEFORE the update
     *
     * This allows you to:
     * - Identify exactly what changed in an update
     * - Build before/after comparisons
     * - Track field-level audit trails
     * - Trigger logic based on specific field changes
     *
     * Example: If an invoice status changed from "draft" to "open",
     * previous_attributes would contain: {"status": "draft"}
     * while object.status would contain: "open"
     *
     * Null or empty for non-update events.
     */
    @SerializedName("previous_attributes")
    private Map<String, Object> previousAttributes;

    /**
     * The raw JSON string representation of the event object.
     * Contains the original JSON payload as received from the API.
     *
     * Use cases:
     * - Custom parsing when you need access to the original format
     * - Debugging and logging the exact payload
     * - Storing complete event data for future processing
     * - Handling forward compatibility with new API fields
     * - Signature verification against the original payload
     *
     * This field preserves the exact JSON structure even if the
     * deserialized object Map doesn't capture all details.
     */
    private String raw;

    /**
     * Creates a new EventData instance.
     */
    public EventData() {
    }

    /**
     * Gets the API resource object affected by this event.
     * @return Map representation of the resource object
     */
    public Map<String, Object> getObject() {
        return object;
    }

    /**
     * Sets the API resource object affected by this event.
     * @param object Map representation of the resource object
     */
    public void setObject(Map<String, Object> object) {
        this.object = object;
    }

    /**
     * Gets the previous values of attributes that changed (for *.updated events only).
     * @return Map of field names to previous values, or null for non-update events
     */
    public Map<String, Object> getPreviousAttributes() {
        return previousAttributes;
    }

    /**
     * Sets the previous values of attributes that changed.
     * @param previousAttributes Map of field names to previous values
     */
    public void setPreviousAttributes(Map<String, Object> previousAttributes) {
        this.previousAttributes = previousAttributes;
    }

    /**
     * Gets the raw JSON string representation of the event object.
     * @return The raw JSON payload
     */
    public String getRaw() {
        return raw;
    }

    /**
     * Sets the raw JSON string representation of the event object.
     * @param raw The raw JSON payload
     */
    public void setRaw(String raw) {
        this.raw = raw;
    }
}
