package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Request to update an existing customer's information.
 */
public class CustomerUpdateRequest {
    /**
     * Customer ID to update.
     */
    @SerializedName("id")
    private String id;

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
     * Custom metadata as key-value pairs.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Customer's phone number.
     */
    @SerializedName("phone")
    private String phone;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
