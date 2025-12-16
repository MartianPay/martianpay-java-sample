package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Parameters for creating or updating a webhook endpoint to receive real-time event notifications.
 * Configure URL, description, and event subscriptions for automated processing.
 */
public class WebhookEndpointParams {
    /**
     * The HTTPS URL where webhook events will be sent.
     * Must be publicly accessible and return 2xx status code.
     */
    @SerializedName("url")
    private String url;

    /**
     * Human-readable description identifying the webhook's purpose and environment.
     */
    @SerializedName("description")
    private String description;

    /**
     * List of event types to receive (e.g., "payment_intent.succeeded", "refund.created").
     * At least one event type must be specified.
     */
    @SerializedName("enabled_events")
    private List<String> enabledEvents;

    public WebhookEndpointParams() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getEnabledEvents() {
        return enabledEvents;
    }

    public void setEnabledEvents(List<String> enabledEvents) {
        this.enabledEvents = enabledEvents;
    }
}
