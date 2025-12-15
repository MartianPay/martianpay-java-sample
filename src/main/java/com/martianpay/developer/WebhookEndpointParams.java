package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WebhookEndpointParams {
    @SerializedName("url")
    private String url;

    @SerializedName("description")
    private String description;

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
