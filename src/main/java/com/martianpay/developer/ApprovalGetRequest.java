package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * ApprovalGetRequest represents a request to get approval instance details
 */
public class ApprovalGetRequest {
    @SerializedName("resource_id")
    private String resourceID;

    @SerializedName("resource_type")
    private String resourceType;

    @SerializedName("instance_id")
    private String instanceID;

    // Getters and Setters
    public String getResourceID() { return resourceID; }
    public void setResourceID(String resourceID) { this.resourceID = resourceID; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public String getInstanceID() { return instanceID; }
    public void setInstanceID(String instanceID) { this.instanceID = instanceID; }
}
