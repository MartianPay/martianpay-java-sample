package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

/**
 * Webhook endpoint for receiving real-time event notifications from MartianPay.
 * Supports selective event subscription, signature verification, and automatic retry on failures.
 */
public class WebhookEndpoint {
    /**
     * Character set for generating random webhook IDs.
     */
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Secure random generator for creating webhook IDs.
     */
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Unique identifier for the webhook endpoint.
     */
    @SerializedName("id")
    private String id;

    /**
     * Object type identifier, always "webhook_endpoint".
     */
    @SerializedName("object")
    private String object;

    /**
     * The HTTPS URL where webhook events will be sent.
     * Must be publicly accessible and respond with 200 OK.
     */
    @SerializedName("url")
    private String url;

    /**
     * API version for webhook event payloads (e.g., "2023-10-01").
     */
    @SerializedName("api_version")
    private String apiVersion;

    /**
     * Unix timestamp in seconds when the webhook was created.
     */
    @SerializedName("created")
    private Long created;

    /**
     * Whether this webhook endpoint has been deleted.
     */
    @SerializedName("deleted")
    private Boolean deleted;

    /**
     * Human-readable description of the webhook endpoint.
     */
    @SerializedName("description")
    private String description;

    /**
     * List of event types this webhook is subscribed to (e.g., "payment_intent.succeeded").
     */
    @SerializedName("enabled_events")
    private List<String> enabledEvents;

    /**
     * Whether this webhook is in live mode (true) or test mode (false).
     */
    @SerializedName("livemode")
    private Boolean livemode;

    /**
     * Key-value pairs for storing additional information.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Secret key for verifying webhook signatures to ensure authenticity.
     */
    @SerializedName("secret")
    private String secret;

    /**
     * Status of the webhook endpoint ("enabled" or "disabled").
     */
    @SerializedName("status")
    private String status;

    public WebhookEndpoint() {
    }

    /**
     * @return A unique webhook endpoint ID
     */
    public static String generateWebhookEndpointId() {
        return DeveloperConstants.WEBHOOK_ENDPOINT_ID_PREFIX + generateRandomString(DeveloperConstants.WEBHOOK_ENDPOINT_ID_LENGTH);
    }

    /**
     * @param length The desired length
     * @return A random string
     */
    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    /**
     * @return The webhook endpoint ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The webhook endpoint ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The object type
     */
    public String getObject() {
        return object;
    }

    /**
     * @param object The object type
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     * @return The webhook URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The webhook URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The API version
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * @param apiVersion The API version
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * @return The creation timestamp
     */
    public Long getCreated() {
        return created;
    }

    /**
     * @param created The creation timestamp
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * @return The deleted status
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * @param deleted The deleted status
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The enabled events
     */
    public List<String> getEnabledEvents() {
        return enabledEvents;
    }

    /**
     * @param enabledEvents The enabled events
     */
    public void setEnabledEvents(List<String> enabledEvents) {
        this.enabledEvents = enabledEvents;
    }

    /**
     * @return The livemode status
     */
    public Boolean getLivemode() {
        return livemode;
    }

    /**
     * @param livemode The livemode status
     */
    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    /**
     * @return The metadata
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * @param metadata The metadata
     */
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    /**
     * @return The webhook secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret The webhook secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
