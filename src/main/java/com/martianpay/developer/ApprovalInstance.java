package com.martianpay.developer;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * ApprovalInstance represents a running instance of an approval workflow.
 *
 * An approval instance is created whenever an operation requiring multi-party authorization
 * is initiated. It tracks the entire lifecycle of the approval process from initiation
 * through completion or rejection.
 *
 * Workflow lifecycle:
 * 1. Created - Instance initialized when operation requested
 * 2. Pending - Awaiting approver actions at current step
 * 3. In Progress - Approvers are reviewing and acting
 * 4. Approved - All required approvals obtained
 * 5. Rejected - At least one approver rejected
 * 6. Expired - Approval deadline passed without completion
 * 7. Executed - Approved operation has been carried out
 * 8. Cancelled - Requester cancelled the approval
 *
 * Key features:
 * - Multi-step approval chains with conditional routing
 * - Role-based approval permissions
 * - Complete audit trail of all actions
 * - Current step tracking
 * - Approval history and timestamps
 *
 * Use cases:
 * - Large payout approvals (e.g., >$10,000)
 * - Withdrawal authorizations
 * - Security-sensitive configuration changes
 * - Multi-signature transaction requirements
 * - Compliance-mandated dual control
 */
public class ApprovalInstance {
    /**
     * Unique identifier for this approval instance.
     * Format: instance_[random_id]
     */
    @SerializedName("id")
    private String id;

    /**
     * Object type identifier, always "approval_instance".
     */
    @SerializedName("object")
    private String object;

    /**
     * ID of the merchant that owns this approval instance.
     * Links the approval to the merchant's account.
     */
    @SerializedName("merchant_id")
    private String merchantId;

    /**
     * Current status of the approval instance.
     *
     * Possible values:
     * - "created" - Instance just initialized
     * - "pending" - Awaiting approver actions
     * - "in_progress" - Being reviewed by approvers
     * - "approved" - All required approvals received
     * - "rejected" - Rejected by at least one approver
     * - "expired" - Deadline passed without completion
     * - "executed" - Approved operation completed
     * - "cancelled" - Cancelled by requester
     */
    @SerializedName("status")
    private String status;

    /**
     * ID of the resource that requires approval.
     *
     * This identifies the specific operation or object being approved.
     * Examples:
     * - Payout ID for payout approvals
     * - Withdrawal ID for withdrawal approvals
     * - Config ID for configuration changes
     */
    @SerializedName("resource_id")
    private String resourceID;

    /**
     * Type of resource requiring approval.
     *
     * Categorizes the operation being approved.
     * Common values: "payout", "withdrawal", "config_change", "api_key", "refund"
     */
    @SerializedName("resource_type")
    private String resourceType;

    /**
     * Unix timestamp (in seconds) when this approval instance was created.
     */
    @SerializedName("created_at")
    private Long createdAt;

    /**
     * Unix timestamp (in seconds) when this approval instance was last updated.
     * Updated whenever any approval action occurs (approve, reject, transition, etc.).
     */
    @SerializedName("updated_at")
    private Long updatedAt;

    /**
     * List of approval records showing the complete approval history.
     *
     * Each record represents an action taken by an approver:
     * - Approval decisions (approve/reject)
     * - Comments and reasoning
     * - Approver identification
     * - Action timestamps
     *
     * Records are ordered chronologically, providing a complete audit trail.
     */
    @SerializedName("records")
    private List<ApprovalRecord> records;

    /**
     * The current step in the approval workflow.
     *
     * Indicates which stage of the multi-step approval process is active.
     * Contains:
     * - Step order/sequence number
     * - Roles authorized to act at this step
     * - Next steps based on approve/reject decisions
     * - Namespace for role-based access control
     *
     * Null if the workflow has completed or been cancelled.
     */
    @SerializedName("current_step")
    private ApprovalStep currentStep;

    /**
     * Gets the unique identifier for this instance.
     * @return The instance ID
     */
    public String getId() { return id; }

    /**
     * Sets the unique identifier for this instance.
     * @param id The instance ID
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets the object type identifier.
     * @return Always "approval_instance"
     */
    public String getObject() { return object; }

    /**
     * Sets the object type identifier.
     * @param object The object type
     */
    public void setObject(String object) { this.object = object; }

    /**
     * Gets the merchant ID that owns this instance.
     * @return The merchant ID
     */
    public String getMerchantId() { return merchantId; }

    /**
     * Sets the merchant ID that owns this instance.
     * @param merchantId The merchant ID
     */
    public void setMerchantId(String merchantId) { this.merchantId = merchantId; }

    /**
     * Gets the current approval status.
     * @return The approval status
     */
    public String getStatus() { return status; }

    /**
     * Sets the current approval status.
     * @param status The approval status
     */
    public void setStatus(String status) { this.status = status; }

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
     * Gets the resource type requiring approval.
     * @return The resource type
     */
    public String getResourceType() { return resourceType; }

    /**
     * Sets the resource type requiring approval.
     * @param resourceType The resource type
     */
    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

    /**
     * Gets the Unix timestamp when created.
     * @return Creation timestamp in seconds
     */
    public Long getCreatedAt() { return createdAt; }

    /**
     * Sets the Unix timestamp when created.
     * @param createdAt Creation timestamp in seconds
     */
    public void setCreatedAt(Long createdAt) { this.createdAt = createdAt; }

    /**
     * Gets the Unix timestamp when last updated.
     * @return Last update timestamp in seconds
     */
    public Long getUpdatedAt() { return updatedAt; }

    /**
     * Sets the Unix timestamp when last updated.
     * @param updatedAt Last update timestamp in seconds
     */
    public void setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; }

    /**
     * Gets the list of approval action records.
     * @return List of approval records
     */
    public List<ApprovalRecord> getRecords() { return records; }

    /**
     * Sets the list of approval action records.
     * @param records List of approval records
     */
    public void setRecords(List<ApprovalRecord> records) { this.records = records; }

    /**
     * Gets the current workflow step.
     * @return The current approval step, or null if completed/cancelled
     */
    public ApprovalStep getCurrentStep() { return currentStep; }

    /**
     * Sets the current workflow step.
     * @param currentStep The current approval step
     */
    public void setCurrentStep(ApprovalStep currentStep) { this.currentStep = currentStep; }
}
