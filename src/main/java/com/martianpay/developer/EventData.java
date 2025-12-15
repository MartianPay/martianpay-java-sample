package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * EventData contains the data payload of a webhook event
 */
public class EventData {
    /** Object is a raw mapping of the API resource contained in the event */
    private Map<String, Object> object;

    /** PreviousAttributes contains the names of updated attributes and their values prior to the event (only included in events of type *.updated) */
    @SerializedName("previous_attributes")
    private Map<String, Object> previousAttributes;

    /** Raw is the raw JSON data of the event object */
    private String raw;

    public EventData() {
    }

    public Map<String, Object> getObject() {
        return object;
    }

    public void setObject(Map<String, Object> object) {
        this.object = object;
    }

    public Map<String, Object> getPreviousAttributes() {
        return previousAttributes;
    }

    public void setPreviousAttributes(Map<String, Object> previousAttributes) {
        this.previousAttributes = previousAttributes;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}
