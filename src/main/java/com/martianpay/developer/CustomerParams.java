package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * CustomerParams contains parameters for creating or updating a customer
 */
public class CustomerParams {
    /**
     * Name is the customer's full name
     */
    @SerializedName("name")
    private String name;

    /**
     * Email is the customer's email address (must be unique per merchant)
     */
    @SerializedName("email")
    private String email;

    /**
     * Description is an optional text description for internal reference
     */
    @SerializedName("description")
    private String description;

    /**
     * Metadata is a set of key-value pairs for storing additional information
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Phone is the customer's phone number in E.164 format (e.g., +1234567890)
     */
    @SerializedName("phone")
    private String phone;

    public CustomerParams() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
