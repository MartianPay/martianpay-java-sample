package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Request to create a new customer.
 * Includes contact information, optional description, metadata, and phone.
 */
public class CustomerCreateRequest {
    /**
     * Customer's full name.
     */
    @SerializedName("name")
    private String name;

    /**
     * Customer's email address.
     */
    @SerializedName("email")
    private String email;

    /**
     * Optional description or notes about the customer.
     */
    @SerializedName("description")
    private String description;

    /**
     * Custom metadata as key-value pairs for additional customer information.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Customer's phone number (optional).
     */
    @SerializedName("phone")
    private String phone;

    /**
     * Gets the customer's name.
     * @return The customer's full name
     */
    public String getName() { return name; }

    /**
     * Sets the customer's name.
     * @param name The customer's full name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the customer's email address.
     * @return The customer's email
     */
    public String getEmail() { return email; }

    /**
     * Sets the customer's email address.
     * @param email The customer's email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Gets the description or notes about the customer.
     * @return The customer description, or null if not set
     */
    public String getDescription() { return description; }

    /**
     * Sets the description or notes about the customer.
     * @param description The customer description
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the custom metadata map.
     * @return The metadata map, or null if not set
     */
    public Map<String, String> getMetadata() { return metadata; }

    /**
     * Sets the custom metadata map.
     * @param metadata The metadata map
     */
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    /**
     * Gets the customer's phone number.
     * @return The phone number, or null if not set
     */
    public String getPhone() { return phone; }

    /**
     * Sets the customer's phone number.
     * @param phone The phone number
     */
    public void setPhone(String phone) { this.phone = phone; }
}
