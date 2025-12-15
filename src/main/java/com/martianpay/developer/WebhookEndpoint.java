package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

public class WebhookEndpoint {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("url")
    private String url;

    @SerializedName("api_version")
    private String apiVersion;

    @SerializedName("created")
    private Long created;

    @SerializedName("deleted")
    private Boolean deleted;

    @SerializedName("description")
    private String description;

    @SerializedName("enabled_events")
    private List<String> enabledEvents;

    @SerializedName("livemode")
    private Boolean livemode;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    @SerializedName("secret")
    private String secret;

    @SerializedName("status")
    private String status;

    public WebhookEndpoint() {
    }

    public static String generateWebhookEndpointId() {
        return DeveloperConstants.WEBHOOK_ENDPOINT_ID_PREFIX + generateRandomString(DeveloperConstants.WEBHOOK_ENDPOINT_ID_LENGTH);
    }

    private static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
