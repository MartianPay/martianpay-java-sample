package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;

/**
 * Request to retrieve approval instance details for a resource.
 */
public class ApprovalGetRequest {
    /**
     * ID of the resource that requires approval.
     */
    @SerializedName("resource_id")
    private String resourceID;

    /**
     * Type of resource that requires approval.
     */
    @SerializedName("resource_type")
    private String resourceType;

    /**
     * Optional ID of a specific approval instance. If omitted, retrieves the latest instance.
     */
    @SerializedName("instance_id")
    private String instanceID;

    /**
     * Gets the resource ID requiring approval.
     * @return The resource ID
     */
    public String getResourceID() { return resourceID; }

    /**
     * Sets the resource ID requiring approval.
     * @param resourceID The resource ID
     */
    public void setResourceID(String resourceID) { this.resourceID = resourceID; }

    /**
     * Gets the type of resource requiring approval.
     * @return The resource type
     */
    public String getResourceType() { return resourceType; }

    /**
     * Sets the type of resource requiring approval.
     * @param resourceType The resource type
     */
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    /**
     * Gets the specific approval instance ID.
     * @return The instance ID, or null for latest instance
     */
    public String getInstanceID() { return instanceID; }

    /**
     * Sets the specific approval instance ID.
     * @param instanceID The instance ID
     */
    public void setInstanceID(String instanceID) { this.instanceID = instanceID; }
}
