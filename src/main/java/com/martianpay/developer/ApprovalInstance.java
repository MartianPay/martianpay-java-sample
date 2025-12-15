package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ApprovalInstance represents an approval workflow instance
 */
public class ApprovalInstance {
    @SerializedName("id")
    private String id;

    @SerializedName("object")
    private String object;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("status")
    private String status;

    @SerializedName("resource_id")
    private String resourceID;

    @SerializedName("resource_type")
    private String resourceType;

    @SerializedName("created_at")
    private Long createdAt;

    @SerializedName("updated_at")
    private Long updatedAt;

    @SerializedName("records")
    private List<ApprovalRecord> records;

    @SerializedName("current_step")
    private ApprovalStep currentStep;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getObject() { return object; }
    public void setObject(String object) { this.object = object; }

    public String getMerchantId() { return merchantId; }
    public void setMerchantId(String merchantId) { this.merchantId = merchantId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getResourceID() { return resourceID; }
    public void setResourceID(String resourceID) { this.resourceID = resourceID; }

    public String getResourceType() { return resourceType; }
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    public Long getCreatedAt() { return createdAt; }
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    public Long getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    public List<ApprovalRecord> getRecords() { return records; }
    public void setRecords(List<ApprovalRecord> records) { this.records = records; }

    public ApprovalStep getCurrentStep() { return currentStep; }
    public void setCurrentStep(ApprovalStep currentStep) { this.currentStep = currentStep; }
}
