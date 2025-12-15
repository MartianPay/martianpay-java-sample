package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * CustomerDeleteResponse represents response after deleting a customer
 */
public class CustomerDeleteResponse {
    @SerializedName("id")
    private String id;

    @SerializedName("deleted")
    private Boolean deleted;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Boolean getDeleted() { return deleted; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
}
