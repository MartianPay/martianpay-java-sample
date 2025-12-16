package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * Parameters for creating or updating a customer record.
 */
public class CustomerParams {
    /**
     * Customer's full name.
     */
    @SerializedName("name")
    private String name;

    /**
     * Customer's email address (must be unique per merchant).
     */
    @SerializedName("email")
    private String email;

    /**
     * Optional description for internal reference (not visible to customer).
     */
    @SerializedName("description")
    private String description;

    /**
     * Key-value pairs for storing additional information.
     */
    @SerializedName("metadata")
    private Map<String, String> metadata;

    /**
     * Customer's phone number in E.164 format (e.g., "+12025551234").
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
