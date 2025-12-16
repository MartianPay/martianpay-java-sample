package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Confirmation response after deleting a customer.
 */
public class CustomerDeleteResponse {
    /** Unique identifier of the deleted customer. */
    @SerializedName("id")
    private String id;

    /** Deletion confirmation flag. */
    @SerializedName("deleted")
    private Boolean deleted;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Boolean getDeleted() { return deleted; }
    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
}
