package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * CustomerCreateRequest contains parameters for creating a new customer
 */
public class CustomerCreateRequest {
    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("description")
    private String description;

    @SerializedName("metadata")
    private Map<String, String> metadata;

    @SerializedName("phone")
    private String phone;

    // Getters and Setters
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
