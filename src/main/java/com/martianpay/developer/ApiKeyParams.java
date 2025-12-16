package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Parameters for creating a new API key.
 */
public class ApiKeyParams {
    /**
     * Human-readable name for the API key.
     */
    @SerializedName("name")
    private String name;

    /**
     * Optional description providing additional context about the key.
     */
    @SerializedName("description")
    private String description;

    /**
     * Type of API key (e.g., "secret", "publishable", "restricted").
     */
    @SerializedName("key_type")
    private String keyType;

    /**
     * Constructs a new empty ApiKeyParams object.
     */
    public ApiKeyParams() {
    }

    /**
     * Gets the name for the API key.
     * @return The API key name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the API key.
     * @param name The API key name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description for the API key.
     * @return The API key description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the API key.
     * @param description The API key description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the type of API key.
     * @return The key type ("secret", "publishable", or "restricted")
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * Sets the type of API key.
     * @param keyType The key type ("secret", "publishable", or "restricted")
     */
    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }
}
